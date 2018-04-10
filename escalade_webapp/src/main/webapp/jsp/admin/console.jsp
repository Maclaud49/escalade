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
    <h1 class="mt-4 mb-3">Console d'administration</h1>

    <s:if test="hasActionMessages()">
        <div class="alert alert-success text-center" style="margin-top:20px">
            <s:actionmessage style="list-style:none" />
        </div>
    </s:if>

    <div class="row">
        <div class="col-md-8">
            <ul class="nav nav-tabs nav-justified">
                <li class="nav-item"><a href="#sites" data-toggle="tab" class="nav-link active show">Sites</a>
                </li>
                <li class="nav-item"><a href="#secteurs" data-toggle="tab" class="nav-link">Secteurs</a>
                </li>
                <li class="nav-item"><a href="#voies" data-toggle="tab" class="nav-link">Voies</a>
                </li>
                <li class="nav-item"><a href="#longueurs" data-toggle="tab" class="nav-link">Longueurs</a>
                </li>
                <li class="nav-item"><a href="#commentaires" data-toggle="tab" class="nav-link">Commentaires</a>
                </li>
                <li class="nav-item"><a href="#users" data-toggle="tab" class="nav-link">Utilisateurs</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="tab-content">
        <div class="tab-pane fade in active adminTable active show" id="sites">
            <s:if test="!listSite.isEmpty()">
            <div class="table-responsive">
                <table class="table table-hover table-sm">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th class="text-center">Nb de secteurs</th>
                        <th class="text-center">Nb de voies</th>
                        <th class="text-center">Status</th>
                        <th class="text-center">Nb commentaires</th>
                        <th class="text-center">Dernière modification</th>
                        <th></th>
                        <!-- Actions column -->
                    </tr>
                    </thead>
                    <s:iterator value="listSite">
                    <tr>
                        <td>
                            <s:a action="site_detail">
                                <s:param name="siteId" value="id" />
                                <s:property value="nom" />
                            </s:a>
                        </td>
                        <td class="text-center"><s:property value="site.nbSecteurs" /></td>
                        <td class="text-center"><s:property value="site.nbVoies" /></td>
                        <td class="text-center">
                            <s:if test="site.ispublication">
                                Publié
                            </s:if>
                            <s:else>
                                Non publié
                            </s:else>
                        </td>
                        <td class="text-center"><s:property value="site.nbCommentaires" /></td>
                        <td class="text-center"><s:date name="lastUpdate" format="dd/MM/yyyy" /> à <s:date name="lastUpdate" format="HH:mm:ss" /></td>
                        <td class="text-center">
                            <s:a action="site_modifier" class="btn btn-info btn-xs" title="Editer">
                                <s:param name="siteId" value="id" />
                                <i class="fa fa-edit"></i>
                            </s:a>
                            <button type="button" class="btn btn-danger btn-xs" title="Supprimer" data-toggle="modal" data-target="#siteDialog%{site.id}"><i class="fa fa-close"></i>
                            </button>
                            <div class="modal fade" id="siteDialog%{site.id}" tabindex="-1"
                                 role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        </div>
                                        <div class="modal-body">Supprimer le site <s:property value="nom" /> ?</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                            <s:a action="site_supprimer" class="btn btn-danger">
                                                <s:param name="siteId" value="id" />
                                                Confirmer
                                            </s:a>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                        </td>
                    </tr>
                    </s:iterator>
                </table>
            </div>
            </s:if>
            <s:else>
            <div class="alert alert-warning">Pas de sites.</div>
            </s:else>
            <s:a action="site_new" class="btn btn-primary">
                <span class="glyphicon glyphicon-plus"></span>
                Ajouter un site
            </s:a>
        </div>

            <div class="tab-pane fade adminTable" id="secteurs">
                test
            </div>


    </div>



</div>
<!-- /.container -->

<%@ include file="../include/script.jsp" %>

</body>

</html>