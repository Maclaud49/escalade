<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="../include/head.jsp" %>
</head>

<body>
    <%@ include file="../include/header.jsp" %>


<header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('../../ressources/images/slide2.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Plus fort ensemble</h3>
                    <p>Votre site collaboratif autour de l'escalade</p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('../../ressources/images/slide1.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Echanges</h3>
                    <p>Nous allons plus loin à plusieurs</p>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('../../ressources/images/slide3.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Une passion</h3>
                    <p>Partageons la et faisons la vivre</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Précédent</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Suivant</span>
        </a>
    </div>
</header>

<!-- Page Content -->
<div class="container">

    <h1 class="my-4">Bienvenue sur le site collaboratif autour de l'escalade</h1>

    <!-- Derniers commentaires -->
    <div class="row">
        <s:subset start="0" count = "3" source = "listCommentaires">
            <s:iterator>
                <s:if test="target_table == 'SITE'">
                    <div class="col-lg-4 mb-4">
                        <div class="card h-100">
                            <h4 class="card-header">
                                <s:a action="utilisateur_detail">
                                    <s:param name="utilisateurId" value="utilisateur.id" />
                                    <s:property value="utilisateur.prenom"/> <s:property value="utilisateur.nom"/>
                                </s:a><br>
                                <small><s:date name="dateCreation" format="dd/MM/yyyy" /> à <s:date name="dateCreation" format="HH" />h<s:date name="dateCreation" format="mm" /></small>
                            </h4>

                            <div class="card-body">
                                <p class="card-text"><s:property value="commentaire" /></p>
                            </div>
                            <div class="card-footer">
                                <s:a action="site_detail" class="btn btn-primary">
                                    <s:param name="siteId" value="reference_id" />
                                    En savoir plus
                                </s:a>
                            </div>
                        </div>
                    </div>

                </s:if>
            </s:iterator>
        </s:subset>
    </div>


    <!-- Dernier sites -->
    <h2>Sites récents</h2>
        <div class="row">
            <s:subset start="0" count = "3" source = "listSites">
                <s:iterator>
                    <div class="col-lg-4 col-sm-6 portfolio-item">
                        <div class="card h-100">
                            <s:a action="site_detail">
                                <s:param name="siteId" value="id" /><img class="card-img-top" src="<s:property value="image" />">
                            </s:a>
                            <div class="card-body">
                                <h4 class="card-title">
                                    <s:a action="site_detail">
                                        <s:param name="siteId" value="id" /><s:property value="nom" />
                                    </s:a>
                                </h4>
                                <p class="card-text"><s:property value="description" /></p>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </s:subset>
        </div>

    <!-- Features Topo -->
    <div class="row">
        <s:subset start="0" count = "1" source = "listTopos">
            <s:iterator>
                <div class="col-lg-6">
                    <h2>Topo à la une</h2>

                    <ul class="fa-ul">
                        <li><i class="fa-li fa fa-spinner fa-spin"></i>
                            <s:a action="topo_detail">
                                <s:param name="topoId" value="id" /><strong><s:property value="nom" /></strong>
                            </s:a>
                        </li>
                        <li><i class="fa-li fa fa-square"></i> Région : <s:property value="region" /></li>
                        <li><i class="fa-li fa fa-square"></i> Nombre de sites : <s:property value="nbSites" /></li>
                        <li><i class="fa-li fa fa-square"></i> Nombre de secteurs : <s:property value="nbSecteurs" /></li>
                        <li><i class="fa-li fa fa-square"></i> Nombre de voies : <s:property value="nbVoies" /></li>
                        <li><i class="fa-li fa fa-square"></i> Date de modification : <s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH" />h<s:date name="lastUpdate" format="mm" /></li>
                        <li><i class="fa-li fa fa-square"></i> Disponible pour location :
                            <s:if test="disponible">
                                Oui
                            </s:if>
                            <s:else>
                                Non
                            </s:else></li>
                    </ul>
                    <p><s:property value="description" /></p>
                </div>
                <div class="col-lg-6">
                    <s:a action="topo_detail">
                        <s:param name="topoId" value="id" /><img class="img-fluid rounded" src="<s:property value="image"/>" >
                    </s:a>
                </div>
            </s:iterator>
        </s:subset>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Call to Action Section -->
    <s:if test="!#session.escalade_user">
        <div class="row mb-4">
            <div class="col-md-8">
                <p>Toi aussi viens partager ta passion de l'escalade ! Cela te permettra d'échanger, de partager et de découvrir de nombreux sites.</p>
            </div>
            <div class="col-md-4">
                <s:a action="register" class="btn btn-lg btn-secondary btn-block">S'enregistrer</s:a>
            </div>
        </div>
    </s:if>

</div>
<!-- /.container -->

    <%@ include file="../include/footer.jsp" %>

    <%@ include file="../include/script.jsp" %>

</body>

</html>

