<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="./include/head.jsp" %>
</head>

<body>
    <h2><s:text name="home.welcome"/></h2>

    <s:a action="site_list">
        <s:text name="nav.listSite"/>
    </s:a>

    <br>
    <%@ include file="./include/footer.jsp" %>
</body>
</html>
