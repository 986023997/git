package com.ScientificItem.servlet;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.dao.ItemDao;
import com.ScientificItem.dao.UserDao;
import com.ScientificItem.dao.impl.ItemDaoImpl;
import com.ScientificItem.dao.impl.UserDaoImpl;
import com.ScientificItem.model.Item;
import com.ScientificItem.model.User;
import com.ScientificItem.service.ItemService;
import com.ScientificItem.service.UserService;
import com.ScientificItem.service.impl.ItemServiceImpl;
import com.ScientificItem.service.impl.UserServiceImpl;

/**
 * 项目更新
 * @author admin
 *
 */
public class UpdateItemServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字符处理
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		ItemDao itemDao=new ItemDaoImpl();
		ItemService itemService=new ItemServiceImpl(itemDao);
		User user=null;
		Item item=new Item();
		//时间格式化类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(request.getParameter("User_realname"));
		//String id=(String )request.getAttribute("User_id");
		//得到表单传过来的参数，
		item.setItem_id(Integer.parseInt(request.getParameter("Item_id")));
		item.setItem_name(request.getParameter("Item_name"));
		item.setItem_topic(request.getParameter("Item_topic"));
		try {
			item.setItem_date(sdf.parse(request.getParameter("Item_date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		item.setItem_content(request.getParameter("Item_content"));
		item.setItem_fund(request.getParameter("Item_fund"));
		//得到登录者的信息
		user=(User) request.getSession().getAttribute("user");
		if(user!=null) {
			//调用service,更新item
			int i= itemService.itemUpdate(item);
		if(i!=0) {
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		}else {
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		out.close();
	}
}
