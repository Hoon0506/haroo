package com.haroo.action.login;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.EmployeeVO;
<<<<<<< HEAD:haroo/src/com/haroo/action/login/LoginAction.java
import com.haroo.service.EmployeeService;
=======
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a:haroo/src/haroo/action/login/LoginAction.java

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.service.EmployeeService;

public class LoginAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        EmployeeService employeeService = EmployeeService.getInstance();
        HttpSession httpSession = request.getSession();

        EmployeeVO employeeVO = employeeService.loginEmployeeService(request, response);

        if (employeeVO != null) {
            actionForward.setPath("/test.jsp");
            actionForward.setRedirect(false);
            httpSession.setAttribute("employeeVO", employeeVO);
        } else {
            actionForward.setPath("/haroo/login");
            actionForward.setRedirect(true);
        }

        return actionForward;
    }
}
