package com.mirim.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.dao.BDao;

public class BDeleteCommand implements BCommand {
	
/*
	public void deleteExcute(HttpServletRequest request, HttpServletResponseresponse) { // return값 없으므로 void로 선언 
	   
	   String bid =request.getParameter("bid"); // 히든속성으로 숨겼던 값을 가져옴
	  
	   BDao bdao = new BDao(); 
	   bdao.delete(bid); 
	   }
*/

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");	// 히든속성으로 숨겼던 값을 가져옴
		
		BDao bdao = new BDao();
		bdao.delete(bid);
		
	}
}
