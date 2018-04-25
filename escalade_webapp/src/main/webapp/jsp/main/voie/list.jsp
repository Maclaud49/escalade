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
        <h1 class="mt-4 mb-3">Liste des voies
            <small>Classé par date de modification</small>
        </h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <s:a action="index" ><s:text name="home.home"/></s:a>
            </li>
            <li class="breadcrumb-item active">Liste des voies</li>
        </ol>

        <div class="row">

            <div class="col-md-8">

                <s:iterator value="listVoie">
                    <s:if test="#session.escalade_user.profil =='admin'">
                    <div class="card mb-4">
                        <img class="card-img-top" src="<s:property value="image" />" alt="Card image cap">
                        <div class="card-body">
                            <h2 class="card-title"><s:property value="nom" /></h2>
                            <p class="card-text"><s:property value="description" /></p>
                            <s:a action="voie_detail" class="btn btn-primary">
                                <s:param name="voieId" value="id" />
                                En savoir plus &rarr;
                            </s:a>
                        </div>
                        <div class="card-footer text-muted">
                            Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                            <s:a action="utilisateur_detail">
                                <s:param name="utilisateurId" value="utilisateur.id" />
                                <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                            </s:a>
                            <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH" />h<s:date name="lastUpdate" format="mm" />
                        </div>
                    </div>
                    </s:if>
                    <s:elseif test="publication == false && utilisateur.id == #session.escalade_user.id">
                        <div class="card-footer text-muted">
                            Voie en cours de validation de modification
                        </div>
                        <div class="card mb-4">
                            <h5 class="card-header">Modifier le voie</h5>
                            <div class="card-body text-center">
                                <s:a action="voie_modifier" class="btn btn-secondary"><s:param name="voieId" value="id" />Modifier</s:a>
                            </div>
                        </div>
                    </s:elseif>
                    <s:elseif test="publication == false">

                    </s:elseif>
                    <s:else>
                        <div class="card mb-4">
                            <img class="card-img-top" src="<s:property value="image" />" alt="Card image cap">
                            <div class="card-body">
                                <h2 class="card-title"><s:property value="nom" /></h2>
                                <p class="card-text"><s:property value="description" /></p>
                                <s:a action="voie_detail" class="btn btn-primary">
                                    <s:param name="voieId" value="id" />
                                    En savoir plus &rarr;
                                </s:a>
                            </div>
                            <div class="card-footer text-muted">
                                Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                                <s:a action="utilisateur_detail">
                                    <s:param name="utilisateurId" value="utilisateur.id" />
                                    <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                                </s:a>
                                <br>Dernière modification le <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH" />h<s:date name="lastUpdate" format="mm" />
                            </div>
                        </div>
                    </s:else>

                </s:iterator>

                <!-- Pagination
                <ul class="pagination justify-content-center mb-4">
                    <li class="page-item">
                        <a class="page-link" href="#">&larr; Précédent</a>
                    </li>
                    <li class="page-item disabled">
                        <a class="page-link" href="#">Suivant &rarr;</a>
                    </li>
                </ul> -->

            </div>

            <!-- Sidebar Widgets Column -->
            <div class="col-md-4">


                <!-- Creation site Widget -->
                <div class="card mb-4">
                    <h5 class="card-header">Créer une nouvelle voie</h5>
                    <div class="card-body text-center">
                        <s:if test="#session.escalade_user">
                            <s:a action="voie_new" class="btn btn-secondary">Moi aussi je partage !</s:a>
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