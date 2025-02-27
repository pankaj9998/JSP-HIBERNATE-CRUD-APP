<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Management Application</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
        }
        .card {
            padding: 20px;
            border-radius: 10px;
        }
        .btn-custom {
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="text-center text-primary mb-4">User Management</h1>
        <div class="text-center mb-4">
            <a href="new" class="btn btn-success me-3">Add New User</a>
            <a href="list" class="btn btn-primary">List All Users</a>
        </div>

        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm">
                    <h3 class="text-center">
                        <c:if test="${user != null}">Edit User</c:if>
                        <c:if test="${user == null}">Add New User</c:if>
                    </h3>
                    <c:if test="${user != null}">
                        <form action="update" method="post">
                    </c:if>
                    <c:if test="${user == null}">
                        <form action="insert" method="post">
                    </c:if>
                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                        </c:if>
                        <div class="mb-3">
                            <label class="form-label">User Name:</label>
                            <input type="text" name="name" class="form-control"
                                   value="<c:out value='${user.name}' />" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">User Email:</label>
                            <input type="email" name="email" class="form-control"
                                   value="<c:out value='${user.email}' />" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Country:</label>
                            <input type="text" name="country" class="form-control"
                                   value="<c:out value='${user.country}' />" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary btn-custom">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
