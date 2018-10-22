package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetBoardController {

    @RequestMapping("/getBoard.do")
    public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView) {
        System.out.println("글 상세 조회 처리");
        modelAndView.addObject("board", boardDAO.getBoard(vo));
        modelAndView.setViewName("getBoard.jsp");
        return modelAndView;
    }
}
