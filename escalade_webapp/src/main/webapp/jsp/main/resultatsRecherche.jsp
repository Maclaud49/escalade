<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="../include/head.jsp" %>
</head>

<body>
<%@ include file="../include/header.jsp" %>

<!-- Page Content -->
<div class="container" style="min-height: 700px">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Résultats de la recherche
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Recherche</li>
    </ol>

    <div class="row">

        <div class="col-md-10">

            <ul class="nav nav-tabs" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" href="#site" role="tab" data-toggle="tab">Sites</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#secteur" role="tab" data-toggle="tab">Secteurs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#voie" role="tab" data-toggle="tab">Voies</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#longueur" role="tab" data-toggle="tab">Longueurs</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active show" id="site">

                    <s:if test="!listSite.isEmpty()">
                        <s:iterator value="listSite">
                            <s:if test="publication == true">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <h4>
                                            <s:a action="site_detail" >
                                                <s:param name="siteId" value="id" />
                                                <s:property value="nom" />
                                            </s:a>
                                        </h4>
                                        <p class="card-text"><s:property value="description" /></p>
                                    </div>
                                    <div class="card-footer text-muted">
                                        Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="utilisateur.id" />
                                            <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                                        </s:a>
                                    </div>
                                </div>
                            </s:if>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <div class="card-footer text-muted">
                            Pas de résultats dans la rubrique site
                        </div>
                    </s:else>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="secteur">

                    <s:if test="!listSecteur.isEmpty()">
                        <s:iterator value="listSecteur">
                            <s:if test="publication == true">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <h4>
                                            <s:a action="secteur_detail" >
                                                <s:param name="secteurId" value="id" />
                                                <s:property value="nom" />
                                            </s:a>
                                        </h4>
                                        <p class="card-text"><s:property value="description" /></p>
                                    </div>
                                    <div class="card-footer text-muted">
                                        Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="utilisateur.id" />
                                            <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                                        </s:a>
                                    </div>
                                </div>
                            </s:if>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <div class="card-footer text-muted">
                            Pas de résultats dans la rubrique secteur
                        </div>
                    </s:else>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="voie">

                    <s:if test="!listVoie.isEmpty()">
                        <s:iterator value="listVoie">
                            <s:if test="publication == true">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <h4>
                                            <s:a action="voie_detail" >
                                                <s:param name="voieId" value="id" />
                                                <s:property value="nom" />
                                            </s:a>
                                        </h4>
                                        <p class="card-text"><s:property value="description" /></p>
                                    </div>
                                    <div class="card-footer text-muted">
                                        Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="utilisateur.id" />
                                            <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                                        </s:a>
                                    </div>
                                </div>
                            </s:if>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <div class="card-footer text-muted">
                            Pas de résultats dans la rubrique voie
                        </div>
                    </s:else>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="longueur">

                    <s:if test="!listLongueur.isEmpty()">
                        <s:iterator value="listLongueur">
                            <s:if test="publication == true">
                                <div class="card mb-4">
                                    <div class="card-body">
                                        <h4>
                                            <s:a action="longueur_detail">
                                                <s:param name="longueurId" value="id" />
                                                <s:property value="nom" />
                                            </s:a>
                                        </h4>
                                        <p class="card-text"><s:property value="description" /></p>
                                    </div>
                                    <div class="card-footer text-muted">
                                        Posté le <s:date name="dateCreation" format="dd/MM/yyyy" /> par
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="utilisateur.id" />
                                            <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                                        </s:a>
                                    </div>
                                </div>
                            </s:if>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <div class="card-footer text-muted" style="margin-bottom: 20px;">
                            Pas de résultats dans la rubrique longueur
                        </div>
                    </s:else>
                </div>
            </div>

        </div>


    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@ include file="../include/script.jsp" %>

</body>

</html>