<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item" href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage -1}">
            <span class="page-link"> < </span>
            </li>
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage -1}">${stationspage -1}</a>
            </li>
            <li class="page-item active">
                <a class="page-link" href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage}">${stationspage}<span class="sr-only">${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage}</span></a>
            </li>
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage +1}">${stationspage +1}</a>
            </li>
            <li class="page-item">
                <a class="page-link" onclick="return location.href = '${pageContext.request.contextPath}/frontController?command=stations&stationspage=${stationspage +1}'"
                   href="#">
                    > </a>
            </li>
        </ul>
    </nav>





