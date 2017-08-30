<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<%
			String username = (String)request.getSession().getAttribute("username");
		%>
		<style>
			body{
				margin:0;
			}
			.head{
				height:50px;
				width:100%;
				background-color:#00EC00;
			}
			.logo{
				color:red;
				font-style:Italic;
				font-weight:bold;
				font-size:25px;
				line-height:50px;
				margin:0 20px 0 20px;
			}
			.search{
				height:100%;
			}
			#userInfo{
				float:right;
				line-height:50px;
				margin-right:20px;
			}
			#shadowDiv{
				position:absolute;
				width:100%;
				height:100%;
				top:0;
				left:0;
				z-index:2;
				background-color:#3D7878;
				opacity:0.4;
				display:none;
			}
			#login{
				position:absolute;
				z-index:3;
				width:400px;
				height:220px;
				top:50%;
				left:50%;
				margin:-110px 0 0 -200px;
				background-color:white;
				box-shadow:10px 10px 5px #613030;
				display:none;
				padding:10px;
				border-radius:10px;
			}
			#login span{
				display:block;
			}
			#login label{
				height:50px;
				line-height:50px;
				font-size:20px;
				width:20%;
				display:inline-block;
			}
			#login input{
				font-size:18px;
				width:75%;
				display:inline-block;
				outline:none;
				border:none;
				border-bottom:1px solid red;
			}
			.closeSpan{
				display:block;
				width:20px;
				height:20px;
				float:right;
				border:1px solid black;
				border-radius:10px;
				cursor:pointer;
				text-align:center;
				line-height:20px;
			}
			.closeSpan:hover{
				background-color:yellow;
				color:red;
			}
			
			.submita{
				width:90%;
				display:block;
				margin:auto;
				height:40px;
				background-color:#0080FF;
				text-align:center;
				text-decoration:none;
				font-size:20px;
				line-height:40px;
				
			}
		</style>
	</head>
<body>
	
	<div class="head">
		<span class="logo">Video</span>
		<span class="search">
			<input type="text" name="content" style="width:30%;height:30px;"/>
			<input type="submit" value="搜索" />
		</span>
		
		<span id="userInfo">
			<%if(username == null || "".equals(username)){ %>
				<a href="javascript:login()">登录</a>&nbsp;|&nbsp;<a href="javascript:register()">注册</a>
			<%}else{ %>
				<a href=""><%=username %></a>
			<%} %>
		</span>
	</div>
	
	
	<div id="shadowDiv">
	</div>
	<form action="<%=request.getContextPath() %>/login" method="post">
	
	<div id="login">
		<span class="closeSpan" onclick="clearShadow()">x</span>
		<span style="margin-top:50px;">
			<label for="username">用户名</label>
			<input type="text" name="username"/>
		</span>
		<span>
			<label for="password">密码</label>
			<input type="password" name="pw" />
		</span>
		<span style="margin-top:20px;">
			<a href="javascript:submitLogin()" class="submita">登&nbsp;&nbsp;录</a>
		</span>
	</div>
	</form>
</body>
<script>
	function login(){
		document.getElementById("shadowDiv").style.display = "block";
		document.getElementById("login").style.display = "block";
	}
	
	function clearShadow(){
		document.getElementById("shadowDiv").style.display = "none";
		document.getElementById("login").style.display = "none";
		
	}
	
	function submitLogin(){
		document.forms[0].submit();
	}
</script>



</html>