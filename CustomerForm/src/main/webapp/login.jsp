<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login with OTP</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- White background styling -->
    <style>
        body {
            background: #f8fafc; /* white/light background */
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .otp-card {
            background: #ffffff;
            color: #1e293b;
            border-radius: 1rem;
            padding: 2rem;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 420px;
        }
        .otp-card h3 {
            font-weight: 700;
            color: #2563eb; /* blue heading */
        }
        .form-control {
            border-radius: 0.5rem;
        }
        .btn-custom {
            background: #2563eb;
            border: none;
            border-radius: 0.5rem;
            font-weight: 600;
            color: #fff;
        }
        .btn-custom:hover {
            background: #1d4ed8;
        }
    </style>
</head>
<body>

<div class="otp-card">
    <h3 class="text-center mb-4">Secure OTP Login</h3>

    <!-- Email Form -->
    <form action="verifyUserEmail" method="post" class="mb-3">
        <div class="mb-3">
            <label for="emailId" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="emailId" name="email" value="${email}" required>
        </div>
        <button type="submit" class="btn btn-custom w-100">Send OTP</button>
    </form>

    <!-- Show only one message at a time -->
    <c:choose>
        <c:when test="${not empty error}">
            <div class="alert alert-danger text-center py-2">${error}</div>
        </c:when>
        <c:when test="${not empty result and result eq 'verified'}">
            <div class="alert alert-success text-center py-2">OTP sent to your email.</div>
        </c:when>
    </c:choose>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
