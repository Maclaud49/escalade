<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="./include/head.jsp" %>
</head>

    <body>
    <s:a action="index">
        <s:text name="error.back.home"/>
    </s:a>

    <h2><s:text name="login.connexion"/></h2>

        <s:form action="login">
            <s:textfield name="login" key="login.id" requiredLabel="true" />
            <s:password name="password" key="login.password" requiredLabel="true" />

            <s:submit value="Connexion"/>
        </s:form>

        <%@ include file="./include/footer.jsp" %>
    </body>

</html>