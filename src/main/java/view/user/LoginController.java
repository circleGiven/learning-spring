package view.user;

import biz.user.UserVO;
import biz.user.impl.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(@ModelAttribute("user") UserVO vo) {
        System.out.println("로그인 화면으로 이동");
        vo.setId("admin");
        vo.setPassword("admin");
        return "login.jsp";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(UserVO vo, UserDAO userDAO) {
        System.out.println("로그인 인증 처리...");

        // 화면 네비게이션
        if (null != userDAO.getUser(vo)) {
            return "getBoardList.do";
        } else {
            return "login.jsp";
        }
    }
}
