<%@page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>出品画面</title>

<!-- ヘッダーの挿入 -->
<%@include file="/common/header"%>

</head>
<body>

	<table align="center" width="800">
		<tr>
			<td width="80">[<a href="<%=request.getContextPath() %>/view/menu.jsp">メニューに戻る</a>]</td>

			<td width="160"><font size="6">出品フォーム</font></td>
		<tr>
	</table>

	<hr align="center" size="2" color="orange" width="100%"></hr>
	<h3 align="center">出品する商品情報を入力してください</h3>
	<form action="<%=request.getContextPath()%>/insertgoods">
		<table align="center" width="500">
			<tr>
				<th style="background-color: ffd700; width: 100">商品名</th>
				<td><input type=text size="30" name="goods_name"></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">商品説明</th>
				<td><textarea name="goods_description" rows="5" cols="30"></textarea></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">出品地域</th>
				<td><input type=text size="30" name="sale_districts"></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">カテゴリー</th>
				<td><input type=text size="30" name="category"></td>
			</tr>

			<tr>
				<th style="background-color: ffd700; width: 100">価格</th>
				<td><input type=text size="30" name="price"></td>
			</tr>

			<tr>
				<th style="background-color: ffd700; width: 100">商品の状態</th>
				<td><input type=text size="30" name="goods_status"></td>
			</tr>

			<tr>
				<th style="background-color: ffd700; width: 100">発送方法</th>
				<td><input type=text size="30" name="shipping_method"></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">発送日数</th>
				<td><input type=text size="30" name="ship_days"></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">発送状況</th>
				<td><select name="ship_status">
						<option value="1">発送前</option>
						<option value="2">発送中</option>
						<option value="3">発送完了</option>
				</select></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">入金状況</th>
				<td><select name="payment_status">
						<option value="1">未入金</option>
						<option value="2">入金完了</option>
				</select></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">販売状況</th>
				<td><select name="payment_status">
						<option value="1">販売中</option>
						<option value="2">売り切れ</option>
				</select></td>
			</tr>
			<tr>
				<th style="background-color: ffd700; width: 100">送料(全国一律)</th>
				<td><input type=text size="30" name="postage"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="listing" value="出品"></td>
			</tr>

		</table>
	</form>


	<br>
	<br>
	<br>
	<br>

</body>
<footer>

	<!-- フッターの挿入 -->
	<%@include file="/common/footer"%>
</footer>
</html>
