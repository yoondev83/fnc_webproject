package com.webprj.project_green.controller;

public class Member {
	String LoginId;
	String LoginPw;
	String nickname;
	
	public Member(String loginId, String loginPw, String nickname) {
		super();
		this.LoginId=loginId;
		this.LoginPw= loginPw;
		this.nickname= nickname;
	}

}
