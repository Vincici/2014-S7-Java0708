<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
<h1 style="color:red">Index</h1>

<a href="<%=request.getContextPath() %>/index/show?name=tom&batch=java">测试参数</a>

<br/>
${name }
<br />
${batch }
<hr />
${student.name }
<br/>
${student.batch }





</body>
</html>