package com.haroo.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.haroo.domain.FileVO;
import com.haroo.repository.ChatDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	
	
	public int fileUploadService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
						
		FileVO fileVO = new FileVO();
		
		
		return dao.uploadFile(fileVO);
	}
	
}
