package biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args) {
        // 1. Spring 컨테이너 구동
        AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
        // 2. spring 컨테이너로 부터 필요한 객체를 요청
        BoardService boardService = (BoardService)factory.getBean("boardService");

        // 3. 글 등록 기능 테스트
        BoardVO vo = new BoardVO();
        vo.setTitle("임시 제목");
        vo.setWriter("최원준");
        vo.setContent("내용 테스트.....");
        boardService.insertBoard(vo);

        // 4. 글 목록 검색 기능 테스트
        List<BoardVO> list = boardService.getBoardList(vo);
        for (BoardVO boardVO: list) {
            System.out.println("---> " + boardVO.toString());
        }

        // 5. 컨테이너 종료
        factory.close();
    }
}
