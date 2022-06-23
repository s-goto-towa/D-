package bean;

public class Address {

	private String user_id;	//住所ID
	private String post_code;	//郵便番号
	private String prefectures;	//都道府県
	private String municipality;	//市区町村
	private String street;	//番地以降
	private String building;	//建物名
	private String room_number;	//部屋番号
	private String address_kana;	//住所(カナ)

	//引数無しコンストラクタ
	public Address() {
		user_id = null;
		post_code = null;
		prefectures = null;
		municipality = null;
		street = null;
		building = null;
		room_number = null;
		address_kana = null;
	}

	//住所IDのゲッターメソッド
	public String getUser_id() {
		return user_id;
	}

	//住所IDのセッターメソッド
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	//郵便番号のゲッターメソッド
	public String getPost_code() {
		return post_code;
	}
	//郵便番号のセッターメソッド
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	//都道府県のゲッターメソッド
	public String getPrefectures() {
		return prefectures;
	}
	//都道府県のセッターメソッド
	public void setPrefectures(String prefectures) {
		this.prefectures = prefectures;
	}

	//市区町村のゲッターメソッド
	public String getMunicipality() {
		return municipality;
	}
	//市区町村のセッターメソッド
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	//番地以降のゲッターメソッド
	public String getStreet() {
		return street;
	}
	//番地以降のセッターメソッド
	public void setStreet(String street) {
		this.street = street;
	}

	//建物名のゲッターメソッド
	public String getBuilding() {
		return building;
	}
	//建物名のセッターメソッド
	public void setBuilding(String building) {
		this.building = building;
	}

	//部屋番号のゲッターメソッド
	public String getRoom_number() {
		return room_number;
	}
	//部屋番号のセッターメソッド
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	//住所(カナ)のゲッターメソッド
	public String getAddress_kana() {
		return address_kana;
	}
	//住所(カナ)のセッターメソッド
	public void setAddress_kana(String adress_kana) {
		this.address_kana = adress_kana;
	}


}
