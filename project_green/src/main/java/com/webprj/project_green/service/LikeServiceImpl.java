package com.webprj.project_green.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.BoardDao;

@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	private BoardDao boardDao;
	
//	@Override
//	public List<Board> getBoards(){
//		return boardDao.getBoards();
//	}
//	
//	@Override
//	public Board getBoards(int id){
//		return boardDao.getBoard(id);
//	}
	
	@Override
	public Map<String,Object> getArticleLikeAvailable(int id, int loginEdMemberID){
//		Board board = getBoard(id);
//		
//		Map<String, Object> rs = new HashMap<>();
		return null;
	}
	
	
	
	

	@Override
	public boolean hasLikeChecked() {
		// ����: ���� �ѹ��� ���� ���̵� ���� ���ƿ並 �������� üũ
		// db�� ���̵�, �Խ��ǳѹ� ���̺� ����
		//  boardnum �޾���!
		// �α����� ���̵� �ִ�.
		
		//� ����ѹ��� �Խ��� ���ƿ並 ���������� �����͸� �ҷ���->
		// point : db��� 
		// DB -> ���� �� �Խ����� ���ƿ並 �ߴ��� ���� (�� ���̵�, �Խ��� ��ȣ, ���ƿ� �ߴ���?) (123, 1, true) / (123, 2, False)
		// -> DAO ���� ��Ź�Ѵ�. ���̵��, �Խ��� ��ȣ�� ���״� True/False�� ������
		
		//���ƿ� ī��Ʈ
		//

		// True
		//true���� ������ -1
		
		// False
		//false���� ������ +1
		//�ش� �Խ����� ���ƿ並 �������� �ִٸ� -1, ���ٸ� +1 
		

		// ���� ���̺� = (�� ���̵�, �Խ��� ��ȣ, ���ƿ� �ߴ���?)
		return false;
		
		
		
		
		
	}





	@Override
	public Map<String, Object> likeArticle(int boardnum) {
		// TODO Auto-generated method stub
		return null;
	}

}
