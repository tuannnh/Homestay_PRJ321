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
        <title>Booking History</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="main-content">
          

                <!-- Navbar -->
                <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom ">
                    <div class="container-fluid ">
                        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                            <!-- Brand -->
                            <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="history.jsp">Booking
                                History</a>
                            <!-- Form -->
                        <s:form action="SearchBillAction" theme="simple" method="POST" cssClass="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
                            <div class="form-group mb-0">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fas fa-search"></i></span>
                                    </div>
                                    <s:textfield name="searchBillValue" cssClass="form-control"/>
                                </div>
                            </div>
                        </s:form>
                        <a class="btn btn-primary btn-lg active" role="button"
                           aria-pressed="true" href="<%= request.getContextPath()%>/index.jsp">
                            BACK TO HOMEPAGE
                        </a>                
                        <s:url action="SearchBookingAction" id="SearchBookingLink">
                        </s:url>
                        <s:a href="%{SearchBookingLink}" cssClass="btn btn-primary btn-lg active" role="button" aria-pressed="true">BOOKING MANAGEMENT</s:a>
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
                                    <h3 class="mb-0">Booking History</h3>
                                </div>
                            <div class="table-responsive py-4">
                                <s:if test="%{historyList != null}">
                                <table class="table align-items-center table-flush" id="datatable-basic">
                                        <thead class="thead-light">
                                            <tr>
                                                <th scope="col">No</th>
                                                <th scope="col">Fullname</th>
                                                <th scope="col">Check-in Date</th>
                                                <th scope="col">Check-out Date</th>
                                                <th scope="col">Rooms</th>
                                                <th scope="col">Services</th>
                                                <th scope="col">Complete Date</th>
                                                <th scope="col">Checkout By</th>
                                                <th scope="col">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="historyList" status="counter">
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

                                                <s:if test="%{singleRoomBooked > 0}">
                                                    <span class="badge badge-dot mr-4">
                                                        <s:property value="%{singleRoomBooked}"/>
                                                        Single Room 
                                                    </span>
                                                    <br/>
                                                </s:if>

                                                <s:if test="%{coupleRoomBooked > 0}">
                                                    <span class="badge badge-dot mr-4">
                                                        <s:property value="%{coupleRoomBooked}"/>
                                                        Couple Room 
                                                    </span>
                                                    <br/>
                                                </s:if>

                                                <s:if test="%{familyRoomBooked > 0}">
                                                    <span class="badge badge-dot mr-4">
                                                        <s:property value="%{familyRoomBooked}"/>
                                                        Family Room 
                                                    </span>

                                                </s:if>
                                            </td>
                                            <td>
                                                <s:if test="%{bike}">
                                                    <span class="badge badge-dot mr-4">
                                                        Motorbike Rent
                                                    </span>
                                                    <br/>
                                                </s:if>


                                                <s:if test="%{bbq}">
                                                    <span class="badge badge-dot mr-4">
                                                        BBQ Party
                                                    </span>
                                                    <br/>
                                                </s:if>


                                                <s:if test="%{breakfast}">
                                                    <span class="badge badge-dot mr-4">
                                                        Buffet Breakfast
                                                    </span>

                                                </s:if>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="%{completeDate}"/>
                                                </span>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="%{checkOutBy}"/>
                                                </span>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    $<s:property value="%{total}"/>
                                                </span>
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

    </body>
</html>

