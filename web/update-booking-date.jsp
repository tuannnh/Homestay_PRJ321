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
                                Update Booking
                            </span>

                            <h3 class="tit3 t-center m-b-35 m-t-2">
                                Update Booking Form
                            </h3>
                        </div>
                        <div class="t-center">
                            <label style="color: red;font-style: oblique"><s:property value="%{bookingError}"/></label>
                            <s:label id="checkOutError" value="" cssStyle="color: red;font-style: oblique"/>
                        </div>
                        <s:form action="ApplyDateAction" method="POST" cssClass="wrap-form-reservation size22 m-l-r-auto" theme="simple">
                            <div class="row">
                                <div class="col-md-4">
                                    <!-- Date -->
                                    <span class="txt9">
                                        Check-in Date
                                    </span>

                                    <div class="wrap-inputdate pos-relative txt10 size12 bo2 bo-rad-10 m-t-3 m-b-23">
                                        <s:textfield id="input-checkIn" name="checkIn" value="%{checkIn}" cssClass="my-calendar-in bo-rad-10 sizefull txt10 p-l-20" onkeydown="return false"/>
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
                                        <s:textfield id="input-checkOut" name="checkOut" value="%{checkOut}" cssClass="my-calendar-out bo-rad-10 sizefull txt10 p-l-20" onkeydown="return false"/>
                                        <i class="btn-calendar-out fa fa-calendar ab-r-m hov-pointer m-r-18"
                                           aria-hidden="true"></i>

                                    </div>
                                </div>
                                <s:hidden name="bookingId" value="%{bookingId}"/>
                                <div class="wrap-btn-booking flex-c-m m-t-6">
                                    <s:hidden name="lastSearchValue" value="%{lastSearchValue}"/>
                                    <s:submit value="Update" cssClass="btn3 flex-c-m size13 txt11 trans-0-4" onclick="return myDateValidator();"/>
                                </div>
                            </s:form>

                        </div>
                    </div>



                </div>
        </section>

        <%@include file="footer.jsp" %>

    </body>
</html>
