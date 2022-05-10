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

		//오늘의 날짜 출력
		String today = service.printTodayService(request);
		request.setAttribute("today", today);
		
		//로그인한 사원의 부서 목록 출력
		List<AttendanceVO> depts = service.listDeptService(request);
		request.setAttribute("depts", depts);
		
		
		//출근한 사람 출력
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
