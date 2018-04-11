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
    <h1 class="mt-4 mb-3">Détail de la voie
        <small><s:property value="voie.nom" /></small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Détail de la voie</li>
    </ol>

    <div class="row">

        <div class="col-md-8">
            <!-- Voie detail -->
            <div class="card mb-4">
                <img class="card-img-top" alt="Card image cap" src="<s:property value="voie.image" />" >
                <div class="card-body">
                    <p class="card-text"><strong>Description : </strong> <s:property value="voie.description" /></p>
                    <p class="card-text"><strong>Nombre de longueurs : </strong> <s:property value="voie.nbVoies" /></p>
                    <p class="card-text"><strong>Hauteur de la voie (en m) : </strong> <s:property value="voie.hauteurVoie" /></p>
                    <p class="card-text"><strong>Cotation : </strong> <s:property value="voie.cotation" /></p>
                    <p class="card-text"><strong>Equipée : </strong>
                        <s:if test="voie.equipee">
                            Oui
                        </s:if>
                        <s:else>
                            Non
                        </s:else>
                    </p>
                    <s:if test="voie.equipee">
                    <p class="card-text"><strong>Nombre de points de la voie : </strong> <s:property value="voie.nbPoints" /></p>
                    </s:if>
                    <p class="card-text"><strong>Publié : </strong>
                        <s:if test="voie.publication">
                            Oui
                        </s:if>
                        <s:else>
                            Non
                        </s:else>
                    </p>
                    <div>
                    <div class="card-text"><strong>Liste des longueurs : </strong>
                        <s:if test="voie.longueurs.size() == 0">
                            Pas de longueurs rattachées à cette voie
                        </s:if>
                        <s:else>
                        <ul class="text-center">
                            <s:iterator value="voie.longueurs">
                                <s:if test="publication == true">
                                    <li style = "list-style: none;margin:10px">
                                        <s:a action="longueur_detail" class="btn btn-primary">
                                            <s:param name="longueurId" value="id" />
                                            <s:property value="nom" />
                                        </s:a>

                                    </li>
                                </s:if>
                            </s:iterator>
                         </ul>
                        </s:else>
                    </div>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    Posté le <s:date name="createdDate" format="dd/MM/yyyy" /> par
                        <s:a action="utilisateur_detail">
                            <s:param name="utilisateurId" value="voie.utilisateur.id" />
                            <s:property value="voie.utilisateur.prenom"/> <s:property value="voie.utilisateur.nom"/>
                        </s:a>
                    <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH:mm:ss" />
                </div>
            </div>

            <!-- Comments Form -->
            <s:if test="#session.escalade_user.profil =='admin'">
                <div class="card my-4">
                    <h5 class="card-header">Ajouter un commentaire</h5>
                    <div class="card-body">
                        <form method="POST" action="voie_comment_new.action">
                            <div class="form-group">
                                <textarea name="commentaire.commentaire" class="form-control" rows="3"></textarea>
                            </div>
                            <div style="display: none;">
                                <s:textfield name="commentaire.target_table" value="VOIE"/>
                                <s:textfield name="commentaire.reference_id" value="%{voie.id}"/>
                                <s:textfield name="sectionId" value="%{voie.id}"/>
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

            <!-- Modification voie -->
            <s:if test="voie.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
                <div class="card mb-4">
                    <h5 class="card-header">Modifier la voie</h5>
                    <div class="card-body text-center">
                        <s:a action="voie_modifier" class="btn btn-secondary"><s:param name="voieId" value="voie.id" />Modifier</s:a>
                    </div>
                </div>
            </s:if>


            <!-- Ajouter une longueur -->
            <s:if test="site.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
            <div class="card mb-4">
                <h5 class="card-header">Ajouter une longueur à cette voie</h5>
                <div class="card-body text-center">
                    <s:a action="longueur_new" class="btn btn-secondary">
                        <s:param name="voieId" value="%{voie.id}" />
                        Ajouter</s:a>
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