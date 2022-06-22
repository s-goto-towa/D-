package dao;

import java.sql.*;

import bean.Address;
import bean.User;

public class AddressDAO {

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

	//新規住所情報を登録する
		public void insertAddressInfo(Address address) {
			int count = 0;
		}

		//アドレス情報を読みだす
		public Address selectByAddress(String user_id) {

			//データベース接続のための変数を宣言
			Connection con = null;
			Statement smt = null;

			//Addressオブジェクトを生成する
			Address address = new Address();

			try {
				//検索を行うSQL文を宣言する
				String sql = "SELECT * FROM addressinfo WHERE user_id ='" +user_id+ "'";

				//データベース接続を行う
				con = getConnection();
				smt = con.createStatement();


				//SQL文を発行する
				ResultSet rs = smt.executeQuery(sql);

				//検索したデータを全て格納するまで繰り返す
				while(rs.next()) {
					address.setAddress_id(rs.getInt("address_id"));
					address.setUser_id(rs.getString("user_id"));
					address.setPost_code(rs.getString("post_code"));
					address.setPrefectures(rs.getString("prefectures"));
					address.setMunicipality(rs.getString("municipality"));
					address.setStreet(rs.getString("street"));
					address.setBuilding(rs.getString("building"));
					address.setRoom_number(rs.getString("room_number"));
					address.setAdress_kana(rs.getString("address_kana"));

				}
				//エラー処理
			}catch(Exception e){
				throw new IllegalStateException(e);

				//データベース接続を終了する
			}finally{
				if( smt != null ){
					try{smt.close();}catch(SQLException ignore){}
				}
				if( con != null ){
					try{con.close();}catch(SQLException ignore){}
				}
			}
			return address;
		}
}
