<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Curry Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h4>Curry Details</h4>
</div>
<div>
    <p><strong>Curry Name:</strong> ${dto.name}</p>
    <p><strong>Spice Level:</strong> ${dto.spiceLevel}</p>
    <p><strong>Main Ingredient:</strong> ${dto.mainIngredient}</p>
    <p><strong>Curry Type:</strong> ${dto.type}</p>
    <p><strong>Quantity (ml):</strong> ${dto.quantity}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
