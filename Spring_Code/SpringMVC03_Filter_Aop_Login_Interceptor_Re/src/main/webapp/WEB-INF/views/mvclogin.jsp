<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginchk").hide();
	});
	
	function loginPrc() {
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		};
		
		if (memberid == null || memberid == "" || memberpw == null || memberpw == "") {
			alert("아이디와 비밀번호를 모두 입력해주세요.");
		} else {
			$.ajax({
				type: "post",
				url: "ajaxlogin.do",
				data: JSON.stringify(loginVal),
				contentType: "application/json",
				dataType: "json",
				success: function(msg) {
					if (msg.check == true) {
						location.href="list.do";
					} else {
						$("#loginchk").show();
						$("#loginchk").html("아이디와 바밀번호를 확인해주세요.").css("color", "red");
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
			<th>아이디</th>
			<td><input type="text" id="memberid"/></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="text" id="memberpw"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="로그인" onclick="loginPrc();"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginchk">
			
			</td>
		</tr>
	</table>

</body>
</html>