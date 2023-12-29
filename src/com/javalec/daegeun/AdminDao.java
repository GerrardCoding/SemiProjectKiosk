package com.javalec.daegeun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.javalec.common.ShareVar;

public class AdminDao {
	
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

	String adminid;
	String adminpw;
	String adminname;
	
	public AdminDao() {
		// TODO Auto-generated constructor stub
	}

	public AdminDao(String adminid, String adminpw) {
		super();
		this.adminid = adminid;
		this.adminpw = adminpw;
	}
	
	public boolean loginCheckAction(String adminid1, String adminpw1) {
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
			String query = "select adminid, adminpw from administer "; // 뒤에 띄어쓰기 한칸 할것
			String query1 = " where adminid = ? and adminpw = ?";

			// PreparedStatement 준비
			ps = conn.prepareStatement(query + query1);
			ps.setString(1, adminid1);
			ps.setString(2, adminpw1);

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
