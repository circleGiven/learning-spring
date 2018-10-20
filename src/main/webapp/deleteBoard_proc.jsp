<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="biz.board.BoardVO" %>
<%@ page import="biz.board.impl.BoardDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 사용자 입력 정보 추출
    String seq = request.getParameter("seq");

    // DB 연동 처리
    BoardVO vo = new BoardVO();
    vo.setSeq(Integer.getInteger(seq));

    BoardDAO boardDAO = new BoardDAO();
    boardDAO.deleteBoard(vo);

    // 화면 네비게이션
    response.sendRedirect("getBoardList.jsp");
%>