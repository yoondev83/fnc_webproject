package com.webprj.project_green.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreenController {
    
    @RequestMapping("/index")

    public String welcomeMain(){

        return "index";
    }
}
