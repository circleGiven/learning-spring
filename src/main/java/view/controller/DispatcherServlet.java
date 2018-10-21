package view.controller;
import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import biz.user.UserVO;
import biz.user.impl.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 사용자 요청을 처리할 클래스
 */
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("./");
        viewResolver.setSuffix(".do");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("EUC-KR");
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트 요청 path 정보 추출
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        // HadlerMapping을 통해 path에 해당하는 Controller를 검색
        Controller ctrl = handlerMapping.getController(path);

        // 검색된 Controller를 실행
        String viewName = ctrl.handleRequest(request, response);

        // ViewResolver를 통해 viewName에 해당하는 화면을 검색
        String view = null;
        if (!viewName.contains(".do")) {
            view = viewResolver.getView(viewName);
        } else {
            view = viewName;
        }

        // 검색된 화면으로 이동
        response.sendRedirect(view);

//        // 클라이언트 요청 path에 따라 적절히 분기처리
//        if (path.equals("/login.do")) {
//            System.out.println("로그인 처리");
//
//            // 사용자 입력 정보 추출
//            String id = request.getParameter("id");
//            String password = request.getParameter("password");
//
//            // DB 연동 처리
//            UserVO vo = new UserVO();
//            vo.setId(id);
//            vo.setPassword(password);
//
//            UserDAO userDAO = new UserDAO();
//            UserVO user = userDAO.getUser(vo);
//
//            // 화면 네비게이션
//            if (user != null) {
//                response.sendRedirect("getBoardList.do");
//            } else {
//                response.sendRedirect("login.jsp");
//            }
//        } else if (path.equals("/logout.do")) {
//            System.out.println("로그아웃 처리");
//
//            // 브라우저와 연결된 세션 객체를 강제 종료
//            HttpSession session = request.getSession();
//            session.invalidate();
//
//            // 세션 종료 후, 메인 화면으로 이동
//            response.sendRedirect("login.jsp");
//        } else if (path.equals("/insertBoard.do")) {
//            System.out.println("글 등록 처리");
//
//            // 사용자 입력 정보 추출
////            request.setCharacterEncoding("EUC-KR");
//            String title = request.getParameter("title");
//            String writer = request.getParameter("writer");
//            String content = request.getParameter("content");
//
//            // DB 연동 처리
//            BoardVO vo = new BoardVO();
//            vo.setTitle(title);
//            vo.setWriter(writer);
//            vo.setContent(content);
//
//            BoardDAO boardDAO = new BoardDAO();
//            boardDAO.insertBoard(vo);
//
//            // 화면 네비게이션
//            response.sendRedirect("getBoardList.do");
//        } else if (path.equals("/updateBoard.do")) {
//            System.out.println("글 수정 처리");
//
//            // 사용자 입력 정보 추출
////            request.setCharacterEncoding("EUC-KR");
//            String title = request.getParameter("title");
//            String content = request.getParameter("content");
//            String seq = request.getParameter("seq");
//
//            // DB 연동 처리
//            BoardVO vo = new BoardVO();
//            vo.setTitle(title);
//            vo.setContent(content);
//            vo.setSeq(Integer.parseInt(seq));
//
//            BoardDAO boardDAO = new BoardDAO();
//            boardDAO.updateBoard(vo);
//
//            // 화면 네비게이션
//            response.sendRedirect("getBoardList.do");
//        }else if (path.equals("/deleteBoard.do")) {
//            System.out.println("글 삭제 처리");
//
//            // 사용자 입력 정보 추출
//            String seq = request.getParameter("seq");
//
//            // DB 연동 처리
//            BoardVO vo = new BoardVO();
//            vo.setSeq(Integer.getInteger(seq));
//
//            BoardDAO boardDAO = new BoardDAO();
//            boardDAO.deleteBoard(vo);
//
//            // 화면 네비게이션
//            response.sendRedirect("getBoardList.do");
//        }else if (path.equals("/getBoard.do")) {
//            System.out.println("글 상세 조회 처리");
//
//            // 검색할 게시글 번호 추출
//            String seq = request.getParameter("seq");
//
//            // DB 연동 처리
//            BoardVO vo = new BoardVO();
//            vo.setSeq(Integer.parseInt(seq));
//
//            BoardDAO boardDAO = new BoardDAO();
//            BoardVO board = boardDAO.getBoard(vo);
//
//            // 검색 결과를 세션에 저장하고 상세화면으로 이동
//            // 검색 결과를 세션에 저장하고 목록 화면으로 이동
//            HttpSession session = request.getSession();
//            session.setAttribute("board", board);
//            response.sendRedirect("getBoard.jsp");
//        }else if (path.equals("/getBoardList.do")) {
//            System.out.println("글 목록 검색 처리");
//
//            // 사용자 입력 정보 추출
//
//            // DB 연동 처리
//            BoardVO vo = new BoardVO();
//            BoardDAO boardDAO = new BoardDAO();
//            List<BoardVO> boardList = boardDAO.getBoardList(vo);
//
//            // 검색 결과를 세션에 저장하고 목록 화면으로 이동
//            HttpSession session = request.getSession();
//            session.setAttribute("boardList", boardList);
//            response.sendRedirect("getBoardList.jsp");
//        }
    }
}
