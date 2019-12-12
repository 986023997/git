package com.ScientificItem.service;

import java.util.List;
import java.util.Map;

import com.ScientificItem.model.Item;

public interface ItemService {
	//��Ŀ����
	int applicationItem(Item item);
	//��ʾ���еĸ�����Ŀ
	List<Item> showAllItem(int user_id);
	//ͨ���û�id�������е���Ŀ
	Item showItemById(int i);
	//ͨ���û�idɾ���û�
	int DeleteItem(int id);
	//�����û��˺�
	int itemUpdate(Item item);
	//���ݲ���id���ҳ����е���Ŀ
	List<Item> showDepartAllItem(int user_depart_id);
	//�����������
	int DepartCheckItem(int id, String string, int status);
	
	//��ʾ���в���δ��˵���Ŀ
	List<Item> showDepartNoCheckItem(int user_depart_id);

	//�õ������Ѿ���������˹�����Ŀ
	List<Item> showChargeDepartAllItem();

    //�޸����״̬
	int ChargeCheckItem(int id, String user_realname, int status);

}
