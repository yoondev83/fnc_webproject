package com.webprj.project_green.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.BoardDao;
import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardDto> getBoardsData() {
		// TODO Auto-generated method stub
		return boardDao.getBoardsData();
	}
	@Override
	public void createBoard(BoardDto boardDto) {
		// TODO Auto-generated method stub
		boardDao.createBoard(boardDto);
	}
	
	
	
	public void updateBoard(BoardDto boardDto) {
		// TODO Auto-generated method stub
		boardDao.updateBoard(boardDto);
	}
	public void delete(int postNum) {
		// TODO Auto-generated method stub
		boardDao.delete(postNum);
	}
	
	
	
	
	
	
	
	
	public BoardDto getBoardData(int boardnum) {
		// TODO Auto-generated method stub
		return boardDao.getBoardData(boardnum);
	}
	
	@Override
	public String logins(String id, String password, HttpSession session) {
		System.out.println("here!!!!!");
		String dbPass=boardDao.logins(id);
		if(dbPass==null) {
			System.out.println("password null");
			return "redirect:/login/sign";
		}
		else {
			if(dbPass.equals(password)) {
				System.out.println("login success");
				session.setAttribute("id", id);
				return "redirect:/index";
			}
			else {
				System.out.println("password Æ²¸²");
				return "redirect:/login/jons";
			}
		}
		
		
	}
	
	public void join(CustomDto customDto) {
		boardDao.join(customDto);
		// TODO Auto-generated method stub
		
	}

}
