package com.haroo.action.dayoff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.Dayoff;
import com.haroo.service.DayoffService;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DayoffService service = DayoffService.getInstance();
		ActionForward forward = new ActionForward();
		
		int emNo = Integer.parseInt((String)request.getAttribute("emNo"));
		Dayoff dayoff = service.listDayoff(emNo);
		request.setAttribute("dayoff", dayoff);
		
		forward.setPath("/dayoff_situation.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
