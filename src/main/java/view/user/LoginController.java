package view.user;

import biz.user.UserVO;
import biz.user.impl.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login.do")
    public String login(UserVO vo, UserDAO userDAO) {
        System.out.println("로그인 처리");

        // 화면 네비게이션
        if (null != userDAO.getUser(vo)) {
            return "getBoardList.do";
        } else {
            return "login.jsp";
        }
    }
}
