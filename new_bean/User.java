package bean;

public class User {
	private String user_id;
	private String password;
	private int authority;
	private String last_name;
	private String last_namekana;
	private String first_name;
	private String first_namekana;
	private String birthday;
	private String mail_address;
	private int profits;
	private int goods_id;
	private String nickname;
	private String create_date;
	private String update_date;

	public User() {
		user_id = null;
		password = null;
		authority = 0;
		last_name = null;
		last_namekana = null;
		first_name = null;
		first_namekana = null;
		birthday = null;
		mail_address = null;
		profits = 0;
		goods_id = 0;
		nickname = null;
		create_date = null;
		update_date = null;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLast_namekana() {
		return last_namekana;
	}

	public void setLast_namekana(String last_namekana) {
		this.last_namekana = last_namekana;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFirst_namekana() {
		return first_namekana;
	}

	public void setFirst_namekana(String first_namekana) {
		this.first_namekana = first_namekana;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_adress) {
		this.mail_address = mail_adress;
	}

	public int getProfits() {
		return profits;
	}

	public void setProfits(int profits) {
		this.profits = profits;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
