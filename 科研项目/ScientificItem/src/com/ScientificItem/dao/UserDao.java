package com.ScientificItem.dao;

import java.util.List;

import com.ScientificItem.model.User;

public interface UserDao {

	//ͨ���˺�������������û�
	User selectByNameAndPassword(String name, String password);
	//ͨ���û��Ĳ���id�õ���������
	String getUserDepartment(int user_depart_id);
	//ͨ��id�õ��û���Ϣ
	User selectById(int user_id);
	//��������
	int updatePassword(int user_id, String newpassword);
	//�����˺���Ϣ
	int userUpdate(User user);
	List<User> getAllUser();
	int deleteUser(int user_id);
	User getUserById(int id);
	User selectByName(String user_name);
	int addUser(User user);
	

}
