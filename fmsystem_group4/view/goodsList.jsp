<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Goods"%>

<%
	ArrayList<Goods> goods_list = (ArrayList<Goods>) request.getAttribute("Goods_list");
%>

<html>
	<head>
		<title>書籍一覧</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!--ヘッダー部分  -->
			<%@ include file="/common/header.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ナビゲーション  -->
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/menu.jsp" >[メニュー]</a></li>
							<li><a href ="<%=request.getContextPath()%>/view/insert.jsp">[書籍登録]</a></li>
						</ul>
					</div>

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>書籍一覧</h2>
					</div>
				</div>
			</div>

			<!-- 書籍一覧のコンテンツ部分 -->
			<div id="main" class="container">

				<!-- 検索フォーム -->
				<form class="inline_block" action="<%=request.getContextPath()%>/search" >
		 			ISBN <input type="text"  name="isbn">
					TITLE <input type="text" name="title">
					価格 <input type="text" name="price">
					<input type="submit" value="検索">
				</form>
				<form class="inline_block" action="<%=request.getContextPath()%>/list" >
					<input type="submit" value="全件表示">
				</form>

				<!-- 書籍情報リスト -->
				<table class="list_table">
					<thead>
						<tr>
							<th>商品名</th>
							<th>価格</th>
							<th>詳細</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (goods_list != null) {
							for (Goods goods : goods_list) {
						%>
						<tr>
							<td><%=goods.getGoods_name() %></td>
							<td><%=goods.getPrice() %></td>
							<td>
								<a href="<%=request.getContextPath()%>/goodsdetail?isbn=<%=goods.getGoods_id()%>&cmd=detail">詳細</a>
							</td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>