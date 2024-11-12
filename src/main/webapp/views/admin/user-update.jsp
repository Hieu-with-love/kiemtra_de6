<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 11/12/2024
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/commons/taglib.jsp"%>
<div class="content-page">
    <div class="container-fluid add-form-list">
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-header d-flex justify-content-between">
                        <div class="header-title">
                            <h4 class="card-title">Update User</h4>
                        </div>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/admin/user/update"
                              method="post" enctype="multipart/form-data">
                            <div class="row">
                                <!-- Username Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="username">Username *</label>
                                        <input id="username" name="username" type="text" class="form-control"
                                               value="${user.username}" placeholder="Enter Username" required>
                                    </div>
                                </div>

                                <!-- Password Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="password">Password *</label>
                                        <input id="password" name="password" type="password" class="form-control"
                                               placeholder="Enter Password" required>
                                    </div>
                                </div>

                                <!-- Full Name Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="fullname">Full Name *</label>
                                        <input id="fullname" name="fullname" type="text" class="form-control"
                                               value="${user.fullname}" placeholder="Enter Full Name" required>
                                    </div>
                                </div>

                                <!-- Email Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="email">Email *</label>
                                        <input id="email" name="email" type="email" class="form-control"
                                               value="${user.email}" placeholder="Enter Email" required>
                                    </div>
                                </div>

                                <!-- Phone Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="phone">Phone *</label>
                                        <input id="phone" name="phone" type="text" class="form-control"
                                               value="${user.phone}" placeholder="Enter Phone Number" required>
                                    </div>
                                </div>

                                <!-- Role Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="admin">Role *</label>
                                        <select id="admin" name="admin" class="form-control" required>
                                            <option value="false" ${user.admin == false ? 'selected' : ''}>User</option>
                                            <option value="true" ${user.admin == true ? 'selected' : ''}>Admin</option>
                                        </select>
                                    </div>
                                </div>

                                <!-- Active Status Field -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="active">Active Status *</label>
                                        <select id="active" name="active" class="form-control" required>
                                            <option value="true" ${user.active == true ? 'selected' : ''}>Active</option>
                                            <option value="false" ${user.active == false ? 'selected' : ''}>Inactive</option>
                                        </select>
                                    </div>
                                </div>

                                <!-- Profile Picture Field -->
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="pic">Profile Picture</label>
                                        <input id="pic" type="file" class="form-control" name="pic" accept="image/*">
                                    </div>
                                </div>

                                <!-- Submit and Reset Buttons -->
                                <div class="col-md-12">
                                    <button type="submit" class="btn btn-primary mr-2">Update User</button>
                                    <button type="reset" class="btn btn-danger">Reset</button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <!-- Page end  -->
    </div>
</div>
