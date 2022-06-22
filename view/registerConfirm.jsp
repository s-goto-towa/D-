<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.User, bean.Address" %>

<%
User user = (User)request.getAttribute("user");
Address address = (Address)request.getAttribute("address");

%>
<html>
<head>
<title>登録確認</title>
<link rel = "stylesheet" href = "<%=request.getContextPath() %>/css/style.css">
</head>
<body>
<div style="text-align: center">
<h2>新規会員登録内容確認</h2>
<hr style="background-color: orange; width: 100%; height: 3px"/>

<table style="margin: 0 auto; text-align: center">
<tr>
<th>ユーザーID</th>
<td><%=user.getUser_id() %></td>
</tr>
<tr>
<th>パスワード</th>
<td><%=user.getPassword() %></td>
</tr>
<tr>
<th>苗字</th>
<td><%=user.getLast_name() %></td>
</tr>
<tr>
<th>苗字(カナ)</th>
<td><%=user.getLast_namekana() %></td>
</tr>
<tr>
<th>名前</th>
<td><%=user.getFirst_name() %></td>
</tr>
<tr>
<th>名前(カナ)</th>
<td><%=user.getFirst_namekana() %></td>
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
<tr>
<th>住所(カナ)</th>
<td><%=address.getAdress_kana() %></td>
</tr>

<tr>
<td><form action="<%=request.getContextPath() %>/delete">
<input type="hidden" name="user_id" value=<%=user.getUser_id() %>>
<input type="hidden" name="cmd" value="register">
<input type="submit" value="もう一度入力する">
</form></td>

<td><form action="./view/registerComplete.jsp">
<input type="submit" value="登録完了">
</form></td>
</tr>

</table>
</div>
</body>
</html>