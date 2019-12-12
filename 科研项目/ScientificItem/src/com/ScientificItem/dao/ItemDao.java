package com.ScientificItem.dao;

import java.util.List;

import com.ScientificItem.model.Item;

public interface ItemDao {
	//插入项目
	int insertItem(Item item);
	//根据申请人id查出所有的项目
	List<Item> selectAllItem(int user_id);
	//通过项目id查找出项目
	Item selectById(int item_id);
	//通过项目id删除
	int deleteItemById(int id);
	//更新项目
	int updateItem(Item item);
	//根据部门id查找出该部门的所有项目
	List<Item> selectDepartAllItem(int user_depart_id);
	//根据项目id,更新部门审核项目人的真实姓名,状态i(0：审核，1：通过，2：拒绝)
	int updateItemStstus(int id, String user_realname, int i);
	//查找出所有的部门未审核的项目
	List<Item> selectDepartNoCheckItem(int user_depart_id);
	//查出所有status1=i的项目，
	List<Item> selectItemByStatus1(int i);
	////根据项目id,更新科研部门审核人的真实姓名,状态i(0：审核，1：通过，2：拒绝)
	int updateItemStatus2(int id, String user_realname, int status);

}