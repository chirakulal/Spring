<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chappal Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h4>Chappal Details</h4>
</div>
<div>
    <p><strong>Chappal Size:</strong> ${dto.size}</p>
    <p><strong>Material:</strong> ${dto.material}</p>
    <p><strong>Color:</strong> ${dto.color}</p>
    <p><strong>Type:</strong> ${dto.type}</p>
    <p><strong>Brand:</strong> ${dto.brand}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
