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
	public Map<String, Object> getArticleLikeAvailable(int boardnum, String loginedMemberId, boolean update) {
		BoardDto board = boardDao.getBoardData(boardnum);
		
		Map<String, Object> rs = new HashMap<>();
		
		int userDidLike = boardDao.getLikePointByMemberId(boardnum, loginedMemberId);
		
		// ���ƿ� �� ����
		if (!update) {
			rs.put("didLike", userDidLike);
			rs.put("resultCode", "S-2");
			return rs;
		}
		
		if(userDidLike > 0) {
			System.out.println("==================== ���ƿ� ��� =====================");
			rs.put("resultCode", "F-1");
			rs.put("didLike", 0);
		}else {
			System.out.println("==================== ���ƿ�  =====================");
			// ���ƿ並 ���� ����!
			rs.put("resultCode", "S-1");
			rs.put("didLike", 1);
		}
		return rs;
	}


	@Override
	public void likeArticle(int boardnum, String loginedMemberId) {
		boardDao.likeArticle(boardnum, loginedMemberId);
		boardDao.updateRecommend(boardnum, 1);
	}


	@Override
	public void unlikeArticle(int boardnum, String loginedMemberId) {
		boardDao.unlikeArticle(boardnum, loginedMemberId);
		boardDao.updateRecommend(boardnum, -1);
	}
	@Override
	public int getRecommendPoint(int boardnum) {
		// TODO Auto-generated method stub
		int recommendPoint = boardDao.getBoardData(boardnum).getRecommend();
		return recommendPoint;
	}
}
	
	
	
	

	
