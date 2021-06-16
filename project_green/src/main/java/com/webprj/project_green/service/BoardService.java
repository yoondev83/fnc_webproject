package com.webprj.project_green.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;


public interface BoardService {
	public List<BoardDto> getBoardsData();
	public void createBoard(BoardDto boardDto);
	public String login(String id , String passm, HttpSession session);
	public void login(CustomDto customDto);
}
