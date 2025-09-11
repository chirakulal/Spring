
<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Socks Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h3 class="mb-4">Socks Details</h3>
    <div class="card p-3 shadow-sm">
        <p><strong>Size:</strong> ${dto.size}</p>
        <p><strong>Material:</strong> ${dto.material}</p>
        <p><strong>Color:</strong> ${dto.color}</p>
        <p><strong>Length Type:</strong> ${dto.lengthType}</p>
        <p><strong>Brand:</strong> ${dto.brand}</p>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

