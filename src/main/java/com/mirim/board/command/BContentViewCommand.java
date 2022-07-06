package com.mirim.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.dao.BDao;
import com.mirim.board.dto.BDto;

public class BContentViewCommand implements BCommand {
/*
	   public void viewExcute(HttpServletRequest request, HttpServletResponse
	   response) {
	  
	   String bid = request.getParameter("bid");
	  
	   BDao bdao = new BDao(); BDto bdto = bdao.contentView(bid);
	  
	   request.setAttribute("contentView", bdto); }
*/
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bid = request.getParameter("bid");
		
		BDao bdao = new BDao(); 
		BDto bdto = bdao.contentView(bid);
		
		request.setAttribute("contentView", bdto);
	}
}
