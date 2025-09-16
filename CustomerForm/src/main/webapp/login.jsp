<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login with OTP</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #1e1e2f, #2c2c54);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .otp-card {
            background: rgba(255, 255, 255, 0.05);
            backdrop-filter: blur(10px);
            color: #fff;
            border-radius: 1rem;
            padding: 2rem;
            width: 100%;
            max-width: 420px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.4);
            animation: fadeIn 0.8s ease-in-out;
        }

        .otp-card h3 {
            font-weight: 700;
            color: #00c6ff;
        }

        .form-label {
            font-weight: 500;
            color: #ddd;
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
            border-color: #00c6ff;
            box-shadow: 0 0 10px rgba(0, 198, 255, 0.5);
        }

        .btn-custom {
            background: #00c6ff;
            border: none;
            border-radius: 0.5rem;
            font-weight: 600;
            color: #fff;
            transition: all 0.3s ease;
        }

        .btn-custom:hover {
            background: #0099cc;
            transform: scale(1.02);
        }

        .alert {
            border-radius: 0.5rem;
            font-weight: 500;
        }

        /* Smooth fade-in animation */
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(15px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<div class="otp-card">
    <h3 class="text-center mb-4"> OTP Login</h3>

    <!-- Email Form -->
    <form action="verifyUserEmail" method="post" class="mb-3">
        <div class="mb-3">
            <label for="emailId" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="emailId" name="email" value="${email}" required>
        </div>
        <button type="submit" class="btn btn-custom w-100">Send OTP</button>
    </form>

    <!-- Conditional messages -->
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
