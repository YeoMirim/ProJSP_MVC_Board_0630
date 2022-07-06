package com.mirim.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.dao.BDao;
import com.mirim.board.dto.BDto;

public class BListCommand implements BCommand{
/*
	public void listExcute(HttpServletRequest request, HttpServletResponse response) {
		BDao bdao = new BDao();
		ArrayList<BDto> bdtos = bdao.list();
		
		request.setAttribute("list", bdtos); 
		// request 객체에 "list"란 이름으로 ArrayList 자료 구조인 bdtos를 setting
		// 자료가 셋팅된(삽입된) request 객체가 그대로 컨트롤러(BFrontController)에 전달
	}
*/	

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BDao bdao = new BDao();
		ArrayList<BDto> bdtos = bdao.list();
		
		request.setAttribute("list", bdtos); 
		// request 객체에 "list"란 이름으로 ArrayList 자료 구조인 bdtos를 setting
		// 자료가 셋팅된(삽입된) request 객체가 그대로 컨트롤러(BFrontController)에 전달
	}
}
