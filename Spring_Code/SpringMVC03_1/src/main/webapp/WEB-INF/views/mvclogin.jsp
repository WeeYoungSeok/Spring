<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		$("#loginchk").hide();
	})
	function loginPrc() {
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		if (memberid == "" || memberpw == "") {
			$("#loginchk").show();
			$("#loginchk").text("아이디와 비밀번호를 입력해주세요.");
			$("#loginchk").css("color","red");
		} else {
			$.ajax({
				type: "post",
				url: "login.do",
				data: JSON.stringify(loginVal),
				contentType: "application/json",
				dataType: "json",
				success: function (msg){
					if (msg.check == true) {
						alert("로긴 추카");
						location.href = "list.do";
					} else {
						$("#loginchk").show();
						$("#loginchk").text("아이디와 비밀번호를 확인해주세요.");
						$("#loginchk").css("color","red");
					}
				},
				error: function() {
					alert("통신 실패");
				}
			});
			
		}
	}
</script>
</head>
<body>

	<h1>로그인</h1>

	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid" /></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="login"
				onclick="loginPrc()" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginchk"></td>
		</tr>
	</table>
</body>
</html>