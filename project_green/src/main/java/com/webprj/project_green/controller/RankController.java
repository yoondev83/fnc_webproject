package com.webprj.project_green.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webprj.project_green.dto.ProductDto;
import com.webprj.project_green.service.RankService;

@Controller
public class RankController {
	
	@Autowired
	private RankService rankService;
	
	private static Map<Integer, Integer> didGood = new HashMap<Integer, Integer>();
	// rank page
    @GetMapping("/rank")
    public String goToRank(){
        
        return "rank/rank";
    }
    
    // rank map page
    @GetMapping("/rank_map")
    public String goToRankMap(){
        
    	return "rank/rank_map";
    }
    
    // like page
    @GetMapping("/like.rank")
    public String goToRankLike(Model model, HttpSession session){
    	model.addAttribute("sess_id", session.getAttribute("id"));
    	model.addAttribute("didgood", didGood);
    	return "rank/like";
    }
    
    @ResponseBody
    @PostMapping("/like.rank")
    public List<ProductDto> getProducts(Model model, HttpSession session) {
    	
    	List<ProductDto> result = rankService.getProducts();
    	System.out.println(result);
    	return result;
    }
    
    @ResponseBody
    @PostMapping("/like.rank/order")
    public List<ProductDto> getProductsOrder(Model model, HttpSession session) {
    	
    	List<ProductDto> result = rankService.getProductsOrder();
    	System.out.println(result);
    	return result;
    }
    
    @ResponseBody
    @GetMapping("/like.rank/like")
    public String likeProduct(@RequestParam Integer productNum, HttpSession session, Model model) {
    	System.out.println(productNum);
    	
    	// ProductNum 이랑 세션 아이디를 받아옴
    	// Map으로 해서 , productNum 이랑 세션 아이디를 연결, 그리고 좋아요 했는지 표시
    	
    	
    	int value = didGood.getOrDefault(productNum, -1);
    	System.out.println(value);
    	if (value == -1) {
    		// 좋아요 한 적 없음
    		didGood.put(productNum, 1);
    		// recommend + 1
    		rankService.updateRecommend(productNum, 1);
    		return "LIKE";
    	}else if(value == 0) {
    		// 좋아요 취소 상태
    		didGood.put(productNum, 1);
    		// recommend + 1
    		rankService.updateRecommend(productNum, 1);
    		return "LIKE";
    	}else if(value == 1) {
    		// 좋아요 한 상태
    		didGood.put(productNum, 0);
    		// recommend - 1
    		rankService.updateRecommend(productNum, -1);
    		return "UNLIKE";
    	}
    	// 모델로 해당 값을 넘긴다.
    	return "";
    }
}
