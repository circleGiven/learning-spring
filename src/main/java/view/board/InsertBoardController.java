package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class InsertBoardController {

    /**
     * command 객체 사용
     * @param vo
     */
    @RequestMapping(value = "/insertBoard.do")
    public void insertBoard(BoardVO vo) {
        System.out.println("글 등록 처리");

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insertBoard(vo);
    }
}
