package com.haroo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haroo.domain.BoardVO;
import com.haroo.domain.ReplyVO;
import com.haroo.domain.SearchVO;
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

	public List<BoardVO> listBoardService(HttpServletRequest request) throws Exception {
		SearchVO search = new SearchVO();
		HttpSession session = request.getSession();
		if (request.getParameter("area") != null) { // üũ�ڽ��� üũ�� ���
			session.removeAttribute("search");

			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
		} // üũ���� �� �˻� ��ư�� Ŭ��
		else if (request.getParameter("area") == null && request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		// ���ǿ� �˻� ������ �ִ� ���
		if (session.getAttribute("search") != null) {
			search = (SearchVO) session.getAttribute("search");
		}
		int totalCount = dao.countBoard(search);
		List<BoardVO> list = dao.listBoard(search);

		// ListModel listModel = new ListModel(list, requestPage, totalPageCount,
		// startPage, endPage);
		return list;
	}

	public BoardVO detailBoardService(int bdNo) throws Exception {

		return dao.detailBoard(bdNo);
	}

	public int updateBoardService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		BoardVO board = new BoardVO();
		board.setBdNo(Integer.parseInt(request.getParameter("bdNo")));
		board.setTitle(request.getParameter("title"));
		board.setContents(request.getParameter("contents"));

		return dao.updateBoard(board);
	}

	public int deleteBoardService(int seq) throws Exception {

		return dao.deleteBoard(seq);
	}

	public int insertReplyService(HttpServletRequest request) throws Exception {
		ReplyVO reply = new ReplyVO();
		request.setCharacterEncoding("utf-8"); // �ѱ۱��� ����
		reply.setReWriter("�輭��");
		reply.setReContents(request.getParameter("reContents"));
		reply.setBdNo(Integer.parseInt(request.getParameter("bdNo"))); // getParameter ���� String���� ���⿡ ������ ��ȯ�ؾ��Ѵ�.

		return dao.insertReply(reply);
	}// end insertReplyService

	public List<ReplyVO> listReplyService(HttpServletRequest request) throws Exception {

		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		// List<Reply> list = dao.listReply(seq);
		return dao.listReply(bdNo);
	}// end listReplyService
}
