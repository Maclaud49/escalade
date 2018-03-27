<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="../../include/head.jsp" %>
</head>

<body>
<%@ include file="../../include/header.jsp" %>

<!-- Page Content -->
<div class="container">

    <s:if test="hasActionMessages()">
        <div class="alert alert-success" style="margin-top:20px">
            <strong>Merci pour ta contribution !</strong><s:actionmessage />
        </div>
    </s:if>

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Détail du site
        <small><s:property value="site.nom" /></small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Détail du site</li>
    </ol>

    <div class="row">

        <div class="col-md-8">
            <!-- Site detail -->
            <div class="card mb-4">
                <img class="card-img-top" alt="Card image cap" src="<s:property value="site.image" />" >
                <div class="card-body">
                    <h2 class="card-title"><s:property value="site.nom" /></h2>
                    <p class="card-text"><s:property value="site.description" /></p>
                    <a href="#" class="btn btn-primary">En savoir plus &rarr;</a>
                </div>
                <div class="card-footer text-muted">
                    Posté le <s:date name="createdDate" format="dd/MM/yyyy" /> par
                        <s:a action="utilisateur_detail">
                            <s:param name="id" value="site.utilisateur.id" />
                            <s:property value="site.utilisateur.prenom"/> <s:property value="site.utilisateur.nom"/>
                        </s:a>
                </div>
            </div>
        </div>


        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Search Widget -->
            <div class="card mb-4">
                <h5 class="card-header">Rechercher</h5>
                <div class="card-body">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                      <button class="btn btn-secondary" type="button">Go!</button>
                    </span>
                    </div>
                </div>
            </div>

            <!-- Categories Widget -->
            <div class="card my-4">
                <h5 class="card-header">Méthode de tri</h5>
                <div class="card-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                                <li>
                                    <a href="#">Date</a>
                                </li>
                                <li>
                                    <a href="#">Commentaires</a>
                                </li>
                                <li>
                                    <a href="#">Difficulté</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                                <li>
                                    <a href="#">Saison</a>
                                </li>
                                <li>
                                    <a href="#">Région</a>
                                </li>
                                <li>
                                    <a href="#">Appéciations</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Creation site Widget -->
            <div class="card mb-4">
                <h5 class="card-header">Créer un nouveau site</h5>
                <div class="card-body text-center">
                    <button class="btn btn-secondary" type="button">Moi aussi je partage !</button>
                </div>
            </div>

        </div>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->


<%@ include file="../../include/footer.jsp" %>

<%@ include file="../../include/script.jsp" %>

</body>

</html>