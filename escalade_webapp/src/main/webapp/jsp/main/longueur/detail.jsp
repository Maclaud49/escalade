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
            <s:actionmessage style="list-style:none" />
        </div>
    </s:if>

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Détail de la longueur
        <small><s:property value="longueur.nom" /></small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Détail de la longueur</li>
    </ol>

    <div class="row">

        <div class="col-md-8">
            <!-- Longueur detail -->
            <div class="card mb-4">
                <img class="card-img-top" alt="Card image cap" src="<s:property value="longueur.image" />" >
                <div class="card-body">
                    <p class="card-text"><strong>Description : </strong> <s:property value="longueur.description" /></p>
                    <p class="card-text"><strong>Relai (en m) : </strong> <s:property value="longueur.relai" /></p>
                    <p class="card-text"><strong>Cotation : </strong> <s:property value="longueur.cotation" /></p>
                    <p class="card-text"><strong>Publié : </strong>
                        <s:if test="longueur.ispublication">
                            Oui
                        </s:if>
                        <s:else>
                            Non
                        </s:else>
                    </p>

                </div>
                <div class="card-footer text-muted">
                    Posté le <s:date name="createdDate" format="dd/MM/yyyy" /> par
                        <s:a action="utilisateur_detail">
                            <s:param name="utilisateurId" value="longueur.utilisateur.id" />
                            <s:property value="longueur.utilisateur.prenom"/> <s:property value="longueur.utilisateur.nom"/>
                        </s:a>
                    <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH:mm:ss" />
                </div>
            </div>
            <!-- Comments Form -->
            <s:if test="#session.escalade_user.profil =='admin'">
                <div class="card my-4">
                    <h5 class="card-header">Ajouter un commentaire</h5>
                    <div class="card-body">
                        <form method="POST" action="longueur_comment_new.action">
                            <div class="form-group">
                                <textarea name="commentaire.commentaire" class="form-control" rows="3"></textarea>
                            </div>
                            <div style="display: none;">
                                <s:textfield name="commentaire.target_table" value="LONGUEUR"/>
                                <s:textfield name="commentaire.reference_id" value="%{longueur.id}"/>
                                <s:textfield name="sectionId" value="%{longueur.id}"/>
                            </div>
                            <button type="submit" class="btn btn-primary">Envoyer</button>
                        </form>
                    </div>
                </div>
            </s:if>
            <s:else>
                <div class="card my-4">
                    <h5 class="card-header">Commentaires</h5>
                </div>
            </s:else>


            <!-- Single Comment -->
            <s:iterator value="listCommentaires">
                <div id="commentsList" class="media mb-4">
                    <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
                    <div class="media-body">
                        <h5 class="mt-0"><s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/> <small>le <s:date name="dateCreation" format="dd/MM/yyyy"/> à <s:date name="dateCreation" format="HH:mm" /></small></h5>
                        <s:property value="commentaire"/>
                    </div>
                </div>
            </s:iterator>
        </div>


        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Modification longueur -->
            <s:if test="longueur.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
                <div class="card mb-4">
                    <h5 class="card-header">Modifier la longueur</h5>
                    <div class="card-body text-center">
                        <s:a action="longueur_modifier" class="btn btn-secondary"><s:param name="longueurId" value="longueur.id" />Modifier</s:a>
                    </div>
                </div>
            </s:if>


            <!-- Creation longueur Widget -->
            <s:if test="site.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
            <div class="card mb-4">
                <h5 class="card-header">Créer une nouvelle longueur</h5>
                <div class="card-body text-center">
                    <s:a action="longueur_new" class="btn btn-secondary">Et une de plus !</s:a>
                </div>
            </div>
            </s:if>
        </div>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->


<%@ include file="../../include/footer.jsp" %>

<%@ include file="../../include/script.jsp" %>

</body>

</html>