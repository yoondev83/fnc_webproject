package com.webprj.project_green.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.UploadResultDto;
import com.webprj.project_green.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	@PostMapping("/b_freetalk")
	public List<BoardDto> getFreeBoardsData() {
		return boardService.getBoardsData("free-board");
	}
	@PostMapping("/b_prove")
	public List<BoardDto> getShowBoardsData() {
		
		return boardService.getBoardsData("show-board");
	}
	@PostMapping("/b_mission")
	public List<BoardDto> getMissionBoardsData() {
		
		return boardService.getBoardsData("mission-board");
	}
	
	@PostMapping("/checkid/{postNum}")
	public boolean checkBoardIdWithSessionId(@PathVariable int postNum) {
		System.out.println( "Check id"  + postNum);
		return false;
	}
	
	@Value("${org.zerock.upload.path}")// application.properties 변수
	private String uploadPath;
	@PostMapping("/uploadAxios")
	public ResponseEntity<List<UploadResultDto>> uploadFile(MultipartFile[] uploadFiles) {
		List<UploadResultDto> resultDTOList = new ArrayList<>();
		for(MultipartFile uploadFile: uploadFiles) {
			//실제 파일이름 IE나 Edge는 전체 경로가 들어옴
			String originalName = uploadFile.getOriginalFilename();
			String fileName = originalName.substring(originalName.lastIndexOf("\\") + 1);
			System.out.println(fileName);
			
			// 날짜 폴더 생성
			String folderPath = makeFolder();
			
			//UUID
			String uuid = UUID.randomUUID().toString();
			
			//저장할 파일 이름 중간에 "_"를 이용해서 구분
			String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
			
			Path savePath = Paths.get(saveName);
			
			try {
				uploadFile.transferTo(savePath); // 실제 이미지 디스크에 저장
				UploadResultDto uploadResultDto = new UploadResultDto(fileName, uuid, folderPath);
				resultDTOList.add(uploadResultDto);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // endfor                 
		return new ResponseEntity<>(resultDTOList, HttpStatus.OK);
	}
	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		
		String folderPath = str.replace("/", File.separator);
		
		//make folder -------
		File uploadPathFolder = new File(uploadPath, folderPath);
		if(uploadPathFolder.exists() == false) {
			uploadPathFolder.mkdirs();
		}
		return folderPath;
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(@RequestParam String fileName){
		ResponseEntity<byte[]> result = null;
		
		try {
			String srcFileName = URLDecoder.decode(fileName, "UTF-8");
			System.out.println("fileName: " + srcFileName);
			
			File file = new File(uploadPath + File.separator + srcFileName);
			
			System.out.println("file : " + file);
			
			HttpHeaders header = new HttpHeaders();
			
			//MIME타입 처리
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			// 파일 데이터 처리
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
}
