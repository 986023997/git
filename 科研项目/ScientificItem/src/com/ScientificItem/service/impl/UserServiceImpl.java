  package com.ScientificItem.service.impl;

import java.io.DataOutput;
import java.util.List;

import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.UserRoleDao;
import com.ScientificItem.dao.impl.UserRoleDaoImpl;
import com.ScientificItem.model.User;
import com.ScientificItem.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userdao;
	UserRoleDao userRoleDao=new UserRoleDaoImpl();

	public UserServiceImpl(UserDao userDao) {
		// TODO Auto-generated constructor stub
		this.userdao=userDao;
	}

	public User UserLogin(String name,String password) {
			User user=null;
			user=userdao.selectByNameAndPassword(name,password);
			//判断该用户名的用户存不存在，若存在再判断密码是否相等，
			return user;
	}

	public String getUserDepartment(int user_depart_id) {
		return userdao.getUserDepartment(user_depart_id);
	
	}

	public User updatePassword(int user_id, String newpassword) {
		User user=null;
		int i=userdao.updatePassword( user_id,newpassword);
		if(i==1) {
			user=userdao.selectById(user_id);
		}
		return user;
	}

	public User userUpdate(User user) {
		User user1=null;
		int i=userdao.userUpdate(user);
		if(i==1) {
			user1=userdao.selectById(user.getUser_id());
		}
		return user1;
	}

	public List<User> getAllUser() {
		return userdao.getAllUser();
	}

	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(id);
	}

	public User userAndPasswordUpdate(User user) {
		userdao.userUpdate(user);
		userdao.updatePassword(user.getUser_id(), user.getUser_password());
		return user;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userdao.getUserById(id);
	}
	
	public int userRegin(User user, int role) {
		int record=0;
	User user2=userdao.selectByName(user.getUser_name());
	if(user2!=null) {
		record=0;
	}else {
	userdao.addUser(user);
	user2=userdao.selectByName(user.getUser_name());
	System.out.println(user2);
	userRoleDao.addUserRole(user2.getUser_id(),role);
	record=1;
	}
	return record;
	}
	
}
