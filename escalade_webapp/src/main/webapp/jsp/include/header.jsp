<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <s:a action="index" class="navbar-brand"><s:text name="home.title"/></s:a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownSite" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Site
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                        <s:a action="site_list" class="dropdown-item"><s:text name="nav.listSite" /></s:a>
                        <s:a action="site_new" class="dropdown-item"><s:text name="site.creation"/></s:a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownSecteur" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Secteur
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <s:a action="secteur_list" class="dropdown-item">Liste des secteurs</s:a>
                        <s:a action="secteur_new" class="dropdown-item">Créer un nouveau secteur</s:a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownVoie" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Voie
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <s:a action="voie_list" class="dropdown-item">Liste des voies</s:a>
                        <s:a action="voie_new" class="dropdown-item">Créer un nouveau voie</s:a>
                    </div>
                </li>
                <s:if test="#session.escalade_user">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLogin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-user"> <s:property value="#session.escalade_user.prenom" /></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                            <s:a action="logout" class="dropdown-item">Déconnexion</s:a>
                            <s:a action="utilisateur_detail" class="dropdown-item">
                                <s:param name="utilisateurId" value="#session.escalade_user.id" />
                                Profil
                            </s:a>
                        </div>
                    </li>
                </s:if>
                <s:else>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownConnexion" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-user"> Non connecté</i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
                            <s:a action="login" class="dropdown-item">Se connecter</s:a>
                            <s:a action="register" class="dropdown-item">S'enregistrer</s:a>
                        </div>
                    </li>
                </s:else>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLangue" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Langue
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <s:a action="request_locale" class="dropdown-item">
                            <s:param name="request_locale">fr</s:param>
                            <span class="lang-sm lang-lbl" lang="fr"/>
                        </s:a>
                        <s:a action="request_locale" class="dropdown-item">
                            <s:param name="request_locale">en</s:param>
                            <span class="lang-sm lang-lbl" lang="en"></span>
                        </s:a>
                        <s:a action="request_locale" class="dropdown-item">
                            <s:param name="request_locale">jp</s:param>
                            <span class="lang-sm lang-lbl-full" lang="ja"></span>
                        </s:a>
                    </div>
                </li>
                <s:if test="#session.escalade_user.profil =='admin'">
                <li class="nav-item">
                    <s:a action="console" class="nav-link">
                        <i class="fa fa-cog"> Admin</i>
                    </s:a>
                </li>
                </s:if>
                <li class="nav-item">

                        <div class="input-group">
                            <form method="POST" action="search.action" class="form-inline">
                                <s:textfield name="keyWord" class="form-control" placeholder="Rechercher..." required="true"></s:textfield>
                                <span class="input-group-btn">
                                    <button type="submit" class="btn btn-secondary">Go!</button>
                                </span>
                            </form>
                        </div>

                </li>
            </ul>
        </div>
    </div>
</nav>