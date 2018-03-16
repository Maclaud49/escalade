<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../include/head.jsp" %>
</head>

<body>
    <%@ include file="../include/header.jsp" %>
    <s:actionerror/>
    <s:actionmessage/>

    <h2><s:text name="site.create"/></h2>
        <s:form action="site_new">
            <s:textfield name="site.nom" label="Nom" requiredLabel="true" />
            <s:select name="site.utilisateur" label="Responsable"
                      list="listUtilisateur" listKey="id" listValue="prenom"
                      emptyOption="true"
                      requiredLabel="true"/>

            <s:checkbox name="site.publication" label="Cloturé"/>

            <s:submit value="OK"/>
        </s:form>

    <%@ include file="../include/footer.jsp" %>
</body>
</html>
