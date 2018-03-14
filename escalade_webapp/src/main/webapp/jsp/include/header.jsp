<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<header>
    <s:if test="#session.user">
        Utilisateur connecté :
        <s:property value="#session.user.prenom" />
        <s:property value="#session.user.nom" />

        <s:a action="logout">Déconnexion</s:a>
    </s:if>
    <s:else>
        <s:a action="login">Connexion</s:a>
    </s:else>
</header>

<nav>
    <s:a action="site_list">
        <s:text name="nav.listSite" />
    </s:a>

    <s:a action="site_new"><s:text name="site.creation"/></s:a>
</nav>

<s:actionerror/>
<s:actionmessage/>