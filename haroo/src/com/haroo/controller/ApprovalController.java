package com.haroo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.action.approval.FormAction;
import com.haroo.action.approval.FormListAction;
import com.haroo.action.approval.LineAction;
import com.haroo.action.approval.MainAction;
import com.haroo.action.approval.PostReportAction;
import com.haroo.action.approval.PostTakebackAction;
import com.haroo.action.approval.ProcessAction;
import com.haroo.action.approval.ProcessListAction;

@WebServlet("/ap/*")
public class ApprovalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApprovalController() {
        super();
    }
    
  public String getCommand(HttpServletRequest request) {
    String requestUri = request.getRequestURI(); // /haroo/ap/form-list
    String contextPath = request.getContextPath(); // /haroo
    String command = requestUri.substring(contextPath.length()+4);
    
    return command;
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String command = getCommand(request); // form/1
    String id = command.substring(command.indexOf("/")+1); // 1

    System.out.println(command);
    System.out.println(id);
    
    Action action = null;
    ActionForward forward = null;
    
    if(command.equals("main")) {
        action = new MainAction();
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
	  } else if(command.contains("form")) { // 양식 리스트
      if(id.equals("forms")) { // /가 없어서 그냥 그대로 저장됨
        action = new FormListAction();
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if(id.equals("line")) { // 결재선 선택창
        action = new LineAction();
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if(id.matches("^[0-9]+$")) { // 번호에 해당하는 양식
        action = new FormAction();
        request.setAttribute("id", id);
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } 
    } else if(command.contains("process")) { // 상신-진행문서
      if(id.equals("process")) {
        action = new ProcessListAction();
        request.setAttribute("status", 0); // process는 진행문서기 때문에 진행 status 0 저장해서 넘겨줌
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if(id.matches("^[0-9]+$")) { // 번호에 해당하는 문서
        action = new ProcessAction();
        request.setAttribute("id", id);
        
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } else if(command.contains("takeback")) { // 상신취소문서
      if(id.equals("takeback")) {
        action = new ProcessListAction();
        request.setAttribute("status", -1); // process는 진행문서기 때문에 진행 status 0 저장해서 넘겨줌
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      } else if(id.matches("^[0-9]+$")) { // 번호에 해당하는 문서
        action = new ProcessAction();
        request.setAttribute("id", id);
        
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }  
    }
    
    if(forward != null) {
      if(forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
      } else {
        RequestDispatcher dp = request.getRequestDispatcher(forward.getPath());
        dp.forward(request, response);
      }
    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String command = getCommand(request);
    String id = command.substring(command.indexOf("/")+1);
    
    System.out.println(command);
    System.out.println(id);
    
    Action action = null;
    ActionForward forward = null;
    
    if(command.contains("form")) { // 양식
      if(id.matches("^[0-9]+$")) { // 상신
        action = new PostReportAction();
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } else if(command.contains("process")) { // 진행중문서
      if(id.matches("^[0-9]+$")) { // 상신취소
        action = new PostTakebackAction();
        try {
          forward = action.execute(request, response);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    
    
    if(forward != null) {
      if(forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
      } else {
        RequestDispatcher dp = request.getRequestDispatcher(forward.getPath());
        dp.forward(request, response);
      }
    }
	}

}
