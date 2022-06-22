package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.User;

public class UserDAO {
	private static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost/fmdb_group4";
	private static String USER = "root";
	private static String PASSWD = "root123";

	public static Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	public User selectByUser(String userid) {
		Connection con = null;
		Statement smt = null;

		User user = new User();
		try {
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "SELECT * FROM userinfo WHERE user ='" + userid + "'";

			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果をUserオブジェクトに格納
			while (rs.next()) {

				user.setUser_id(rs.getString("user"));
				user.setPassword(rs.getString("password"));
				user.setMail_adress(rs.getString("email"));
				user.setAuthority(rs.getInt("authority"));

			}
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return user;
	}
	//新規ユーザー情報を登録する
		public void insertUserFirst(User user) {

			//データベース接続のための変数を宣言
			Connection con = null;
			Statement smt = null;

			//登録結果を格納する変数を宣言
			int count = 0;

			//登録を行うSQL文
			String sql = "INSERT INTO userinfo(user_id,password,authority,last_name,last_namekana,"
					+ "first_name,first_namekana,birthday,mail_address,address_id,nickname,create_date) VALUES('"
					+user.getUser_id()+ "','"
					+user.getPassword()+ "',1,'"
					+user.getLast_name()+ "','"
					+user.getLast_namekana()+ "','"
					+user.getFirst_name()+ "','"
					+user.getFirst_namekana()+ "','"
					+user.getBirthday()+ "','"
					+user.getMail_adress()+ "','"
					+user.getAddress_id()+ "','"
					+user.getNickname()+ "','CURDATE()')";

			try {
				//データベース接続を行う
				con = getConnection();
				smt = con.createStatement();

				//SQL文を発行する
				count = smt.executeUpdate(sql);

				//エラー処理
			}catch(Exception e) {
				throw new IllegalStateException(e);

				//データベース接続を終了する
			}finally {
				if(smt != null) {
					try{smt.close();}catch(SQLException ignore){}
				}
				if(con != null) {
					try{con.close();}catch(SQLException ignore){}
				}
			}
		}


}
