package com.webprj.project_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webprj.project_green.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@ResponseBody
	@GetMapping("/login/idchk")
	public int idCheck(@RequestParam String userInputId) {
		System.out.println(userInputId);
		// ���񽺷� userInputId�� ������ �ߺ�üũ�� ����!
		
		return loginService.idCheck(userInputId);
	}
	
}
