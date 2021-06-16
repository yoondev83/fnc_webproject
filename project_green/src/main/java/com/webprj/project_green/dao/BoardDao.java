package com.webprj.project_green.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	
	int getLikePointByMemberId(@Param("id")int id, @Param("loginedMemberId") String loginedMemberId);
	
	void likeArticle(@Param("id")int id, @Param("loginedMemberId") String loginedMemberId);
	
//	void 취소함수명(@Param("id")int id, @Param("loginedMemberId") String loginedMemberId);
}
