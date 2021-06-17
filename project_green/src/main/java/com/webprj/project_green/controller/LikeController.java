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
		
		// ����ڰ� ���ƿ並 �����°�?!
		Map<String,Object> articleLikeAvailableRs = likeService.getArticleLikeAvailable(boardnum, loginedMemberId);
		
		// ����ڰ� ���ƿ並 ������!
		if (((String) articleLikeAvailableRs.get("resultCode")).startsWith("false")){
			
			
		
			// ���ƿ並 ����Ѵٴ� ������ �߰��Ѵ�!
			// DB �� �����ؼ� ����Ʈ�� -1 update
			
			
			model.addAttribute("alrtMsg", articleLikeAvailableRs.get("msg"));
			model.addAttribute("historyBack", true);
			
			return 0;
		}
		// ����ڰ� ���ƿ並 �� ������
		Map<String,Object> rs = likeService.likeArticle(boardnum, loginedMemberId);
		
		String msg = (String) rs.get("msg");
	
		
		model.addAttribute("alrtMsg", msg);
		model.addAttribute("locationReplace", redirectUrl);
		
		return 1;
		
	}


		
}

