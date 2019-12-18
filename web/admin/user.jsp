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
        <title>User Management</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="main-content">

            <!-- Navbar -->
            <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom ">
                <div class="container-fluid ">
                    <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
                        <a class="h4 mb-0 text-white text-uppercase d-none d-lg-inline-block" href="<%= request.getContextPath()%>">User Management</a>
                        <!-- Form -->
                        <s:form action="SearchUserAction" theme="simple" method="POST" cssClass="navbar-search navbar-search-dark form-inline mr-3 d-none d-md-flex ml-lg-auto">
                            <div class="form-group mb-0">
                                <div class="input-group input-group-alternative">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i class="fas fa-search"></i></span>
                                    </div>
                                    <s:textfield  name="searchUserValue" cssClass="form-control"/>
                                    <s:if test="%{listUsers == null}">
                                        <s:submit id="auto-click" cssStyle="display:none"/>
                                    </s:if>
                                </div>
                            </div>
                        </s:form>

                        <button type="button" class="btn btn-primary btn-lg active" data-toggle="modal" data-target="#modal-form">NEW USER</button>
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



                <!--Create new user form-->
                <div class="container">
                    <div class="modal fade" id="modal-form" tabindex="-11" role="dialog" aria-labelledby="modal-form" aria-hidden="true" >
                        <div class="modal-dialog modal- modal-dialog-centered modal-sm" role="document" >
                            <div class="modal-content">

                                <div class="modal-body p-0">

                                    <div class="card bg-secondary shadow border-0">
                                        <div class="card-body px-lg-5 py-lg-5">
                                            <div class="text-center text-muted mb-lg-5">
                                                <h2>CREATE NEW USER</h2>
                                            </div>
                                            <s:form action="CreateUserAction" method="POST" role="form" theme="simple">

                                                <label style="color: red;font-style: oblique"><s:property value="%{createError}"/></label>
                                                <div class="form-group mb-3">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-badge"></i></span>
                                                        </div>
                                                        <s:textfield id="username" name="username" cssClass="form-control" placeholder="Username" value="%{errorUsername}" required=""/>
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
                                                <div class="form-group">
                                                    <div class="input-group input-group-alternative">
                                                        <div class="input-group-prepend">
                                                            <span class="input-group-text"><i class="ni ni-user-run"></i></span>
                                                        </div>
                                                        <span class="card-stats">

                                                        </span>
                                                        <select class="form-control" name="role">
                                                            <option>user</option>
                                                            <option>staff</option>
                                                            <option>admin</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="text-center">
                                                    <s:hidden name="lastSearchValue" value="%{searchUserValue}"/>
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
                        <div class="card shadow">
                            <div class="card-header border-0">
                                <h3 class="mb-0">Users List</h3>
                            </div>
                            <div class="table-responsive py-4">
                                <s:if test="%{listUsers != null}">
                                    <table class="table align-items-center table-flush" id="datatable-basic">
                                        <thead class="thead-light">
                                            <tr>

                                                <th scope="col">No</th>
                                                <th scope="col">Username</th>
                                                <th scope="col">Full Name</th>
                                                <th scope="col">Role</th>
                                                <th scope="col">Status</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="listUsers" status="counter">

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
                                                    <s:property value="username"/>
                                                </span>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="fullname"/>

                                                </span>
                                            </td>
                                            <td>
                                                <span class="badge badge-dot mr-4">
                                                    <s:property value="role"/>

                                                </span>
                                            </td>

                                            <td>
                                                <div class="media align-items-center">
                                                    <div class="media-body justify-content-between">
                                                        <span class="mb-0 text-sm">
                                                            <s:if test="%{active}">
                                                                Active
                                                            </s:if>
                                                            <s:else>
                                                                Disabled
                                                            </s:else>
                                                        </span>
                                                        <span class="float-right">
                                                            <s:url action="EditUserAction" id="EditLink">
                                                                <s:param name="username" value="%{username}"/>
                                                                <s:param name="lastSearchValue" value="%{searchUserValue}"/>
                                                            </s:url>
                                                            <s:a href="%{EditLink}" cssClass="btn btn-default btn-sm" role="button"  aria-pressed="true">Edit</s:a>

                                                            <s:url action="DeleteUserAction" id="DeleteLink">
                                                                <s:param name="username" value="%{username}"/>
                                                                <s:param name="lastSearchValue" value="%{searchUserValue}"/>
                                                            </s:url>
                                                            <s:if test="%{active}">
                                                                <s:a href="%{DeleteLink}" cssClass="btn btn-warning btn-sm" role="button"  aria-pressed="true">Disable</s:a>
                                                            </s:if>
                                                            <s:else>
                                                                <s:a href="%{DeleteLink}" cssClass="btn btn-warning btn-sm" role="button"  aria-pressed="true">Enable</s:a>
                                                            </s:else>
                                                        </span>
                                                    </div>

                                                </div>

                                            </td>
                                            </tr>
                                        </s:iterator>
                                        </tbody>
                                    </table>
                                </s:if>
                                <s:else>
                                    <h3>Sorry, there are no user found</h3>
                                </s:else>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
            <div class="text-center">     
                <s:if test="%{createError != null}">
                    <label style="color: red;font-style: oblique">Cannot create new user: The username is existed!</label>
                </s:if>
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
