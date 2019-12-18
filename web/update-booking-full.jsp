<%-- 
    Document   : booking
    Created on : Dec 10, 2019, 2:46:49 PM
    Author     : tuannnh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Booking</title>
    </head>
    <body>

        <%@include file="header.jsp" %>

        <!-- Title Page -->
        <section class="bg-title-page flex-c-m p-t-160 p-b-80 p-l-15 p-r-15"
                 style="background-image: url(<%= request.getContextPath()%>/images/bg-title-page-02.jpg);">
            <h2 class="tit6 t-center">
                Update Booking
            </h2>
        </section>


        <!-- Reservation -->
        <section class="section-reservation bg1-pattern p-t-100 p-b-113">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-b-30">
                        <div class="t-center">
                            <span class="tit2 t-center">
                              Update  Booking
                            </span>

                            <h3 class="tit3 t-center m-b-35 m-t-2">
                              Update  Booking Form
                            </h3>
                        </div>

                        <s:form action="UpdateBookingAction" method="POST" cssClass="wrap-form-reservation size22 m-l-r-auto" theme="simple">

                            <div class="row">
                                <div class="col-md-4">
                                    <!-- Date -->
                                    <span class="txt9">
                                        Check-in Date
                                    </span>

                                    <div class="wrap-inputdate pos-relative txt10 size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield name="checkIn" value="%{checkIn}" cssClass="bo-rad-10 sizefull txt10 p-l-20" readonly="true"/>
                                        <i class="btn-calendar-in fa fa-calendar ab-r-m hov-pointer m-r-18"
                                           aria-hidden="true"></i>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <!-- Time -->
                                    <span class="txt9">
                                        Check-out Date
                                    </span>

                                    <div class="wrap-inputdate pos-relative txt10 size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield name="checkOut" value="%{checkOut}" cssClass="bo-rad-10 sizefull txt10 p-l-20" readonly="true"/>
                                        <i class="btn-calendar-out fa fa-calendar ab-r-m hov-pointer m-r-18"
                                           aria-hidden="true"></i>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <!-- People -->
                                    <span class="txt9">
                                        Peoples
                                    </span>

                                    <div class="wrap-inputpeople size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield type="number" id="people" name="people" value="%{booking.people}" cssClass="bo-rad-10 sizefull txt10 p-l-20" min="1" max="12"/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <!-- Name -->
                                    <span class="txt9">
                                        Full Name
                                    </span>

                                    <div class="wrap-inputname size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield name="fullname" value="%{booking.fullname}" cssClass="bo-rad-10 sizefull txt10 p-l-20" 
                                                     pattern="[a-z A-Z]+"  title="Please input valid name" required=""/>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <!-- Phone -->
                                    <span class="txt9">
                                        Phone Number
                                    </span>

                                    <div class="wrap-inputphone size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield name="phone" value="%{booking.phone}" pattern="^[+]*[(]{0,1}[0-9]{1,3}[)]{0,1}[-\s\./0-9]*$"
                                                     cssClass="bo-rad-10 sizefull txt10 p-l-20" title="Example: 123-456-7890" required=""/>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <!-- Email -->
                                    <span class="txt9">
                                        Coupon
                                    </span>

                                    <div class="wrap-inputemail size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield name="couponId" value="%{booking.couponId}" cssClass="bo-rad-10 sizefull txt10 p-l-20"
                                                     pattern="(%{couponIdAvailable})?" title="Invalid Coupon"/>
                                    </div>
                                </div>

                            </div>

                            <div class="row">

                                <div class="col-md-2">
                                    <span class="txt9">
                                        Available Rooms: 
                                    </span>
                                </div>
                            </div>

                            <div class="row">


                                <div class="col-md-4">
                                    <span class="txt9">
                                        Single: <strong> <s:property value="%{singleRoomRemain}"/> </strong>
                                    </span>
                                </div>

                                <div class="col-md-4">
                                    <span class="txt9">
                                        Couple: <strong> <s:property value="%{coupleRoomRemain}"/> </strong>
                                    </span>
                                </div>
                                <div class="col-md-3">
                                    <span class="txt9">
                                        Family: <strong> <s:property value="%{familyRoomRemain}"/> </strong>
                                    </span>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <span class="txt9">
                                        Single Room
                                    </span>
                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number" disabled="enabled" data-type="minus" data-field="single">
                                                <span class="glyphicon glyphicon-minus"></span>
                                            </button>
                                        </span>
                                        <s:textfield id="single" name="single" cssClass="form-control input-number" min="0"  max="%{singleRoomRemain}" value="%{singleRoomBooked}"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="single">
                                                <span class="glyphicon glyphicon-plus"></span>
                                            </button>
                                        </span>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <span class="txt9">
                                        Couple Room
                                    </span>
                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number" disabled="enabled" data-type="minus" data-field="couple">
                                                <span class="glyphicon glyphicon-minus"></span>
                                            </button>
                                        </span>
                                        <s:textfield id="couple" name="couple" cssClass="form-control input-number" min="0"  max="%{coupleRoomRemain}" value="%{coupleRoomBooked}"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="couple">
                                                <span class="glyphicon glyphicon-plus"></span>
                                            </button>
                                        </span>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <span class="txt9">
                                        Family Room
                                    </span>

                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number" disabled="enabled" data-type="minus" data-field="family">
                                                <span class="glyphicon glyphicon-minus"></span>
                                            </button>
                                        </span>
                                        <s:textfield id="family" name="family" cssClass="form-control input-number" min="0"  max="%{familyRoomRemain}" value="%{familyRoomBooked}"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-default btn-number" data-type="plus" data-field="family">
                                                <span class="glyphicon glyphicon-plus"></span>
                                            </button>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="wrap-btn-booking flex-c-m m-t-6">
                                <s:hidden name="bookingId" value="%{bookingId}"/>
                                <s:hidden name="lastSearchValue" value="%{lastSearchValue}"/>
                                <s:submit value="Update" cssClass="btn3 flex-c-m size13 txt11 trans-0-4" onclick="return roomBookingValidate();"/>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="footer.jsp" %>

    </body>
</html>
