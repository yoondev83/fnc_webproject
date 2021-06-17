package com.webprj.project_green.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webprj.project_green.dao.BoardDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int idCheck(String userInputId) {
		// �ߺ��� �˻�
		// ������ ���ؼ� 0 / 1
		// isDuplicate
		int isDuplicate = boardDao.idCheck(userInputId);		
		if (isDuplicate == 1) {
			// 1 �϶�,
			return isDuplicate;
		}else {
			// 0 �϶�, 
			return isDuplicate;
		}
	}

}
