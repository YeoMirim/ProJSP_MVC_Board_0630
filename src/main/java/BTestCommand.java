import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mirim.board.command.BCommand;

public class BTestCommand implements BCommand {	
	// interface를 상속받아 쓰면 정의된 추상메소드는 반드시 구현해서 사용해야함(의무적) - 내부 내용만 만들어서 바꿔서 쓰면 됨(overriding)
	// 장점 : 표준화(공통성-통일성)   

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) { 
		// TODO Auto-generated method stub

	}

}
