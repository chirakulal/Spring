<!doctype html>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forgot Password</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="SignIn.jsp">
            <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24"
                 class="d-inline-block align-text-top">
            Bootstrap
        </a>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg rounded-3">
                <div class="card-body">
                    <h3 class="text-center mb-4">Reset Password</h3>
                    <span style="color:red">${error}</span>
                    <form action="resetpassword" method="post">
                        <div class="mb-3">
                            <label for="email" class="form-label">Registered Email</label>
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="example@gmail.com" value="${dto.email}" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">New Password</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   oninput="validatePassword()" value="${dto.password}" required>
                            <small id="passwordError" class="text-danger"></small>

                        </div>
                        <div class="mb-3">
                            <label for="confirmPassword" class="form-label">Confirm Password</label>
                            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                                   oninput="validateConfirmPassword()" value="${dto.confirmPassword}" required>
                            <small id="confirmPasswordError" class="text-danger"></small>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Update Password</button>
                        </div>
                        <div class="text-center mt-3">
                            <p>Remembered your password? <a href="SignIn.jsp">Sign In</a></p>
                        </div>
                    </form>
                    <span style="color:green">${success}</span>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="Validation.js"></script>
</body>
</html>
