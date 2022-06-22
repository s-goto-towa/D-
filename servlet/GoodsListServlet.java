package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goods;
import dao.GoodsDAO;

public class GoodsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		try {
			GoodsDAO goodsDao = new GoodsDAO();

			ArrayList<Goods> list = goodsDao.selectAll();

			request.setAttribute("Goods_list", list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録できませんでした。";


		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/goodsList.jsp").forward(request, response);
			} else {
				request.setAttribute("error", error);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}

