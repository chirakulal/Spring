<!doctype html>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home - Xworkz</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" crossorigin="anonymous">

    <style>
        body {
            background: linear-gradient(135deg, #1e1e2f, #2c2c54);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        /* Navbar Styling */
        .navbar {
            background-color: #121212 !important;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.5);
        }

        .navbar-brand {
            font-weight: bold;
            font-size: 1.5rem;
            color: #ffffff !important;
        }

        .nav-link {
            color: #ffffff !important;
            transition: color 0.3s ease;
        }

        .nav-link:hover {
            color: #00c6ff !important;
        }

        /* Welcome Card */
        .welcome-card {
            background: rgba(255, 255, 255, 0.05);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            color: #fff;
            padding: 40px;
            max-width: 500px;
            margin: 60px auto;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.4);
            text-align: center;
            animation: fadeIn 1s ease-in-out;
        }

        h2 span {
            color: #00c6ff;
            font-weight: bold;
        }

        /* Smooth Animation */
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Xworkz</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="userdetails">Update Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger fw-bold" href="SignIn.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Welcome Section -->
<div class="welcome-card">
    <h2>Welcome <span>${username}</span> 🎉</h2>
    <p class="mt-3">You are successfully signed in. Explore and enjoy your dashboard!</p>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

</body>
</html>
