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
import com.haroo.action.board.DetailAction;
import com.haroo.action.board.InsertAction;
import com.haroo.action.board.InsertFormAction;
import com.haroo.action.board.ListAction;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardController() {
		super();

	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI().trim(); // /haroo/board/list.do trim : 공백제거
		String contextPath = request.getContextPath(); // /haroo
		String command = requestURI.substring(contextPath.length() + 7); // list.do만나오게 하려고
		System.out.println(command);// list.do만나옴

		Action action = null;
		ActionForward forward = null;

		if (command.equals("insertForm.do")) {
			action = new InsertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("insertAction.do")) {
			action = new InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("listAction.do")) {
			action = new ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("detailAction.do")) {
			action = new DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// forward의 값이 들어간 경우
		if (forward != null) {
			if (forward.isRedirect()) {// redirect
				response.sendRedirect(forward.getPath());
			} else { // dispather
				RequestDispatcher dispathcer = request.getRequestDispatcher(forward.getPath());
				dispathcer.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
