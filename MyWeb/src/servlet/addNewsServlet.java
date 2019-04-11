package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mingrisoft.News;

import entity.En_News;
@WebServlet("/addNews")
public class addNewsServlet extends HttpServlet {

	private static final long serialVersionUID = -3042391775300941360L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	String newsTime =  format1.format(new Date());
	    	String newsTitle=req.getParameter("NewsTitle");
	    	String NewsContent=req.getParameter("NewsContent");
	    	String AdminName=(String)req.getSession().getAttribute("AdminName");
	    	
	    	En_News news=new En_News(newsTitle,NewsContent,newsTime,AdminName);
	    	boolean b = News.addNews(news);
	    	if (b) {
	    		
	    		resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('添加成功');");
				out.print("window.location.href='admin/news.jsp'");
				out.print("</script>");
				
			}else {
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.print("<script>");
				out.print("alert('添加失败');");
				out.print("window.location.href='admin/news.jsp'");
				out.print("</script>");
			}
	}
}
