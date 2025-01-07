package member;

import java.util.Date;

public class Member {

	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade;
	private String city;
	
	//getter
	public int getCustno() {return custno;}
	public String getCustname() {return custname;}
	public String getAddress() {return address;}
	public String getPhone() {return phone;}
	public String getGrade() {return grade;}
	public Date getJoindate() {return joindate;}
	public String getCity() {return city;}
	
	//setter
	public void setCustno(int custno) {this.custno = custno;}
	public void setCustname(String custname) {this.custname = custname;}
	public void setAddress(String address) {this.address = address;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setJoindate(Date joindate) {this.joindate = joindate;}
	public void setGrade(String grade) {this.grade = grade;}
	public void setCity(String city) {this.city = city;}
	
	
}
