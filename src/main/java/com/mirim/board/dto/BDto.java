// DTO - DB에서 1개의 레코드값들을 담은 상자 역할을 함, ex: 10건일 경우 10개의 DTO가 움직임

package com.mirim.board.dto;
import java.sql.Timestamp;

public class BDto {				// 생성자는 DTO는 DB의 필드명과 같은 이름을 줘야 자동으로 값을 넣어줌
	
	private int bid;			// 게시판 번호
	private String bname;		// 게시판 작성자
	private String btitle;		// 게시판 이름
	private String bcontent;	// 게시판 글 내용
	private int bhit;			// 게시판 조회수
	private Timestamp bdate;	// 게시판 글 작성 시간 (자동으로 작성시간 넣어줌)
	
	
	public BDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BDto(int bid, String bname, String btitle, String bcontent, int bhit, Timestamp bdate) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bdate = bdate;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public int getBhit() {
		return bhit;
	}


	public void setBhit(int bhit) {
		this.bhit = bhit;
	}


	public Timestamp getBdate() {
		return bdate;
	}


	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	
	
	
	
	
}
