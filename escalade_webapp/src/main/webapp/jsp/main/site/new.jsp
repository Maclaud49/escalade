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
    <div class="container" style="margin-bottom:50px">

        <!-- Page Heading/Breadcrumbs -->
        <h1 class="mt-4 mb-3"><s:text name="site.create"/></h1>

        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <s:a action="index" ><s:text name="home.home"/></s:a>
            </li>
            <li class="breadcrumb-item active">Création site</li>
        </ol>

        <form class="form-horizontal" method="POST" action="site_new.action" enctype="multipart/form-data">
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-8">
                    <h4>Renseignez les différents champs pour créer un nouveau site</h4>
                    <hr>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label>Nom du site</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <s:textfield name="site.nom" class="form-control" required="true"/>
                        </div>
                        <s:if test="hasFieldErrors()">
                            <small class="text-danger align-middle"><s:fielderror fieldName="siteNom"/></small>
                        </s:if>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label>Decription</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <s:textarea  class="form-control" name="site.description" />
                        </div>
                        <small id="descriptionHelp" class="form-text text-muted">Decription limité à 500 caractères</small>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label >Région</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <s:select  class="form-control" name="site.region"
                                       list="listRegions"  emptyOption="true" required="true"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="form-group">
                        <label >Image</label>
                        <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                            <s:file name="site.images"/>
                        </div>
                        <small id="imageHelp" class="form-text text-muted">Image de dimensions : 750x300 </small>
                    </div>
                </div>
            </div>

            <div class="row" style="padding-top: 1rem">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <button type="submit" class="btn btn-success">Création du site</button>
                </div>
            </div>
        </form>
    </div>



    <%@ include file="../../include/footer.jsp" %>

    <%@ include file="../../include/script.jsp" %>


    </body>

</html>


