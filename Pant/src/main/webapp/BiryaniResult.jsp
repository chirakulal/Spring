
<!doctype html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Biryani Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body >
<div >
            <h4>Biryani Order Details</h4>
        </div>
        <div>
            <p><strong>Biryani Type:</strong> ${dto.type}</p>
            <p><strong>Spice Level:</strong> ${dto.spice}</p>
            <p><strong>Portion Size:</strong> ${dto.size}</p>
            <p><strong>Accompaniments:</strong> ${dto.accompaniments}</p>
            <p><strong>Rice Type:</strong> ${dto.rice}</p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
