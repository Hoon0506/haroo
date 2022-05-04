package com.haroo.service;

import javax.servlet.http.HttpServletRequest;

import com.haroo.model.ChatDAO;

public class ChatService {
	private static ChatService service = new ChatService();
	private static ChatDAO dao;
	
	public static ChatService getInstance() {
		dao = ChatDAO.getInstance();
		return service;
	}
	
	public int insertChatService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		
	}
	
	
}
