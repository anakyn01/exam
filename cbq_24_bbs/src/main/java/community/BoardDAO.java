package community;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BoardDAO {
	
	private Connection conn;
	private ResultSet rs;
	
	//1) �젒�냽�븯湲곗쐞�븳 �깮�꽦�옄 => crud�븷�븣留덈떎 �젒�냽�빐�빞�릺�뒗 遺덊렪�븿 洹몃옒�꽌 @Autowired
	public BoardDAO() {
		try {
			String dbURL ="jdbc:oracle:thin:@localhost:1521/xe";
			String dbID = "TWO_U";
			String dbPassword = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//2)�옉�꽦�씪�옄瑜� 援ы븯�뒗 硫붿냼�뱶
	public String getDate() {
		String sql = "select sysdate from BOARD_TBL";
		try {
			//��湲� 諛� �꽕�젙
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";//�뜲�씠�꽣 踰좎씠�뒪 �삤瑜�
	}
	
	//寃뚯떆湲� 踰덊샇 遺��뿬 硫붿냼�뱶
	public int getNext() {
		int num=0;//�삤�씪�겢 �떆���뒪 珥덇린�솕
		String sql = "select IDX_SEQ.NEXTVAL from dual";
		//mysql => select idx from board order by idx desc;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("nextval");
			}
			return num;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	

	//湲��벐湲� 硫붿냼�뱶 [湲��젣紐�,�궗�슜�옄ID,湲��궡�슜�쓣 �쟾�떖諛쏆븘 DB�뿉 �깉濡쒖슫 �뜲�씠�꽣瑜� �엯�젰]
	public int write(String writer, String subject, String content) {
		String sql = "insert into BOARD_TBL values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  getNext());//�닔�룞利앷�
			pstmt.setString(2,  writer);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);//議댁옱�븯�뒗 �떆媛꾩쓣 媛��졇�삤湲� �븣臾몄뿉
			pstmt.setString(5, getDate());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //�뜲�씠�꽣 踰좎씠�뒪 �삤瑜�
	}
	
	//list
	public ArrayList<Board> getList(){
		String sql = "select * from BOARD_TBL order by IDX asc";
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();//�뿬�뒗 �깭洹�
				board.setIdx(rs.getInt(1));//columnIndex;
				board.setWriter(rs.getString(2));
				board.setSubject(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setDate(rs.getString(5));
				list.add(board);//�떕�뒗 �깭洹�
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//하나의 게시글을 보는 메소드 => read
	public Board getBoard(int idx) {
		String sql = "select * from BOARD_TBL where IDX = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);//parameterindex
			rs=pstmt.executeQuery();
			//만약 글이 존재한다면
			if(rs.next()) {
				Board board = new Board();
				board.setIdx(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setSubject(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setDate(rs.getString(5));
				return board;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/*
	private int idx;
	private String writer;
	private String subject;
	private String content;
	private String date;
	*/
	//게시글 수정 메소드
	public int update(String writer, String subject, String content, int idx) {
		String sql = "update BOARD_TBL set writer=?, subject=?, content=? where idx = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			pstmt.setInt(4, idx);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//게시글 삭제 메소드
	public int delete(int idx) {
		//String sql ="update BOARD_TBL set bbsAvailable = 0 where idx = ?";
		String sql ="delete from BOARD_TBL where idx = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	

}
