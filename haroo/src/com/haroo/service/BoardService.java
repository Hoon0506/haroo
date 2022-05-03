package com.haroo.service;

import javax.servlet.http.HttpServletRequest;

import com.haroo.domain.BoardVO;
import com.haroo.repository.BoardDao;

public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao dao;
	
	public static BoardService getInstance() {
		dao = BoardDao.getInstance();
		return service;
	}
	
	public int insertBoardService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		BoardVO board = new BoardVO();
		board.setTitle(request.getParameter("title"));
		board.setWriter("�輭��");
		board.setContents(request.getParameter("contents"));
		board.setEmNo(19362300);
		return dao.insertBoard(board);
	}
}
