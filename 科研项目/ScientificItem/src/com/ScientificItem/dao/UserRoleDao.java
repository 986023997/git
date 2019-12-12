package com.ScientificItem.dao;

public interface UserRoleDao {

	int findRoleIdByUid(int user_id);
	void addUserRole(int user_id, int role);
}
