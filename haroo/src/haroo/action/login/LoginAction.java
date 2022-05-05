package haroo.action.login;

import haroo.action.Action;
import haroo.action.ActionForward;
import haroo.domain.EmployeeVO;
import haroo.service.EmployeeService;

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
            actionForward.setPath("/test.jsp");
            actionForward.setRedirect(false);
            httpSession.setAttribute("employeeVO", employeeVO);
        } else {
            actionForward.setPath("/login");
            actionForward.setRedirect(true);
        }

        return actionForward;
    }
}
