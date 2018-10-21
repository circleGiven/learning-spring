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
        viewResolver.setSuffix(".jsp");
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
    }
}
