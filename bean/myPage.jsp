<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.User, bean.Address" %>

<%
User user = (User)request.getAttribute("user");
Address address = (Address)request.getAttribute("address");

%>

<head>
<title>マイページ情報画面</title>
</head>
<body>
	<div style="text-align: center">
	<%@include file="/common/header.jsp"%>

		<%--css入れれば直る --%>
		<%--メニュー、書籍一覧のリンク、タイトルを表示 --%>
		<div id="title">
			<div class="clearfix underline">
				<div class="titleflo">
					<ul class="titleli">
						<li>[<a href ="<%=request.getContextPath()%>/view/menu.jsp">メニュー</a>]</li>
					</ul>
				</div>
				<div class="titleflo">
					<h2>アカウント情報</h2>
				</div>
			</div>
		</div>

		<table style="margin: 0 auto; text-align: center">

			<tr>
			<th>氏名</th>
			<td><%=user.getLast_name() %> &nbsp; <%=user.getFirst_name() %></td>
			</tr>
			<tr>
			<th>氏名(カナ)</th>
			<td><%=user.getLast_namekana() %> &nbsp; <%=user.getFirst_namekana() %></td>
			</tr>
			<tr>
			<th>ニックネーム</th>
			<td><%=user.getNickname() %></td>
			</tr>
			<tr>
			<th>生年月日</th>
			<td><%=user.getBirthday() %></td>
			</tr>
			<tr>
			<th>メールアドレス</th>
			<td><%=user.getMail_adress() %></td>
			</tr>
			<tr>
			<th>郵便番号</th>
			<td><%=address.getPost_code() %></td>
			</tr>
			<tr>
			<th>都道府県</th>
			<td><%=address.getPrefectures() %></td>
			</tr>
			<tr>
			<th>市区町村</th>
			<td><%=address.getMunicipality() %></td>
			</tr>
			<tr>
			<th>番地以降</th>
			<td><%=address.getStreet() %></td>
			</tr>
			<tr>
			<th>建物名</th>
			<td><%=address.getBuilding() %></td>
			</tr>
			<tr>
			<th>部屋番号</th>
			<td><%=address.getRoom_number() %></td>
			</tr>

		</table>
	<%@include file="/common/footer.jsp"%>
	</div>
</body>
</html>