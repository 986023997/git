package com.ScientificItem.test;

import java.util.Date;

import org.junit.Test;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.dao.impl.ItemDaoImpl;
import com.ScientificItem.model.Item;

public class ItemDaoTest {
	
	
	ItemDao itemdao=new ItemDaoImpl();
	
	@Test
	public void TestinsertItem() {
		Item item=new Item();
		
		item.setItem_name("�칫��ֽ�����о�");
		item.setItem_topic("�ִ���");
		item.setItem_content("�ִ����İ칫��ʽ");
		item.setItem_fund("200");
		item.setItem_app_id(1);
		item.setItem_date(new Date());
		itemdao.insertItem(item);
		
		
	}
	@Test
	public void TestselectAllItem(){
		
		System.out.println(itemdao.selectAllItem(1));
	}
	
	@Test
	public void TestsedeleteItemById() {
		
		itemdao.deleteItemById(1);
	}
	@Test
	public void TestupdateItem() {
		Item item=new Item();
		item.setItem_id(2);
		item.setItem_name("�칫��ֽ�����о�");
		item.setItem_topic("�ִ���");
		item.setItem_content("�ִ����İ칫��ʽ");
		item.setItem_fund("200");
		item.setItem_app_id(1);
		item.setItem_date(new Date());
		itemdao.updateItem(item);
		
	}
	
	@Test
	public void TestselectDepartAllItem(){
		
		System.out.println(itemdao.selectDepartAllItem(1));
	}
	@Test
	public void TestupdateItemStstus() {
		
		System.out.println(itemdao.updateItemStstus(2, "11", 1));
	}
	
	

}
