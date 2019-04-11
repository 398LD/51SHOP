<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="javax.imageio.*"%>
<%@ page import="com.mingrisoft.*"%>

<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>科讯科技有限公司</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link rel="stylesheet"
			href="css/amazeui.min.css" />
		<style>
		
.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
</style>
	</head>
	

	<body>
		
		<div class="header">
			<div class="am-g">
				<h1>
					科讯科技有限公司
				</h1>
			</div>
			<hr />
		</div>
		
		<div class="am-g">
			<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
				<form action="../doLogin" method="post" class="am-form login-form" onSubmit="return LoginCheck()">
					<label for="name">
						用户名:
					</label>
					<input type="text" name="User" id="User"  value="">
					<br>
					<label for="ps">
						密码:
					</label>
					<input type="password" name="Pwd"  id="Pwd"  value="">
					<br>

					<br />
					<div class="am-cf">
					
					<input name="Action" type="hidden" value="Login">
					
					
					<input type="submit" value="登 录" id="save"	class="am-btn am-btn-primary am-btn-sm am-fl">

					</div>
				</form>
				
			</div>
		</div>
		
	</body>

	<script src="js/jquery.min.js"></script>
	<script src="js/amazeui.min.js"></script>
<script>
function LoginCheck() 
{   

    var LoginCheck = false;
    if($("#User").val()==="" || $("#Pwd").val()===""){
		alert("用户名或密码不能为空!");
        return false;
	}
    
    return true;
}
</script>
	<!--<![endif]-->
</html>