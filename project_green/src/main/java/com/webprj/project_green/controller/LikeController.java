package com.webprj.project_green.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webprj.project_green.service.BoardService;
import com.webprj.project_green.service.LikeService;


@RestController
@RequestMapping("/board")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	
	@GetMapping("/list/like")
	public String dolike(Model model, @RequestParam int boardnum, @RequestParam boolean update, String redirectUrl, HttpSession session) {
		System.out.println(update);
		String loginedMemberId = (String) session.getAttribute("id");
		
		// 사용자가 좋아요를 눌렀는가?!
		Map<String,Object> articleLikeAvailableRs = likeService.getArticleLikeAvailable(boardnum, loginedMemberId, update);
		System.out.println(articleLikeAvailableRs.get("resultCode"));
		
		// 사용자가 좋아요를 눌렀다!
		
		if(((String) articleLikeAvailableRs.get("resultCode")).equals("F-1")) {
			System.out.println("---------------- unlike Article --------------------------");
			likeService.unlikeArticle(boardnum, loginedMemberId);
			articleLikeAvailableRs.put("state", "doUnlike");
		}
		else if(((String) articleLikeAvailableRs.get("resultCode")).equals("S-1")) {
			System.out.println("---------------- like Article --------------------------");
			// 사용자가 좋아요를 안 눌렀음
			likeService.likeArticle(boardnum, loginedMemberId);
			articleLikeAvailableRs.put("state", "doLike");
		}
		 else if(((String) articleLikeAvailableRs.get("resultCode")).equals("S-2")) {
			 System.out.println("---------------- Check Like --------------------------");
			 // 그냥 체크 
			 articleLikeAvailableRs.put("state", "justCheck"); 
		 }
		articleLikeAvailableRs.put("recommendPoint", likeService.getRecommendPoint(boardnum));
		// resultCode
		// state
		// recommendPoint
		String json;
		try {
			json = new ObjectMapper().writeValueAsString(articleLikeAvailableRs);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}


		
}

