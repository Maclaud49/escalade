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
        <div class="alert alert-success text-center" style="margin-top:20px">
            <strong>Merci pour ta contribution !</strong><s:actionmessage style="list-style:none" />
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
                    <p class="card-text"><strong>Nombre de secteurs : </strong> <s:property value="site.nbSecteurs" /></p>
                    <p class="card-text"><strong>Nombre de voies : </strong> <s:property value="site.nbVoies" /></p>
                    <p class="card-text"><strong>Publié : </strong>
                        <s:if test="site.ispublication">
                            Oui
                        </s:if>
                        <s:else>
                            Non
                        </s:else>
                    </p>
                    <div>
                    <div class="card-text"><strong>Liste des secteurs : </strong>
                        <s:if test="site.secteurs.size() == 0">
                            Pas de secteurs rattachés à ce site
                        </s:if>
                        <s:else>
                        <ul class="text-center">


                            <s:iterator value="site.secteurs">
                                    <li style = "list-style: none;margin:10px">
                                        <s:a action="secteur_detail" class="btn btn-primary">
                                            <s:param name="secteurId" value="id" />
                                            <s:property value="nom" />
                                        </s:a>

                                    </li>
                            </s:iterator>
                         </ul>
                        </s:else>
                    </div>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    Posté le <s:date name="createdDate" format="dd/MM/yyyy" /> par
                        <s:a action="utilisateur_detail">
                            <s:param name="utilisateurId" value="site.utilisateur.id" />
                            <s:property value="site.utilisateur.prenom"/> <s:property value="site.utilisateur.nom"/>
                        </s:a>
                    <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH:mm:ss" />
                </div>
            </div>
        </div>


        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Modification site -->
            <s:if test="site.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
                <div class="card mb-4">
                    <h5 class="card-header">Modifier le site</h5>
                    <div class="card-body text-center">
                        <s:a action="site_modifier" class="btn btn-secondary"><s:param name="siteId" value="site.id" />Modifier</s:a>
                    </div>
                </div>
            </s:if>


            <!-- Creation site Widget -->
            <div class="card mb-4">
                <h5 class="card-header">Créer un nouveau site</h5>
                <div class="card-body text-center">
                    <s:a action="site_new" class="btn btn-secondary">Et un de plus !</s:a>
                </div>
            </div>

            <!-- Ajouter un secteur -->
            <div class="card mb-4">
                <h5 class="card-header">Ajouter un secteur à ce site</h5>
                <div class="card-body text-center">
                    <s:a action="secteur_new" class="btn btn-secondary">
                        <s:param name="siteId" value="%{site.id}" />
                        Ajouter</s:a>
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