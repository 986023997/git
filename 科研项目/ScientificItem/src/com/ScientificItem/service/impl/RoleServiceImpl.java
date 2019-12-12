package com.ScientificItem.service.impl;

import com.ScientificItem.dao.RoleDao;
import com.ScientificItem.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	RoleDao roleDao;
	public RoleServiceImpl(RoleDao roleDao) {
		// TODO Auto-generated constructor stub
		this.roleDao=roleDao;
	}

	public int selectUserRole(int user_id) {
		return roleDao.selectUserRole(user_id);
	}

}
