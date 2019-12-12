package com.ScientificItem.servlet;

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

/**项目申请
 * @author admin
 *
 */
public class ItemApplicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//字符处理
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//得到申请表单中的信息
		ItemDao itemDao=new ItemDaoImpl();
		ItemService itemService=new ItemServiceImpl(itemDao);
		User user=null;
		Item item=new Item();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user=(User) request.getSession().getAttribute("user");

		item.setItem_name(request.getParameter("Item_name"));
		item.setItem_app_id(user.getUser_id());
		try {
			System.out.println(request.getParameter("Item_date"));
			item.setItem_date(sdf.parse(request.getParameter("Item_date")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		item.setItem_topic(request.getParameter("Item_topic"));
		item.setItem_content((request.getParameter("Item_content")));
		item.setItem_fund(request.getParameter("Item_fund"));
		//调用业务，申请项目，得到返回值 （为0入库失败，申请失败，不为0，成功）
		int i=itemService.applicationItem(item);
		if(i!=0) {
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "出错");
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("itemapplication.jsp").forward(request, response);
		}
		out.close();
	}
	
	
	
	

}
