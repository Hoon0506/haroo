package haroo.action.mypage;

import haroo.action.Action;
import haroo.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/mypage-form.jsp");
        actionForward.setRedirect(false);

        return actionForward;
    }
}
