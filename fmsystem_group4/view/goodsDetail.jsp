<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="bean.Goods"%>
<%@page import="bean.User"%>


<html>
<head>
<title>詳細情報</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>

	<div style="text-align: center">
		<h2>商品の詳細</h2>
		<%
			Goods goods = (Goods) request.getAttribute("goods");
			User user = (User) request.getAttribute("user");

		%>

		<table align="center">
			<tr>
				<td style="background-color: ffa500; width: 120"><font size="5">商品名</font></td>
				<td><%=goods.getGoods_name()%></td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">価格</td>
				<td><%=goods.getPrice()%>円</td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">商品説明</td>
				<td><%=goods.getGoods_description()%></td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">出品地域</td>
				<td><%=goods.getSale_districts()%></td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">カテゴリー</td>
				<td><%=goods.getCategory()%></td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">商品の状態</td>
				<td><%=goods.getGoods_status()%></td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">発送方法</td>
				<td><%=goods.getShipping_methods()%></td>
			</tr>
			<tr>
				<td style="background-color: ffd700; width: 100">送料</td>
				<td><%=goods.getPostage()%>円</td>
			</tr>
		</table>
		<br>
		<table align="center">
			<tr>
				<td style="background-color: ffd700; width: 100">出品者</td>
				<td><%=user.getNickname()%></td>
			</tr>
		</table>


	</div>

	<%@include file="/common/footer.jsp"%>
</body>
</html>