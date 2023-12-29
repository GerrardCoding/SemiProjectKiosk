package com.javalec.daegeun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.javalec.common.ShareVar;

public class SignLoginDao {
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

	String custid;
	String custpw;
	String custname;
	String phone;
	String address;

	// Constructor
	public SignLoginDao() {
		// TODO Auto-generated constructor stub
	}

	public SignLoginDao(String custid) {
		super();
		this.custid = custid;
	}

	public SignLoginDao(String custid, String custpw) {
		super();
		this.custid = custid;
		this.custpw = custpw;
	}

	public SignLoginDao(String custid, String custpw, String custname, String phone, String address) {
		super();
		this.custid = custid;
		this.custpw = custpw;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
	}

	// 입력
	public boolean insertAction() {
		PreparedStatement ps = null; // 보안상 사용, 불러올때는 그냥 Statement를 사용하면 됨

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			String A = "insert into customer (custid, custpw, custname, phone, address";
			String B = ") values (?,?,?,?,?)";

//			Sign sign = new Sign();

			ps = conn_mysql.prepareStatement(A + B);
			ps.setString(1, custid);
			ps.setString(2, custpw);
			ps.setString(3, custname);
			ps.setString(4, phone);
			ps.setString(5, address);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean sameCheckAction(String custid1) {
		PreparedStatement ps = null; // 보안상 사용, 불러올때는 그냥 Statement를 사용하면 됨
		boolean available = false;
		ResultSet rs = null;
		Connection conn = null;

		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 데이터베이스 연결
			conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			// SQL 문장
			String sql = "select custid from customer where custid = ?";

			// PreparedStatement 준비
			ps = conn.prepareStatement(sql);
			ps.setString(1, custid1);
			
//			ResultSet rst = ps.executeQuery(sqlstr);

			// 쿼리 실행 및 결과 가져오기
			rs = ps.executeQuery();

			// 결과 확인
			if (rs.next()) {
				// 아이디가 존재하는 경우 false
				available = false;
//				if(custid1.trim() == custid1) {
				// 공백 제거를 받아서 중복 된 아이디 확인
				JOptionPane.showMessageDialog(null, custid1 + "는 중복된 아이디입니다.");
			} else {
				// 아이디가 존재하지 않는 경우 true
				available = true;
				// 공백만 입력 받았을때 처리
				if(custid1.length() == 0) {
					JOptionPane.showMessageDialog(null, "잘못된 아이디입니다.");
				}else {
				JOptionPane.showMessageDialog(null, custid1 + "는 사용할 수 있는 아이디입니다.");
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return available;
	}

	public boolean loginCheckAction(String custid1, String custpw1) {
		PreparedStatement ps = null;
		boolean available = false;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 데이터베이스 연결
			conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			// SQL 문장
			String query = "select custid, custpw from customer "; // 뒤에 띄어쓰기 한칸 할것
			String query1 = " where custid = ? and custpw = ?";

			// PreparedStatement 준비
			ps = conn.prepareStatement(query + query1);
			ps.setString(1, custid1);
			ps.setString(2, custpw1);

			// 쿼리 실행 및 결과 가져오기
			rs = ps.executeQuery();
			
			if (rs.next()) {
				// 아이디와 비밀번호가 이미 존재하는 경우
				available = true;
				JOptionPane.showMessageDialog(null, "로그인을 환영합니다.");
			} else {
				// 아이디와 비밀번호가 존재하지 않는 경우
				available = false;
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 결과 확인
		return available;
	}

}
