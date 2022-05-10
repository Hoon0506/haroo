package com.haroo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.chat.ChatFormAction;
import com.haroo.action.chat.FileUploadAction;
import com.haroo.action.chat.ListFileAction;




@WebServlet("/chat/*")
public class ChatController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
       
 
    public ChatController() {
        super();
     
    }

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI().trim();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length()+6);
    	System.out.println(command);
    	
    	com.haroo.action.Action action = null;
    	com.haroo.action.ActionForward forward = null;
    	
    	if(command.equals("chatFormAction.do")) {
    		action = new ChatFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	if(command.equals("fileUploadAction.do")) {
    		action = new FileUploadAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	if(command.equals("listFileAction.do")) {
    		action = new ListFileAction();
    		try {
    			forward = action.execute(request, response);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	
    	
    	
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {//redirect
    			response.sendRedirect(forward.getPath());
    		}else {//Dispatcher
    			RequestDispatcher dispatcher =
    					request.getRequestDispatcher(forward.getPath()	);
    			dispatcher.forward(request, response);
    		}
    	
    	}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
