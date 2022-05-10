package com.haroo.action.chat;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haroo.action.Action;
import com.haroo.action.ActionForward;
import com.haroo.domain.FileVO;
import com.haroo.service.ChatService;

public class ListFileAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ChatService service = ChatService.getInstance();
		ActionForward forward = new ActionForward();
			
		List<FileVO> list = service.listFileService(request);
		request.setAttribute("list", list);
		
		forward.setPath("/chat_fileuploaded.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
