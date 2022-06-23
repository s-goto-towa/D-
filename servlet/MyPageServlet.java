package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Address;
import bean.User;
import dao.AddressDAO;
import dao.UserDAO;

public class MyPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		//エラーメッセージと遷移情報を宣言
		String error = "";
		String cmd = "";

		//Userオブジェクトを生成する
		User user = new User();
		//UserDAOオブジェクトを生成する
		UserDAO userDao = new UserDAO();

		//Addressオブジェクトを生成する
		Address address = new Address();
		//AddressDAOオブジェクトを生成する
		AddressDAO addressDao = new AddressDAO();

		//セッションでユーザー情報を受け取る
		/*
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		String user_id = user.getUser_id;
		*/
		//↑本来はこっち
		//↓下は仮
		String user_id = request.getParameter("user_id");

		try {
			//アカウント情報を読みだす
			user = userDao.selectByUser(user_id);
			address = addressDao.selectByAdress(user_id);

			//ユーザー情報がないときエラー
			if(user.getUser_id() == null || address.getAddress_id() == 0) {
				error = "ユーザー情報が存在しない為、ユーザー情報を表示できません。";
				cmd = "menu";
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

				request.getRequestDispatcher("/view/myPage.jsp").forward(request, response);

			}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}

