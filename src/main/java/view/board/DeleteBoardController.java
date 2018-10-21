package view.board;

import biz.board.BoardVO;
import biz.board.impl.BoardDAO;
import view.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("글 삭제 처리");

        // 사용자 입력 정보 추출
        String seq = request.getParameter("seq");

        // DB 연동 처리
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.getInteger(seq));

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(vo);

        // 화면 네비게이션
        return "getBoardList.do";
    }
}
