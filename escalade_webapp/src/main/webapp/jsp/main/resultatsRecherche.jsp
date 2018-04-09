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
            <div class="row">
                <div class="col-md-8">
                    <h2>Recherche dans les sites</h2>
                    <hr>
                </div>
            </div>
            <s:if test="!listSite.isEmpty()">
            <s:iterator value="listSite">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2>
                            <s:a action="site_detail" class="btn btn-primary">
                            <s:param name="siteId" value="id" />
                            <s:property value="nom" />
                            </s:a>
                        </h2>
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
            </s:iterator>
            </s:if>
            <s:else>
                <div class="card-footer text-muted">
                    Pas de résultats dans la rubrique site
                </div>
            </s:else>
            <div class="row">
                <div class="col-md-8">
                    <h2>Recherche dans les secteurs</h2>
                    <hr>
                </div>
            </div>
            <s:if test="!listSecteur.isEmpty()">
            <s:iterator value="listSecteur">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2>
                            <s:a action="secteur_detail" class="btn btn-primary">
                                <s:param name="secteurId" value="id" />
                                <s:property value="nom" />
                            </s:a>
                        </h2>
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
            </s:iterator>
            </s:if>
            <s:else>
                <div class="card-footer text-muted">
                    Pas de résultats dans la rubrique secteur
                </div>
            </s:else>
            <div class="row">
                <div class="col-md-8">
                    <h2>Recherche dans les voies</h2>
                    <hr>
                </div>
            </div>
            <s:if test="!listVoie.isEmpty()">
            <s:iterator value="listVoie">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2>
                            <s:a action="voie_detail" class="btn btn-primary">
                                <s:param name="voieId" value="id" />
                                <s:property value="nom" />
                            </s:a>
                        </h2>
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
            </s:iterator>
            </s:if>
            <s:else>
                <div class="card-footer text-muted">
                    Pas de résultats dans la rubrique voie
                </div>
            </s:else>
            <div class="row">
                <div class="col-md-8">
                    <h2>Recherche dans les longueurs</h2>
                    <hr>
                </div>
            </div>
            <s:if test="!listLongueur.isEmpty()">
            <s:iterator value="listLongueur">
                <div class="card mb-4">
                    <div class="card-body">
                        <h2>
                            <s:a action="longueur_detail" class="btn btn-primary">
                                <s:param name="longueurId" value="id" />
                                <s:property value="nom" />
                            </s:a>
                        </h2>
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
            </s:iterator>
            </s:if>
            <s:else>
                <div class="card-footer text-muted" style="margin-bottom: 20px;">
                    Pas de résultats dans la rubrique longueur
                </div>
            </s:else>

        </div>


    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<%@ include file="../include/footer.jsp" %>

<%@ include file="../include/script.jsp" %>

</body>

</html>