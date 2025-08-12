<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h4>User Details</h4>
</div>
<div>
    <p><strong>First Name:</strong> ${dto.fname}</p>
    <p><strong>Last Name:</strong> ${dto.lname}</p>
    <p><strong>Number:</strong> ${dto.number}</p>
    <p><strong>Email:</strong> ${dto.email}</p>
    <p><strong>Address:</strong> ${dto.address}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
