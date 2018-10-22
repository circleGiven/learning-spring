package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertBoardController {

    /**
     * command 객체 사용
     * @param vo
     */
    @RequestMapping(value = "/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 등록 처리");

        // 글 등록
        boardDAO.insertBoard(vo);
        // 포워드
        return "getBoardList.do";
    }
}
