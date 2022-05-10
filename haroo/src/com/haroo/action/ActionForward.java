
package com.haroo.action;

public class ActionForward {
    private boolean isRedirect;//Dispatcher vs Redirect
    private String path;//경로

    public ActionForward() {}

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    public String getPath() {
        return path;
    }

	public void setPath(String path) {
		this.path = path;
	}
}

