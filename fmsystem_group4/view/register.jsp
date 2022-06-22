<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>新規登録</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>


	<h2 align="center">新規会員登録</h2>

	<hr align="center" size="2" color="ffa500" width="950"></hr>

	<h3 align="center">登録する情報を入力してください。</h3>

	<form action="<%=request.getContextPath()%>/registerServlet">
	<table style="margin: 0 auto">
		<tr>
			<th style="background-color: ffa500; width: 100">ユーザーID</th>
			<td><input type=text size="30" name="user_id"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffa500; width: 100">パスワード</th>
			<td><input type="password" size="30" name="password"></input></td>
		</tr>
	</table>

	<br>

	<table style="margin: 0 auto">
		<tr>
			<th style="background-color: ffd700; width: 100">苗字</th>
			<td><input type=text size="30" name="last_name"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">苗字（カナ）</th>
			<td><input type="text" size="30" name="last_namekana"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">名前</th>
			<td><input type=text size="30" name="first_name"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">名前（カナ）</th>
			<td><input type="text" size="30" name="first_namekana"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">ニックネーム</th>
			<td><input type=text size="30" name="nickname"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">生年月日</th>
			<td><input type="text" size="30" name="birthday"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 120">メールアドレス</th>
			<td><input type="text" size="30" name="mail_address"></input></td>
		</tr>

	</table>
	<br>
	<table style="margin: 0 auto">
		<tr>
			<th style="background-color: ffd700; width: 100">郵便番号</th>
			<td><input type="text" size="30" name="post_code"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">都道府県</th>
			<td><input type="text" size="30" name="prefectures"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">市区町村</th>
			<td><input type="text" size="30" name="municipality"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">番地以降</th>
			<td><input type="text" size="30" name="street"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">建物名</th>
			<td><input type="text" size="30" name="buliding"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">部屋番号</th>
			<td><input type="text" size="30" name="room_number"></input></td>
		</tr>
		<tr>
			<th style="background-color: ffd700; width: 100">住所（カナ）</th>
			<td><textarea rows="10" name="address_kana"></textarea></td>
		</tr>

		<tr>
			<td colspan=2 style="text-align: center"><input type="submit" value="登録"></td>
		</tr>

	</table>
</form>


	<%@include file="/common/footer.jsp"%>
</body>
</html>