package com.webprj.project_green.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;
import com.webprj.project_green.dto.UploadResultDto;


public interface BoardService {
	public List<BoardDto> getBoardsData(String string);
	public BoardDto getBoardData(int boardnum);
	public void createBoard(BoardDto boardDto);
	
	public void updateBoard(BoardDto boardDto);
	public void delete(int postNum);
	
	public void join(CustomDto customDto);
	String logins(String id, String passm, HttpSession session);
//	public int idCheck(int idcheck);
	public void saveImageUrl(UploadResultDto uploadResultDto);
	
}
