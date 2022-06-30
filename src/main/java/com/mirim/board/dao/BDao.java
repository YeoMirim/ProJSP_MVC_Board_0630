// 실제 데이터(DB)와 연결을 담당하는 DAO

package com.mirim.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {

	private DataSource datasource;		// Server => context.xml 확인

	public BDao() {
		
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/odbo"); // 형변환 필요
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String bname, String btitle, String bcontent) { //insert, 매개변수 선언
		
		Connection conn = null;				// java.sql
		PreparedStatement pstmt = null;		// java.sql
		
		try {
			String sql = "INSERT INTO mvc_board(bname, btitle, bcontent, bhit) VALUES (?, ?, ?, 0)"; 
			// PreparedStatement는 값에 뭐가 들어올지 모를 때 parameter값에 '?'를 씀, 조회수는 0부터 시작
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setString(1, bname);		// pstmt는 자리값이 0이 아닌 1부터 시작, 매개변수값으로  setting
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			pstmt.executeUpdate(); 	// sql 실행
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
