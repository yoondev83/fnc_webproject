package com.webprj.project_green.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.webprj.project_green.dto.CustomDto;

public interface LikeService {
	public Map<String, Object> getArticleLikeAvailable(int boardnum, String loginedMemberId , boolean update);
	public void likeArticle(int boardnum, String loginedMemberId);
	public void unlikeArticle(int boardnum, String loginedMemberId);
	public int getRecommendPoint(int boardnum);
}
	