package view.board;

import biz.board.BoardService;
import biz.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("board")
public class BoardController {


    @Autowired
    private BoardService boardService;

    // 검색 조건 목록 설정 (@RequestMapping 보다 먼저 호출)
    @ModelAttribute("conditionMap")
    public Map<String, String> searchConditionMap() {
        Map<String, String> conditionMap = new HashMap<String, String>();
        conditionMap.put("제목", "TITLE");
        conditionMap.put("내용", "CONTENT");
        return conditionMap;
    }


    // 글 등록
    @RequestMapping(value = "/insertBoard.do")
    public String insertBoard(BoardVO vo) {
        System.out.println("글 등록 처리");

        // 글 등록
        boardService.insertBoard(vo);
        // 포워드
        return "getBoardList.do";
    }

    // 글 수정
    @RequestMapping("updateBoard.do")
    public String updateBoard(@ModelAttribute("board") BoardVO vo) {
        System.out.println("글 수정 처리");
        // 작성자 이름 check
        System.out.println("번호 : " + vo.getSeq());
        System.out.println("제목 : " + vo.getTitle());
        System.out.println("작성자 이름 : " + vo.getWriter());
        System.out.println("내용 : " + vo.getContent());
        System.out.println("등록일 : " + vo.getRegDate());
        System.out.println("조회수 : " + vo.getCnt());
        // 업데이트
        boardService.updateBoard(vo);
        return "getBoardList.do";
    }

    // 글 삭제
    @RequestMapping("/deleteBoard.do")
    public String modelAndView(BoardVO vo) {
        System.out.println("글 삭제 처리");

        // 삭제
        boardService.deleteBoard(vo);

        // 화면 네비게이션
        return "getBoardList.do";
    }

    // 글 상세조회
    @RequestMapping("/getBoard.do")
    public String getBoard(BoardVO vo, Model model) {
        System.out.println("글 상세 조회 처리");
        // 조회 결과를 model 에 저장
        // @SessionAttribute("board")라는 설정이 있으면 model에 저장될때 세션에 같이 저장됨
        model.addAttribute("board", boardService.getBoard(vo));
        return "getBoard.jsp";
    }

    // 글 목록 검색
    @RequestMapping("/getBoardList.do")
    public String getBoardList(@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
                               @RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword,
                               BoardVO vo, Model model) {
        System.out.println("글 목록 검색 처리");
        System.out.println("검색 조건 : " + condition);
        System.out.println("검색 단어 : " + keyword);

        // 검색 결과 저장
        model.addAttribute("boardList", boardService.getBoardList(vo));
        // 화면 정보 설정
        return "getBoardList.jsp";
    }

}
