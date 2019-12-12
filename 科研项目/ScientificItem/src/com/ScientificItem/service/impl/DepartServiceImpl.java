package com.ScientificItem.service.impl;



import java.util.List;

import com.ScientificItem.dao.DepartDao;

import com.ScientificItem.model.Depart;
import com.ScientificItem.service.DepartService;

public class DepartServiceImpl implements DepartService {
	DepartDao departDao;

	public DepartServiceImpl(DepartDao departDao) {
		// TODO Auto-generated constructor stub
		this.departDao=departDao;
	}

	public List<Depart> getAllDepartment() {
		return departDao.getAllDepartment();
	}

}
