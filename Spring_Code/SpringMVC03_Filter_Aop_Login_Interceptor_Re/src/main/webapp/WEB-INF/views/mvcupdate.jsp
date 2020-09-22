<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 수정하기</h1>
	
	<form action="updateres.do" method="post">
	<input type="hidden" name="myno" value="${detail.myno }">
		<table>
			<tr>
			<th>작성자</th>
			<td>${detail.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="mytitle" value="${detail.mytitle }"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="6" cols="60" name="mycontent">${detail.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="취소" onclick="location.href='detail.do?myno=${detail.myno }'" />
				<input type="submit" value="완료" />
			</td>
		</tr>
		</table>
	</form>

</body>
</html>