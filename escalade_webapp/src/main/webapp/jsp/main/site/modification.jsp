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
    <h1 class="mt-4 mb-3">Modification des informations du site</h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Modification du site</li>
    </ol>

    <div class="row">
        <div class="col-md-8">
            <form class="form-horizontal" method="POST" action="site_modifier.action" enctype="multipart/form-data">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Image actuelle</label>
                                <img class="card-img-top" alt="Card image cap" src="<s:property value="site.image" />" >
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:file name="imageTemp" class="form-control-file" label="Modifier l'image"/>
                                </div>
                                <small id="imageHelp" class="form-text text-muted">Image de dimensions : 750x300 </small>
                            </div>
                        </div>
                    </div>
                    <div style="display: none;">
                        <s:textfield name="site.id" value="%{site.id}"/>
                        <s:textfield name="site.utilisateur.id" value="%{site.utilisateur.id}"/>
                        <s:textfield name="site.dateCreation" value="%{site.dateCreation}"/>
                        <s:textfield name="site.image" value="%{site.image}"/>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Nom du site</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textfield name="site.nom" class="form-control" value="%{site.nom}" title="Nom du site" required="true"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="nomSite"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Description</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textarea rows="10" name="site.description" class="form-control" value="%{site.description}" title="Description du site" required="true"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="descriptionSite"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Région</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:select  class="form-control" name="site.region"
                                               list="listRegions"  emptyOption="true" required="true" value="%{site.region}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-check">
                                <s:checkbox class="form-check-input" name="site.publication"  value="%{site.publication}" label="Publication"/>
                            </div>
                        </div>
                    </div>



                <div class="row">
                    <div class="col-md-12" style="padding-top: .35rem">
                                <span class="text-danger align-middle">
                                    <s:actionerror class="text-danger align-middle"/>
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

