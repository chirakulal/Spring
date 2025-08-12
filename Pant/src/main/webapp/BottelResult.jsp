<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bottle Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h4>Bottle Details</h4>
</div>
<div>
    <p><strong>Bottle Material:</strong> ${dto.material}</p>
    <p><strong>Bottle Capacity:</strong> ${dto.capacity}</p>
    <p><strong>Bottle Color:</strong> ${dto.color}</p>
    <p><strong>Bottle Shape:</strong> ${dto.shape}</p>
    <p><strong>Bottle Price:</strong> ${dto.price}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
