<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2021/9/3
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--静态包含base标签，css样式，jQuery文件    --%>
<%
    String baseURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<base href="<%=baseURL%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script src="static/script/jquery-1.7.2.js"></script>
