package com.webprj.project_green.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.BoardDao;
import com.webprj.project_green.dto.BoardDto;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private BoardDao boardDao;
	
	// 좋아요 체크 함수
	@Override
	public Map<String, Object> getArticleLikeAvailable(int boardnum, String loginedMemberId) {
		BoardDto board = boardDao.getBoardData(boardnum);
		
		Map<String, Object> rs = new HashMap<>();
		
		if(board.getUserId() == loginedMemberId) {
			rs.put("resultCode", "F-1");
			rs.put("msg", "본인은 추천불가.");
			return rs;
		}
		
		int likePoint = boardDao.getLikePointByMemberId(boardnum, loginedMemberId);
		
		if(likePoint > 0) {
			rs.put("resultCode", "F-2");
			rs.put("msg", "이미 좋아요를 하셨습니다.");
		}
			
		// 좋아요를 아직 안함!
		rs.put("resultCode", "S-1");
		rs.put("msg", "가능합니다.");
		return rs;
	}


	@Override
	public Map<String, Object> likeArticle(int boardnum, String actorMemberId) {
		boardDao.likeArticle(boardnum, actorMemberId);
		
		Map<String, Object> rs = new HashMap<>();
		
		rs.put("resultCode", "S-1");
		rs.put("msg", String.format("%d번 게시물을 추천하였습니다.", boardnum));
		
		return rs;
		
	}
//	
//	취소함수{ daol }
}
	
	
	
	

	
