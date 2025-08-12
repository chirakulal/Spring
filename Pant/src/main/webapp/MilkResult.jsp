<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Milk Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3 class="mb-4">Milk Details</h3>
    <div class="card p-3 shadow-sm">
        <p><strong>Milk Type:</strong> ${dto.type}</p>
        <p><strong>Quantity:</strong> ${dto.quantity}</p>
        <p><strong>Fat Percentage:</strong> ${dto.fatPercentage}</p>
        <p><strong>Price:</strong> ${dto.price}</p>
        <p><strong>Brand:</strong> ${dto.brand}</p>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
