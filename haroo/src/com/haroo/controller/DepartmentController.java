package com.haroo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.*;
import com.haroo.action.department.DepartmentAction;

@WebServlet("/department/*")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentController() {
		super();
	}

	public String getCommand(HttpServletRequest request) {

		// url 받아 오기.
		String requestURI = request.getRequestURI().trim();// => trim(공백 제거) /haroo/department/~.~
		String contextPath = request.getContextPath(); // /haroo
		String command = requestURI.substring(contextPath.length() + 12); // ~.~

		return command;
	}// --end getCommand

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doProcess(request, response);

		// getCommand로 url 받아 오기.

		String command = getCommand(request); // ~.~ 받음.

		System.out.println(command);// console에 ~.~ 출력.

		Action action = null;
		ActionForward actionForward = null;

		if (command.equals("departmentAction.do")) {

			action = new DepartmentAction();
			try {

				actionForward = action.execute(request, response);

			} catch (Exception e) {

				e.printStackTrace();
			} // --end try~catch

		} // --end if

		if (actionForward != null) {
			if (actionForward.isRedirect()) {// redirect
				response.sendRedirect(actionForward.getPath());
				
			}else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(actionForward.getPath());
				
				dispatcher.forward(request, response);
			} //--end actionForward.isRedirect

		}
	}// --end doProcess
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * // doProcess(request, response);
	 * 
	 * String command = getCommand(request); System.out.println(command);
	 * 
	 * Action action = null; ActionForward actionForward = null;
	 * 
	 * 
	 * 
	 * if(command.contains("listDepartment")) {
	 * 
	 * action = new DepartmentAction();
	 * 
	 * try {
	 * 
	 * actionForward = action.execute(request, response);
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace(); }// --end try~catch
	 * 
	 * }// --end if
	 * 
	 * if(actionForward != null) {
	 * 
	 * if(actionForward.isRedirect()) {
	 * response.sendRedirect(actionForward.getPath());
	 * 
	 * }else { RequestDispatcher dispatcher =
	 * request.getRequestDispatcher(actionForward.getPath());
	 * dispatcher.forward(request, response);
	 * 
	 * } } }// --end doPost
	 */
}
