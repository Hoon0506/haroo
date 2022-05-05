package haroo.action.task;

import haroo.action.Action;
import haroo.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaskFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/task-form.jsp");
        actionForward.setRedirect(false);

        return actionForward;
    }
}
