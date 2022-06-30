// 실제 데이터(DB)와 연결을 담당하는 DAO

package com.mirim.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mirim.board.dto.BDto;

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
	
	
	public void write(String bname, String btitle, String bcontent) { //insert, 매개변수 선언, 반환타입X
		
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
	} // write() 함수 종료
	
	
	public ArrayList<BDto> list() {
		
		// sql = "SELECT * FROM mvc_board" => ResultSet 통재로 반환받아야함
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BDto> bdtos = new ArrayList<BDto>();	// ArrayList() 선언
		
		String sql = "SELECT * FROM mvc_board ORDER BY bid DESC";	// bid 내림차순으로 정렬 
		
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			rs = pstmt.executeQuery(); 	// sql 실행(select문은 executeQuery()로 반환값 발생)
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				int bhit = rs.getInt("bhit");
				Timestamp bdate = rs.getTimestamp("bdate");
				
				BDto bdto = new BDto(bid, bname, btitle, bcontent, bhit, bdate);
				bdtos.add(bdto);	
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs!= null) {
					rs.close();
				}
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
		
		return bdtos;
	}  // list() 함수 종료
	
	
	public BDto contentView(String boardid) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BDto bdto = null;					// 초기값 선언
		
		
		String sql = "SELECT * FROM mvc_board WHERE bid =?";	// bid 내림차순으로 정렬 
		
		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setString(1, boardid);
			
			rs = pstmt.executeQuery(); 	// sql 실행(select문은 executeQuery()로 반환값 발생)
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				int bhit = rs.getInt("bhit");
				Timestamp bdate = rs.getTimestamp("bdate");
				
				bdto = new BDto(bid, bname, btitle, bcontent, bhit, bdate);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs!= null) {
					rs.close();
				}
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
		
		return bdto;
	}
}
