package com.webprj.project_green.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.webprj.project_green.dto.CustomDto;

public interface LikeService {
	public boolean hasLikeChecked();

	public Map<String, Object> getArticleLikeAvailable(int boardnum, int loginedMemberId);

	public Map<String, Object> likeArticle(int boardnum);
	
}
