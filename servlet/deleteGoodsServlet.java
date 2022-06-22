package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goodsDAO;

public class deleteGoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";
		try {
			// BookDaoクラスのオブジェクト生成
			goodsDAO goodsDAO = new goodsDAO();

			// 画面から送信されるgoods_idとcmd情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// 画面から送信されるISBNとcmd情報を受け取ります
			int goods_id = Integer.parseInt(request.getParameter("goods_id"));
			// 削除対象の書籍が存在しないエラー
			if (goodsDAO.selectByGoods_id(goods_id)==null) {
				error = "削除対象の書籍が存在しない為、書籍削除処理は行えませんでした。";
				cmd = "list";
				return;
			}

			// BookDAOクラスに定義したdelete（）メソッドを利用して書籍情報を削除
			goodsDAO.delete(goods_id);

			// 接続エラー
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍削除処理は行えませんでした。";
			cmd = "logout";
		} finally {
			if (error.equals("")) {
				// 「ListServlet」へフォワード
				request.getRequestDispatcher("/list").forward(request, response);
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
