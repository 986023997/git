package com.ScientificItem.service;

public interface FilterService {
	//根据用户id，得到用户的权限
	String getLimitUrl(int user_id);

}
