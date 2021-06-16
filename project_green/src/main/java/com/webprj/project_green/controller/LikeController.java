package com.webprj.project_green.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/board")
public class LikeController {
	
	@GetMapping("/list/like/{boardnum}")
	public int good(@PathVariable int boardnum) {
		System.out.println(boardnum);
		return 7; 
	}
		
}

