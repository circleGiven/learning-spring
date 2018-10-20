<%--
  Created by IntelliJ IDEA.
  User: choewonjun
  Date: 20/10/2018
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR" language="java" %>
<%
    // 브라우저와 연결된 세션 객체를 강제 종료
    session.invalidate();

    // 세션 종료 후, 메인 화면으로 이동
    response.sendRedirect("login.jsp");
%>
