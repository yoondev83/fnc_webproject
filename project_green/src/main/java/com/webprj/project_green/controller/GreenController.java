package com.webprj.project_green.controller;




public class GreenController{
	


}

public void doCommand(String command) {
	if(command.equals("article add")) {
		//�α��� üũ
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
    //Ư�� �Խù��� �޾� ������ִ� �޼���
public void prin


