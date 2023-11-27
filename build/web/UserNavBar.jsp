<%-- 
    Document   : UserNavBar
    Created on : 26-Nov-2023, 8:46:50 pm
    Author     : Sohan_Maali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
        
         <!-- --------------------font-awesome---------------------- -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- --------------------font-awesome---------------------- -->

        
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Jost:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
            />

        <!-- Vendor CSS Files -->
        <link
            href="assets/vendor/bootstrap/css/bootstrap.min.css"
            rel="stylesheet"
            />
        <link
            href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
            rel="stylesheet"
            />
        <link rel="stylesheet" href="assets/css/NavBar.css" />
    </head>
    <body>
        <header id="header" class="fixed-top">
            <div class="container d-flex align-items-center">
                <h1 class="logo me-auto"><a href="UserDashBoard.html">SOHAN</a></h1>
                <nav id="navbar" class="navbar">
                    <ul>
                        <li><a class="nav-link scrollto active" href="UserDashBoard.jsp">Home</a></li>
                        <!--<li><a class="nav-link scrollto" href="#about">About</a></li>-->
                        <li><a class="nav-link scrollto" href="#services">Services</a></li>
                        <li>
                            <a class="nav-link scrollto" href="#portfolio">Products</a>
                        </li>
                        <li><a class="nav-link scrollto" href="#team">Watches</a></li>
                        <li><a class="nav-link scrollto" href="#team">Sale</a></li>
                        <li><a class="nav-link scrollto" href="#team">Blog</a></li>
                        <li class="dropdown">
                            <a href="#"
                               > <span>Drop Down</span> <i class="bi bi-chevron-down"> </i
                                > </a>
                            <ul>
                                <li><a href="#">Drop Down 1</a></li>
                                <li class="dropdown">
                                    <a href="#"
                                       ><span>Deep Drop Down</span>
                                        <i class="bi bi-chevron-right"></i
                                        ></a>
                                    <ul>
                                        <li><a href="#">Deep Drop Down 1</a></li>
                                        <li><a href="#">Deep Drop Down 2</a></li>
                                        <li><a href="#">Deep Drop Down 3</a></li>
                                        <li><a href="#">Deep Drop Down 4</a></li>
                                        <li><a href="#">Deep Drop Down 5</a></li>
                                    </ul>
                                </li>
                                <li><a href="#">Drop Down 2</a></li>
                                <li><a href="#">Drop Down 3</a></li>
                                <li><a href="#">Drop Down 4</a></li>
                            </ul>
                        </li>
                        
<!--                        <li class="dropdown">
                            <a href="#"
                               > <span>Login</span> <i class="bi bi-chevron-down"> </i
                                > </a>
                            <ul>
                                <li><a href="EmployeeLogin.jsp">Employee</a></li>
                                <li class="dropdown">
                                    <a href="UserLogin.jsp"
                                       ><span>User</span>
                                    </a>

                                </li>

                            </ul>

                        </li>
                       -->
                       
                        <%--<jsp:forward page="Login.jsp" />--%>
                        <li>
                            <a href="cart.jsp"><i class="fa-solid fa-cart-shopping"></i></a>
                        </li>
                        <li>
                            <a href="profile.jsp"><i class="fa-solid fa-user"></i></a>
                        </li>
                        <li>
                            <a href="Logout"><i class="fa-solid fa-right-from-bracket"></i></a>
                        </li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav>
            </div>
        </header>
        <script src="assets/js/main.js"></script>
    </body>
</html>
