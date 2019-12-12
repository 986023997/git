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
		//字符处理
				response.setContentType("text/html;charset=UTF-8");
				response.setCharacterEncoding("utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter out = response.getWriter();
				DepartDao departDao=new DepartDaoImpl();
				DepartService departService=new DepartServiceImpl(departDao);
				User user=null;

				//取登录者信息
				user=(User)request.getSession().getAttribute("user");
				
				if(user!=null) {
					//根据传过来的项目id去查询出项目的具体内容并保存到reques
					List<Depart> depart=departService.getAllDepartment();
					if(depart!=null){
						request.setAttribute("depart", depart);//将所有的部门传到页面
						request.getRequestDispatcher("pages/admin/useradd.jsp").forward(request, response);	
					}else{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					
				}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	}
}
