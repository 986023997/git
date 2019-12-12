package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ScientificItem.dao.UserDao;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.util.DButil;


public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see com.ScientificItem.dao.UserDao#selectByNameAndPawword(java.lang.String, java.lang.String)
	 */
	public User selectByNameAndPassword(String name, String password) {
		Connection con = DButil.getConnection();
		User user = null;
		ResultSet result = null;
		PreparedStatement pre = null;
		
		try {
			pre = con.prepareStatement("select * from user where User_name=? and User_password=?");
			pre.setString(1,name);
			pre.setString(2, password);
			result = pre.executeQuery();
			if (result.next()) {
				user=new User(result.getInt("User_id"),result.getString("User_name"),result.getString("User_password"),result.getString("User_realname"),result.getInt("User_age"),result.getString("User_sex"),result.getInt("User_depart_id"),result.getString("User_mail"),result.getString("User_phone"),result.getString("User_address"),result.getDate("User_date"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				result.close();
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	public String getUserDepartment(int user_depart_id) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		String depart_name=null;
		
		try {
			pre = con.prepareStatement("select Depart_name from department where Depart_id=?");
			pre.setInt(1,user_depart_id);
			result = pre.executeQuery();
			if (result.next()) {
				depart_name=result.getString("Depart_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				result.close();
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return depart_name;
	}

	public User selectById(int user_id) {
		Connection con = DButil.getConnection();
		User user = null;
		ResultSet result = null;
		PreparedStatement pre = null;
		
		try {
			pre = con.prepareStatement("select * from user where User_id=?");
			pre.setInt(1,user_id);
			result = pre.executeQuery();
			if (result.next()) {
				user=new User(result.getInt("User_id"),result.getString("User_name"),result.getString("User_password"),result.getString("User_realname"),result.getInt("User_age"),result.getString("User_sex"),result.getInt("User_depart_id"),result.getString("User_mail"),result.getString("User_phone"),result.getString("User_address"),result.getDate("User_date"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				result.close();
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	public int updatePassword(int user_id, String newpassword) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("update user set User_password=? where User_id=?");
			pre.setString(1,newpassword);
			pre.setInt(2,user_id);
			record = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return record;
	}

	public int userUpdate(User user) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("update user set User_realname=? ,User_sex=?,User_age=?,User_mail=?, User_phone=?,User_address=? where User_id=?");
			pre.setString(1,user.getUser_realname());
			pre.setString(2, user.getUser_sex());
			pre.setInt(3,user.getUser_age());
			pre.setString(4, user.getUser_mail());
			pre.setString(5, user.getUser_phone());
			pre.setString(6, user.getUser_address());
			pre.setInt(7,user.getUser_id());
			record = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return record;
	}

	public List<User> getAllUser() {
		Connection con = DButil.getConnection();
		User user=null;
		ResultSet result = null;
		PreparedStatement pre = null;
		List<User> list = new ArrayList<User>();

		try {
			pre = con.prepareStatement("select * from user");
			result = pre.executeQuery();

			while (result.next()) {
				
				user=new User(result.getInt("User_id"),result.getString("User_name"),result.getString("User_password"),result.getString("User_realname"),result.getInt("User_age"),result.getString("User_sex"),result.getInt("User_depart_id"),result.getString("User_mail"),result.getString("User_phone"),result.getString("User_address"),result.getDate("User_date"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public int deleteUser(int User_id) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("delete from user where User_id=?");
			pre.setInt(1, User_id);
			record = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return record;
	}

	public User getUserById(int id) {
		Connection con = DButil.getConnection();
		User user = null;
		ResultSet result = null;
		PreparedStatement pre = null;
		
		try {
			pre = con.prepareStatement("select * from user where User_id=? ");
			pre.setInt(1,id);
			result = pre.executeQuery();
			if (result.next()) {
				user=new User(result.getInt("User_id"),result.getString("User_name"),result.getString("User_password"),result.getString("User_realname"),result.getInt("User_age"),result.getString("User_sex"),result.getInt("User_depart_id"),result.getString("User_mail"),result.getString("User_phone"),result.getString("User_address"),result.getDate("User_date"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				result.close();
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}
	public User selectByName(String user_name) {
		Connection con = DButil.getConnection();
		User user = null;
		ResultSet result = null;
		PreparedStatement pre = null;
		
		try {
			pre = con.prepareStatement("select * from user where User_name=?");
			pre.setString(1,user_name);
			result = pre.executeQuery();
			if (result.next()) {
				user=new User(result.getInt("User_id"),result.getString("User_name"),result.getString("User_password"),result.getString("User_realname"),result.getInt("User_age"),result.getString("User_sex"),result.getInt("User_depart_id"),result.getString("User_mail"),result.getString("User_phone"),result.getString("User_address"),result.getDate("User_date"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				result.close();
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return user;
	}

	public int addUser(User user) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("insert into user(User_name,User_password,User_realname,User_age,User_sex,User_depart_id,User_mail,User_phone,User_address,User_date) values (?,?,?,?,?,?,?,?,?,?)");
			pre.setString(1,user.getUser_name());
			pre.setString(2,user.getUser_password());
			pre.setString(3, user.getUser_realname());
			pre.setInt(4, user.getUser_age());
			pre.setString(5, user.getUser_sex());
			pre.setInt(6, user.getUser_depart_id());
			pre.setString(7, user.getUser_mail());
			pre.setString(8, user.getUser_phone());
			pre.setString(9, user.getUser_address());
			pre.setDate(10, new java.sql.Date(user.getUser_date().getTime()));
			record = pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pre.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return record;
	}

	
	

}
