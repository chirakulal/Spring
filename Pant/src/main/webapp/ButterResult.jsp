<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Butter Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
    <h4>Butter Details</h4>
</div>
<div>
    <p><strong>Butter Type:</strong> ${dto.type}</p>
    <p><strong>Fat Content (%):</strong> ${dto.fatContent}</p>
    <p><strong>Salted/Unsalted:</strong> ${dto.saltType}</p>
    <p><strong>Packaging Size:</strong> ${dto.packageSize}</p>
    <p><strong>Brand Name:</strong> ${dto.brand}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
