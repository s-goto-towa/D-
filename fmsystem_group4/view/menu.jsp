<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>メニュー画面</title>
</head>
<body>
	<%@include file="/common/header.jsp" %>

		<p align="center">
		<font size="6">MENU</font>
	</p>
	<hr align="center" size="2" color="ffa500" width="950">

	<br>
	<p align="center">
		<a href="<%=request.getContextPath()%>/insertgoods"><font size="4">売る（出品する！）</font></a>
	</p>
	<p align="center">
		<a href="<%=request.getContextPath()%>/goodslist"><font size="4">買う（商品を探す！）</font></a>
	</p>
	<p align="center">
		<a href="<%=request.getContextPath()%>/listingconfirm">出品中の商品</a>
	</p>
	<p align="center">
		<a href="<%=request.getContextPath()%>/mypage">アカウント情報</a>
	</p>


	<br>
	<p align="center">
		<a href="<%=request.getContextPath()%>/logout">ログアウト</a>
	</p>

	<%@include file="/common/footer.jsp" %>
</body>
</html>
