package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.userDAO;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String userid = "";
		String cmd = "";
		int authority=0;
		try {
			// UserDAOクラスのオブジェクト生成
			userDAO userDao = new userDAO();

			// 画面から送信されるuser_idとpassword情報を受け取るためのエンコードを設定
			request.setCharacterEncoding("UTF-8");

			// 画面から送信されるuser_idとpassword情報を受け取ります
			userid = request.getParameter("user");
			String password = request.getParameter("pass");

			// UserDaoクラスに定義したselectByUser（）メソッドを利用して書籍情報を取得します。
			User user = userDao.selectByUser(userid, password);

			//権限を取得
			authority=user.getAuthority();

			// User情報が存在しないエラー
			if (user.getUser_id() == null) {
				error = "入力データが間違っています。";
				cmd = "relogin";
				return;
			}
			// 取得した書籍情報を「user」という名前でセッションに登録
			HttpSession session=request.getSession();
			session.setAttribute("user", user);

			// クッキーに入力情報のuseridとpasswordを登録する。
			Cookie userCookie = new Cookie("user", userid);
			userCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(userCookie);

			Cookie passwordCookie = new Cookie("pass", password);
			passwordCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(passwordCookie);
			// 接続エラー処理
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
			cmd = "logout";

		} finally {
			// エラーの有無でフォワード先を変える
			if (error.equals("")) {
				//権限によてフォワード先を変える
				if(authority==1) {
					request.getRequestDispatcher("/view/adminMenu.jsp").forward(request, response);
				}else if(authority==2) {
					request.getRequestDispatcher("/view/menu.jsp").forward(request, response);
				}
			} else {
				if(cmd.equals("relogin")) {
					request.setAttribute("error", error);
					request.getRequestDispatcher("/view/login.jsp").forward(request, response);

				}else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			}

		}
	}
}
