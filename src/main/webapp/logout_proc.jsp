<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%
    // �������� ����� ���� ��ü�� ���� ����
    session.invalidate();

    // ���� ���� ��, ���� ȭ������ �̵�
    response.sendRedirect("login.jsp");
%>
