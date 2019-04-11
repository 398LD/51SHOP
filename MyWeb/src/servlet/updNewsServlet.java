package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mingrisoft.News;

import entity.En_News;
@WebServlet("/updNews")
public class updNewsServlet extends HttpServlet {

	private static final long serialVersionUID = 7278425826005047628L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String newsID=req.getParameter("newsId");
		String upd_NewsTitle=req.getParameter("upd_NewsTitle");
		String upd_NewsContent=req.getParameter("upd_NewsContent");
		En_News users=new En_News();
		users.setNewsID(Integer.parseInt(newsID));
		users.setNewsTitle(upd_NewsTitle);
		users.setNewsContent(upd_NewsContent);
		boolean b = News.updNews(users);
if (b) {
    		
    		resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('编辑成功');");
			out.print("window.location.href='admin/news.jsp'");
			out.print("</script>");
			
		}else {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("alert('编辑失败');");
			out.print("window.location.href='admin/news.jsp'");
			out.print("</script>");
		}
	}
}
