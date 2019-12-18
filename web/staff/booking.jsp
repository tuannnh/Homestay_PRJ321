<%@taglib prefix="s" uri="/struts-tags" %>
<%-- 
    Document   : admincp
    Created on : Dec 5, 2019, 6:56:56 PM
    Author     : tuannnh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking Management</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="main-content">


            <!-- Navbar -->
            <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom ">
                <div class="container-fluid ">
                    <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                        <!-- Brand -->
                        <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="<%= request.getContextPath()%>">Booking Management</a>

                        <!-- Form -->
                        <s:form action="SearchBookingAction" theme="simple" method="POST" cssClass="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
                            <div class="form-group mb-0">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fas fa-search"></i></span>
                                    </div>
                                    <s:textfield name="searchBookingValue" cssClass="form-control"/>
                                    <s:if test="%{listBookings == null}">
                                        <s:submit id="auto-click" cssStyle="display:none"/>
                                    </s:if>
                                </div>
                            </div>
                        </s:form>

                        <a class="btn btn-primary btn-lg active" role="button"
                           aria-pressed="true" href="<%= request.getContextPath()%>/index.jsp">
                            BACK TO HOMEPAGE
                        </a>   
                        <s:url action="SearchBillAction" id="SearchBillLink">
                        </s:url>
                        <s:a href="%{SearchBillLink}" cssClass="btn btn-primary btn-lg active" role="button" aria-pressed="true">HISTORY</s:a>
                            <a class="btn btn-primary btn-lg active" role="button"
                               aria-pressed="true" href="<%= request.getContextPath()%>/booking-date.jsp">
                            NEW BOOKING
                        </a>                
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->



            <!-- Header -->
            <div class="header bg-primary pb-3 pt-md-8">
                <div class="container-fluid">
                    <div class="header-body">

                    </div>
                </div>
            </div>
            <div class="container-fluid mt--7">

                <!--Edit profile form-->
                <div class="container">
                    <div class="modal fade" id="modal-form" tabindex="-11" role="dialog" aria-labelledby="modal-form" aria-hidden="true" >
                        <div class="modal-dialog modal- modal-dialog-centered modal-sm" role="document" >
                            <div class="modal-content">

                                <div class="modal-body p-0">

                                    <div class="card bg-secondary shadow border-0">
                                        <div class="card-body px-lg-5 py-lg-5">
                                            <div class="text-center text-muted mb-lg-5">
                                                <h2>EDIT PROFILE</h2>
                                            </div>
                                            <s:form action="UpdateUserAction" method="POST" role="form" theme="simple">

                                                <div class="form-group mb-3">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-badge"></i></span>
                                                        </div>
                                                        <s:textfield name="username" cssClass="form-control" placeholder="Username" value="%{#session.USER}" readonly="true"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                                        </div>
                                                        <input id ="password" name="password" class="form-control" placeholder="Password" type="password" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                                                        </div>
                                                        <input id="confirm" name="confirm" class="form-control" placeholder="Confirm" type="password" required="">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-credit-card"></i></span>
                                                        </div>
                                                        <input name="fullname" class="form-control" pattern="[a-z A-Z]+" placeholder="Fullname" type="text" required="">
                                                    </div>
                                                </div>

                                                <div class="text-center">
                                                    <s:submit value="Update" cssClass="btn btn-primary my-4 btn-md"/>
                                                </div>
                                            </s:form>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>



                <!-- Table -->
                <div class="row">
                    <div class="col">
                        <div class="card shadow">
                            <div class="card-header border-0">
                                <h3 class="mb-0">Booking List</h3>
                            </div>
                            <div class="table-responsive py-4">
                                <s:if test="%{listBookings != null}">
                                    <table class="table align-items-center table-flush" id="datatable-basic">
                                        <thead class="thead-light">
                                            <tr>
                                                <th scope="col">No</th>
                                                <th scope="col">Booking ID</th>
                                                <th scope="col">Fullname</th>
                                                <th scope="col">Check-in Date</th>
                                                <th scope="col">Check-out Date</th>
                                                <th scope="col">People</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="listBookings" status="counter">
                                                <tr>
                                                    <th scope="row">
                                            <div class="media align-items-center">

                                                <div class="media-body">
                                                    <span class="mb-0 text-sm"><s:property value="%{#counter.count}"/></span>
                                                </div>
                                            </div>
                                            </th>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="%{bookingId}"/>

                                                </span>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="%{fullname}"/>
                                                </span>
                                            </td>

                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="%{checkIn}"/>
                                                </span>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="%{checkOut}"/>
                                                </span>
                                            </td>

                                            <td>
                                                <div class="media">
                                                    <div class="media-body justify-content-between">
                                                        <span class="mb-0 text-sm"> 
                                                            <s:property value="%{people}"/>
                                                        </span>
                                                        <span class="float-right">
                                                            <s:url action="CheckOutAction" id="CheckOutLink">
                                                                <s:param name="bookingId" value="%{bookingId}"/>
                                                            </s:url>
                                                            <s:a href="%{CheckOutLink}" cssClass="btn btn-primary btn-sm active" role="button"  aria-pressed="true">
                                                                CHECK OUT
                                                            </s:a>

                                                            <s:url action="EditBookingAction" id="EditLink">
                                                                <s:param name="bookingId" value="%{bookingId}"/>
                                                                <s:param name="lastSearchValue" value="%{searchBookingValue}"/>
                                                            </s:url>
                                                            <s:a href="%{EditLink}" cssClass="btn btn-default btn-sm" role="button"  aria-pressed="true">Edit</s:a>


                                                            <s:url action="DeleteBookingAction" id="DeleteLink">
                                                                <s:param name="bookingId" value="%{bookingId}"/>
                                                                <s:param name="lastSearchValue" value="%{searchBookingValue}"/>
                                                            </s:url>
                                                            <s:a href="%{DeleteLink}" cssClass="btn btn-warning btn-sm" role="button"  aria-pressed="true">Delete</s:a>
                                                            </span>
                                                        </div>
                                                    </div>
                                                </td>
                                                </tr>
                                        </s:iterator>
                                        </tbody>
                                    </table>
                                </s:if>

                            </div>

                        </div>
                        <label style="color: red;font-style: oblique"><s:property value="%{updateConfirm}"/></label>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>
        <script>
            window.onload = function () {
                document.getElementById("auto-click").click();
            };
        </script>
    </body>
</html>

