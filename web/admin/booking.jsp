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
                        <s:url action="SearchBillAction" id="SearchBillLink">
                        </s:url>
                        <s:a href="%{SearchBillLink}" cssClass="btn btn-primary btn-lg active" role="button" aria-pressed="true">BOOKING HISTORY</s:a>
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

