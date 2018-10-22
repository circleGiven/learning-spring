package view.user;

import biz.user.UserVO;
import biz.user.impl.UserDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그인 처리");

        // 사용자 입력 정보 추출
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        // DB 연동 처리
        UserVO vo = new UserVO();
        vo.setId(id);
        vo.setPassword(password);

        UserDAO userDAO = new UserDAO();
        UserVO user = userDAO.getUser(vo);

        // 화면 네비게이션
        ModelAndView mav = new ModelAndView();
        if (null != user) {
            mav.setViewName("redirect:getBoardList.do");
        } else {
            mav.setViewName("redirect:login.jsp");
        }
        return mav;
    }
}
