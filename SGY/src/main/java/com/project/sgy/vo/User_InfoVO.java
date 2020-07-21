package com.project.sgy.vo;

import java.io.Serializable;

public class User_InfoVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3064033232779307372L;
	private int ui_idx; // 회원 index
	private String ui_id; // 회원아이디  
	private String ui_pw; // 회원패스워드
	private String ui_phone; // 회원 핸드폰번호
	
	public User_InfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_InfoVO(int ui_idx, String ui_id, String ui_pw, String ui_phone) {
		super();
		this.ui_idx = ui_idx;
		this.ui_id = ui_id;
		this.ui_pw = ui_pw;
		this.ui_phone = ui_phone;
	}
	
	public int getUi_idx() {
		return ui_idx;
	}
	public void setUi_idx(int ui_idx) {
		this.ui_idx = ui_idx;
	}
	public String getUi_id() {
		return ui_id;
	}
	public void setUi_id(String ui_id) {
		this.ui_id = ui_id;
	}
	public String getUi_pw() {
		return ui_pw;
	}
	public void setUi_pw(String ui_pw) {
		this.ui_pw = ui_pw;
	}
	public String getUi_phone() {
		return ui_phone;
	}
	public void setUi_phone(String ui_phone) {
		this.ui_phone = ui_phone;
	}
	
	@Override
	public String toString() {
		return "User_InfoVO [ui_idx=" + ui_idx + ", ui_id=" + ui_id + ", ui_pw=" + ui_pw + ", ui_phone=" + ui_phone
				+ "]";
	}
	

}
