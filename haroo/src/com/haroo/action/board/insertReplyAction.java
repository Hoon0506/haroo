package com.haroo.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.BoardService;

public class insertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();

		service.insertReplyService(request);
		forward.setPath("detailAction.do?bdNo=" + request.getParameter("bdNo"));
		forward.setRedirect(true);// 리다이렉트해야 한다.

		return forward;
	}

}
