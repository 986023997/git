package com.ScientificItem.test;

import org.junit.Test;

import com.ScientificItem.service.FilterService;
import com.ScientificItem.service.impl.FilterServiceImpl;

public class FilterServiceTest {
	@Test
	public void Testgeturl() {
		
		FilterService service=new FilterServiceImpl();
		System.out.println(service.getLimitUrl(1));
	}

}
