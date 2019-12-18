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
        <title>Room Management</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="main-content">
            <!-- Navbar -->

            <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom ">
                <div class="container-fluid ">
                    <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                        <!-- Brand -->
                        <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="<%= request.getContextPath()%>">Room Management</a>
                        <!-- Form -->
                        <button type="button" class="btn btn-primary btn-lg active float-right" data-toggle="modal" data-target="#modal-form">NEW ROOM</button>
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



                <!--Create new COUPON form-->
                <div class="container">
                    <div class="modal fade" id="modal-form" tabindex="-11" role="dialog" aria-labelledby="modal-form" aria-hidden="true" >
                        <div class="modal-dialog modal- modal-dialog-centered modal-sm" role="document" >
                            <div class="modal-content">

                                <div class="modal-body p-0">

                                    <div class="card bg-secondary shadow border-0">
                                        <div class="card-body px-lg-5 py-lg-5">
                                            <div class="text-center text-muted mb-lg-5">
                                                <h2>CREATE NEW ROOM</h2>
                                            </div>
                                            <s:form action="CreateRoomAction" method="POST" role="form" theme="simple">

                                                <label style="color: red;font-style: oblique"><s:property value="%{createError}"/></label>
                                                <div class="form-group mb-3">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-collection"></i></span>
                                                        </div>
                                                        <s:textfield name="roomNo" pattern="\d{3}" title="Example: 001" cssClass="form-control" placeholder="Room No" value="%{roomNoError}" required=""/>
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
                                                    <s:submit value="Create" cssClass="btn btn-primary my-4 btn-md"/>
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
                        <div class="card">
                            <div class="card-header border-0">
                                <h3 class="mb-0">Rooms List</h3>
                            </div>
                            <div class="table-responsive py-4" >
                                <s:if test="%{listRooms != null}">
                                    <table class="table align-items-center table-flush" id="datatable-basic">
                                        <thead class="thead-light">
                                            <tr>

                                                <th scope="col">No</th>
                                                <th scope="col">Room No</th>
                                                <th scope="col">Room Type</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="listRooms" status="counter">

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
                                                    <s:property value="roomNo"/>
                                                </span>
                                            </td>

                                            <td>
                                                <div class="media align-items-center">
                                                    <div class="media-body justify-content-between">
                                                        <span class="mb-0 text-sm">
                                                            <s:property value="roomType"/>
                                                        </span>
                                                        <span class="float-right">
                                                            <s:url action="EditRoomAction" id="EditLink">
                                                                <s:param name="roomNo" value="%{roomNo}"/>
                                                            </s:url>
                                                            <s:a href="%{EditLink}" cssClass="btn btn-default btn-sm" role="button"  aria-pressed="true">Edit</s:a>

                                                            <s:url action="DeleteRoomAction" id="DeleteLink">
                                                                <s:param name="roomNo" value="%{roomNo}"/>
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
            <div class="text-center">     
                <s:if test="%{createError != null}">
                    <label style="color: red;font-style: oblique"><s:property value="%{createError}"/></label>
                </s:if>
            </div>
        </div>
        <%@include file="footer.jsp" %>

    </body>
</html>
