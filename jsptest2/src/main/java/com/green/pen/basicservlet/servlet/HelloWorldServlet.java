package com.green.pen.basicservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * TEST용 서블릿 생성 //http servlet클래스를 상속받은 클래스! 서블릿!!
	 * 시리얼 넘버를 입력해야하는 이유는 serializable 인터페이스를 구현하는 클래스에 나타나는 특성이다. 
	 * api를 확인해보면 httpservlet이 java.io.serializable 을 implement 한 클래스임을 알 수 있다.
	 */
	private static final long serialVersionUID = 40240019304984L;
	
	//우선 UTL을 호출하면 응답할 수 있는 doGet메서드를 만들어본다.
	//@param request , response @throws ServletException IOException

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html");//응답형식지정
		PrintWriter out = response.getWriter(); // response로 부터 출력장치확보
		
		out.println("<html>");
		out.println("hello, world");
		out.println("</html>");
	}
}
