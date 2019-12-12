package com.ScientificItem.service;

import java.util.List;
import java.util.Map;

import com.ScientificItem.model.Item;

public interface ItemService {
	//项目申请
	int applicationItem(Item item);
	//显示所有的个人项目
	List<Item> showAllItem(int user_id);
	//通过用户id查找所有的项目
	Item showItemById(int i);
	//通过用户id删除用户
	int DeleteItem(int id);
	//更新用户账号
	int itemUpdate(Item item);
	//根据部门id查找出所有的项目
	List<Item> showDepartAllItem(int user_depart_id);
	//部门主管审核
	int DepartCheckItem(int id, String string, int status);
	
	//显示所有部门未审核的项目
	List<Item> showDepartNoCheckItem(int user_depart_id);

	//得到所有已经被部门审核过的项目
	List<Item> showChargeDepartAllItem();

    //修改审核状态
	int ChargeCheckItem(int id, String user_realname, int status);

}
