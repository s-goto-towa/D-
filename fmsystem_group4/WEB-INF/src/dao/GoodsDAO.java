package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Goods;

public class GoodsDAO {
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


	public void delete(int goods_id) {
		Connection con = null;
		Statement smt = null;

		try {
			// SQL文作成
			String sql = "DELETE FROM goodsinfo WHERE goods_id = '" + goods_id + "'";
			// getConnection()メソッドを利用してConnectionオブジェクト生成
			con = getConnection();

			// ConnectionオブジェクトのcreateStatement（）メソッドを利用してStatementオブジェクトを生成します。
			smt = con.createStatement();

			// Statementオブジェクトの、executeUpdate（）メソッドを利用してSQL文を発行し書籍データをします。
			// SQL文発行
			smt.executeUpdate(sql);

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
	}

	public void insert(Goods goods) {

		Connection con = null;
		Statement smt = null;

		try {

			// SQL文作成
			String sql = "INSERT INTO goodsinfo(goods_id,user_id,goods_name,price,goods_description,"
					+ "on_sale_date,sale_districts,category,goods_status,postage,shipping_methods,"
					+ "ship_form,ship_days,ship_status,payment_status,sale_status,create_date,update_date) " + "VALUES("
					+ goods.getGoods_id() + ",'" + goods.getUser_id() + "','" + goods.getGoods_name() + "',"
					+ goods.getPrice() + "," + "'" + goods.getGoods_description() + "','" + goods.getOn_sale_date()
					+ "'," + "'" + goods.getSale_districts() + "','" + goods.getCategory() + "'," + "'"
					+ goods.getGoods_status() + "'," + goods.getPostage() + "," + "'" + goods.getShipping_methods()
					+ "','" + "" + goods.getShip_days() + ",'" + goods.getBuy_date() + "," + goods.getShip_status()
					+ "," + "" + goods.getPayment_status() + "," + goods.getSale_status() + "," + "'"
					+ goods.getCreate_date() + "','" + goods.getUpdate_date() + "')";

			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文発行
			smt.executeUpdate(sql);

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
	}

	public ArrayList<Goods> selectAll() {

		ArrayList<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT * FROM goodsinfo ORDER BY goods_id";

		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setUser_id(rs.getString("user_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setPrice(rs.getInt("price"));
				goods.setGoods_description(rs.getString("goods_description"));
				goods.setOn_sale_date(rs.getString("on_sale_date"));
				goods.setSale_districts(rs.getString("sale_districts"));
				goods.setCategory(rs.getString("category"));
				goods.setGoods_status(rs.getString("goods_status"));
				goods.setPostage(rs.getInt("postage"));
				goods.setShipping_methods(rs.getString("shipping_methods"));
				goods.setShip_days(rs.getInt("ship_days"));
				goods.setShip_status(rs.getInt("ship_status"));
				goods.setPayment_status(rs.getInt("payment_status"));
				goods.setSale_status(rs.getInt("sale_status"));
				goods.setGoods_status(rs.getString("goods_status"));
				goods.setGoods_status(rs.getString("goods_status"));

				list.add(goods);
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
		return list;

	}

	// 商品IDをもとに入金情報を更新するメソッド
	public void updatePayment_status(int goods_id, int payment_status) {

		Connection con = null;
		Statement smt = null;

		// SQL文
		String sql = "UPDATE goodsinfo SET payment_status = '" + payment_status + "' WHERE goods_id = '" + goods_id
				+ "'";

		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文を発行
			smt.executeUpdate(sql);

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
	}

	// 商品IDをもとに発送情報を更新するメソッド
	public void updateShip_status(int goods_id, int ship_status) {

		Connection con = null;
		Statement smt = null;

		// SQL文
		String sql = "UPDATE goodsinfo SET payment_status = '" + ship_status + "' WHERE goods_id = '" + goods_id + "'";

		try {
			con = getConnection();
			smt = con.createStatement();
			// SQL文を発行
			smt.executeUpdate(sql);

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
	}

	// 商品IDをもとに詳細検索するメソッド
	public Goods selectByGoods_id(int goods_id) {

		Connection con = null;
		Statement smt = null;

		Goods goods = new Goods();

		try {
			// DBに接続
			con = getConnection();
			smt = con.createStatement();

			// SQL文作成
			String sql = "SELECT goods_id,user_id,goods_name,price FROM goodsinfo WHERE goods_id = '" + goods_id + "'";
			// SQL文発行
			ResultSet rs = smt.executeQuery(sql);

			// 結果をBookオブジェクトに格納
			while (rs.next()) {
				goods.setGoods_id(rs.getInt("goods_id"));
				goods.setUser_id(rs.getString("user_id"));
				goods.setGoods_name(rs.getString("goods_name"));
				goods.setPrice(rs.getInt("price"));
				goods.setGoods_description(rs.getString("goods_description"));
				goods.setOn_sale_date(rs.getString("on_sale_date"));
				goods.setSale_districts(rs.getString("sale_districts"));
				goods.setCategory(rs.getString("category"));
				goods.setGoods_status(rs.getString("goods_status"));
				goods.setPostage(rs.getInt("postage"));
				goods.setShipping_methods(rs.getString("shipping_methods"));
				goods.setShip_days(rs.getInt("ship_days"));
				goods.setShip_status(rs.getInt("ship_status"));
				goods.setPayment_status(rs.getInt("payment_status"));
				goods.setSale_status(rs.getInt("sale_status"));
				goods.setGoods_status(rs.getString("goods_status"));
				goods.setGoods_status(rs.getString("goods_status"));
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
		return goods;
	}

}
