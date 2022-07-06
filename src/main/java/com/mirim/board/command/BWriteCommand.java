package com.mirim.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.dao.BDao;

public class BWriteCommand implements BCommand{
/*
	public void writeExcute(HttpServletRequest request, HttpServletResponse response) {
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle"); 
		String bcontent = request.getParameter("bcontent");
		
		BDao bdao = new BDao(); 
		bdao.write(bname, btitle, bcontent);	// 메소드에 필요한 인수들
	}
*/
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle"); 
		String bcontent = request.getParameter("bcontent");
		
		BDao bdao = new BDao(); 
		bdao.write(bname, btitle, bcontent);	// 메소드에 필요한 인수들
	}
}
