package kosta.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.Board;
import kosta.model.BoardDao2;
import kosta.model.ListModel;
import kosta.model.Reply;
import kosta.model.Search;
import kosta.util.ImageUtil;


public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao2 dao;
	private static final int PAGE_SIZE = 2;
	
	public static BoardService getInstance() {
		dao = BoardDao2.getInstance();
		return service;
	}
	
	public int insertBoardService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		//파일업로드 로직
		//업로드경로, 파일크기, 인코딩, 파일이름중첩 정책
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;//20MB
				
		//파일 업로드가 완료
		MultipartRequest multi =
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
						
		Board board = new Board();
		board.setTitle(multi.getParameter("title"));
		board.setWriter(multi.getParameter("writer"));
		board.setContents(multi.getParameter("contents"));
		board.setFname("");
		
		//파일업로드 했을때
		if(multi.getFilesystemName("fname") != null) {
			String fname = (String)multi.getFilesystemName("fname");			
			board.setFname(fname);
			
			//썸네일 이미지(gif,jpg,png)   aa.jpg => aa_small.jpg
			String pattern = fname.substring(fname.indexOf(".")+1);//gif, jpg, png
			String head = fname.substring(0, fname.indexOf("."));//aa
			
			//원본파일객체
			String imagePath = uploadPath + "\\" + fname;
			File src = new File(imagePath);
			
			//썸네일 파일객체
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("JPEG") || pattern.equals("JPG") || pattern.equals("jpg")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
		}				
		
		return dao.insertBoard(board);
	}
	
	public ListModel listBoardService(HttpServletRequest request)throws Exception{
		
		//검색 관련 내용
		Search search = new Search();
		HttpSession session = request.getSession();
		
		//새로운 검색을 할 경우
		if(request.getParameterValues("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
		}//체크해제 후 검색버튼만 클릭
		else if(request.getParameterValues("area") == null
						&& request.getParameter("pageNum") == null) {
			session.removeAttribute("search");
		}
		
		//세션에 검색 정보가 있는 경우
		if(session.getAttribute("search") != null) {
			search = (Search)session.getAttribute("search");
		}
		
		
		
		//페이지 처리시 필요한 사항
		//페이지당 글개수, 총글개수, 총페이지수, 현재페이지
		//startPage, endPage, startRow, endRow
		
		//총글개수
		int totalCount = dao.countBoard(search);
		
		//총페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		//현재페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}		
		
		int requestPage = Integer.parseInt(pageNum);
		
		//startPage = 현재페이지 - (현재페이지 - 1)%5  => ex)  14 - (14 -1)%5 = 11
		int startPage = requestPage - (requestPage - 1) %5;
				
		//endPage 
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		//startRow = (현재페이지 - 1) * 페이지당 글개수
		int startRow = (requestPage - 1) * PAGE_SIZE;
		
		List<Board> list = dao.listBoard(startRow, search);
		
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
	}
	
	public Board detailBoardService(int seq)throws Exception{
		return dao.detailBoard(seq);
	}
	
	public int updateBoardService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Board board = new Board();
		board.setSeq(Integer.parseInt(request.getParameter("seq")));
		board.setTitle(request.getParameter("title"));
		board.setContents(request.getParameter("contents"));
		
		return dao.updateBoard(board);		
	}
	
	public int insertReplyService(HttpServletRequest request)throws Exception{
		Reply reply = new Reply();
		request.setCharacterEncoding("utf-8");
		reply.setR_title(request.getParameter("r_title"));
		reply.setR_writer(request.getParameter("r_writer"));
		reply.setR_contents(request.getParameter("r_contents"));
		reply.setSeq(Integer.parseInt(request.getParameter("seq")));
		
		return dao.insertReply(reply);		
	}
	
	public List<Reply> listReplyService(HttpServletRequest request)throws Exception{
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		return dao.listReply(seq);
	}
	
	
}









