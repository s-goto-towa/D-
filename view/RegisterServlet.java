package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Address;
import bean.User;
import dao.AddressDAO;
import dao.UserDAO;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エラーメッセージと遷移情報を宣言
		String error = "";
		String cmd = "";

		// Userオブジェクトを生成する
		User user = new User();
		// Addressオブジェクトを生成する
		Address address = new Address();

		// フォームから受け取る
		// ユーザー情報
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String last_name = request.getParameter("last_name");
		String last_namekana = request.getParameter("last_namekana");
		String first_name = request.getParameter("first_name");
		String first_namekana = request.getParameter("first_namekana");
		String nickname = request.getParameter("nickname");
		String birthday = request.getParameter("birthday");
		String mail_address = request.getParameter("mail_address");

		//Userクラスに登録
		user.setUser_id(user_id);
		user.setPassword(password);
		user.setLast_name(last_name);
		user.setLast_namekana(last_namekana);
		user.setFirst_name(first_name);
		user.setFirst_namekana(first_namekana);
		user.setNickname(nickname);
		user.setBirthday(birthday);
		user.setMail_address(mail_address);

		// 住所情報
		String post_code = request.getParameter("postcode");
		String prefectures = request.getParameter("prefectures");
		String municipality = request.getParameter("municipality");
		String street = request.getParameter("street");
		String building = request.getParameter("building");
		String room_number = request.getParameter("room_number");
		String address_kana = request.getParameter("address_kana");

		//Addressクラスに登録
		address.setPost_code(post_code);
		address.setPrefectures(prefectures);
		address.setMunicipality(municipality);
		address.setStreet(street);
		address.setBuilding(building);
		address.setRoom_number(room_number);
		address.setAddress_kana(address_kana);

		// UserDAOオブジェクトを生成
		UserDAO userDao = new UserDAO();
		// AddressDAOオブジェクトを生成
		AddressDAO addressDao = new AddressDAO();

		try {
			// 重複チェック
			user = userDao.selectByUser(user_id);

			// 重複があればやり直し
			if (user.getUser_id() != null) {
				error = "";
				cmd = "insert";
				return;
			}

			// 住所情報を登録する
			addressDao.insertAddressInfo(address);

			// 住所情報を読みだす
			address = addressDao.selectByAddress(user_id);

			// アドレスIDがないとき
			if (address.getPrefectures().equals("")) {
				error = "";
				cmd = "insert";
				return;
			}

			// 新規ユーザー情報を登録する
			userDao.insertUserFirst(user);

			// エラー処理
		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、新規登録できません。";
			cmd = "logout";

		} finally {
			// エラーがないとき
			if (error.equals("")) {
				request.setAttribute("user_id", user_id);

				request.getRequestDispatcher("/registerconfirm.jsp").forward(request, response);

				// エラーがあるとき
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);

				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}
}
