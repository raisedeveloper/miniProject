//package project.controller;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import project.entity.BoardAdvice;
//import project.service.BoardAdviceService;
//import project.service.BoardAdviceServiceImpl;
//
//import java.io.IOException;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet("/mini/board/*")
//public class BoardAdviceController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private BoardAdviceService b1Svc = new BoardAdviceServiceImpl();
//
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String[] uri = request.getRequestURI().split("/");
//		String action = uri[uri.length - 1];
//		String method = request.getMethod();
//		HttpSession session = request.getSession();
//		String sessUid = (String) session.getAttribute("sessUid");
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//
//		RequestDispatcher rd = null;
//		String title = null, content = null, field = null, query = null, uid = null, page_ = null;
//		BoardAdvice boardAdv = null;
//		int bid = 0;
//		int page = 0;
//
//		switch (action) {
//		case "listBoardAuction": {// /mp/mini/board/list?p=1&f=title&q=검색
//			page_ = request.getParameter("p");
//			field = request.getParameter("f");
//			query = request.getParameter("q");
//			page = (page_ == null || page_.equals("")) ? 1 : Integer.parseInt(page_);
//			session.setAttribute("currentBoardPage", page);
//			field = (field == null || field.equals("")) ? "title" : field;
//			query = (query == null || query.equals("")) ? "" : query;
//			session.setAttribute("field", field);
//			session.setAttribute("query", query);
//			List<BoardAdvice> boardList = b1Svc.getBoardAdviceList(page, field, query);
//			request.setAttribute("boardList", boardList);
//
//			// for pagination
//			int totalItems = b1Svc.getBoardAdviceCount(field, query);
//			int totalPages = (int) Math.ceil(totalItems * 1.0 / b1Svc.COUNT_PER_PAGE);
//			List<String> pageList = new ArrayList<String>();
//			for (int i = 1; i <= totalPages; i++)
//				pageList.add(String.valueOf(i));
//			request.setAttribute("pageList", pageList);
//
//			rd = request.getRequestDispatcher("/WEB-INF/view/board/list.jsp");
//			rd.forward(request, response);
//			break;
//		}
//		
//		
//	
//		case "insertBoardAuction": {
//
//			if (sessUid == null || sessUid.equals("")) {
//				response.sendRedirect("/mp/mini/user/login");
//				// 이것만 있으면 오류 코드 - sendRedirect와 forward 중 한번만 쓸 수 있음.
//				break; // 이후에 forward 를 할 수 없게 함.
//			}
//			if (method.equals("GET")) {
//				rd = request.getRequestDispatcher("/WEB-INF/view/board/insert.jsp");
//				rd.forward(request, response);
//			} else {
//				title = request.getParameter("title");
//				content = request.getParameter("content");
//				boardAdv = new BoardAdvice(title, content, sessUid);
//				b1Svc.insertBoardAdvice(boardAdv);
//				response.sendRedirect("/mp/mini/board/list?p=1");
//			}
//			break;
//		}
//
//		
//		case "detailBoardAuction": {
//			bid = Integer.parseInt(request.getParameter("bid"));
//			uid = request.getParameter("uid");
//			if (!uid.equals(sessUid))
//				b1Svc.increaseViewCount(bid);
//
//			boardAdv = b1Svc.getBoardAdvice(bid);
//			request.setAttribute("board", boardAdv);
//
//			List<Reply> replyList = null; // 댓글 목록 필요 - 2024 02 22 현재 미구현
//			request.setAttribute("replyList", replyList);
//
//			rd = request.getRequestDispatcher("/WEB-INF/view/board/detail.jsp");
//			rd.forward(request, response);
//			break;
//		}
//		
//		
//		case "deleteBoardAuction": {
//			bid = Integer.parseInt(request.getParameter("bid"));
//			b1Svc.deleteBoard(bid);
//			page = (Integer) session.getAttribute("currentBoardPage");
//			field = (String) session.getAttribute("field");
//			query = (String) session.getAttribute("query");
//			query = URLEncoder.encode(query, "utf-8");
//			response.sendRedirect("/mp/mini/board/list?p=" + page + "&f=" + field + "&q=" + query);
//			break;
//		}
//
//		
//		case "updateBoardAuction": {
//			if (method.equals("GET")) {
//				bid = Integer.parseInt(request.getParameter("bid"));
//				boardAdv = b1Svc.getBoard(bid);
//				request.setAttribute("board", boardAdv);
//				rd = request.getRequestDispatcher("/WEB-INF/view/board/update.jsp");
//				rd.forward(request, response);
//			} else {
//				bid = Integer.parseInt(request.getParameter("bid"));
//				uid = request.getParameter("uid");
//				title = request.getParameter("title");
//				content = request.getParameter("content");
//				boardAdv = new BoardAdvice(bid, title, content);
//
//				b1Svc.updateBoard(boardAdv);
//				response.sendRedirect("/mp/mini/board/detail?bid=" + bid + "&uid=" + uid);
//			}
//			break;
//		}
//	
//	
//
//		}
//	}
//}