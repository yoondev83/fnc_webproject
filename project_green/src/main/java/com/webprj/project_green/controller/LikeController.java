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
import org.springframework.web.bind.annotation.RestController;

import com.webprj.project_green.service.BoardService;
import com.webprj.project_green.service.LikeService;


@RestController
@RequestMapping("/board")
public class LikeController {
	
	@Autowired
	private LikeService likeService;
	
	
	@GetMapping("/list/like/{boardnum}")
	public int dolike(Model model, @PathVariable int boardnum, String redirectUrl, HttpSession session) {
		
//		String loginedMemberId = (String) session.getAttribute("id");
		String loginedMemberId = "mosang";
		
		// 사용자가 좋아요를 눌렀는가?!
		Map<String,Object> articleLikeAvailableRs = likeService.getArticleLikeAvailable(boardnum, loginedMemberId);
		
		// 사용자가 좋아요를 눌렀다!
		if (((String) articleLikeAvailableRs.get("resultCode")).startsWith("false")){
			
			
		
			// 좋아요를 취소한다는 로직을 추가한다!
			// DB 에 접근해서 포인트를 -1 update
			
			
			model.addAttribute("alrtMsg", articleLikeAvailableRs.get("msg"));
			model.addAttribute("historyBack", true);
			
			return 0;
		}
		// 사용자가 좋아요를 안 눌렀음
		Map<String,Object> rs = likeService.likeArticle(boardnum, loginedMemberId);
		
		String msg = (String) rs.get("msg");
	
		
		model.addAttribute("alrtMsg", msg);
		model.addAttribute("locationReplace", redirectUrl);
		
		return 1;
		
	}


		
}

