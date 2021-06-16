package com.webprj.project_green.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @GetMapping("/board/list")
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
		return "redirect:/board/list";
	}
    @GetMapping("/login")
    public void login(Model model, HttpSession session) {
    	System.out.println("login");
    	session.setAttribute("id", "mosang");
    }
}
