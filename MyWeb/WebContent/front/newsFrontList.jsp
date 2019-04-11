<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entity.En_News"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.mingrisoft.*"%>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
 
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>科讯科技有限公司</title>
		<link href="css/main.css" rel="stylesheet" type="text/css">
		<link href="css/container.css" rel="stylesheet" type="text/css">
		<link href="css/reset.css" rel="stylesheet" type="text/css">
		<link href="css/screen.css" rel="stylesheet" type="text/css">
		<script src="js/jquery.min.js">
</script>
		<script src="js/tab.js">
</script>
	</head>

	<body>
		<%@ include file="common_header.jsp"%>

		<!--banner-->
		<div class="second_banner">
			<img src="img/3.gif" alt="">
		</div>
		<!--//banner-->
		<!--新闻-->
		<div class="container">
	<div class="left">
        <div class="menu_plan">
            <div class="menu_title">公司动态<br><span>news of company</span></div>
			 <ul id="tab">
                <li ><a href="#">公司新闻</a></li>
            </ul>
        </div>
     </div>
     <div class="right">
            <div class="location">
                <span>当前位置：<a href="javascript:void(0)" id="a"><a href="#">公司新闻</a></a></span>
                <div class="brief" id="b"><a href="#">公司新闻</a></div>
            </div>
            <div style=" font-size:14px; margin-top:53px; line-height:36px;">
               <div id="tab_con">
                    <div id="tab_con_2" class="dis-n" style="display: none;">
							<table style="margin-top:70px">
								<tbody>
									<tr class="tt_bg">
										
										<td>
											新闻标题
										</td>
										<td>
											发布人
										</td>
										<td>
											发布时间
										</td>
										<td>
											详情
										</td>
										
									</tr>
									
									<%
										request.setCharacterEncoding("UTF-8"); 
								
								HttpSession session2=request.getSession();
								int page1=1;
								if(session2.getAttribute("page1")!=null){
									 page1=(Integer)session2.getAttribute("page1");
								}else{
									page1=2;
								}
								
								
									
								
								
									ArrayList<En_News> list=News.QueryByPage(page1-1);
									if(list!=null&&list.size()>0){
										for(int i=0;i<list.size();i++){
											En_News en_News=list.get(i);
											%>
											 <tr>
											<td><%=en_News.getNewsTitle() %></td>
											<td><%=en_News.getAdminName() %></td>
											<td><%=en_News.getNewsTime() %></td>
											<td><a href="newsFrontDetail.jsp?newsId=<%=en_News.getNewsID()%>">详情</a></td>
											</tr>
											<% 
										}
										
									}else{
										out.println("<tr ><td colspan=4>到底了</td></tr>");
										
										
										page1=1;
										
										
									}
									
								
									session2.setAttribute("page1", ++page1);
									%>
									
							</tbody>
							</table>
						</div>
                    <button onclick="nextpage()" style="height:30px; width: 100px; border: 0px solid; background-color: #2166a9; color: white;">下一页(<%=page1-2 %>)</button>
                    <script type="text/javascript">
                    
                   
                    	function nextpage(){
                    		
                    		window.location.href="newsFrontList.jsp";
                    		
                    	}
                    </script>
				</div>
            </div>
    </div>
</div>
		<!--//新闻-->
		<!--底部-->
		<%@ include file="common_footer.jsp"%>
		
	</body>

	<!--//底部-->
	<script>
tabs("#tab", "active", "#tab_con");
</script>


	
</script>

</html>
