package com.haroo.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.BoardService;

public class InsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();

		// 비지니스 호출
		service.insertBoardService(request);

		// 페이지 이동 : listAction.do
		forward.setPath("listAction.do");
		forward.setRedirect(true); // redirect

		return forward;
	}

}
