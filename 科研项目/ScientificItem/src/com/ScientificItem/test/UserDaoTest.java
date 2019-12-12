package com.ScientificItem.test;

import java.util.Date;

import org.junit.Test;

import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.service.UserService;
import com.ScientificItem.service.impl.UserServiceImpl;

public class UserDaoTest {
	
	UserDao userdao=new UserDaoImpl();
	UserService userService=new UserServiceImpl(userdao);
	@Test
	public void TestGetUserByName(){
		User user=new User();
		user=userdao.selectByNameAndPassword("zl", "1234567");
		System.out.println(user);
	}
	@Test
	public void TestgetUserDepartment() {
		String name=userdao.getUserDepartment(1);
		System.out.println(name);
	}
	@Test
	public void TestupdatePassword() {
		userdao.updatePassword(1, "123456789");
	}
	@Test
	public void TestuserUpdate() {
		User user=new User();
		user.setUser_id(1);
		user.setUser_realname("zzz");
		user.setUser_age(22);
		user.setUser_mail("2405943665@qq.com");
		user.setUser_phone("13672263043");
		user.setUser_address("江西省赣州市");
		userdao.userUpdate(user);
	}
	
	@Test
	public void Testuseradduserrole() {
		User user=new User();
		user.setUser_name("nkl");
		user.setUser_password("123456");
		user.setUser_realname("zzz");
		user.setUser_age(22);
		user.setUser_mail("2405943665@qq.com");
		user.setUser_phone("13672263043");
		user.setUser_address("江西省赣州市");
		user.setUser_date(new Date());
		int i=userService.userRegin(user, 1);
		System.out.println(i);
	}
	
	

}
