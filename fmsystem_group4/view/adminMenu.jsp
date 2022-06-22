<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>管理者画面</title>
</head>
<body>
	<%@include file="/common/adminheader.jsp" %>

	<p align="center">
		<font size="5">管理者メニュー</font>
	</p>
	<hr align="center" size="2" color="ffa500" width="950">

	<br>
	<p align="center">
		<a href="<%=request.getContextPath()%>/userlist">ユーザー一覧</a>
	</p>
	<p align="center">
		<a href="<%=request.getContextPath()%>/goodslist">商品一覧</a>
	</p>
	<br>
	<p align="center">
		<a href="<%=request.getContextPath()%>/logout">ログアウト</a>
	</p>

	<%@include file="/common/adminfooter.jsp" %>
</body>
</html>
