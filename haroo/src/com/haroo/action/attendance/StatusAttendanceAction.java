package com.haroo.action.attendance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.AttendanceVO;
import com.haroo.service.AttendanceService;

public class StatusAttendanceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AttendanceService service = AttendanceService.getInstance();
		ActionForward forward = new ActionForward();
		
//		HttpSession session = request.getSession();
//	    session.setAttribute("emNo", 45424411);
//	    session.setAttribute("daName", "백민주");
		
		
		
		List<AttendanceVO> list = service.statusAttendanceService(request);
		request.setAttribute("list", list);
		
		//System.out.println(list.get(0).getEmNo());
	     // System.out.println(list.get(0).getAtState());
	     // System.out.println(list.get(0).getAtNote());
		
		
	    forward.setPath("/attendance_situation.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
