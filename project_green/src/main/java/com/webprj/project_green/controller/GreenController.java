package com.webprj.project_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @GetMapping("/board/detail/{boardnum}")
	public ModelAndView detail(@PathVariable int boardnum) {
		System.out.println(boardnum);
		ModelAndView mv = new ModelAndView("/board/detail");
		BoardDto board = boardService.getBoardData(boardnum);
		mv.addObject("board", board);
		System.out.println(board);
		return mv;
	}
}
