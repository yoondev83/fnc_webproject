package com.webprj.project_green.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import oracle.jdbc.proxy.annotation.Post;

import com.webprj.project_green.dto.BoardDto;
import com.webprj.project_green.dto.CustomDto;
import com.webprj.project_green.service.BoardService;

@Controller
public class GreenController {
    
	@Autowired
	private BoardService boardService;
	
    //메인화면
    @GetMapping("/index")
    public String welcomeMain(){

        return "index";
    }

    

    //소개화면
    @GetMapping("/intro")
    public String goIntroduction(){

        return "redirect:/index#introduction";
    }
    
    //랭킹게시판
    @GetMapping("/rank")
    public String goToRank(){
        
        return "rank/rank";
    }
    
    //커뮤니티-자유게시판
    @GetMapping("/b_freetalk")
    public String goCommunity(){

        return "board/b_freetalk";
    }

      //로그인 화면
	@PostMapping("/login/login")
	public String login(@ModelAttribute CustomDto customDto) {
		System.out.println(customDto);
		boardService.login(customDto);
		return "redirect:/index";
	}
    @GetMapping("/login")
    public String sign() {
    	return "login/login";
    }

    //회원가입
    @GetMapping("/join")
    public String goJoin(){

        return "login/join";
    }
    //회원가입 성공
    @PostMapping("/joinOk")
    public String gojoinOk(){

        return "redirect:/joinOk";
    }



    @GetMapping("/board/b_freetalk")
    public void board(Model model, HttpSession session) {
    	System.out.println("board page");
    	model.addAttribute("sess_id", session.getAttribute("id"));
    }
    
    @GetMapping("/board/new")
    public void new_board() {
    	System.out.println("Create board Page");
    }
    
    @PostMapping("/board/new")
	public String createBoard(@ModelAttribute BoardDto boardDto, HttpSession session) {
		System.out.println(boardDto);
		boardDto.setUserId((String) session.getAttribute("id"));
		boardService.createBoard(boardDto);
		return "redirect:/board/b_freetalk";
	}
//    @GetMapping("/login")
//    public void login(Model model, HttpSession session) {
//    	System.out.println("login");
//    	session.setAttribute("id", "mosang");
//    }

}
