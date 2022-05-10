package com.haroo.action.dayoff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.DayoffVO;
import com.haroo.service.DayoffService;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DayoffService service = DayoffService.getInstance();
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
	    session.setAttribute("emNo", 45424411);
	    session.setAttribute("daName", "백민주");
		
		DayoffVO dayoff = service.listDayoffService(request);
		request.setAttribute("dayoff", dayoff);
		
		forward.setPath("/dayoff_situation.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
