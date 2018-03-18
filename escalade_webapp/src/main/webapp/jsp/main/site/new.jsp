<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
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

        <div class="row">

            <div class="col-md-8">

                <s:if test="hasActionErrors()">
                    <div class="alert alert-danger actionError">
                        <s:actionerror theme="bootstrap"/>
                    </div>
                </s:if>
                <s:if test="hasActionMessages()">
                    <div class="alert alert-info">
                        <p><span class="ui-icon ui-icon-info" style="float: left; margin-right: 0.3em;"></span>
                            <span><s:actionmessage theme="bootstrap"/></span></p>
                    </div>
                </s:if>


                <s:form action="site_new" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal"
                        label="Renseignez les différents champs pour créer un nouveau site">
                    <s:textfield
                            label="Nom du site"
                            name="site.nom"
                            requiredLabel="true"/>

                    <s:textarea
                            label="Description"
                            name="site.description"
                            cols="20"
                            rows="3"/>

                    <s:select
                            label="Région"
                            list="{'Red', 'Blue', 'Green'}"
                            name="site.region"
                            emptyOption="true"
                            headerKey="--- Région ---"
                            headerValue="Aucune"/>

                    <s:file
                            label="Image"
                            name="site.images"/>

                    <s:submit cssClass="btn btn-primary" value="Créer"/>
                </s:form>
            </div>
        </div>
    </div>

    <%@ include file="../../include/footer.jsp" %>

    <%@ include file="../../include/script.jsp" %>


    </body>

</html>


