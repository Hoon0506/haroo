package com.haroo.action.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.BoardVO;
import com.haroo.domain.ReplyVO;
import com.haroo.service.BoardService;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		BoardVO board = service.detailBoardService(bdNo);
		
		List<ReplyVO> replys = service.listReplyService(request);
		
		//ListModel listModel = service.listBoardService(request);
		//request.setAttribute("listModel", listModel);
		
		request.setAttribute("board", board);
		request.setAttribute("replys", replys);
		
		forward.setPath("/detail.jsp");
		forward.setRedirect(false);
		
		return forward;	}

}
