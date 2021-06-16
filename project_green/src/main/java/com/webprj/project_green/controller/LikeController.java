package com.webprj.project_green.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webprj.project_green.service.BoardService;
import com.webprj.project_green.service.LikeService;


@RestController
@RequestMapping("/board")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/list/like/{boardnum}")
	public int good(@PathVariable int boardnum, HttpSession session) {
		System.out.println(boardnum);
		// boardnum 받았음!
		// 로그인한 아이디도 있다.
		// -> 누른적이 있는가? 판단
		// 서비스에서 하기로 하자!
		likeService.hasLikeChecked();
		return 7; 
	}
	
	
	@PostMapping("/list/like/{boardnum}")
	public String dolike(Model model, int boardnum, String redirectUrl, HttpSession session) {
		
		int loginedMemberId = (int) session.getAttribute("id");
		
		Map<String,Object> articleLikeAvailableRs = likeService.getArticleLikeAvailable(boardnum, loginedMemberId);
		
		if (((String) articleLikeAvailableRs.get("resultCode")).startsWith("false")){
			model.addAttribute("alrtMsg", articleLikeAvailableRs.get("msg"));
			model.addAttribute("historyBack", true);
			
			return "common/redirect";
		}
		
		Map<String,Object> rs = likeService.likeArticle(boardnum);
		
		String msg = (String) rs.get("msg");
	
		
		model.addAttribute("alrtMsg", msg);
		model.addAttribute("locationReplace", redirectUrl);
		
		return "common/redirect";
		
	}


		
}

