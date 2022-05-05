package haroo.action.login;

import haroo.action.task.Action;
import haroo.action.task.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/login-form.jsp");
        actionForward.setRedirect(false);

        return actionForward;
    }
}
