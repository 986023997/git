package com.ScientificItem.service;

import java.util.List;

import com.ScientificItem.model.User;

public interface UserService {
	
	//�û���¼
	User UserLogin(String name, String password);
	//�����û�����id���ز�������
	String getUserDepartment(int user_depart_id);
	//�����û�����
	User updatePassword(int user_id, String newpassword);
	//�����û�
	User userUpdate(User user);
	//�õ����е��˺�
	List<User> getAllUser();
	//ɾ��ָ��id���˺�
	int deleteUser(int id);
	User userAndPasswordUpdate(User user);
	User getUserById(int parseInt);
	int userRegin(User user, int role);
}
