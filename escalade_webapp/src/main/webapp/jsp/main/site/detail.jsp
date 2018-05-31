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
                                <s:if test="publication == true || #session.escalade_user.profil =='admin'">
                                    <li style = "list-style: none;margin:10px">
                                        <s:a action="secteur_detail" class="btn btn-primary">
                                            <s:param name="secteurId" value="id" />
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
                            <s:param name="utilisateurId" value="site.utilisateur.id" />
                            <s:property value="site.utilisateur.prenom"/> <s:property value="site.utilisateur.nom"/>
                        </s:a>
                    <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH" />h<s:date name="lastUpdate" format="mm" />
                </div>
            </div>


            <!-- Comments Form -->
            <s:if test="#session.escalade_user.profil =='admin'">
            <div class="card my-4">
                <h5 class="card-header">Ajouter un commentaire</h5>
                <div class="card-body">
                    <form method="POST" action="site_comment_new.action">
                        <div class="form-group">
                            <textarea name="commentaire.commentaire" class="form-control" rows="3"></textarea>
                        </div>
                        <div style="display: none;">
                            <s:textfield name="commentaire.target_table" value="SITE"/>
                            <s:textfield name="commentaire.reference_id" value="%{site.id}"/>
                            <s:textfield name="sectionId" value="%{site.id}"/>
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
                    <h5 class="mt-0"><s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/><small> le <s:date name="dateCreation" format="dd/MM/yyyy"/> à <s:date name="dateCreation" format="HH:mm" /></small></h5>
                    <s:property value="commentaire"/>
                </div>
            </div>
            </s:iterator>

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

            <!-- Ajouter un secteur -->
            <s:if test="site.utilisateur.id == #session.escalade_user.id || #session.escalade_user.profil =='admin'">
            <div class="card mb-4">
                <h5 class="card-header">Ajouter un secteur à ce site</h5>
                <div class="card-body text-center">
                    <s:a action="secteur_new" class="btn btn-secondary">
                        <s:param name="siteId" value="%{site.id}" />
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

<script>
    function saveAndReloadListCommentaires() {
        // URL de l'action AJAX
        var url = "<s:url action="getListCommentaires"><s:param name="pSection" value="SITE" /><s:param name="pArticle" value="site.id" /></s:url>";

        // Action AJAX en POST
        jQuery.post(
            url,
            function (data) {
                var commentsList = jQuery("#commentsList");
                commentsList.empty();
                jQuery.each(data, function (key, val) {
                    commentsList.append(
                        jQuery('<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">')
                            .append('<div class="media-body">')
                            .append('<h5 class="mt-0">')
                            .append(val.utilisateur.prenom)
                            .append(val.utilisateur.nom)
                            .append(dateCreation)
                            .append('</h5>')
                            .append('</div>')
                    );
                });
            })
            .fail(function () {
                alert("Une erreur s'est produite.");
            });
    }
</script>


</body>

</html>