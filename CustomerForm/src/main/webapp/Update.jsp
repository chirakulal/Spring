<!doctype html>
<%@ page isELIgnored = "false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Update Profile</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">MyApp</a>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="SignOut.jsp">Sign Out</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container mt-4">
    <h2 class="mb-3">Update Profile</h2>
    <span style="color:red">${error}</span>
    <form action="updateProfile" method="post">
        <div class="row">

            <!-- Left Column -->
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="name" class="form-label">Full Name</label>
                    <input type="text" class="form-control" id="name" name="name"
                           value="${dto.name}" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email (Read Only)</label>
                    <input type="text" class="form-control" id="email" name="email"
                           value="${dto.email}" readonly>
                </div>
                <div class="mb-3">
                    <label for="phoneNumber" class="form-label">Phone Number</label>
                    <input type="number" class="form-control" id="phoneNumber" name="phoneNumber"
                           value="${dto.phoneNumber}" required>
                </div>

            </div>

            <!-- Right Column -->
            <div class="col-md-6">
                <div class="mb-3">
                    <label for="age" class="form-label">Age</label>
                    <input type="number" class="form-control" id="age" name="age"
                           value="${dto.age}" required>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <textarea class="form-control" id="address" name="address" rows="3" required>${dto.address}</textarea>
                </div>
                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="form-select" id="gender" name="gender" required>
                        <option value="" disabled>-- Select Gender --</option>
                        <option value="Male" ${dto.gender=='Male' ? 'selected' : ''}>Male</option>
                        <option value="Female" ${dto.gender=='Female' ? 'selected' : ''}>Female</option>
                        <option value="Other" ${dto.gender=='Other' ? 'selected' : ''}>Other</option>
                    </select>
                </div>
            </div>
        </div>

        <!-- Submit Button -->
        <div class="text-center">
            <button type="submit" class="btn btn-primary mt-3">Update</button>
        </div>
        <span style="color:green">${success}</span>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
