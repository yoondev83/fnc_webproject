package com.webprj.project_green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreenController {
    
    @RequestMapping("/index")

    public String welcomeMain(){

        return "index";
    }
    
    @GetMapping("/board")
    public void board() {
    	System.out.println("board page");
    }
}
