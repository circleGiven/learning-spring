package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
        System.out.println("글 상세 조회 처리");
        model.addAttribute("board", boardDAO.getBoard(vo));
        return "getBoard.jsp";
    }

    // 글 목록 검색
    @RequestMapping("/getBoardList.do")
    public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
        System.out.println("글 목록 검색 처리");
        // 검색 결과 저장
        model.addAttribute("boardList", boardDAO.getBoardList(vo));
        // 화면 정보 설정
        return "getBoardList.jsp";
    }

}
