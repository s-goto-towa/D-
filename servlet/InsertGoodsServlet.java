package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Goods;
import dao.GoodsDAO;

public class InsertGoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		try {
			// 文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			// DTOオブジェクト宣言
			Goods goodsInfo = new Goods();
			// DAOオブジェクト宣言
			GoodsDAO goodsDao = new GoodsDAO();

			// パラメータの取得
			String goods_name = request.getParameter("goods_name");
			String description = request.getParameter("goods_description");
			String districts = request.getParameter("sale_districts");
			String category = request.getParameter("category");

			// goodsInfoオブジェクトにリクエストスコープのデータ登録
			goodsInfo.setGoods_name(goods_name);
			goodsInfo.setGoods_description(description);
			goodsInfo.setSale_districts(districts);
			goodsInfo.setCategory(category);
			goodsInfo.setGoods_status(request.getParameter("goods_status"));
			goodsInfo.setPayment_status(Integer.parseInt(request.getParameter("payment_status")));
			goodsInfo.setPostage(Integer.parseInt(request.getParameter("postage")));
			goodsInfo.setPrice(Integer.parseInt(request.getParameter("price")));
			goodsInfo.setSale_status(Integer.parseInt(request.getParameter("sale_status")));
			goodsInfo.setShip_days(Integer.parseInt(request.getParameter("ship_days")));
			goodsInfo.setShip_status(Integer.parseInt(request.getParameter("ship_status")));
			goodsInfo.setShopping_methods(request.getParameter("shopping_methods"));


			// DAOオブジェクトのinsertメソッドにgoodsInfoを引数として与える
			goodsDao.insert(goodsInfo);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、登録できませんでした。";

		} catch (Exception e) {
			error = "予期せぬエラーが発生しました。<br>" + e;

		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view.listingConfirm.jsp").forward(request, response);

			} else {

				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
