package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteBoardController {

    @RequestMapping("/deleteBoard.do")
    public String modelAndView(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 삭제 처리");

        // 삭제
        boardDAO.deleteBoard(vo);

        // 화면 네비게이션
        return "getBoardList.do";
    }
}
