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
		

		
	    service.updateEndTimeService(request);
		
	    forward.setPath("status");
		forward.setRedirect(true);
		
		
		return forward;
	}

}
