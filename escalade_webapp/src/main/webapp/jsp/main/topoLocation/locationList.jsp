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
<div class="container" style="min-height: 700px">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Location de topos</h1>

    <s:if test="hasActionMessages()">
        <div class="alert alert-success text-center" style="margin-top:20px">
            <s:actionmessage style="list-style:none" />
        </div>
    </s:if>

    <div class="row">
        <div class="col-md-8">
            <ul class="nav nav-tabs nav-justified">
                <li class="nav-item"><a href="#demandes" data-toggle="tab" class="nav-link active show">Demandes</a>
                </li>
                <li class="nav-item"><a href="#encours" data-toggle="tab" class="nav-link">En cours</a>
                </li>
                <li class="nav-item"><a href="#clos" data-toggle="tab" class="nav-link">Cloturés</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="tab-content">

        <!------------------------------------------------------- Demandes ------------------------------------------------------->

        <div class="tab-pane fade in active adminTable active show" id="demandes">
                <div class="table-responsive">
                    <table class="table table-hover table-sm">
                        <thead>
                        <tr>
                            <th class="text-center">Date de la demande</th>
                            <th class="text-center">Demandeur</th>
                            <th class="text-center">Topo</th>
                            <th></th>
                            <!-- Actions column -->
                        </tr>
                        </thead>
                        <s:iterator value="listTopoLocation">
                            <s:if test="topoproprio ==  #session.escalade_user.id && status == 'Demande' || #session.escalade_user.profil =='admin' && status == 'Demande' || topoloueur ==  #session.escalade_user.id && status == 'Demande'">
                                <tr>

                                    <td class="text-center">
                                        <s:date name="dateDebut" format="dd/MM/yyyy"/> à <s:date name="dateDebut" format="HH:mm" />
                                    </td>
                                    <td class="text-center">
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="topoLoueur" />
                                            Demandeur
                                        </s:a>
                                    </td>
                                    <td class="text-center">
                                        <s:a action="topo_detail">
                                            <s:param name="topoId" value="topo.id" />
                                            <s:property value="topo.nom"/>
                                        </s:a>
                                    </td>
                                    <td class="text-center">
                                        <s:if test="topoproprio ==  #session.escalade_user.id || #session.escalade_user.profil =='admin'">
                                            <s:a action="location_accepter" class="btn btn-info btn-xs" title="Accepter">
                                                <s:param name="locationId" value="id" />
                                                <i class="fa fa-check"></i>
                                            </s:a>
                                            <s:a action="location_refuser" class="btn btn-danger btn-xs" title="Refuser">
                                                <s:param name="locationId" value="id" />
                                                <i class="fa fa-close"></i>
                                            </s:a>
                                        </s:if>
                                    </td>
                                </tr>
                            </s:if>
                        </s:iterator>
                    </table>
                </div>
        </div>
        <!------------------------------------------------------- En cours ------------------------------------------------------->

        <div class="tab-pane fade in adminTable" id="encours">
                <div class="table-responsive">
                    <table class="table table-hover table-sm">
                        <thead>
                        <tr>
                            <th class="text-center">Date de la demande</th>
                            <th class="text-center">Demandeur</th>
                            <th class="text-center">Topo</th>
                            <th></th>
                            <!-- Actions column -->
                        </tr>
                        </thead>
                        <s:iterator value="listTopoLocation">
                            <s:if test="topoproprio ==  #session.escalade_user.id && status == 'Acceptation' || #session.escalade_user.profil =='admin' && status == 'Acceptation'">
                                <tr>

                                    <td class="text-center">
                                        <s:date name="dateDebut" format="dd/MM/yyyy"/> à <s:date name="dateDebut" format="HH:mm" />
                                    </td>
                                    <td class="text-center">
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="topoLoueur" />
                                            Demandeur
                                        </s:a>
                                    </td>
                                    <td class="text-center">
                                        <s:a action="topo_detail">
                                            <s:param name="topoId" value="topo.id" />
                                            <s:property value="topo.nom"/>
                                        </s:a>
                                    </td>
                                    <td class="text-center">
                                        <s:if test="topoproprio ==  #session.escalade_user.id || #session.escalade_user.profil =='admin'">
                                            <s:a action="location_terminer" class="btn btn-info btn-xs" title="Clore la location">
                                                <s:param name="locationId" value="id" />
                                                <i class="fa fa-flag-checkered"></i>
                                            </s:a>
                                        </s:if>
                                    </td>
                                </tr>
                            </s:if>
                        </s:iterator>
                    </table>
                </div>
        </div>

        <!------------------------------------------------------- Clos ------------------------------------------------------->



        <div class="tab-pane fade in adminTable" id="clos">
                <div class="table-responsive">
                    <table class="table table-hover table-sm">
                        <thead>
                        <tr>
                            <th class="text-center">Date de la demande</th>
                            <th class="text-center">Date de fin de location</th>
                            <th class="text-center">Demandeur</th>
                            <th class="text-center">Topo</th>
                            <th class="text-center">Status</th>
                            <!-- Actions column -->
                        </tr>
                        </thead>
                        <s:iterator value="listTopoLocation">
                            <s:if test="topoproprio ==  #session.escalade_user.id && status == 'Refus' || #session.escalade_user.profil =='admin' && status == 'Refus' || topoloueur ==  #session.escalade_user.id && status == 'Refus' || topoproprio ==  #session.escalade_user.id && status == 'Clos' || #session.escalade_user.profil =='admin' && status == 'Clos' || topoloueur ==  #session.escalade_user.id && status == 'Clos'">
                                <tr>

                                    <td class="text-center">
                                        <s:date name="dateDebut" format="dd/MM/yyyy"/> à <s:date name="dateDebut" format="HH:mm" />
                                    </td>
                                    <td class="text-center">
                                        <s:date name="dateFin" format="dd/MM/yyyy"/> à <s:date name="dateFin" format="HH:mm" />
                                    </td>
                                    <td class="text-center">
                                        <s:a action="utilisateur_detail">
                                            <s:param name="utilisateurId" value="topoLoueur" />
                                            Demandeur
                                        </s:a>
                                    </td>
                                    <td class="text-center">
                                        <s:a action="topo_detail">
                                            <s:param name="topoId" value="topo.id" />
                                            <s:property value="topo.nom"/>
                                        </s:a>
                                    </td>
                                    <td class="text-center">
                                        <s:property value="status"/>
                                    </td>
                                </tr>
                            </s:if>
                        </s:iterator>
                    </table>
                </div>
        </div>

    </div>



</div>
<!-- /.container -->

<%@ include file="../../include/script.jsp" %>

</body>

</html>