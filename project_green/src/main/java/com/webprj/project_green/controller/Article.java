package com.webprj.project_green.controller;

public class Article {
	
	public int num;
	public String title;
	public String body;
	public String regDate;
	public int hit;
	public String nickname;



//�ݵ�� Ŭ������� ����
//return type�� �������� ������ ���� x
//��ü(�ν��Ͻ�)���� �� �ݵ�� �ѹ��� ȣ��
//������

public Article(int num, String title, String body, String regDate, int hit, String nickname) {
	this.num=num;
	this.title=title;
	this.body=body;
	this.regDate=regDate;
	this.hit=hit;
	this.nickname=nickname;
}

}