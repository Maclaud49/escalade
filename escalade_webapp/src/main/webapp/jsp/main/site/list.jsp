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

        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3">Liste des sites
            <small>Classé par date de modification</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <s:a action="index" ><s:text name="home.home"/></s:a>
            </li>
            <li class="breadcrumb-item active">Liste des sites</li>
        </ol>

        <div class="row">

            <div class="col-md-8">

                <s:iterator value="listSite">
                    <div class="card mb-4">
                        <img class="card-img-top" src="<s:property value="image" />" alt="Card image cap">
                        <div class="card-body">
                            <h2 class="card-title"><s:property value="nom" /></h2>
                            <p class="card-text"><s:property value="description" /></p>
                            <s:a action="site_detail" class="btn btn-primary">
                                <s:param name="id" value="id" />
                                En savoir plus &rarr;
                            </s:a>
                        </div>
                        <div class="card-footer text-muted">
                            Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                            <s:a action="utilisateur_detail">
                                <s:param name="id" value="utilisateur.id" />
                                <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                            </s:a>
                        </div>
                    </div>
                </s:iterator>

                <!-- Pagination -->
                <ul class="pagination justify-content-center mb-4">
                    <li class="page-item">
                        <a class="page-link" href="#">&larr; Précédent</a>
                    </li>
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Suivant &rarr;</a>
                    </li>
                </ul>

            </div>

            <!-- Sidebar Widgets Column -->
            <div class="col-md-4">

                <!-- Search Widget -->
                <div class="card mb-4">
                    <h5 class="card-header">Rechercher</h5>
                    <div class="card-body">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Rechercher...">
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
                        <s:if test="#session.escalade_user">
                            <s:a action="site_new" class="btn btn-secondary">Moi aussi je partage !</s:a>
                        </s:if>
                        <s:else>
                            <s:a action="login" class="btn btn-secondary">Je me connecte !</s:a>
                        </s:else>
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