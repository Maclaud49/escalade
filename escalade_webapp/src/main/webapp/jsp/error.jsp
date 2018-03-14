<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="./include/head.jsp" %>
</head>

<body>

    <h2>Une erreur s'est produite</h2>

    <s:a action="index">
        <s:text name="error.back.home"/>
    </s:a>

    <s:actionerror />

    <s:bean name="java.util.Date" var="now" />
    <s:text name="error.metadata">
        <s:param value="now" />
    </s:text>
</body>
</html>
