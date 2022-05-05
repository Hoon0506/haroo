package haroo.action.mypage;

import haroo.action.Action;
import haroo.action.ActionForward;
import haroo.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        EmployeeService employeeService = new EmployeeService();

        employeeService.updateEmployeeService(request, response);

        actionForward.setPath("/mypage");
        actionForward.setRedirect(true);

        return actionForward;
    }
}
