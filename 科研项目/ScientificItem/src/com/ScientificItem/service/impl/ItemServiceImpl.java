package com.ScientificItem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.model.Item;
import com.ScientificItem.service.ItemService;

public class ItemServiceImpl implements ItemService {
		ItemDao itemdao;

	public ItemServiceImpl(ItemDao itemDao) {
		// TODO Auto-generated constructor stub
		this.itemdao=itemDao;
	}

	public int applicationItem(Item item) {
		int record=itemdao.insertItem(item);
		return record;
	}

	public List<Item> showAllItem(int user_id) {
		List<Item> list=itemdao.selectAllItem(user_id);
		return list;
	}

	public Item showItemById(int Item_id) {
		return itemdao.selectById(Item_id);
	}

	public int DeleteItem(int id) {
		return itemdao.deleteItemById(id);
	}

	public int itemUpdate(Item item) {
		return itemdao.updateItem(item);
	}

	public List<Item> showDepartAllItem(int user_depart_id) {
		
		
		return itemdao.selectDepartAllItem(user_depart_id);
	}

	public int DepartCheckItem(int id, String user_realname,int  status) {
		if(status==2){
			Item item=itemdao.selectById(id);
			if(item.getItem_status2()==1){
				return 3;
			}
		}
		int i=itemdao.updateItemStstus(id,user_realname,status);
		return i;
	}

	public int DepartRejectItem(int id, String user_id) {
		int i=itemdao.updateItemStstus(id,user_id,2);
		return i;
	}

	public List<Item> showDepartNoCheckItem(int user_depart_id) {
		List<Item> list=itemdao.selectDepartNoCheckItem(user_depart_id);
		return list;
	}

	public List<Item> showChargeDepartAllItem() {
		int i=1;
		//ͨ��status1=1ȥȡ��������ͨ��������˵���Ŀ
		List<Item> list=itemdao.selectItemByStatus1(i);
		return list;
	}

	
	//���ܲ������
	public int ChargeCheckItem(int id, String user_realname, int status) {
		// TODO Auto-generated method stub
		return itemdao.updateItemStatus2(id,user_realname,status);
	}

}
