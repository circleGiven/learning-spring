<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="biz.user.impl.UserDAO" %>
<%@page import="biz.user.UserVO" %>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%
    // ����� �Է� ���� ����
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    // DB ���� ó��
    UserVO vo = new UserVO();
    vo.setId(id);
    vo.setPassword(password);

    UserDAO userDAO = new UserDAO();
    UserVO user = userDAO.getUser(vo);

    // ȭ�� �׺���̼�
    if (user != null) {
        response.sendRedirect("getBoardList.jsp");
    } else {
        response.sendRedirect("login.jsp");
    }
%>
