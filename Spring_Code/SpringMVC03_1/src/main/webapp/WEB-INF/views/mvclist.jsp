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

	<h1>리스트</h1>

	<table>
		<col width="50" />
		<col width="100" />
		<col width="300" />
		<col width="100" />
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>


		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">작성된 글 없음</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr align="center">
						<td>${dto.myno }</td>
						<td>${dto.myname }</td>
						<td><a href="detail.do?myno=${dto.myno}">${dto.mytitle }</a></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.mydate }"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글 작성" onclick="location.href='insertform.do'"/>
			</td>
		</tr>
	</table>
</body>
</html>