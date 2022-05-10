package com.haroo.service;

import javax.servlet.http.HttpServletRequest;

import com.haroo.repository.ChatDao;

public class ChatService {
	private static ChatService service = new ChatService();
	private static ChatDao dao;
	
	public static ChatService getInstance() {
		dao = ChatDao.getInstance();
		return service;
	}
	
	public int insertChatService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		return 0;
	}
	
	
}
