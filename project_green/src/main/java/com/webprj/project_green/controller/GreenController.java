package com.webprj.project_green.controller;




public class GreenController{
	


}

public void doCommand(String command) {
	if(command.equals("article add")) {
		//로그인 체크
		if(islogin()) {
			addArticle();	
		}
	}
	
	if (command.equals("article list")) {
		printArticles(articles);
	}
	
	if (command.equals("article update")){
		updateArticles();
	}
	
	if (command.equals("article delete")) {
		deleteArticles();
	}
	
	if (command.equals("article search")) {
		searchArticles();
	}
	
	if (command.equals("article read")) {
		if(isLogin()) {
			readArticle();
		}
	}
	
}
    //특정 게시물을 받아 출력해주는 메서드
public void prin


