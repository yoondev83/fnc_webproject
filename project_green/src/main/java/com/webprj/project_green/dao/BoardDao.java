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
	
	public void updateBoard(BoardDto boardDto);
	public void delete(int postNum);
	
	public void join(CustomDto customDto);
	public String logins(String id);
	
	public int idCheck(String id);
	public int getLikePointByMemberId(@Param("id") int boardnum, @Param("loginedMemberId") String loginedMemberId);
	public void likeArticle(@Param("id") int boardnum, @Param("loginedMemberId") String loginedMemberId);
	public void unlikeArticle(@Param("id") int boardnum, @Param("loginedMemberId") String loginedMemberId);
	public void updateRecommend(@Param("id")int boardnum, @Param("num")int i);
}
