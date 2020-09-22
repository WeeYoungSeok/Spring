<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글 상세보기</h1>

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
			<td><textarea rows="6" cols="60" readonly="readonly">${detail.mycontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="취소" onclick="location.href='list.do'" />
				<input type="button" value="수정" onclick="location.href='updateform.do?myno=${detail.myno}'" />
				<input type="button" value="삭제" onclick="location.href='delete.do?myno=${detail.myno}'" />
			</td>
		</tr>
	</table>
</body>
</html>