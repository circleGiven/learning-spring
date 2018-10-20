package view.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
        System.out.println(path);

        // 클라이언트 요청 path에 따라 적절히 분기처리
        if (path.equals("/login.do")) {
            System.out.println("로그인 처리");
        } else if (path.equals("/logout.do")) {
            System.out.println("로그아웃 처리");
        } else if (path.equals("/insertBoard.do")) {
            System.out.println("글 등록 처리");
        } else if (path.equals("/updateBoard.do")) {
            System.out.println("글 수정 처리");
        }else if (path.equals("/deleteBoard.do")) {
            System.out.println("글 삭제 처리");
        }else if (path.equals("/getBoard.do")) {
            System.out.println("글 상세 조회 처리");
        }else if (path.equals("/getBoardList.do")) {
            System.out.println("글 목록 검색 처리");
        }
    }
}
