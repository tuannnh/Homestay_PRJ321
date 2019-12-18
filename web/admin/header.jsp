<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>
            AdminCP
        </title>
        <!-- Favicon -->
        <link href="<%= request.getContextPath()%>/images/brand/favicon.png" rel="icon" type="image/png">
        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
        <!-- Icons -->
        <link href="<%= request.getContextPath()%>/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
        <link href="<%= request.getContextPath()%>/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
        <!-- CSS Files -->
        <!-- Page plugins -->
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/vendor/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/vendor/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/vendor/datatables.net-select-bs4/css/select.bootstrap4.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/vendor/select2/dist/css/select2.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/vendor/quill/dist/quill.core.css">
        <!-- Argon CSS -->
        <link rel="stylesheet" href="<%= request.getContextPath()%>/assets/css/argon.css?v=1.1.0" type="text/css">

    </head>

    <body class="">
        <nav class="sidenav navbar navbar-vertical fixed-left navbar-expand-xs navbar-light bg-white" id="sidenav-main">
            <div class="scrollbar-inner">
                <!-- Brand -->
                <div class="sidenav-header d-flex align-items-center">
                    <a class="navbar-brand" href="<%= request.getContextPath()%>/index.jsp">
                        <img src="<%= request.getContextPath()%>/images/brand/logo.png" class="navbar-brand-img" alt="...">
                    </a>
                    <div class="ml-auto">
                        <!-- Sidenav toggler -->
                        <div class="sidenav-toggler d-none d-xl-block" data-action="sidenav-unpin" data-target="#sidenav-main">
                            <div class="sidenav-toggler-inner">
                                <i class="sidenav-toggler-line"></i>
                                <i class="sidenav-toggler-line"></i>
                                <i class="sidenav-toggler-line"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="navbar-inner">
                    <!-- Collapse -->
                    <div class="collapse navbar-collapse" id="sidenav-collapse-main">
                        <!-- Navigation -->
                        <ul class="navbar-nav">
                            <li class="nav-item">

                                <a class="nav-link"  href="<%= request.getContextPath()%>/index.jsp">
                                    <i class="ni ni-shop text-primary"></i>
                                    <span class="nav-link-text">Home</span>

                                </a>
                            </li>
                            <li class="nav-item">
                                <s:url action="SearchUserAction" id="UserLink">
                                    <s:param name="lastSearchValue" value="%{searchUserValue}"/>
                                </s:url>

                                <s:a cssClass="nav-link" href="%{UserLink}">
                                    <i class="ni ni-calendar-grid-58 text-red"></i>
                                    <span class="nav-link-text">User Management</span>
                                </s:a>
                            </li>

                            <li class="nav-item">
                                <s:url action="SearchRoomAction" id="RoomLink">
                                    <s:param name="lastSearchValue" value="%{searchRoomValue}"/>
                                </s:url>
                                <s:a cssClass="nav-link" href="%{RoomLink}">
                                    <i class="ni ni-calendar-grid-58 text-red"></i>
                                    <span class="nav-link-text">Room Management</span>
                                </s:a>
                            </li>

                            <li class="nav-item">
                                <s:url action="SearchBookingAction" id="BookingLink">
                                    <s:param name="lastSearchValue" value="%{searchBookingValue}"/>
                                </s:url>
                                <s:a cssClass="nav-link" href="%{BookingLink}">
                                    <i class="ni ni-calendar-grid-58 text-red"></i>
                                    <span class="nav-link-text">Booking Management</span>
                                </s:a>
                            </li>

                            <li class="nav-item">
                                <s:a cssClass="nav-link" href="SearchCouponAction">
                                    <i class="ni ni-calendar-grid-58 text-red"></i>
                                    <span class="nav-link-text">Coupon Management</span>
                                </s:a>
                            </li>
                        </ul>

                    </div>
                </div>
            </div>
        </nav>