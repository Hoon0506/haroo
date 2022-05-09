package com.haroo.action.attendance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.AttendanceService;

public class UpdateAttendanceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AttendanceService service = AttendanceService.getInstance();
		ActionForward forward = new ActionForward();
		
//		HttpSession session = request.getSession();
//	    session.setAttribute("emNo", 45424411);
//	    session.setAttribute("emName", "백민주");
		
	    service.updateEndTimeService(request);
		
	    forward.setPath("status");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
