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
        <title>Update Room</title>
    </head>
    <body style="background: url(../images/roomBackground.jpeg); background-size: cover;background-repeat: no-repeat; background-position: center center;">
        <div class="header bg-gradient-primary ">
        </div>

        <%@include file="header.jsp" %>
        <div class="container-fluid mt--6 mr--5">
            <div class="modal-dialog modal- modal-dialog-centered modal-sm" role="document" >
                <div class="modal-content">
                    <div class="modal-body p-0">

                        <div class="card bg-secondary shadow border-0">
                            <div class="card-body px-lg-5 py-lg-5">
                                <div class="text-center text-muted mb-lg-5">
                                    <h2>UPDATE ROOM</h2>
                                </div>
                                <s:form action="UpdateRoomAction" method="POST" role="form" theme="simple">

                                    <div class="form-group mb-3">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-badge"></i></span>
                                            </div>
                                            <s:textfield name="roomNo" cssClass="form-control"  value="%{roomNo}" readonly="true" required=""/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group input-group-alternative">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text"><i class="ni ni-building"></i></span>
                                            </div>
                                            <span class="card-stats">

                                            </span>
                                            <select class="form-control" name="roomType">
                                                <option>Single</option>
                                                <option>Couple</option>
                                                <option>Family</option>
                                            </select>
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
        <%@include file="footer.jsp" %>
    </body>
</html>

