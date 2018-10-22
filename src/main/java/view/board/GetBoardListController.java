package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetBoardListController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 목록 검색 처리");

        // 사용자 입력 정보 추출

        // DB 연동 처리
        BoardVO vo = new BoardVO();
        BoardDAO boardDAO = new BoardDAO();
        List<BoardVO> boardList = boardDAO.getBoardList(vo);

        // 검색 결과와 화면 정보를 ModelAndView 에 저장하여 리턴
        ModelAndView modelAndView = new ModelAndView();
        // 검색 결과 저장
        modelAndView.addObject("boardList", boardList);
        // 화면 정보 설정
        modelAndView.setViewName("getBoardList");
        return modelAndView;
    }
}
