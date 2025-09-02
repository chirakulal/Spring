<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Verify OTP</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f8fafc;
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
            color: #2563eb;
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
        .resend-link {
            display: block;
            margin-top: 0.5rem;
            font-size: 0.9rem;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="otp-card">
    <h3 class="text-center mb-4">Verify OTP</h3>

    <!-- OTP Form -->
    <form action="otpVerify" method="post" class="mb-3">
        <input type="hidden" name="email" value="${email}">
        <div class="mb-3">
            <label for="otpId" class="form-label">Enter OTP</label>
            <input type="text" class="form-control" id="otpId" name="otp" maxlength="6" required>
        </div>
        <button type="submit" class="btn btn-custom w-100">Verify OTP</button>
    </form>


    <!-- Show error if present -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center py-2">${error}</div>
        <!-- Resend OTP option -->
        <form action="resendOtp" method="post" class="text-center mt-2">
            <input type="hidden" name="email" value="${email}">
            <button type="submit" class="btn btn-link resend-link">Resend OTP</button>
        </form>
    </c:if>

    <!-- Show success if present -->
    <c:if test="${not empty message}">
        <div class="alert alert-success text-center py-2">${message}</div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
