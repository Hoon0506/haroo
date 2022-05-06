package com.haroo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.action.dayoff.ListAction;

@WebServlet("/dayoff/*")
public class DayoffController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DayoffController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// uri �떇蹂�
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 8);
		System.out.println(requestURI);
		System.out.println(command);
		
		Action action = null;
		ActionForward forward = null;
		System.out.println("list작동전");
		if (command.equals("list")) { // �쑕媛��쁽�솴 蹂닿린
			action = new ListAction();
			System.out.println("list작동");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// �럹�씠吏� �씠�룞
		if (forward != null) {
			if (forward.isRedirect()) { // redirect
				response.sendRedirect(forward.getPath());
			} else { // dispatcher
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} // end if

	} // end doGet()

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	} // end doPost()

}
