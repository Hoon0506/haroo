package com.haroo.action.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.DepartmentVO;
import com.haroo.service.DepartmentService;

public class DepartmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward actionForward = new ActionForward();
		DepartmentService service = DepartmentService.getInstance();
		
		List<DepartmentVO> list = service.listDepartment(request);
		request.setAttribute("list", list);
		
		actionForward.setPath("/department_list.jsp");
		actionForward.setRedirect(false);

/*	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward actionForward = new ActionForward();
		DepartmentService departmentService = new DepartmentService();
		
		departmentService.listDepartment(request);
		
		actionForward.setPath("/list.jsp");
		actionForward.setRedirect(false);
		*/
		return actionForward;
		
	
	}// --end execute

}// --end Class DepartmentAction