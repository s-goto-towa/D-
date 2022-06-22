package bean;

public class Goods {
	private int goods_id;
	private String user_id;
	private String goods_name;
	private int price;
	private String goods_description;
	private String on_sale_date;
	private String sale_districts;
	private String category;
	private String goods_status;
	private int postage;
	private String shipping_methods;
	private int ship_days;
	private String buy_date;
	private int ship_status;
	private int payment_status;
	private int sale_status;
	private String create_date;
	private String update_date;

	public Goods() {
		goods_id = 0;
		user_id = null;
		goods_name = null;
		price = 0;
		goods_description = null;
		on_sale_date = null;
		sale_districts = null;
		category = null;
		goods_status = null;
		postage = 0;
		shipping_methods = null;
		ship_days = 0;
		buy_date=null;
		ship_status = 0;
		payment_status = 0;
		sale_status = 0;
		create_date = null;
		update_date = null;

	}

	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGoods_description() {
		return goods_description;
	}

	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}

	public String getOn_sale_date() {
		return on_sale_date;
	}

	public void setOn_sale_date(String on_sale_date) {
		this.on_sale_date = on_sale_date;
	}

	public String getSale_districts() {
		return sale_districts;
	}

	public void setSale_districts(String sale_districts) {
		this.sale_districts = sale_districts;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGoods_status() {
		return goods_status;
	}

	public void setGoods_status(String goods_status) {
		this.goods_status = goods_status;
	}

	public int getPostage() {
		return postage;
	}

	public void setPostage(int postage) {
		this.postage = postage;
	}

	public String getShipping_methods() {
		return shipping_methods;
	}

	public void setShipping_methods(String shopping_methods) {
		this.shipping_methods = shopping_methods;
	}


	public int getShip_days() {
		return ship_days;
	}

	public void setShip_days(int ship_days) {
		this.ship_days = ship_days;
	}

	public int getShip_status() {
		return ship_status;
	}

	public void setShip_status(int ship_status) {
		this.ship_status = ship_status;
	}

	public int getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(int payment_status) {
		this.payment_status = payment_status;
	}

	public int getSale_status() {
		return sale_status;
	}

	public void setSale_status(int sale_status) {
		this.sale_status = sale_status;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}
