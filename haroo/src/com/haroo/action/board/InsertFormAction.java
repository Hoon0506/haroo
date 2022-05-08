package com.haroo.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.BoardService;

public class InsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// insert_form.jsp �̵��� ���ּ���.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // ����ó�ϱ�����
		forward.setPath("/insert_form.jsp");

		return forward;
	}

}
