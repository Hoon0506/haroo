package com.haroo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.haroo.domain.BoardVO;
import com.haroo.domain.ListModel;
import com.haroo.domain.ReplyVO;
import com.haroo.domain.SearchVO;
import com.haroo.repository.BoardDao;

public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao dao;
	private static final int PAGE_SIZE = 10;

	public static BoardService getInstance() {
		dao = BoardDao.getInstance();
		return service;
	}

	public int insertBoardService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		BoardVO board = new BoardVO();
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("name"));
		board.setContents(request.getParameter("contents"));
		board.setEmNo(Integer.parseInt(request.getParameter("emNo")));
		return dao.insertBoard(board);
	}

	public ListModel listBoardService(HttpServletRequest request) throws Exception {
		SearchVO search = new SearchVO();
		HttpSession session = request.getSession();
		if (request.getParameter("area") != null) { // 泥댄겕諛뺤뒪媛� 泥댄겕�맂 寃쎌슦
			session.removeAttribute("search");

			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
		} // 泥댄겕�빐�젣 �썑 寃��깋 踰꾪듉留� �겢由�
		else if (request.getParameter("area") == null && request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		// �꽭�뀡�뿉 寃��깋 �젙蹂닿� �엳�뒗 寃쎌슦
		if (session.getAttribute("search") != null) {
			search = (SearchVO) session.getAttribute("search");
		}
		int totalCount = dao.countBoard(search);
		int totalPageCount = totalCount / PAGE_SIZE;
		if (totalCount % PAGE_SIZE > 0) {
			totalPageCount++;
		}
		//System.out.println(totalPageCount);

		// 현재 페이지
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}

		// 현재 페이지 값 구현
		int requestPage = Integer.parseInt(pageNum);

		// startPage = 현재페이지 - (현재페이지 - 1) %5
		// ex) 14 - (14-1)%5
		int startPage = requestPage - (requestPage - 1) % 5;
		int endPage = startPage + 4;

		// endPage가 totalPageCount보다 크게 되면 안되니까!!
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}

		// startRow = (현재페이지 - 1) * 페이지당 글개수
		int startRow = (requestPage - 1) * PAGE_SIZE;
		List<BoardVO> list = dao.listBoard(startRow, search);

		ListModel listModel = new ListModel(list, requestPage, totalPageCount,startPage, endPage);
		return listModel;
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

	public int deleteBoardService(int bdNo) throws Exception {

		return dao.deleteBoard(bdNo);
	}

	public int insertReplyService(HttpServletRequest request) throws Exception {
		ReplyVO reply = new ReplyVO();
		request.setCharacterEncoding("utf-8"); // �븳湲�源⑥쭚 諛⑹�
		reply.setReWriter(request.getParameter("name"));
		reply.setReContents(request.getParameter("reContents"));
		reply.setBdNo(Integer.parseInt(request.getParameter("bdNo"))); // getParameter 媛믪� String�쑝濡� �삤湲곗뿉 �젙�닔濡� 蹂��솚�빐�빞�븳�떎.

		return dao.insertReply(reply);
	}// end insertReplyService

	public List<ReplyVO> listReplyService(HttpServletRequest request) throws Exception {

		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		// List<Reply> list = dao.listReply(seq);
		return dao.listReply(bdNo);
	}// end listReplyService
	
	public int hitCountService(int bdNo) throws Exception {

		return dao.hitCount(bdNo);
	}
}
