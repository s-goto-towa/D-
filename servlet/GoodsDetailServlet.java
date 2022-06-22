package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goods;
import bean.User;
import dao.goodsDAO;
import dao.userDAO;

public class GoodsDetailServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラーメッセージとcmd情報を管理する変数
		String error = "";
		String cmd = ""; // フォワード先を区別

		try {
			// 画面から送信される情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			String user_id = request.getParameter("user_id");
			String strGoods_id = request.getParameter("goods_id");


			int goods_id= Integer.parseInt(strGoods_id);

			// userDAOとgoodsDAOクラスのオブジェクトを生成しデータベースに接続
			userDAO userObj = new userDAO();
			goodsDAO goodsObj = new goodsDAO();

			// 表示する情報を格納するUserオブジェクトを生成
			// UserDAOクラスに定義したselectByUser（）メソッドを利用して情報を取得
			User user = userObj.selectByUser(user_id);
			Goods goods = goodsObj.selectByGoods_id(goods_id);
			// 取得した情報をリクエストスコープに登録
			request.setAttribute("goods", goods);
			request.setAttribute("user", user);

			// 詳細情報のエラーチェック

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、表示できませんでした。";
			cmd = "menu";

		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (cmd.equals("detail")) {
				request.getRequestDispatcher("/view/buyConfirm.jsp").forward(request, response);
			} else {
				// エラーのある場合はerror.jspにフォワード
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
