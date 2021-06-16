package com.webprj.project_green.service;

import java.util.Map;

public interface LikeService {
	public boolean hasLikeChecked();

	public Map<String, Object> getArticleLikeAvailable(int boardnum, int loginedMemberId);

	public Map<String, Object> likeArticle(int boardnum);
}
