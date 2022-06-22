<%@page contentType="text/html;charset=UTF-8" %>

<%@page import="java.util.ArrayList,bean.Goods"%>
<%@page import="bean.User" %>
<%
User user=(User)session.getAttribute("user");

%>
<html>

<head>
    <title>商品一覧</title>
    <!-- ヘッダーの挿入 -->
		<%@include file="/common/header" %>
</head>

<body>


    <table align="center" width="800">
        <tr>
            <td width="80">[<a href="<%=request.getContextPath() %>/view/menu.jsp">メニューに戻る</a>]</td>

            <td width="100">
                <font align="center" size="6">商品一覧</font>
            </td>
        <tr>

    </table>
    <hr align="center" size="2" color="orange" width="100%"></hr>
    <div style="text-align: center">

<%
			ArrayList<Goods> list =(ArrayList<Goods>)request.getAttribute("Goods_list");
			if(list != null&&user.getAuthority()==1){
				for(int i=0;i<list.size();i++){
					Goods goods = (Goods)list.get(i);
			%>
        1, バッグ<br>
        <a href="./detail.jsp">詳細閲覧</a><br>

			<tr>
			<th style="background-color: ffd700; width: 100">売上：</th>
			<td size="30"> <%=goods.getPrice()%></td>
			</tr>
         2,シューズ<br>
        <a href="./detail.jsp">詳細閲覧</a><br>

       <tr>
			<th style="background-color: ffd700; width: 100">売上：</th>
			<td size="30"> <%= goods.getPrice()%></td>
			</tr>

		<%}
				}%>
    </div>
    <br><br><br><br><br><br>

</body>
<footer>

	<!-- フッターの挿入 -->
	<%@include file="/common/footer"%>
</footer>

</html>