package biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args) {
        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

        BoardService service = (BoardService)container.getBean("boardService");

        BoardVO vo = new BoardVO();
        vo.setTitle("제목");
        vo.setWriter("최원준");
        vo.setContent("테스트으으으으으으응!");
        service.insertBoard(vo);

        List<BoardVO> boardList = service.getBoardList(vo);
        for (BoardVO board: boardList) {
            System.out.println(board.toString());
        }

        container.close();
    }
}
