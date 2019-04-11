package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mingrisoft.News;
@WebServlet("/delNews")
public class delNewsServlet extends HttpServlet {

	private static final long serialVersionUID = -8848293617175269912L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String newsID=req.getParameter("NewsID");
		boolean b = News.delNews(newsID);
		if (b) {
    		
    		resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('删除成功');");
			out.print("window.location.href='admin/news.jsp'");
			out.print("</script>");
			
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('删除失败');");
			out.print("window.location.href='admin/news.jsp'");
			out.print("</script>");
		}
	}
}
