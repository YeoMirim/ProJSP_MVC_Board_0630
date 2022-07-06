// interface로 만들고 command를 일정하게 표준화시켜서(공통성 부여) 쉽게 호출해서 쓸 수 있게 만듬 -> 내용만 수정가능

package com.mirim.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BCommand {	
	
	// 추상메소드 (접근지정자 생략가능, 메서드명, 반환타입O, 매개변수 선언)
	void excute(HttpServletRequest request, HttpServletResponse response);
	
}
