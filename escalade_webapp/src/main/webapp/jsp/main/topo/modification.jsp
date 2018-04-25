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
    <h1 class="mt-4 mb-3">Modification des informations du topo</h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <s:a action="index" ><s:text name="home.home"/></s:a>
        </li>
        <li class="breadcrumb-item active">Modification du topo</li>
    </ol>

    <div class="row">
        <div class="col-md-8">
            <form class="form-horizontal" method="POST" action="topo_modifier.action" enctype="multipart/form-data">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Image actuelle</label>
                                <img class="card-img-top" alt="Card image cap" src="<s:property value="topo.image" />" >
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:file name="imageTemp" class="form-control-file" label="Modifier l'image"/>
                                </div>
                                <small id="imageHelp" class="form-text text-muted">Image de dimensions : 750x300 </small>
                            </div>
                        </div>
                    </div>
                    <div style="display: none;">
                        <s:textfield name="topo.id" value="%{topo.id}"/>
                        <s:textfield name="topo.utilisateur.id" value="%{topo.utilisateur.id}"/>
                        <s:textfield name="topo.dateCreation" value="%{topo.dateCreation}"/>
                        <s:textfield name="topo.image" value="%{topo.image}"/>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Nom du topo</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textfield name="topo.nom" class="form-control" value="%{topo.nom}" title="Nom du topo" required="true"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="topoNom" style="list-style:none"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Description</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:textarea rows="10" name="topo.description" class="form-control" value="%{topo.description}" title="Description du topo" required="true"/>
                                </div>
                                <s:if test="hasFieldErrors()">
                                    <small class="text-danger align-middle"><s:fielderror fieldName="descriptionTopo" style="list-style:none"/></small>
                                </s:if>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group has-danger">
                                <label>Région</label>
                                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                    <s:select  class="form-control" name="topo.region"
                                               list="listRegions"  emptyOption="true" required="true" value="%{topo.region}"/>
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group has-danger">
                            <label>Nombre de sites</label>
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <s:textfield name="topo.nbSites" class="form-control" value="%{topo.nbSites}" title="Nombre de sites"/>
                            </div>
                            <s:if test="hasFieldErrors()">
                                <small class="text-danger align-middle"><s:fielderror fieldName="nbSitesTopo" style="list-style:none"/></small>
                            </s:if>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group has-danger">
                            <label>Nombre de secteurs</label>
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <s:textfield name="topo.nbSecteurs" class="form-control" value="%{topo.nbSecteurs}" title="Nombre de secteurs"/>
                            </div>
                            <s:if test="hasFieldErrors()">
                                <small class="text-danger align-middle"><s:fielderror fieldName="nbSecteursTopo" style="list-style:none"/></small>
                            </s:if>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group has-danger">
                            <label>Nombre de voies</label>
                            <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                                <s:textfield name="topo.nbVoies" class="form-control" value="%{topo.nbVoies}" title="Nombre de voies"/>
                            </div>
                            <s:if test="hasFieldErrors()">
                                <small class="text-danger align-middle"><s:fielderror fieldName="nbVoiesTopo" style="list-style:none"/></small>
                            </s:if>
                        </div>
                    </div>
                </div>


                    <s:if test="#session.escalade_user.profil =='admin'">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-check">
                                <s:checkbox class="form-check-input" name="topo.publication"  value="%{topo.publication}" label="Publication"/>
                            </div>
                        </div>
                    </div>
                    </s:if>
                    <s:else >
                        <div style="display: none;">
                            <s:checkbox class="form-check-input" name="topo.publication"  value="false" label="Publication"/>
                        </div>
                    </s:else>

                <s:if test="#session.escalade_user.profil =='admin'">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-check">
                                <s:checkbox class="form-check-input" name="topo.disponible"  value="%{topo.disponible}" label="Disponible"/>
                            </div>
                        </div>
                    </div>
                </s:if>
                <s:else >
                    <div style="display: none;">
                        <s:textfield name="topo.disponible" value="%{topo.disponible}"/>
                    </div>
                </s:else>



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

