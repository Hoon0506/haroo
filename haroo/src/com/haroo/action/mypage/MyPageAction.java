package com.haroo.action.mypage;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        EmployeeService employeeService = new EmployeeService();

        employeeService.updateEmployeeService(request, response);

        actionForward.setPath("/haroo/mypage");
        actionForward.setRedirect(true);

        return actionForward;
    }
}
