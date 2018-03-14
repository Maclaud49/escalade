<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../include/head.jsp" %>
</head>

<body>
    <h2>Détail de l'utilisateur</h2>

    <ul>
        <li>ID : <s:property value="utilisateur.id" /></li>
        <li>Nom : <s:property value="utilisateur.nom" /></li>
        <li>Prénom : <s:property value="utilisateur.prenom" /></li>
    </ul>

    <%@ include file="../include/footer.jsp" %>
</body>
</html>
