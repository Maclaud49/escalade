<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../include/head.jsp" %>
</head>

<body>

    <s:actionmessage />

    <h2><s:text name="site.detail"/></h2>

    <ul>
        <li>ID : <s:property value="site.id" /></li>
        <li>Nom : <s:property value="site.nom" /></li>
        <li>Présentation : <s:property value="site.presentation" /></li>
        <li>
            Responsable :
            <s:a action="utilisateur_detail">
                <s:param name="id" value="site.utilisateur.id" />
                <s:property value="site.utilisateur.prenom"/> <s:property value="site.utilisateur.nom"/>
            </s:a>
        </li>
        <li>Création : <s:property value="site.dateCreation" /></li>
    </ul>

    <%@ include file="../include/footer.jsp" %>
</body>
</html>
