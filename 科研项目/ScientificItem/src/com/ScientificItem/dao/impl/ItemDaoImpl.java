package com.ScientificItem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.util.DButil;


public class ItemDaoImpl implements ItemDao {

	public int insertItem(Item item) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("insert into item (Item_name,Item_app_id,Item_date,Item_topic,Item_content,Item_fund) values(?,?,?,?,?,?)");
			pre.setString(1,item.getItem_name());
			pre.setInt(2, item.getItem_app_id());
			pre.setDate(3,new Date(item.getItem_date().getTime()));
			pre.setString(4,item.getItem_topic());
			pre.setString(5, item.getItem_content());
			pre.setString(6, item.getItem_fund());
			
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

	public List<Item> selectAllItem(int user_id) {
		Connection con = DButil.getConnection();

		ResultSet result = null;
		PreparedStatement pre = null;
		List<Item> list = new ArrayList<Item>();

		try {
			pre = con.prepareStatement("select * from item where Item_app_id=?");
			pre.setInt(1, user_id);
			result = pre.executeQuery();

			while (result.next()) {
				int Item_id = result.getInt("Item_id");
				//System.out.println(Item_id);
				String Item_name = result.getString("Item_name");
				String Item_topic=result.getString("Item_topic");
				int Item_app_id=result.getInt("Item_app_id");
				String Item_content=result.getString("Item_content");
				String Item_fund=result.getString("Item_fund");
				Date Item_date = result.getDate("Item_date");
				int Item_status1=result.getInt("Item_status1");
				String Item_Check_id1=result.getString("Item_Check_id1");
				int Item_status2=result.getInt("Item_status2");
				String Item_Check_id2=result.getString("Item_Check_id2");
				Item item =new Item(Item_id,Item_name,Item_app_id,Item_date,Item_topic,Item_content,Item_fund,Item_status1,Item_Check_id1,Item_status2,Item_Check_id2);
				
				list.add(item);
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

	public Item selectById(int item_id) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		Item item=null;
		try {
			pre = con.prepareStatement("select * from item where Item_id=?");
			pre.setInt(1, item_id);
			result = pre.executeQuery();
			if (result.next()) {
				int Item_id = result.getInt("Item_id");
				//System.out.println(Item_id);
				String Item_name = result.getString("Item_name");
				String Item_topic=result.getString("Item_topic");
				int Item_app_id=result.getInt("Item_app_id");
				String Item_content=result.getString("Item_content");
				String Item_fund=result.getString("Item_fund");
				Date Item_date = result.getDate("Item_date");
				int Item_status1=result.getInt("Item_status1");
				String Item_Check_id1=result.getString("Item_Check_id1");
				int Item_status2=result.getInt("Item_status2");
				String Item_Check_id2=result.getString("Item_Check_id2");
				item =new Item(Item_id,Item_name,Item_app_id,Item_date,Item_topic,Item_content,Item_fund,Item_status1,Item_Check_id1,Item_status2,Item_Check_id2);
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

		return item;
	}

	public int deleteItemById(int id) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("delete from item where Item_id=?");
			pre.setInt(1, id);
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

	public int updateItem(Item item) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("update  item set Item_name=?,Item_date=?,Item_topic=?,Item_content=?,Item_fund=? where Item_id=?");
			pre.setString(1,item.getItem_name());

			pre.setDate(2,new Date(item.getItem_date().getTime()));
			pre.setString(3,item.getItem_topic());
			pre.setString(4, item.getItem_content());
			pre.setString(5, item.getItem_fund());
			pre.setInt(6, item.getItem_id());
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

	public List<Item> selectDepartAllItem(int user_depart_id) {
		Connection con = DButil.getConnection();

		ResultSet result = null;
		PreparedStatement pre = null;
		List<Item> list = new ArrayList<Item>();

		try {
			pre = con.prepareStatement("select a.* from item a,`user` b where a.Item_app_id =b.User_id and b.User_depart_id=?");
			pre.setInt(1, user_depart_id);
			result = pre.executeQuery();

			while (result.next()) {
				int Item_id = result.getInt("Item_id");
				//System.out.println(Item_id);
				String Item_name = result.getString("Item_name");
				String Item_topic=result.getString("Item_topic");
				int Item_app_id=result.getInt("Item_app_id");
				String Item_content=result.getString("Item_content");
				String Item_fund=result.getString("Item_fund");
				Date Item_date = result.getDate("Item_date");
				int Item_status1=result.getInt("Item_status1");
				String Item_Check_id1=result.getString("Item_Check_id1");
				int Item_status2=result.getInt("Item_status2");
				String Item_Check_id2=result.getString("Item_Check_id2");
				Item item =new Item(Item_id,Item_name,Item_app_id,Item_date,Item_topic,Item_content,Item_fund,Item_status1,Item_Check_id1,Item_status2,Item_Check_id2);
				list.add(item);
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

		return list;
	}

	public int updateItemStstus(int id, String user_id, int i) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("update  item set Item_status1=?,Item_Check_id1=? where Item_id=?");
			pre.setInt(1,i);
			pre.setString(2, user_id);
			pre.setInt(3, id);
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

	public List<Item> selectDepartNoCheckItem(int user_depart_id) {
		Connection con = DButil.getConnection();

		ResultSet result = null;
		PreparedStatement pre = null;
		List<Item> list = new ArrayList<Item>();

		try {
			pre = con.prepareStatement("select a.* from item a,`user` b where a.Item_app_id =b.User_id and b.User_depart_id=? and a.Item_status1 =0");
			pre.setInt(1, user_depart_id);
			result = pre.executeQuery();

			while (result.next()) {
				int Item_id = result.getInt("Item_id");
				//System.out.println(Item_id);
				String Item_name = result.getString("Item_name");
				String Item_topic=result.getString("Item_topic");
				int Item_app_id=result.getInt("Item_app_id");
				String Item_content=result.getString("Item_content");
				String Item_fund=result.getString("Item_fund");
				Date Item_date = result.getDate("Item_date");
				int Item_status1=result.getInt("Item_status1");
				String Item_Check_id1=result.getString("Item_Check_id1");
				int Item_status2=result.getInt("Item_status2");
				String Item_Check_id2=result.getString("Item_Check_id2");
				Item item =new Item(Item_id,Item_name,Item_app_id,Item_date,Item_topic,Item_content,Item_fund,Item_status1,Item_Check_id1,Item_status2,Item_Check_id2);
				list.add(item);
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

		return list;
	}

	public List<Item> selectItemByStatus1(int i) {
		Connection con = DButil.getConnection();

		ResultSet result = null;
		PreparedStatement pre = null;
		List<Item> list = new ArrayList<Item>();

		try {
			pre = con.prepareStatement("select * from item where Item_status1=?");
			pre.setInt(1, i);
			result = pre.executeQuery();

			while (result.next()) {
				int Item_id = result.getInt("Item_id");
				//System.out.println(Item_id);
				String Item_name = result.getString("Item_name");
				String Item_topic=result.getString("Item_topic");
				int Item_app_id=result.getInt("Item_app_id");
				String Item_content=result.getString("Item_content");
				String Item_fund=result.getString("Item_fund");
				Date Item_date = result.getDate("Item_date");
				int Item_status1=result.getInt("Item_status1");
				String Item_Check_id1=result.getString("Item_Check_id1");
				int Item_status2=result.getInt("Item_status2");
				String Item_Check_id2=result.getString("Item_Check_id2");
				Item item =new Item(Item_id,Item_name,Item_app_id,Item_date,Item_topic,Item_content,Item_fund,Item_status1,Item_Check_id1,Item_status2,Item_Check_id2);
				list.add(item);
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

		return list;
	}

	public int updateItemStatus2(int id, String user_realname, int status) {
		Connection con = DButil.getConnection();
		ResultSet result = null;
		PreparedStatement pre = null;
		int record=0;
		
		try {
			pre = con.prepareStatement("update  item set Item_status2=?,Item_Check_id2=? where Item_id=?");
			pre.setInt(1,status);
			pre.setString(2, user_realname);
			pre.setInt(3, id);
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


