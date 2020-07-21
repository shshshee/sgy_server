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
		
		User_InfoVO userlogin = uService.LoginCheck(user);
		
		if(userlogin != null) {
			if(bcryptPE.matches(user.getUi_pw(), userlogin.getUi_pw())) {
				session.setAttribute("ui_id", userlogin);
				System.out.println("ui_id=>"+userlogin.getUi_id());
				return 1;
			}else {
				return 0;
			}
		}else {
			return -1;
		}
		
	}
	
}
