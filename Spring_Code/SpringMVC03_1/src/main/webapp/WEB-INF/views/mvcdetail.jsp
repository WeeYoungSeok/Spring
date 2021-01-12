<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>디테일</h1>
	
	<table>
		<tr>
			<th>작성자</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="50" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'"/>
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${dto.myno}'"/>
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${dto.myno}'"/>
			</td>
		</tr>
	</table>
</body>
</html>