package com.webprj.project_green.service;

import java.util.Map;

public interface LikeService {

	public Map<String, Object> getArticleLikeAvailable(int boardnum, String loginedMemberId);

	public Map<String, Object> likeArticle(int boardnum, String loginedMemberId);
	
//	치소함수
}
