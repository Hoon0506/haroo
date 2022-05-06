package com.haroo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.service.ChatService;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ChatService service = ChatService.getInstance();
		ActionForward forward = new ActionForward();
		
		
		return forward;
	}

}
