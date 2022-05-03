package com.haroo.action.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.BoardVO;
import com.haroo.service.BoardService;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardService service = BoardService.getInstance();
		ActionForward forward = new ActionForward();
		
		//ListModel listModel = service.listBoardService(request);
		List<BoardVO> list = service.listBoardService(request);
		request.setAttribute("list", list);
		//request.setAttribute("listModel", listModel);
		
		forward.setPath("/list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
