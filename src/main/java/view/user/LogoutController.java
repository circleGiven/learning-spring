package view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping("/logout.do")
    public String logOut(HttpSession session) {
        System.out.println("로그아웃 처리");

        // 브라우저와 연결된 세션 객체를 강제 종료
        session.invalidate();

        // 세션 종료 후, 메인 화면으로 이동
        return "login.jsp";
    }
}
