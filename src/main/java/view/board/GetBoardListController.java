package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GetBoardListController {

    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView) {
        System.out.println("글 목록 검색 처리");
        // 검색 결과 저장
        modelAndView.addObject("boardList", boardDAO.getBoardList(vo));
        // 화면 정보 설정
        modelAndView.setViewName("getBoardList.jsp");
        return modelAndView;
    }
}
