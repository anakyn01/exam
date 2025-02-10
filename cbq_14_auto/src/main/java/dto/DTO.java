package dto;

public class DTO {
	
	public String empno, empname, resvdate, seatno, office, callno;
	
	//위에 생성자
	public DTO(String empno, String empname,  String resvdate, String seatno, String office, String callno) {
		this.empno = empno;
		this.empname = empname;
		this.resvdate = resvdate;
		this.seatno = seatno;
		this.office = office;
		this.callno = callno;
	}

	
}
