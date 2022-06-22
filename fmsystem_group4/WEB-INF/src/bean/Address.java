package bean;

public class Address {

	private int address_id;
	private String user_id;
	private String post_code;
	private String prefectures;
	private String municipality;
	private String street;
	private String building;
	private String room_number;
	private String address_kana;

	public Address() {
		address_id = 0;
		user_id="";
		post_code = "";
		prefectures = "";
		municipality = "";
		street = "";
		building = "";
		room_number = "";
		address_kana = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getAddress_kana() {
		return address_kana;
	}

	public void setAddress_kana(String address_kana) {
		this.address_kana = address_kana;
	}

	public int getAddress_id() {
		return address_id;
	}

	//住所IDのゲッターメソッド
	public int Address_id() {
		return address_id;
	}
	//住所IDのセッターメソッド
	public void setAddress_id(int address_id){
		this.address_id = address_id;
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
	public String getAdress_kana() {
		return address_kana;
	}
	//住所(カナ)のセッターメソッド
	public void setAdress_kana(String adress_kana) {
		this.address_kana = adress_kana;
	}


}
