package com.haroo.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haroo.domain.FileVO;
import com.haroo.repository.ChatDao;
import com.haroo.repository.FileDao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ChatService {
	private static ChatService service = new ChatService();
	private static ChatDao dao;
	private static FileDao dao2;
	
	public static ChatService getInstance() {
		dao = ChatDao.getInstance();
		dao2 = FileDao.getInstance();
		return service;
	}
	
	
	public int fileUploadService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
						
		String uploadPath = request.getRealPath("upload");
		int size = 10 * 1024 * 1024;
		String encoding = "UTF-8";
		
		MultipartRequest multi =
				new MultipartRequest(request, uploadPath, size, encoding, new DefaultFileRenamePolicy());
		
		FileVO fileVO = new FileVO();
		/* fileVO.setContentssize(multi.getParameter("contentsSize")); */
		fileVO.setCo_name("");
		
		//파일업로드 했을때
		if(multi.getFilesystemName("contentsName") != null) {
			String contentsName = (String)multi.getFilesystemName("contentsName");			
			fileVO.setCo_name(contentsName);
		
		
			//썸네일 이미지(gif,jpg,png)   aa.jpg => aa_small.jpg
			String pattern = contentsName.substring(contentsName.indexOf(".")+1);//gif, jpg, png
			String head = contentsName.substring(0, contentsName.indexOf("."));//aa
			
			//원본파일객체
			String imagePath = uploadPath + "\\" + contentsName;
			File src = new File(imagePath);
			
			//썸네일 파일객체
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("JPEG") || pattern.equals("JPG") || pattern.equals("jpg")) {
				com.haroo.action.chat.ImageUtil.resize(src, dest, 100, com.haroo.action.chat.ImageUtil.RATIO);
		}
	}		
		
		return dao2.uploadFile(fileVO);
	}
		
	
	public List<FileVO> listFileService(HttpServletRequest request)throws Exception {
		List<FileVO> list = dao2.listFileVO();
		return list;
	}

}
