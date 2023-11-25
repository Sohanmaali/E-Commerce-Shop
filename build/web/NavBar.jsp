<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>JSP Page</title>
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
                <h1 class="logo me-auto"><a href="index.html">SOHAN</a></h1>
                <nav id="navbar" class="navbar">
                    <ul>
                        <li><a class="nav-link scrollto active" href="index.jsp">Home</a></li>
                        <li><a class="nav-link scrollto" href="#about">About</a></li>
                        <li><a class="nav-link scrollto" href="#services">Services</a></li>
                        <li>
                            <!--<a class="nav-link scrollto" href="#portfolio">Portfolio</a>-->
                        </li>
                        <li><a class="nav-link scrollto" href="#team">Team</a></li>
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
                        <!--<li><a class="getstarted scrollto" href="Login.jsp">Login</a></li>-->


                        <!-------------------------------------------------------------------------->
                        <li class="dropdown">
                            <a href="#"
                               > <span>Login</span> <i class="bi bi-chevron-down"> </i
                                > </a>
                            <ul>
                                <li><a href="EmployeeLogin.jsp">Employee</a></li>
                                <li class="dropdown">
                                    <a href="Login.jsp"
                                       ><span>User</span>

                                    </a>

                                </li>

                            </ul>
                        </li>
                        <!-------------------------------------------------------------------------->

                        <%--<jsp:forward page="Login.jsp" />--%>
                        <li>
                            <a class="getstarted scrollto" href="Registration.jsp">Sign Up</a>
                        </li>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav>
            </div>
        </header>
        <script src="assets/js/main.js"></script>
    </body>
</html>
