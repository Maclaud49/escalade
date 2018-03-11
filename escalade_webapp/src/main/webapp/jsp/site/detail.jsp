<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Escalade</title>
</head>

<body>
    <h2>Détail du site</h2>

    <ul>
        <li>ID : <s:property value="site.id" /></li>
        <li>Nom : <s:property value="site.nom" /></li>
        <li>Date création : <s:date name="site.presentation" /></li>
        <li>
            Responsable :
            <s:a action="utilisateur_detail">
                <s:param name="id" value="site.utilisateur.id" />
                <s:property value="site.utilisateur.prenom"/> <s:property value="site.utilisateur.nom"/>
            </s:a>
        </li>
        <li>Cloturé : <s:property value="site.lastUpdate" /></li>
    </ul>
</body>
</html>
