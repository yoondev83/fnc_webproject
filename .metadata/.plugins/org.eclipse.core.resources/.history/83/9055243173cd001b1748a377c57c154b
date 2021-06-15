package com.webprj.project_green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.BoardDao;
import com.webprj.project_green.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardDto> getBoardsData() {
		// TODO Auto-generated method stub
		return boardDao.getBoardData();
	}

}
