package com.project.sgy.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.sgy.dao.UserDAO;
import com.project.sgy.vo.User_InfoVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String queryprefix="UserDAO.";
	
	@Override
	public ArrayList<User_InfoVO> selectUserList(){
		//user list test 잘 나오는지 확인용임  
		List<User_InfoVO> userList = sqlSession.selectList(this.queryprefix+"selectUserList");
		return (ArrayList<User_InfoVO>) userList;
	}
	
	@Override
	public User_InfoVO LoginCheck(User_InfoVO user) {
		return sqlSession.selectOne(this.queryprefix+"selectUserList",user);
	}
}
