package com.ScientificItem.model;

import java.util.Date;

public class User {
	private int User_id;//员工id
	 String User_name;//员工名字
	private String User_password;//账号密码
	private String User_realname;//姓名
	private int User_age;//年龄
	private String User_sex;//性别 
	
	private int User_depart_id;//部门编号
	private String User_mail;//员工邮箱
	private String User_phone;//员工电话
	private String User_address;//员工住址
	private Date User_date;//入职时间
	
	public User(int user_id, String user_name, String user_password, String user_realname, int user_age,
			String user_sex, int user_depart_id, String user_mail, String user_phone, String user_address,
			Date user_date) {
		super();
		User_id = user_id;
		User_name = user_name;
		User_password = user_password;
		User_realname = user_realname;
		User_age = user_age;
		User_sex = user_sex;
		User_depart_id = user_depart_id;
		User_mail = user_mail;
		User_phone = user_phone;
		User_address = user_address;
		User_date = user_date;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getUser_id() {
		return User_id;
	}


	public void setUser_id(int user_id) {
		User_id = user_id;
	}


	public String getUser_name() {
		return User_name;
	}


	public void setUser_name(String user_name) {
		User_name = user_name;
	}


	public String getUser_password() {
		return User_password;
	}


	public void setUser_password(String user_password) {
		User_password = user_password;
	}


	public String getUser_realname() {
		return User_realname;
	}


	public void setUser_realname(String user_realname) {
		User_realname = user_realname;
	}


	public int getUser_age() {
		return User_age;
	}


	public void setUser_age(int user_age) {
		User_age = user_age;
	}


	public String getUser_sex() {
		return User_sex;
	}


	public void setUser_sex(String user_sex) {
		User_sex = user_sex;
	}


	public int getUser_depart_id() {
		return User_depart_id;
	}


	public void setUser_depart_id(int user_depart_id) {
		User_depart_id = user_depart_id;
	}


	public String getUser_mail() {
		return User_mail;
	}


	public void setUser_mail(String user_mail) {
		User_mail = user_mail;
	}


	public String getUser_phone() {
		return User_phone;
	}


	public void setUser_phone(String user_phone) {
		User_phone = user_phone;
	}


	public String getUser_address() {
		return User_address;
	}


	public void setUser_address(String user_address) {
		User_address = user_address;
	}


	public Date getUser_date() {
		return User_date;
	}


	public void setUser_date(Date user_date) {
		User_date = user_date;
	}


	@Override
	public String toString() {
		return "User [User_id=" + User_id + ", User_name=" + User_name + ", User_password=" + User_password
				+ ", User_realname=" + User_realname + ", User_age=" + User_age + ", User_sex=" + User_sex
				+ ", User_depart_id=" + User_depart_id + ", User_mail=" + User_mail + ", User_phone=" + User_phone
				+ ", User_address=" + User_address + ", User_date=" + User_date + "]";
	}

	
	

}
