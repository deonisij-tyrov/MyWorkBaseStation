<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.7.18
  Time: 15.43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My project!</title>
</head>
<body>
<!-- header -->
<div>
    <h1>Super app!</h1>
</div>

<div>       <!-- content -->
    <div>    <!-- buttons holder -->
        <button onclick="location.href='/main/list'">List users</button>
        <button onclick="location.href='/main/addstation'">Add addstation</button>
    </div>
</div>
</body>
</html>
