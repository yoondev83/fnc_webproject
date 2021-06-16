package com.webprj.project_green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/b_freetalk")
	public List<BoardDto> getBoardsData() {
		
		return boardService.getBoardsData();
	}
	
	
}
