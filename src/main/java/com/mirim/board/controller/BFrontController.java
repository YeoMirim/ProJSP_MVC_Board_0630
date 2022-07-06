package com.mirim.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.command.BContentViewCommand;
import com.mirim.board.command.BDeleteCommand;
import com.mirim.board.command.BListCommand;
import com.mirim.board.command.BModifyCommand;
import com.mirim.board.command.BWriteCommand;
import com.mirim.board.dao.BDao;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")		// .do로 끝나는 확장자 패턴을 모조리 긁어와서 요청에 맞게 분기시킴
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		actionDo(request, response);
	}
	
	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 들어오면 .do로 모조리 잡아왔으므로 들어온 요청별로 분기시켜야함
		String uri = request.getRequestURI();				// 요청 주소(URI) 저장 (/ProJSP_MVC_Board_0630/write.do, 프로젝트명+실제요청주소)
		String conPath = request.getContextPath();			// ContextPath 저장, (/ProJSP_MVC_Board_0630, 요청한 주소의 프로젝트명까지만 가져옴)
		String command = uri.substring(conPath.length());	// 실제 요청 주소 분기 (/write.do)
		
		String view = null;
		
		if (command.equals("/write_view.do")) {
//			request.setAttribute("id", "tiger");	// request객체에 내용을 실어서 전달
			
			view = "write_view.jsp";
		}
		else if (command.equals("/write.do")) {
			// 글쓰기 명령이 실행 
/*			// command에서 작성할 내용
 			  String bname = request.getParameter("bname"); 
 			  String btitle = request.getParameter("btitle"); 
 			  String bcontent = request.getParameter("bcontent");
			 
			  
			  BDao bdao = new BDao(); bdao.write(bname, btitle, bcontent);
*/
			request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
			
			BWriteCommand comm = new BWriteCommand(); // BWriteCommand.java파일 
			comm.writeExcute(request, response);
			
			view = "list.do";
		}
		else if (command.equals("/list.do")) {
			// 글 리스트 불러오기 명령이 실행
			
			request.setCharacterEncoding("utf-8");//한글 깨짐 방지
			
			BListCommand comm = new BListCommand();
			comm.listExcute(request, response);
			
			view = "list.jsp";
//			response.sendRedirect(view); // 기존의 데이터가 셋팅된 request 객체를 사용하지 못함 
		}
		else if (command.equals("/content_view.do")) {
			// 글 내용보기 명령이 실행
			
			request.setCharacterEncoding("utf-8");//한글 깨짐 방지
			
			BContentViewCommand comm = new BContentViewCommand();
			comm.viewExcute(request, response);
			
			view = "content_view.jsp";

		}
		else if (command.equals("/modify.do")) {
			// 글 수정하기 명령이 실행
			
			request.setCharacterEncoding("utf-8");//한글 깨짐 방지
			
			BModifyCommand comm = new BModifyCommand();
			comm.modifyExcute(request, response);
			
			view = "list.do";

		}
		
		else if (command.equals("/delete.do")) {
			// 글 삭제하기 명령이 실행
			
//			request.setCharacterEncoding("utf-8"); //한글 깨짐 방지
			
			BDeleteCommand comm = new BDeleteCommand();
			comm.deleteExcute(request, response);
			
			view = "list.do"; // 지운 후 확인 차 list로 이동

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);	// RequestDispatcher는 하나로 계속 돌려씀
		dispatcher.forward(request, response);
	
	}
}
