<%@page import="entity.En_News"%>
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
			<img src="img/4.gif" alt="">
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
				<div style="font-size: 14px; margin-top: 53px; line-height: 36px;">
					<div id="tab_con">
						<div id="tab_con_2" class="dis-n" style="display: none;">
							<div class="content_main">
								<%
										request.setCharacterEncoding("UTF-8"); 
										
										int newsId = Integer.parseInt(request.getParameter("newsId"));
									En_News news=News.QueryNewsByID(newsId);
									String[] content=news.getNewsContent().split("#");
									
								%>
								<br><h2 style="font-size:28px;margin-left:30%"><%=news.getNewsTitle()%></h2>
									<%
									for(int j=0;j<content.length;j++){
										%>
										<p><%=content[j] %></p>
										<% 
									}
									%>		
							</div>
						</div>

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