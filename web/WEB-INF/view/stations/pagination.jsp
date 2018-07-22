<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav aria-label="...">
    <ul class="pagination">
        <%--предыдущие страницы--%>
        <c:if test="${currentPage > 1}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage -1}">
                < </a>
            </li>
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage -1}">${currentPage -1}</a>
            </li>
        </c:if>
        <c:if test="${currentPage <= 1}">
            <li class="page-item disabled"
                href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage -1}">
                <span class="page-link"> < </span>
            </li>
        </c:if>
        <%--текущий номер страницы--%>
        <li class="page-item active">
            <a class="page-link"
               href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage}">${currentPage}<span
                    class="sr-only"></span></a>
        </li>
            <%--следующие страницы--%>
        <c:if test="${currentPage < maxPage}">
            <li class="page-item"><a class="page-link"
                                     href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage +1}">${currentPage +1}</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage +1}">
                    > </a>
            </li>
        </c:if>
        <c:if test="${currentPage >= maxPage}">
            <li class="page-item disabled"
                href="${pageContext.request.contextPath}/frontController?command=stations&stationspage=${currentPage +1}">
                <span class="page-link"> > </span>
            </li>
        </c:if>
    </ul>
</nav>





