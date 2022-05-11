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
import com.haroo.action.attendance.InsertAttendanceAction;
import com.haroo.action.attendance.OutsideAttendanceAction;
import com.haroo.action.attendance.StatusAttendanceAction;
import com.haroo.action.attendance.UpdateAttendanceAction;

@WebServlet("/attendance/*")
public class AttendanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AttendanceController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// uri 식별
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 12);

		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("status")) { //현황보기
			action = new StatusAttendanceAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 페이지 이동
		if (forward != null) {
			if (forward.isRedirect()) { // redirect
				response.sendRedirect(forward.getPath());
			} else { // dispatcher
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} // end if
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// uri 식별
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 12);

		System.out.println(command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("insert")) { // insert 출근내용
			action = new InsertAttendanceAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("update")) { // update 퇴근 시간
			action = new UpdateAttendanceAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("outside")) { // insert 외근
			action = new OutsideAttendanceAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 페이지 이동
		if (forward != null) {
			if (forward.isRedirect()) { // redirect
				response.sendRedirect(forward.getPath());
			} else { // dispatcher
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
