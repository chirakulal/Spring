<!doctype html>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign In</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24"
                 class="d-inline-block align-text-top">
            Bootstrap
        </a>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="SignUp.jsp">Sign Up</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg rounded-3">
                <div class="card-body">
                    <h3 class="text-center mb-4">Sign In</h3>
                    <span style="color:red">${error}</span>
                    <form action="signin" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="name" name="name" oninput="validateName()" value="${dto.name}" required>
                            <div id="nameError" class="form-text text-danger"></div>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" oninput="validatePassword()" required>

                            <div class="form-check mt-2">
                                <input class="form-check-input" type="checkbox" id="showPassword">
                                <label class="form-check-label" for="showPassword">Show Password</label>
                            </div>

                            <small id="passwordError" class="text-danger"></small>
                            <a href="Forgetpassword.jsp">Forgot password?</a>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                        <div class="text-center mt-3">
                            <p>Don't have an account? <a href="SignUp.jsp">Sign Up</a></p>
                            <p><a href="login.jsp" class="btn btn-outline-secondary btn-sm">Login with OTP</a></p>
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

<script>
    document.addEventListener("DOMContentLoaded", function () {
        const showPassword = document.getElementById("showPassword");
        const pwd = document.getElementById("password");

        if (showPassword) {
            showPassword.addEventListener("change", function() {
                pwd.type = this.checked ? "text" : "password";
            });
        }
    });
</script>

<script src="Validation.js"></script>
</body>
</html>

