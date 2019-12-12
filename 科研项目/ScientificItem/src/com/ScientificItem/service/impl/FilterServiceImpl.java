package com.ScientificItem.service.impl;

import com.ScientificItem.dao.LimitDao;
import com.ScientificItem.dao.RoleLimitDao;
import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.UserRoleDao;
import com.ScientificItem.dao.impl.LimitDaoImpl;
import com.ScientificItem.dao.impl.RoleLimitDaoImpl;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.dao.impl.UserRoleDaoImpl;
import com.ScientificItem.service.FilterService;

public class FilterServiceImpl implements FilterService {
	UserDao userDao=new UserDaoImpl();
	UserRoleDao userRoleDao=new UserRoleDaoImpl();
	RoleLimitDao roleLimitDao=new RoleLimitDaoImpl();
	LimitDao limitDao=new LimitDaoImpl();
	

	public String getLimitUrl(int user_id) {
		// TODO Auto-generated method stub
		/*在用户角色表查出用户的角色id，然后根据用户角色id查角色权限表得到权限id
		 * 再查权限表得出用户的权限
		 * 
		 * */
		int userRoleId=userRoleDao.findRoleIdByUid(user_id);
		int limitId=roleLimitDao.findLimitIdByRid(userRoleId);
		String url=limitDao.findUrlById(limitId);
		
		return url;
		
	}

}
