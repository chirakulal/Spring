<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Onion Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3 class="mb-4">Onion Details</h3>
    <div class="card p-3 shadow-sm">
        <p><strong>Onion Type:</strong> ${dto.type}</p>
        <p><strong>Color:</strong> ${dto.color}</p>
        <p><strong>Weight:</strong> ${dto.weight}</p>
        <p><strong>Price:</strong> ${dto.price}</p>
        <p><strong>Imported:</strong> ${dto.imported}</p>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
