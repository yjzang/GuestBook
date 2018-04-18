package kr.co.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bit.dao.GuestDAO;
import kr.co.bit.vo.GuestVO;

public class CommandController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		String url = "./controller?cmd=getList";
		cmd = cmd==null?"":cmd;
		if("add".equals(cmd)) {
			System.out.println("add");
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			String content = request.getParameter("content");
			GuestVO vo = new GuestVO();
			GuestDAO dao = new GuestDAO();
			
			
			vo.setNo(" ");
			vo.setDate(" ");
			vo.setName(name);
			vo.setPw(pw);
			vo.setContent(content);
			dao.add(vo);
			url= "./controller?cmd=getList";
			
			
		} else if ("getList".equals(cmd)) {
			
			GuestDAO dao = new GuestDAO();
			ArrayList<GuestVO> list = dao.getList();
			
			url = "./WEB-INF/list.jsp";
			request.setAttribute("list", list);
	
		} else if ("delete".equals(cmd)) {
			
			GuestDAO dao = new GuestDAO();
			String pw_DB= request.getParameter("pw_DB");
			String no = request.getParameter("no");
			String pw_input = request.getParameter("pw_input");
			/*			ArrayList<GuestVO> list = dao.delete();*/
			if(pw_input==null) {
				url = "./WEB-INF/deleteform.jsp?no="+no+"&pw_DB="+pw_DB;
			} else if (pw_input.equals(pw_DB)) {
				dao.delete(no);
				url = "./controller?cmd=getList";
			}
			/*request.setAttribute("list", list);*/
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);		
	
	}
	

}
