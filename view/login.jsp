<%@page contentType="text/html; charset=UTF-8"%>
<%
	String user = ""; //ユーザーを管理する変数
	String pass = ""; //パスワードを管理する変数

	Cookie[] userCookie = request.getCookies(); //クッキーの取得

	//クッキーがあるか判定
	if (userCookie != null) {
		for (int i = 0; i < userCookie.length; i++) {
			//クッキーからユーザー情報の取得
			if (userCookie[i].getName().equals("user")) {
				user = userCookie[i].getValue();
			}
			//クッキーからパスワード情報の取得
			if (userCookie[i].getName().equals("pass")) {
				pass = userCookie[i].getValue();
			}
		}
	}

	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
%>
<html>

<head>
<title>ログイン画面</title>
</head>

<body>

	<%@ include file="/common/header.jsp"%>

	<h2 align="center">神田雑貨店フリマアプリへようこそ</h2>
	<br>
	<h2 align="center">ログインページ</h2>

	<form action="<%=request.getContextPath()%>/login" method="POST">
		<table class="input-table" align="center">
			<tr>
				<th>ユーザー</th>
				<td><input type="text" name="user" value=<%=user%>></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="pass" value=<%=pass%>></td>
			</tr>
		</table>
		<p><%=error%></p>
		<input type="submit" value="ログイン"> <br> <br>
		<h3 align="center">会員登録をされていない方はこちら</h3>
		<h3 align="center">↓↓</h3>

		<p align="center">
			<a href="<%=request.getContextPath()%>/register">新規会員登録へ</a>
		</p>



	</form>
	<%@ include file="/common/footer.jsp"%>

</body>


</html>