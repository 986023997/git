package com.ScientificItem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.DepartDao;
import com.ScientificItem.dao.impl.DepartDaoImpl;
import com.ScientificItem.model.Depart;
import com.ScientificItem.model.User;
import com.ScientificItem.service.DepartService;
import com.ScientificItem.service.impl.DepartServiceImpl;

public class AddUserUIServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//�ַ�����
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				DepartDao departDao=new DepartDaoImpl();
				DepartService departService=new DepartServiceImpl(departDao);
				User user=null;

				//ȡ��¼����Ϣ
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
					//���ݴ���������Ŀidȥ��ѯ����Ŀ�ľ������ݲ����浽reques
					List<Depart> depart=departService.getAllDepartment();
					if(depart!=null){
						request.setAttribute("depart", depart);//�����еĲ��Ŵ���ҳ��
						request.getRequestDispatcher("pages/admin/useradd.jsp").forward(request, response);	
					}else{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}
}
