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
                    <p class="card-text"><strong>Description : </strong> <s:property value="site.description" /></p>
                    <p class="card-text"><strong>Région : </strong> <s:property value="site.region" /></p>
                    <p class="card-text"><strong>Nombres de secteurs : </strong> </strong><s:property value="site.nbSecteurs" /></p>
                    <p class="card-text"><strong>Nombres de voies : </strong> <s:property value="site.description" /></p>
                    <p class="card-text"><strong>Site publié : </strong>
                        <s:if test="site.ispublication">
                            Oui
                        </s:if>
                        <s:else>
                            Non
                        </s:else>
                    </p>
                    <div>
                    <p class="card-text"><strong>Liste des secteurs : </strong>
                        <ul class="text-center">
                            <s:iterator value="listSecteur">
                                    <li style = "list-style: none;margin:10px">
                                        <s:a action="secteur_detail" class="btn btn-primary">
                                            <s:param name="id" value="id" />
                                            <s:property value="nom" />
                                        </s:a>

                                    </li>
                            </s:iterator>
                         </ul>
                    </p>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    Posté le <s:date name="createdDate" format="dd/MM/yyyy" /> par
                        <s:a action="utilisateur_detail">
                            <s:param name="id" value="site.utilisateur.id" />
                            <s:property value="site.utilisateur.prenom"/> <s:property value="site.utilisateur.nom"/>
                        </s:a>
                    Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" />
                </div>
            </div>
        </div>


        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Modification site -->
            <div class="card mb-4">
                <h5 class="card-header">Modifier ce site</h5>
                <div class="card-body text-center">
                    A faire
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
                    <s:a action="site_new" class="btn btn-secondary">Et un de plus !</s:a>
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