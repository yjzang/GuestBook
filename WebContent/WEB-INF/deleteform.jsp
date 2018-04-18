<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<% 
	 	String no = request.getParameter("no"); 
		String pw_DB = request.getParameter("pw_DB");
	%>
	<form method="post" action="./controller">
	<input type='hidden' name="cmd" value="delete">
	<input type="hidden" name= "no" value=<%=no%>>
	<input type="hidden" name= "pw_DB" value=<%=pw_DB%>>
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw_input"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="./controller">go main</a></td>
		</tr>
	</table>
	</form>
</body>
</html>