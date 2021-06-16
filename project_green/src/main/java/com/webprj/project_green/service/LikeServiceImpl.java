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
		// 목적: 보드 넘버랑 세션 아이디를 통해 좋아요를 눌렀는지 체크
		// db에 아이디, 게시판넘버 테이블 세팅
		//  boardnum 받았음!
		// 로그인한 아이디도 있다.
		
		//어떤 보드넘버의 게시판 좋아요를 눌렀었는지 데이터를 불러옴->
		// point : db사용 
		// DB -> 내가 이 게시판을 좋아요를 했는지 여부 (내 아이디, 게시판 번호, 좋아요 했는지?) (123, 1, true) / (123, 2, False)
		// -> DAO 한테 부탁한다. 아이디랑, 게시판 번호를 줄테니 True/False를 내놔라
		
		//좋아요 카운트
		//

		// True
		//true값을 받으면 -1
		
		// False
		//false값을 받으면 +1
		//해당 게시판의 좋아요를 누른적이 있다면 -1, 없다면 +1 
		

		// 만들 테이블 = (내 아이디, 게시판 번호, 좋아요 했는지?)
		return false;
		
		
		
		
		
	}





	@Override
	public Map<String, Object> likeArticle(int boardnum) {
		// TODO Auto-generated method stub
		return null;
	}

}
