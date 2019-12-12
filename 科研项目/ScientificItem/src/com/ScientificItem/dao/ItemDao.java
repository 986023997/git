package com.ScientificItem.dao;

import java.util.List;

import com.ScientificItem.model.Item;

public interface ItemDao {
	//������Ŀ
	int insertItem(Item item);
	//����������id������е���Ŀ
	List<Item> selectAllItem(int user_id);
	//ͨ����Ŀid���ҳ���Ŀ
	Item selectById(int item_id);
	//ͨ����Ŀidɾ��
	int deleteItemById(int id);
	//������Ŀ
	int updateItem(Item item);
	//���ݲ���id���ҳ��ò��ŵ�������Ŀ
	List<Item> selectDepartAllItem(int user_depart_id);
	//������Ŀid,���²��������Ŀ�˵���ʵ����,״̬i(0����ˣ�1��ͨ����2���ܾ�)
	int updateItemStstus(int id, String user_realname, int i);
	//���ҳ����еĲ���δ��˵���Ŀ
	List<Item> selectDepartNoCheckItem(int user_depart_id);
	//�������status1=i����Ŀ��
	List<Item> selectItemByStatus1(int i);
	////������Ŀid,���¿��в�������˵���ʵ����,״̬i(0����ˣ�1��ͨ����2���ܾ�)
	int updateItemStatus2(int id, String user_realname, int status);

}