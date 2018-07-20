<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <style>
        .center {
            text-align: center;
        }

        .pagination {
            display: inline-block;
        }

        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
            margin: 0 4px;
        }

        .pagination a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }

        .pagination a:hover:not(.active) {background-color: #ddd;}
    </style>
</head>
<body>

<h2>Centered Pagination</h2>

<div class="center">
    <div class="pagination">
        <a href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage - 1}">&laquo;</a>
        <a href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage - 1}">1</a>
        <a href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage}" class="active">${stationspage}</a>
        <a href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage + 1}">3</a>
        <a onclick="return location.href = '${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage +1}'" href="#">&raquo;</a>
    </div>
</div>



