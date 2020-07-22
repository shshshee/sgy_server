package com.project.sgy.dao;

import java.util.ArrayList;

import com.project.sgy.vo.User_InfoVO;

public interface UserDAO {
	
	/* 회원 리스트 test */
	ArrayList<User_InfoVO> selectUserList();
	
	/* 로그인 test */
	User_InfoVO LoginCheck(User_InfoVO user);
	
	/* 회원가입  */
	int insertUser(User_InfoVO user);
}
