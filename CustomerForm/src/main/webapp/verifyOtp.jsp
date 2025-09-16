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
            /* Dark gradient background to match previous page */
            background: linear-gradient(135deg, #1b1b2f, #242446);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .otp-card {
            background: rgba(255, 255, 255, 0.06);
            backdrop-filter: blur(12px);
            color: #fff;
            border-radius: 1rem;
            padding: 2rem;
            width: 100%;
            max-width: 420px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.45);
            animation: fadeIn 0.8s ease-in-out;
        }

        .otp-card h3 {
            font-weight: 700;
            color: #7dd3fc; /* Light blue accent */
        }

        .form-label {
            font-weight: 500;
            color: #ccc;
        }

        .form-control {
            background-color: rgba(255, 255, 255, 0.1);
            color: #fff;
            border: 1px solid rgba(255, 255, 255, 0.2);
            border-radius: 0.5rem;
        }

        .form-control:focus {
            background-color: rgba(255, 255, 255, 0.15);
            color: #fff;
            border-color: #7dd3fc;
            box-shadow: 0 0 10px rgba(125, 211, 252, 0.5);
        }

        .btn-custom {
            background: #7dd3fc;
            border: none;
            border-radius: 0.5rem;
            font-weight: 600;
            color: #0f172a;
            transition: all 0.3s ease;
        }

        .btn-custom:hover {
            background: #38bdf8;
            transform: scale(1.02);
        }

        .resend-link {
            display: block;
            margin-top: 0.5rem;
            font-size: 0.9rem;
            text-align: center;
            color: #7dd3fc;
            text-decoration: none;
        }

        .resend-link:hover {
            color: #38bdf8;
            text-decoration: underline;
        }

        .alert {
            border-radius: 0.5rem;
            font-weight: 500;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(15px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<div class="otp-card">
    <h3 class="text-center mb-4">🔑 Verify OTP</h3>

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
