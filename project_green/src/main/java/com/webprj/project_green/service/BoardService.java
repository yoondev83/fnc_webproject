package com.webprj.project_green.service;

import java.util.List;


import com.webprj.project_green.dto.BoardDto;


public interface BoardService {
	public List<BoardDto> getBoardsData();
	public BoardDto getBoardData(int boardnum);
	public void createBoard(BoardDto boardDto);
	
}
