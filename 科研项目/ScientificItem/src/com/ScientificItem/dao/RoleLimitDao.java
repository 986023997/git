package com.ScientificItem.dao;

public interface RoleLimitDao {
	//通过角色id查找出权限id
	int findLimitIdByRid(int userRoleId);

}
