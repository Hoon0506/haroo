package com.haroo.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.BoardVO;
import com.haroo.service.BoardService;

public class UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		BoardVO board = service.detailBoardService(bdNo);
		
		request.setAttribute("board", board);
		
		forward.setPath("/update_form.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
