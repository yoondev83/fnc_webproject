package com.webprj.project_green.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;
import com.webprj.project_green.service.BoardService;

@Controller
public class GreenController {
    
	@Autowired
	private BoardService boardService;
	
    @GetMapping("/index")
    public String welcomeMain(){

        return "index";
    }
    @GetMapping("/login/jons")
    public String login() {
    	return "login/jons";
  
    }
    @GetMapping("/login/sign")
    public String sign() {
    	return "login/sign";
    }
//    @GetMapping("/login/sign")
//	public void sign_board() {
//    	System.out.println("login board Page");
//	}

	@PostMapping("/login/sign")
	public String login(@ModelAttribute CustomDto customDto) {
		System.out.println(customDto);
		boardService.login(customDto);
		return "redirect:/custom/sign";
	}
    
    @GetMapping("/board/list")
    public void board() {
    	System.out.println("board page");
    }
    
    @GetMapping("/board/new")
    public void new_board() {
    	System.out.println("Create board Page");
    }
    
    @PostMapping("/board/new")
	public String createBoard(@ModelAttribute BoardDto boardDto) {
		System.out.println(boardDto);
		boardService.createBoard(boardDto);
		return "redirect:/board/list";
	}
    
    // ===========================  회원 가입 =========================
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
