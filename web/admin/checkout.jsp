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
        <title>Checkout</title>
    </head>
    <body>
        <div class="header bg-primary pb-8 pt-5 pt-md-5">
            <div class="container-fluid">
            </div>
        </div>

        <%@include file="header.jsp" %>
        <div class="container-fluid mt--6 mr--5">
            <div class="container card-stats ">
                <div class="card bg-title-page shadow border-0">
                    <div class="card-calendar px-lg-5 py-lg-5">
                        <div class="text-center mb-lg-5">
                            <h1>Checkout Detail</h1>
                        </div>
                        <div class="container-fluid ml-9">
                            <s:form action="CreateBillAction" method="POST" role="form" theme="simple">
                                <div class="row">
                                    <span class="card-stats px-lg-5">
                                        Booking ID:
                                        <s:textfield name="bookingId" value="%{bookingId}" cssStyle="font-weight: 600 ;border: 0;background: transparent" disabled="disable"/>

                                    </span>
                                    <span class="card-stats px-lg-6">
                                        Username:
                                        <s:textfield name="username" value="%{booking.username}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/>
                                    </span>
                                </div>
                                <br/>
                                <div class="row">
                                    <span class="card-stats px-lg-5">
                                        Check-in: 
                                        <s:textfield name="checkIn" value="%{booking.checkIn}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/>
                                    </span>
                                    <span class="card-stats px-lg-6" style="margin-left: 15px">
                                        Check-out: 
                                        <s:textfield name="checkOut" value="%{booking.checkOut}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/>
                                    </span>
                                </div>
                                <br/>
                                <div class="row">
                                    <span class="card-stats px-lg-5">
                                        Fullname:
                                        <s:textfield name="checkIn" value="%{booking.fullname}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/>
                                    </span>
                                    <span class="card-stats px-lg-6" style="margin-left: 10px">
                                        Coupon: 
                                        <s:textfield name="couponId" value="%{booking.couponId}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/>
                                    </span>
                                </div>
                                <br/>
                                <div class="row">
                                    <span class="card-stats px-lg-5">
                                        Single Rooms: <strong> <s:property value="%{singleRoomBooked}"/> </strong>
                                    </span>

                                    <span class="card-stats px-lg-4" style="margin-left: 10px">
                                        Couple Rooms: <strong> <s:property value="%{coupleRoomBooked}"/> </strong>
                                    </span>

                                    <span class="card-stats px-lg-5">
                                        Family Rooms: <strong> <s:property value="%{familyRoomBooked}"/> </strong>
                                    </span>
                                </div>

                                <div class="row">
                                    <span class="card-stats  px-lg-5">
                                        <div class="custom-control custom-checkbox mb-3">
                                            <s:checkbox name="bike" value="bike" cssClass="custom-control-input" id="bike" onclick="bikeClicked()"/><br/>
                                            <label class="custom-control-label" for="bike"><strong>Motorbike Rent</strong></label>
                                        </div>
                                    </span>
                                    <span class="card-stats px-lg-1" style="margin-left: 10px">
                                        <div class="custom-control custom-checkbox mb-3">
                                            <s:checkbox name="bbq" value="bbq" cssClass="custom-control-input" id="bbq" onclick="bbqClicked()"/><br/>
                                            <label class="custom-control-label" for="bbq"><strong>BBQ Night Party</strong></label>
                                        </div>
                                    </span>

                                    <span class="card-stats px-lg-5">
                                        <div class="custom-control custom-checkbox mb-3">
                                            <s:checkbox name="breakfast" value="breakfast" cssClass="custom-control-input" id="breakfast" onclick="breakfastClicked()"/><br/>
                                            <label class="custom-control-label" for="breakfast"><strong>Buffet Breakfast</strong></label>
                                        </div>
                                    </span>
                                </div>
                                <br/>
                                <div class="row">
                                    <span class="card-stats px-lg-5">
                                        Date Complete: 
                                        <s:textfield name="dateComplete" value="%{currentDate}" cssStyle="font-weight: 600;border: 0;background: transparent;"  disabled="disable"/>                                        
                                    </span>
                                    <span class="card-stats px-lg-5" style="margin-left: -10px">
                                        Discount: <strong> <s:property value="%{discount}"/> %</strong>
                                    </span>
                                </div>
                                <br/>
                                <div class="row">
                                    <span class="card-stats px-lg-5" >
                                        Checkout by: 
                                        <s:textfield name="checkOutBy" value="%{#session.USER}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/>                                        
                                    </span>
                                    <span class="card-stats px-lg-5" style="margin-left: 10px">
                                        Total: 
                                        <strong> $ <s:textfield id="total" name="total" value="%{total}" cssStyle="font-weight: 600;border: 0;background: transparent" disabled="disable"/> </strong>
                                    </span>
                                </div>
                                <br/>
                                <div class="card-columns px-lg-9" style="margin-left: 80px">
                                    <s:submit value="Checkout" cssClass="btn btn-primary my-4 btn-lg"/>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>

