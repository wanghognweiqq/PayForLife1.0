package net.onest.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserValidServlet
 */
@WebServlet("/UserValidServlet")
public class UserValidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��GET����");
		PrintWriter writer = response.getWriter();
		String param = request.getParameter("user");
		System.out.println("�յ����������" + param);
		writer.write("from server:OK");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("来自客户端的POST请求");
		PrintWriter writer = response.getWriter();
		InputStream in = request.getInputStream();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(in, "UTF-8"));
		String str = null;
		StringBuffer buff = new StringBuffer();
		while(null !=(str = reader.readLine())) {
			buff.append(str);
		}
		System.out.println("得到前台数据:" + buff.toString());
		String userName=buff.toString();
//		String userName=(String)request.getAttribute("userName");
//		
//		String password=request.getParameter("password");
		System.out.println(userName);
//		System.out.println(password);
		writer.write("from server:OK");
	}

}
