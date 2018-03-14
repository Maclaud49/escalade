<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../include/head.jsp" %>
</head>

<body>
<h2><s:text name="site.list"/></h2>

    <ul>
        <s:iterator value="listSite">
            <li>
                <s:a action="site_detail">
                    <s:param name="id" value="id" />
                    <s:property value="nom"/>
                </s:a>

                - Responsable :
                <s:a action="utilisateur_detail">
                    <s:param name="id" value="utilisateur.id" />
                    <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                </s:a>
            </li>
        </s:iterator>
    </ul>

    <%@ include file="../include/footer.jsp" %>
</body>
</html>
