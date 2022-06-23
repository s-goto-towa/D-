package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Address;
import bean.User;
import dao.UserDAO;
import dao.AddressDAO;

public class RegisterConfirmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		//エラーメッセージと遷移情報を宣言
		String error = "";
		String cmd = "";

		//ユーザーIDを受け取る
		//String user_id = (String)request.getAttribute("user_id");
		//↑本来はこっち

		String user_id = request.getParameter("user_id");

		//Userオブジェクトを生成する
		User user = new User();
		//UserDAOオブジェクトを生成する
		UserDAO userDao = new UserDAO();

		//Addressオブジェクトを生成する
		Address address = new Address();
		//AddressDAOオブジェクトを生成する
		AddressDAO addressDao = new AddressDAO();

		try {
			//登録した情報を読みだす
			user = userDao.selectByUser(user_id);

			//登録した情報を読みだす
			address = addressDao.selectByAddress(user_id);

			//ユーザー情報があるか確認
			if(user.getUser_id() == null) {
				error = "ユーザー情報が存在しない為、ユーザー情報を表示できません。";
				cmd = "insert";
				return;
			}

			//エラー処理
		}catch(IllegalStateException e) {
			error = "DB接続エラーの為、ユーザー情報を表示できません。";
			cmd = "logout";

		}finally {
			if(error.equals("")) {
				request.setAttribute("user", user);
				request.setAttribute("address", address);

				request.getRequestDispatcher("/view/registerConfirm.jsp").forward(request, response);

			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
