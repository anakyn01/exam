package dto;

public class DTO {

	private String p_code, p_name, p_size, p_incost, p_outcost, c_code, c_name, c_tel1, c_tel2, c_tel3, t_no, t_type, t_cnt, t_date, result;

public DTO(String p_code, String p_name, String p_size, String p_incost, String p_outcost) {//제품조회
	this.p_code = p_code;
	this.p_name = p_name;
	this.p_size = p_size;
	this.p_incost = p_incost;
	this.p_outcost = p_outcost;
}

public DTO(String c_code, String c_name) {//거래처목록
	this.c_code = c_code;
	this.c_name = c_name;
}

public DTO(String t_no, String p_code, String p_name, String t_type, String t_cnt, String c_name,String t_date) {
this.t_no = t_no;
this.p_code = p_code;
this.p_name = p_name;
this.t_type = t_type;
this.t_cnt = t_cnt;
this.c_name = c_name;
}

public DTO(String p_code, String p_name, String t_cnt, String result) {
this.p_code = p_code;
this.p_name = p_name;
this.t_cnt = t_cnt;
this.result = result;
}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_size() {
		return p_size;
	}

	public void setP_size(String p_size) {
		this.p_size = p_size;
	}

	public String getP_incost() {
		return p_incost;
	}

	public void setP_incost(String p_incost) {
		this.p_incost = p_incost;
	}

	public String getP_outcost() {
		return p_outcost;
	}

	public void setP_outcost(String p_outcost) {
		this.p_outcost = p_outcost;
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_tel1() {
		return c_tel1;
	}

	public void setC_tel1(String c_tel1) {
		this.c_tel1 = c_tel1;
	}

	public String getC_tel2() {
		return c_tel2;
	}

	public void setC_tel2(String c_tel2) {
		this.c_tel2 = c_tel2;
	}

	public String getC_tel3() {
		return c_tel3;
	}

	public void setC_tel3(String c_tel3) {
		this.c_tel3 = c_tel3;
	}

	public String getT_no() {
		return t_no;
	}

	public void setT_no(String t_no) {
		this.t_no = t_no;
	}

	public String getT_type() {
		return t_type;
	}

	public void setT_type(String t_type) {
		this.t_type = t_type;
	}

	public String getT_cnt() {
		return t_cnt;
	}

	public void setT_cnt(String t_cnt) {
		this.t_cnt = t_cnt;
	}

	public String getT_date() {
		return t_date;
	}

	public void setT_date(String t_date) {
		this.t_date = t_date;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
