package com.webprj.project_green.controller;

public class Article {
	
	public int num;
	public String title;
	public String body;
	public String regDate;
	public int hit;
	public String nickname;



//반드시 클래스명과 동일
//return type이 존재하지 않을시 리턴 x
//객체(인스턴스)생성 시 반드시 한번은 호출
//생성자

public Article(int num, String title, String body, String regDate, int hit, String nickname) {
	this.num=num;
	this.title=title;
	this.body=body;
	this.regDate=regDate;
	this.hit=hit;
	this.nickname=nickname;
}

}