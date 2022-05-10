package com.haroo.action.login;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.*;
import com.haroo.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        EmployeeService employeeService = EmployeeService.getInstance();
        HttpSession httpSession = request.getSession();

        EmployeeVO employeeVO = employeeService.loginEmployeeService(request, response);

        if (employeeVO != null) {
            actionForward.setPath("/test-main.jsp");
            actionForward.setRedirect(false);
            httpSession.setAttribute("employeeVO", employeeVO);
        } else {
            actionForward.setPath("/haroo/login");
            actionForward.setRedirect(true);
        }

        return actionForward;
    }
}
