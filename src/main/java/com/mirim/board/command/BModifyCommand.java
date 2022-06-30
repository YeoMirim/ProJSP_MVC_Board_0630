package com.mirim.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.dao.BDao;

public class BModifyCommand {
	
	public void	modifyExcute(HttpServletRequest request, HttpServletResponse response) {		// UpdateSet
		
		String btitle = request.getParameter("btitle");
		String bname = request.getParameter("bname");
		String bcontent = request.getParameter("bcontent");
		String bid = request.getParameter("bid");	// 히든속성으로 숨겼던 값을 가져옴
	
		BDao bdao = new BDao();
		bdao.modify(bname, btitle, bcontent, bid);
	}
}
