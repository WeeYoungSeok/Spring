<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<td>${detail.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${detail.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="6" cols="50" readonly="readonly">${detail.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="목록" onclick="location.href='list.do'"/>
				<input type="button" value="수정" onclick=""/>
				<input type="button" value="삭제" onclick=""/>
			</td>
		</tr>
	</table>
</body>
</html>