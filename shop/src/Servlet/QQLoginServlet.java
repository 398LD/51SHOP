package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.kexun.entity.UserInfo;
import com.kexun.login.QQLogin;
@WebServlet("/QLogin")
public class QQLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accessToken = req.getParameter("access_token");
		resp.setContentType("application/json;charset=utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = resp.getWriter();
		try {
			UserInfo user = QQLogin.getUser(accessToken,"101543277");
			System.out.println(JSON.toJSONString(user));
			HttpSession session = req.getSession();
			session.setAttribute("qUser", user);
			out.write(JSON.toJSONString(user));
			System.out.println("来了");
			
		} catch (Exception e) {
			out.write("{\"error\":\"accessToken非法\"}");
			
		}
	}
	
}
