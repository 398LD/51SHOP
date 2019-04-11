package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingrisoft.UsersDao;

import entity.Users;

public class doLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 4444431582778187671L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("User");
		String pwd=req.getParameter("Pwd");
		Users users = UsersDao.SerichByNameAndPwd(user,pwd);
		if (users!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("AdminName",users.getAdminName());
			resp.sendRedirect("admin/adminUser.jsp");
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('账号或密码错误');");
			out.print("window.location.href='admin/login.jsp'");
			out.print("</script>");
		}
	}
	
}
