<%--
  Created by IntelliJ IDEA.
  User: HP-PC
  Date: 3/26/2023
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/b9d30f0e4c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <title>More Products</title>
    <style> body{
        background: #dedede;
    }
    </style>
</head>
<body class="position-relative">
<nav class="navbar navbar-expand-md mb-5" style="background: #FFF0A0;">
    <div class="container-lg">
        <a href="StoreServlet" class="navbar-brand">
                <span class="fw-bold text-black">
                    <i style="margin-right: 5px;" class="fa fa-building" aria-hidden="true"></i>StoreX
                </span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#main-nav" aria-controls="#main-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end align-center" id="main-nav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="StoreServlet"><i style="margin-right: 5px;" class="fa fa-home" aria-hidden="true"></i>Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i style="margin-right: 5px;" class="fa fa-briefcase" aria-hidden="true"></i>Services</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i style="margin-right: 5px;" class="fa fa-sign-in" aria-hidden="true"></i>Staff DashBoard</a>
                        <ul class="dropdown-menu" style="background: #FFF0A0;">
                            <li><a class="dropdown-item" href="ManagerControllerServlet">Manager DashBoard</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="cashierLoginCtrlServlet">Cashier Dashboard</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i style="margin-right: 5px;" class="fa fa-phone" aria-hidden="true"></i>Contact</a>
                </li>
                <li class="nav-item d-md-none">
                    <a class="nav-link" href="#intro">Pricing</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="searchProductCtrl">
                <input class="form-control me-2" type="search" name="name" placeholder="Search" aria-label="Search">
                <input class="btn btn-outline-warning text-black " type="submit" value="Search" >
            </form>
        </div>
    </div>
</nav>
<form action="${pageContext.request.contextPath}/moreChairsServlet" method="post">

</form>
<div class="container-lg">
    <div class="text-center">
        <h2>Pricing</h2>
        <p class="lead text-muted">Choose the product that matches your taste</p>
    </div>

    <div class="row my-5 align-items-center justify-content-center g-0">
        <div class="col-8 col-lg-4 col-xl-3">
            <div class="card border-0">
                <img src="./assets/office4.jpg" class="card-img-top" alt="Chair">
                <div class="card-body text-center py-4">
                    <h4 class="card-title">Platinum Model</h4>
                    <p class="lead card-subtitle">For Office Use</p>
                    <p class="display-5 my-4 text-primary fw-bold">$53.99</p>
                    <p class="card-text mx-5 text-muted d-none d-lg-block">Lorem, ipsum dolor sit amet consectetur adipisicing elit!</p>
                    <a href="#" class="btn btn-outline-primary btn-lg mt-3">Buy Now</a>
                </div>
            </div>
        </div>

        <div class="col-9 mb-3 col-lg-4 col-xl-3">
            <div class="card border-primary border-3">
                <div class="card-header text-center text-primary">Most Popular</div>
                <img src="./assets/office2.jpg" class="card-img-top" alt="Chair">
                <div class="card-body text-center py-4">
                    <h4 class="card-title">Executive Model</h4>
                    <p class="lead card-subtitle">For Office Use</p>
                    <p class="display-3 my-4 text-primary fw-bold">$23.99</p>
                    <p class="card-text mx-5 text-muted d-none d-lg-block">Lorem, ipsum dolor sit amet consectetur adipisicing elit!</p>
                    <a href="#" class="btn btn-outline-primary btn-lg mt-3">Buy Now</a>
                </div>
            </div>
        </div>

        <div class="col-8 col-lg-4 col-xl-3">
            <div class="card border-0">
                <img src="./assets/office3.jpg" class="card-img-top" alt="Chair">
                <div class="card-body text-center py-4">
                    <h4 class="card-title">Presidential Model</h4>
                    <p class="lead card-subtitle">For Office Use</p>
                    <p class="display-3 my-4 text-primary fw-bold">$49.99</p>
                    <p class="card-text mx-5 text-muted d-none d-lg-block">Lorem, ipsum dolor sit amet consectetur adipisicing elit!</p>
                    <a href="#" class="btn btn-outline-primary btn-lg mt-3">Buy Now</a>
                </div>
            </div>
        </div>
    </div>
</div>

<section id="Help" style="background-color: azure;">
    <div class="container-fluid mt-5 position-absolute bottom" style="background-color: azure;">
        <div class="row justify-content-center my-3">
            <div class="col-lg-6 col-xl-3">
              <span class="aa" data-bs-placement="bottom" title="we are happy to serve you">
                <img src="./assets/back3.jpg" width="100" class="my-5 ms-5" alt="Man">
              </span>
            </div>

            <div class="col-lg-6 col-xl-2 my-3">
                <div class="bravo">
                    <a href="#" class="fw-bold text-dark ps-2" style="text-decoration: none;">INFORMATION</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;" id="About Us">About Us</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">Delivery Information</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">Privacy & Policy</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">Terms & Conditions</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">How To Be A Vendor</a>
                </div>
            </div>

            <div class="col-lg-6 col-xl-2 my-3">
                <div class="bravo">
                    <a href="#" class="fw-bold text-dark ps-2" style="text-decoration: none;">User Area</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">My Cart <i style="margin-left: 2px; margin-top: 5px;" class="fa fa-shopping-cart" aria-hidden="true"></i></a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">Wishlist</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">My Account</a>
                </div>
            </div>

            <div class="col-lg-6 col-xl-4 my-3 me-2">
                <div class="bravo">
                    <a href="#" class="fw-bold text-dark ps-2" style="text-decoration: none;">Contact Info</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;"> <i class="fa fa-phone px-2 pt-1"></i>+234 1 234 5678</a>
                    <a href="#" class="fw-light m-2 text-dark  d-flex" style="text-decoration: none;">Plot 29, new Road, Yaba, Lagos, 902355 Nigeria.</a>
                    <a href="#" class="fw-light m-2 d-flex" style="text-decoration: none;">mail@storeX.com</a>
                    <a href="#" class="fw-light m-2 text-muted  d-flex" style="text-decoration: none;">
                        <i class="bi bi-facebook ps-3"></i>
                        <i class="bi bi-twitter ps-3"></i>
                        <i class="bi bi-youtube ps-3"></i>
                        <i class="bi bi-instagram ps-3"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    const tooltips=document.querySelectorAll('.aa')
    tooltips.forEach(t=>{
        new bootstrap.Tooltip(t)
    })
</script>
</body>
</html>
