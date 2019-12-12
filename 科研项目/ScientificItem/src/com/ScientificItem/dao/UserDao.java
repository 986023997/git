package com.ScientificItem.dao;

import java.util.List;

import com.ScientificItem.model.User;

public interface UserDao {

	//通过账号名和密码查找用户
	User selectByNameAndPassword(String name, String password);
	//通过用户的部门id得到部门名称
	String getUserDepartment(int user_depart_id);
	//通过id得到用户信息
	User selectById(int user_id);
	//更新密码
	int updatePassword(int user_id, String newpassword);
	//更新账号信息
	int userUpdate(User user);
	List<User> getAllUser();
	int deleteUser(int user_id);
	User getUserById(int id);
	User selectByName(String user_name);
	int addUser(User user);
	

}
