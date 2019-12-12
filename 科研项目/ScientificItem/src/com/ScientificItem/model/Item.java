package com.ScientificItem.model;

import java.util.Date;

public class Item {
	private int Item_id;//项目ID
	private String Item_name;//项目名
	private int Item_app_id;//申请人
	private Date Item_date;//申请时间
	private String Item_topic;//项目主题
	private String Item_content;//项目内容
	private String Item_fund;//项目经费
	private int Item_status1;//部门审核
	private String  Item_Check_id1;//部门审核人id
	private int  Item_status2;//科研主管部门审核
	private String  Item_Check_id2;//科研主管部门审核人id
	
	public Item(int item_id, String item_name, int item_app_id, Date item_date, String item_topic, String item_content,
			String item_fund, int item_status1, String  item_Check_id1, int item_status2, String  item_Check_id2) {
		super();
		Item_id = item_id;
		Item_name = item_name;
		Item_app_id = item_app_id;
		Item_date = item_date;
		Item_topic = item_topic;
		Item_content = item_content;
		Item_fund = item_fund;
		Item_status1 = item_status1;
		Item_Check_id1 = item_Check_id1;
		Item_status2 = item_status2;
		Item_Check_id2 = item_Check_id2;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public int getItem_id() {
		return Item_id;
	}
	public void setItem_id(int item_id) {
		Item_id = item_id;
	}
	public String getItem_name() {
		return Item_name;
	}
	public void setItem_name(String item_name) {
		Item_name = item_name;
	}
	public int getItem_app_id() {
		return Item_app_id;
	}
	public void setItem_app_id(int item_app_id) {
		Item_app_id = item_app_id;
	}
	public Date getItem_date() {
		return Item_date;
	}
	public void setItem_date(Date item_date) {
		Item_date = item_date;
	}
	public String getItem_topic() {
		return Item_topic;
	}
	public void setItem_topic(String item_topic) {
		Item_topic = item_topic;
	}
	public String getItem_content() {
		return Item_content;
	}
	public void setItem_content(String item_content) {
		Item_content = item_content;
	}
	public String getItem_fund() {
		return Item_fund;
	}
	public void setItem_fund(String item_fund) {
		Item_fund = item_fund;
	}
	public int getItem_status1() {
		return Item_status1;
	}
	public void setItem_status1(int item_status1) {
		Item_status1 = item_status1;
	}
	public String  getItem_Check_id1() {
		return Item_Check_id1;
	}
	public void setItem_Check_id1(String  item_Check_id1) {
		Item_Check_id1 = item_Check_id1;
	}
	public int getItem_status2() {
		return Item_status2;
	}
	public void setItem_status2(int item_status2) {
		Item_status2 = item_status2;
	}
	public String  getItem_Check_id2() {
		return Item_Check_id2;
	}
	public void  setItem_Check_id2(String item_Check_id2) {
		Item_Check_id2 = item_Check_id2;
	}
	@Override
	public String toString() {
		return "Item [Item_id=" + Item_id + ", Item_name=" + Item_name + ", Item_app_id=" + Item_app_id + ", Item_date="
				+ Item_date + ", Item_topic=" + Item_topic + ", Item_content=" + Item_content + ", Item_fund="
				+ Item_fund + ", Item_status1=" + Item_status1 + ", Item_Check_id1=" + Item_Check_id1
				+ ", Item_status2=" + Item_status2 + ", Item_Check_id2=" + Item_Check_id2 + "]";
	}
	
	
	
	

}
