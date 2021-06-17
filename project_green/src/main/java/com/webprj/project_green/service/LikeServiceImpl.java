package com.webprj.project_green.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.BoardDao;
import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;

@Service
public class LikeServiceImpl implements LikeService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public Map<String, Object> getArticleLikeAvailable(int boardnum, String loginedMemberId) {
		BoardDto board = boardDao.getBoardData(boardnum);
		
		Map<String, Object> rs = new HashMap<>();
		
		if(board.getUserId() == loginedMemberId) {
			rs.put("resultCode", "F-1");
			rs.put("msg", "������ ��õ�Ұ�.");
			return rs;
		}
		
		int likePoint = boardDao.getLikePointByMemberId(boardnum, loginedMemberId);
		
		if(likePoint > 0) {
			rs.put("resultCode", "F-2");
			rs.put("msg", "�̹� ���ƿ並 �ϼ̽��ϴ�.");
		}
			
		// ���ƿ並 ���� ����!
		rs.put("resultCode", "S-1");
		rs.put("msg", "�����մϴ�.");
		return rs;
	}


	@Override
	public Map<String, Object> likeArticle(int boardnum, String actorMemberId) {
		boardDao.likeArticle(boardnum, actorMemberId);
		
		Map<String, Object> rs = new HashMap<>();
		
		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d�� �Խù��� ��õ�Ͽ����ϴ�.", boardnum));
		
		return rs;
		
	}
}
	
	
	
	

	
