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
    <h1 class="mt-4 mb-3">Détail du secteur
        <small><s:property value="secteur.nom" /></small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Détail du secteur</li>
    </ol>

    <div class="row">

        <div class="col-md-8">
            <!-- Secteur detail -->
            <div class="card mb-4">
                <img class="card-img-top" alt="Card image cap" src="<s:property value="secteur.image" />" >
                <div class="card-body">
                    <p class="card-text"><strong>Description : </strong> <s:property value="secteur.description" /></p>
                    <p class="card-text"><strong>Département : </strong> <s:property value="secteur.departement" /></p>
                    <p class="card-text"><strong>Nombre de voies : </strong> <s:property value="secteur.nbVoies" /></p>
                    <p class="card-text"><strong>Publié : </strong>
                        <s:if test="secteur.ispublication">
                            Oui
                        </s:if>
                        <s:else>
                            Non
                        </s:else>
                    </p>
                    <div>
                    <div class="card-text"><strong>Liste des voies : </strong>
                        <s:if test="secteur.voies.size() == 0">
                            Pas de voies rattachées à ce secteur
                        </s:if>
                        <s:else>
                        <ul class="text-center">
                            <s:iterator value="secteur.voies">
                                    <li style = "list-style: none;margin:10px">
                                        <s:a action="voie_detail" class="btn btn-primary">
                                            <s:param name="voieId" value="id" />
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
                            <s:param name="utilisateurId" value="secteur.utilisateur.id" />
                            <s:property value="secteur.utilisateur.prenom"/> <s:property value="secteur.utilisateur.nom"/>
                        </s:a>
                    <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH:mm:ss" />
                </div>
            </div>
        </div>


        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Modification secteur -->
            <s:if test="secteur.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
                <div class="card mb-4">
                    <h5 class="card-header">Modifier le secteur</h5>
                    <div class="card-body text-center">
                        <s:a action="secteur_modifier" class="btn btn-secondary"><s:param name="secteurId" value="secteur.id" />Modifier</s:a>
                    </div>
                </div>
            </s:if>


            <!-- Creation secteur Widget -->
            <div class="card mb-4">
                <h5 class="card-header">Créer un nouveau secteur</h5>
                <div class="card-body text-center">
                    <s:a action="secteur_new" class="btn btn-secondary">Et un de plus !</s:a>
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