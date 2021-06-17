package com.webprj.project_green.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;

@Mapper
@Repository
public interface BoardDao {
	public List<BoardDto> getBoardsData();
	public BoardDto getBoardData(int boardnum);
	public void createBoard(BoardDto boardDto);
	public void login(CustomDto customDto);
	public String logins(String id);
}
