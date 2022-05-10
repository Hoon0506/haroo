package com.haroo.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.BoardService;

public class DeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		service.deleteBoardService(bdNo);
	
		
		forward.setPath("listAction.do");
		forward.setRedirect(true);
		return forward;
	}

}
