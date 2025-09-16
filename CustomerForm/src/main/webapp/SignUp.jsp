<!doctype html>
<%@ page isELIgnored = "false" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">

    <title>Customer Registration</title>
    <style>
        body {
            background-color: #000; /* Full black background */
            color: #fff; /* White default text */
        }
        .navbar {
            background: linear-gradient(90deg, #0d0d1a, #1a1a33); /* Deep dark gradient */
            border-bottom: 2px solid #3b82f6; /* Blue accent */
        }
        .navbar-brand span {
            font-family: 'Courier New', monospace;
            font-size: 1.5rem;
            font-weight: bold;
            color: #3b82f6; /* Blue brand text */
        }
        .nav-link {
            color: #f8f9fa !important;
            font-weight: 500;
            transition: color 0.3s ease;
        }
        .nav-link:hover {
            color: #3b82f6 !important; /* Hover Blue */
        }
        .container {
            background-color: #111;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 0 15px rgba(59, 130, 246, 0.2);
        }
        .form-label {
            font-weight: bold;
            color: #3b82f6; /* Blue form labels */
        }
        input, textarea, select {
            background-color: #222 !important;
            color: white !important;
            border: 1px solid #444;
        }
        input:focus, textarea:focus, select:focus {
            border-color: #3b82f6;
            box-shadow: 0 0 5px #3b82f6;
        }
        .btn-primary {
            background-color: #3b82f6;
            border: none;
            font-weight: bold;
            transition: transform 0.2s ease-in-out;
        }
        .btn-primary:hover {
            transform: scale(1.05);
            background-color: #2563eb;
        }
        h2 {
            color: #3b82f6;
            text-align: center;
            margin-bottom: 20px;
            text-transform: uppercase;
            letter-spacing: 1px;
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
                <a class="nav-link" href="SignIn.jsp">Sign In</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <h2>Customer Registration Form</h2>
    <span style="color:red">${error}</span>
    <form action="signup" method="post" enctype="multipart/form-data">
        <div class="row">
            <!-- Left Column -->
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name"
                           oninput="validateName()" onchange="checkName()" value="${dto.name}" required>
                    <div id="nameError" class="form-text text-danger"></div>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" class="form-control" id="email" name="email"
                           oninput="validateEmail()" onchange="checkEmail()" value="${dto.email}" required>
                    <div id="emailError" class="form-text text-danger"></div>
                </div>
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="number" class="form-control" id="phoneNumber" name="phoneNumber"
                           oninput="validatePhoneNumber()" onchange="checkPhoneNumber()" value="${dto.phoneNumber}" required>
                    <small id="phoneNumberError" class="text-danger"></small>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password"
                           oninput="validatePassword()" value="${dto.password}" required>
                    <small id="passwordError" class="text-danger"></small>
                </div>
                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                           oninput="validateConfirmPassword()" value="${dto.confirmPassword}" required>
                    <div id="confirmPasswordError" class="form-text text-danger"></div>
                </div>
            </div>

            <!-- Right Column -->
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="age" class="form-label">Age</label>
                    <input type="number" class="form-control" id="age" name="age"
                           oninput="validateAge()" value="${dto.age}" required>
                    <div id="ageError" class="form-text text-danger"></div>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <textarea class="form-control" id="address" name="address" rows="3"
                              oninput="validateAddress()" required>${dto.address}</textarea>
                    <div id="AddressError" class="form-text text-danger"></div>
                </div>
                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="form-select" id="gender" name="gender" value="${dto.gender}" required>
                        <option value="" disabled>-- Select Gender --</option>
                        <option value="Male" ${dto.gender=='Male' ? 'selected' : ''}>Male</option>
                        <option value="Female" ${dto.gender=='Female' ? 'selected' : ''}>Female</option>
                        <option value="Other" ${dto.gender=='Other' ? 'selected' : ''}>Other</option>
                    </select>
                    <small class="text-danger" id="genderError"></small>
                </div>
                <div class="mb-3">
                    <label for="image" class="form-label">Upload Profile Picture</label>
                    <input type="file" class="form-control" id="image" name="image" accept="image/*" required>
                    <small id="profilePictureError" class="text-danger"></small>
                </div>
            </div>
        </div>

        <!-- Submit Button -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary mt-3">Submit</button>
        </div>
        <span style="color:green">${success}</span>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="Validation.js"></script>
</body>
</html>
