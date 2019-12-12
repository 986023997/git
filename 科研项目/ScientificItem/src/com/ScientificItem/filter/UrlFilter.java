package com.ScientificItem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ScientificItem.model.User;
import com.ScientificItem.service.FilterService;
import com.ScientificItem.service.impl.FilterServiceImpl;

/**
 * Servlet Filter implementation class UrlFilter
 */
/**权限过滤器
 * @author admin
 *
 */
public class UrlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UrlFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest  request2=(HttpServletRequest) request;
		HttpServletResponse  response2=(HttpServletResponse) response;
		FilterService filterService=new FilterServiceImpl();
		/*首先取登录者的id，然后调用service去得到登录者的所有权限，然后跟请求的路径对比，
		看权限中是否包含所请求路径的子串，若有则放行，若没有返回提示没有权限*/
		User user=(User) request2.getSession().getAttribute("user");
		//根据账号id得到账号的权限
		String limiturl=filterService.getLimitUrl(user.getUser_id());
		//得到请求的路径
		String url=request2.getServletPath();
		/*System.out.println(limiturl);
		System.out.println(request2.getServletPath());*/
		//判断用户的权限中是否包含该请求路径，若包含，则放行，若不包含则提示用户“无权访问”
		if(limiturl.contains(url)){
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
		else{
			request.setAttribute("error", "无权访问");
			request2.getRequestDispatcher("/pages/user_item/error.jsp").forward(request2, response2);
			
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
