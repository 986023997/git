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

/**��Ŀ����
 * @author admin
 *
 */
public class ItemApplicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ַ�����
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//�õ�������е���Ϣ
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
		//����ҵ��������Ŀ���õ�����ֵ ��Ϊ0���ʧ�ܣ�����ʧ�ܣ���Ϊ0���ɹ���
		int i=itemService.applicationItem(item);
		if(i!=0) {
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "����");
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("itemapplication.jsp").forward(request, response);
		}
		out.close();
	}
	
	
	
	

}
