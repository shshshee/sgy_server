package com.project.sgy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sgy.dao.UserDAO;
import com.project.sgy.vo.User_InfoVO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO udao;
	
	public ArrayList<User_InfoVO> userList(){
		return udao.selectUserList();
	}
	
	//로그인
	public User_InfoVO LoginCheck(User_InfoVO user) {
		return udao.LoginCheck(user);
	}
	
	//회원가입
	public int insertUser(User_InfoVO user) {
		return udao.insertUser(user);
	}
}
