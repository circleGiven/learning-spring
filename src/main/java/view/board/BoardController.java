package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
    // 글 등록
    @RequestMapping(value = "/insertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 등록 처리");

        // 글 등록
        boardDAO.insertBoard(vo);
        // 포워드
        return "getBoardList.do";
    }

    // 글 수정
    @RequestMapping("updateBoard.do")
    public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 수정 처리");

        // 업데이트
        boardDAO.updateBoard(vo);
        return "getBoardList.do";
    }

    // 글 삭제
    @RequestMapping("/deleteBoard.do")
    public String modelAndView(BoardVO vo, BoardDAO boardDAO) {
        System.out.println("글 삭제 처리");

        // 삭제
        boardDAO.deleteBoard(vo);

        // 화면 네비게이션
        return "getBoardList.do";
    }

    // 글 상세조회
    @RequestMapping("/getBoard.do")
    public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView modelAndView) {
        System.out.println("글 상세 조회 처리");
        modelAndView.addObject("board", boardDAO.getBoard(vo));
        modelAndView.setViewName("getBoard.jsp");
        return modelAndView;
    }

    // 글 목록 검색
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
