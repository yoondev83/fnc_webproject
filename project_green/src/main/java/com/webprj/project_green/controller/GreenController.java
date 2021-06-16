package com.webprj.project_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.service.BoardService;

@Controller
public class GreenController {
    
	@Autowired
	private BoardService boardService;
	
    @GetMapping("/index")
    public String welcomeMain(){

        return "index";
    }
    @GetMapping("/intro")
    public String goIntroduction(){

        return "redirect:/index#introduction";
    }
    
    @GetMapping("/rank")
    public String goToRank(){
        
        return "rank/rank";
    }
    
    @GetMapping("/b_freetalk")
    public String goCommunity(){

        return "board/b_freetalk";
    }
    @GetMapping("/login")
    public String goLogin(){

        return "login/login";
    }
    @GetMapping("/join")
    public String goJoin(){

        return "login/join";
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
}
