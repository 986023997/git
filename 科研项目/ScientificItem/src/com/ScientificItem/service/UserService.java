package com.ScientificItem.service;

import java.util.List;

import com.ScientificItem.model.User;

public interface UserService {
	
	//用户登录
	User UserLogin(String name, String password);
	//根据用户部门id返回部门名称
	String getUserDepartment(int user_depart_id);
	//更新用户密码
	User updatePassword(int user_id, String newpassword);
	//更新用户
	User userUpdate(User user);
	//得到所有的账号
	List<User> getAllUser();
	//删除指定id的账号
	int deleteUser(int id);
	User userAndPasswordUpdate(User user);
	User getUserById(int parseInt);
	int userRegin(User user, int role);
}
