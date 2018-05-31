<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../../include/head.jsp" %>
</head>

<body>
<%@ include file="../../include/header.jsp" %>


<div class="container" style="margin-top:50px">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Modification des informations de la voie</h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Modification de la voie</li>
    </ol>

    <div class="row">
        <div class="col-md-8">
            <form class="form-horizontal" method="POST" action="voie_modifier.action" enctype="multipart/form-data">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Image actuelle</label>
                                <img class="card-img-top" alt="Card image cap" src="<s:property value="voie.image" />" >
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:file name="imageTemp" class="form-control-file" label="Modifier l'image"/>
                                </div>
                                <small id="imageHelp" class="form-text text-muted">Image de dimensions : 750x300 </small>
                            </div>
                        </div>
                    </div>
                    <div style="display: none;">
                        <s:textfield name="voie.id" value="%{voie.id}"/>
                        <s:textfield name="voie.utilisateur.id" value="%{voie.utilisateur.id}"/>
                        <s:textfield name="voie.dateCreation" value="%{voie.dateCreation}"/>
                        <s:textfield name="voie.image" value="%{voie.image}"/>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Nom de la voie</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textfield name="voie.nom" class="form-control" value="%{voie.nom}" title="Nom de la voie" required="true"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="voieNom" style="list-style:none"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Description</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textarea rows="10" name="voie.description" class="form-control" value="%{voie.description}" title="Description de la voie" required="true"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="descriptionVoie" style="list-style:none"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Hauteur de la voie (en m)</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textfield name="voie.hauteurVoie" class="form-control" value="%{voie.hauteurVoie}" title="Hauteur de la voie"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="hauteurVoie" style="list-style:none"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Cotation</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:select  class="form-control" name="voie.cotation"
                                               list="listCotations"  emptyOption="true" required="true" value="%{voie.cotation}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-check">
                                <s:checkbox class="form-check-input" name="voie.equipee"  value="%{voie.equipee}" label="Equipée"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Nombre de points</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textfield name="voie.nbPoints" class="form-control" value="%{voie.nbPoints}" title="Nombre de points de la voie"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="nbPointsVoie" style="list-style:none"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <s:if test="#session.escalade_user.profil =='admin'">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-check">
                                    <s:checkbox class="form-check-input" name="voie.publication"  value="%{voie.publication}" label="Publication"/>
                                </div>
                            </div>
                        </div>
                    </s:if>
                    <s:else >
                        <div style="display: none;">
                            <s:checkbox class="form-check-input" name="voie.publication"  value="false" label="Publication"/>
                        </div>
                    </s:else>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Rattacher cette voie au secteur</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:select  class="form-control" name="secteurId"
                                               list="secteurList" listKey="id"  listValue="nom" emptyOption="true" />
                                </div>
                            </div>
                        </div>
                    </div>


                <div class="row">
                    <div class="col-md-12" style="padding-top: .35rem">
                                <span class="text-danger align-middle">
                                    <s:actionerror class="text-danger align-middle" style="list-style:none"/>
                                </span>
                    </div>
                </div>

                <div class="row" style="padding-top: 1rem">
                    <div class="col-md-4"></div>
                    <div class="col-md-7">
                        <button type="submit" class="btn btn-success" style="margin-bottom: 20px;"><i class="fa fa-sign-in"></i> Modifier</button>
                    </div>
                </div>

            </form>
        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">




        </div>
    </div>
</div>

<%@ include file="../../include/footer.jsp" %>

<%@ include file="../../include/script.jsp" %>

</body>
</html>

