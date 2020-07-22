package com.project.sgy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sgy.service.UserService;
import com.project.sgy.vo.User_InfoVO;

@RestController
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPE;
	
	//test
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ArrayList<User_InfoVO> user(Model model) {
		ArrayList<User_InfoVO> u = uService.userList();
		System.out.println(u.toString());
		
		return u;
	}
	
	//login 
	@PostMapping("/login")
	public int loginCheck(@RequestBody User_InfoVO user, HttpSession session) {
		
		//로그인 객체 가져오기
		User_InfoVO userlogin = uService.LoginCheck(user);
		
		if(userlogin != null) {
			//아이디가 존재한다면 -> 비밀번호 비교 
			if(bcryptPE.matches(user.getUi_pw(), userlogin.getUi_pw())) {
				session.setAttribute("ui_id", userlogin);
				System.out.println("ui_id=>"+userlogin.getUi_id());
				return 1;
			}else {
				return 0;
			}
		}else {
			//아이디가 존재하지 않을 때
			return -1;
		}
		
	}
	
	//회원가입
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public int signup(@RequestBody User_InfoVO user) {
		//중복체크는 아직 X -> 있어야할까 ? 
		
		//비밀번호 암호화
		String encodePassword = bcryptPE.encode(user.getUi_pw()); 
		user.setUi_pw(encodePassword);
		
		int result = uService.insertUser(user);
		
		return result;
	}
	
}
