<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Site collaboratif sur l'escalade">
    <meta name="author" content="">

    <title>Escalade - Votre site collaboratif</title>

    <!-- Bootstrap core CSS -->
    <link href="../../ressources/template/main/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Langues -->
    <link rel="stylesheet" href="../../ressources/css/languages.min.css">
    <link  href="../../ressources/css/languages.png">

    <!-- Custom styles for this template -->
    <link href="../../ressources/template/main/css/modern-business.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <s:a action="index" class="navbar-brand"><s:text name="home.title"/></s:a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <s:a action="index" class="nav-link"><s:text name="home.home"/></s:a>
                </li>
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
                        <a class="dropdown-item" href="blog-home-1.html">Liste des secteurs</a>
                        <a class="dropdown-item" href="blog-home-2.html">Créer un nouveau secteur</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Recherche</a>
                </li>
                <s:if test="#session.user">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLogin" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <s:property value="#session.user.prenom" />
                            <s:property value="#session.user.nom" />
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                            <s:a action="logout" class="dropdown-item">Déconnexion</s:a>
                        </div>
                    </li>

                </s:if>
                <s:else>
                <li class="nav-item">
                        <s:a action="login" class="nav-link">Connexion</s:a>
                </li>
                    </s:else>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLangue" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Langue
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
                        <s:a action="index" class="dropdown-item">
                            <s:param name="request_locale">fr</s:param>
                            <span class="lang-sm lang-lbl" lang="fr"/>
                        </s:a>
                        <s:a action="index" class="dropdown-item">
                            <s:param name="request_locale">en</s:param>
                            <span class="lang-sm lang-lbl" lang="en"></span>
                        </s:a>
                        <s:a action="index" class="dropdown-item">
                            <s:param name="request_locale">jp</s:param>
                            <span class="lang-sm lang-lbl-full" lang="ja"></span>
                        </s:a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Admin</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

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

    <!-- Marketing Icons Section -->
    <div class="row">
        <div class="col-lg-4 mb-4">
            <div class="card h-100">
                <h4 class="card-header">Mickaël Parlow - 15 mars 2018</h4>
                <div class="card-body">
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">En savoir plus</a>
                </div>
            </div>
        </div>
        <div class="col-lg-4 mb-4">
            <div class="card h-100">
                <h4 class="card-header">Aimée Parlow - 4 mars 2018</h4>
                <div class="card-body">
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus commodi similique totam consectetur praesentium molestiae atque exercitationem ut consequuntur, sed eveniet, magni nostrum sint fuga.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">En savoir plus</a>
                </div>
            </div>
        </div>
        <div class="col-lg-4 mb-4">
            <div class="card h-100">
                <h4 class="card-header">Marc Lefèvre - 2 février 2018</h4>
                <div class="card-body">
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
                </div>
                <div class="card-footer">
                    <a href="#" class="btn btn-primary">En savoir plus</a>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->

    <!-- Portfolio Section -->
    <h2>Sites plébiscités</h2>

    <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="../../ressources/images/etiquette1.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Site 1</a>
                    </h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="../../ressources/images/etiquette2.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Site 2</a>
                    </h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" src="../../ressources/images/etiquette3.jpg" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">Site 3</a>
                    </h4>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->

    <!-- Features Section -->
    <div class="row">
        <div class="col-lg-6">
            <h2>Site à la une</h2>
            <p>Site recommendé pour la saison actuelle:</p>
            <ul>
                <li>
                    <strong>Site 4</strong>
                </li>
                <li>Nb de voies : 4</li>
                <li>Difficulté moyenne : 2c</li>
                <li>Type de roche : volcanique</li>
                <li>Région : Pays de la Loire</li>
            </ul>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
        </div>
        <div class="col-lg-6">
            <img class="img-fluid rounded" src="../../ressources/images/lightUp.jpg" alt="">
        </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Call to Action Section -->
    <div class="row mb-4">
        <div class="col-md-8">
            <p>Toi aussi viens partager ta passion de l'escalade ! Cela te permettra d'échanger, de partager et de découvrir de nombreux sites.</p>
        </div>
        <div class="col-md-4">
            <a class="btn btn-lg btn-secondary btn-block" href="#">S'enregistrer</a>
        </div>
    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Mickaël Parlow 2018</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../../ressources/template/main/vendor/jquery/jquery.min.js"></script>
<script src="../../ressources/template/main/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

