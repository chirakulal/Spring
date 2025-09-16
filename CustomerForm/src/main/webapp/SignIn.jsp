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

    <style>
        body {
            background: linear-gradient(135deg, #1e1e2f, #2c2c54);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        .navbar {
            background-color: #121212 !important;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
        }

        .navbar-brand {
            font-weight: bold;
            font-size: 1.4rem;
            color: #ffffff !important;
            display: flex;
            align-items: center;
        }

        .navbar-brand img {
            margin-right: 8px;
            border-radius: 8px;
        }

        .nav-link {
            color: #ddd !important;
            transition: color 0.3s ease-in-out;
        }

        .nav-link:hover {
            color: #00c6ff !important;
        }

        .card {
            background: rgba(255, 255, 255, 0.05);
            backdrop-filter: blur(10px);
            border: none;
            border-radius: 20px;
            color: #fff;
            padding: 25px;
        }

        .form-control {
            background-color: rgba(255, 255, 255, 0.1);
            color: #fff;
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        .form-control:focus {
            background-color: rgba(255, 255, 255, 0.15);
            border-color: #00c6ff;
            box-shadow: 0 0 5px #00c6ff;
        }

        .btn-primary {
            background: linear-gradient(90deg, #00c6ff, #0072ff);
            border: none;
            font-weight: bold;
            transition: transform 0.2s ease-in-out;
        }

        .btn-primary:hover {
            transform: scale(1.05);
            background: linear-gradient(90deg, #0072ff, #00c6ff);
        }

        a {
            color: #00c6ff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand d-flex align-items-center" href="#">
            <img src="resources/images/Logo%20(1).png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">

        </a>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="SignUp.jsp">Sign Up</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg">
                <div class="card-body">
                    <h3 class="text-center mb-4">Sign In</h3>
                    <span style="color:#ff4d4d">${error}</span>
                    <form action="signin" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="name" name="name"
                                   oninput="validateName()" value="${dto.name}" required>
                            <div id="nameError" class="form-text text-danger"></div>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password"
                                   oninput="validatePassword()" required>
                            <div class="form-check mt-2">
                                <input class="form-check-input" type="checkbox" id="showPassword">
                                <label class="form-check-label" for="showPassword">Show Password</label>
                            </div>
                            <small id="passwordError" class="text-danger"></small>
                            <a href="Forgetpassword.jsp" class="d-block mt-2">Forgot password?</a>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                        <div class="text-center mt-3">
                            <p>Don't have an account? <a href="SignUp.jsp">Sign Up</a></p>
                            <p><a href="login.jsp" class="btn btn-outline-light btn-sm">Login with OTP</a></p>
                        </div>
                    </form>
                    <span style="color:lightgreen">${success}</span>
                </div>
            </div>
        </div>
    </div>
</div>

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
