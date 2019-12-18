<%@taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.png" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/themify/themify-icons.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/lightbox2/css/lightbox.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">

        <!--===============================================================================================-->
        <script>
            window.history.forward();
        </script>
    </head>

    <body class="animsition">

        <!-- Header -->
        <header>
            <!-- Header desktop -->
            <div class="wrap-menu-header gradient1 trans-0-4">
                <div class="container h-full">
                    <div class="wrap_header trans-0-3">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="index.jsp">
                                <img src="images/icons/logo.png" alt="IMG-LOGO" data-logofixed="images/icons/logo2.png">
                            </a>
                        </div>

                        <!-- Menu -->
                        <div class="wrap_menu p-l-45 p-l-0-xl">
                            <nav class="menu">
                                <ul class="main_menu">
                                    <li>
                                        <a href="index.jsp">Homepage</a>
                                    </li>


                                </ul>
                            </nav>
                        </div>

                        <!-- Social -->
                        <div class="social flex-w flex-l-m p-r-20">

                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="login-form">
            <h2>Register</h2>
            <s:form action="CreateUserAction" method="POST" theme="simple">
                <label style="color: red;font-style: oblique"><s:property value="%{createError}"/></label>
                <div class="inputBox">
                    <s:textfield id="username" name="username" value="%{errorUsername}" required="" onkeyup="validateUsername()"/>
                    <label>Username</label>
                </div>
                <div class="inputBox">
                    <input id="password" type="password" name="password" required="" onkeyup="validatePassword()"/>
                    <label>Password</label>
                </div>
                <div class="inputBox">
                    <input id="confirm" type="password" name="confirm" required=""/>
                    <label>Confirm Password</label>
                </div>
                <div class="inputBox">
                    <input type="text" name="fullname" pattern="[a-z A-Z]+" required=""/>
                    <label>Full Name</label>
                </div>

                <s:submit value="Register" cssClass="btn3 flex-c-m size13 txt11  m-l-r-auto" onclick="return "/>
            </s:form>

        </div>

        <!--===============================================================================================-->
        <script type="text/javascript" src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="vendor/daterangepicker/moment.min.js"></script>
        <script type="text/javascript" src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script type="text/javascript" src="vendor/slick/slick.min.js"></script>
        <script type="text/javascript" src="js/slick-custom.js"></script>

        <script src="js/main.js"></script>
        <script src="<%= request.getContextPath()%>/js/my-input-validator.js"></script>



    </body>

</html>