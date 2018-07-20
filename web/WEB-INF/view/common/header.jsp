<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
<nav class="navbar navbar-expand-lg navbar-light bg-primary">

    <a class="navbar-brand" href="#" style="color:#0affbd;">
        Denis
    </a>
    <div class="collapse-fluid navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav mr-auto" >
            <li class="nav-item active">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/frontController?command=login" ><b><fmt:message
                        bundle="${i18n}" key="login.title"/></b></a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="${pageContext.request.contextPath}/frontController?command=registration"><b><fmt:message
                        bundle="${i18n}" key="registration.title"/></b></a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <fmt:message bundle="${i18n}" key="station.title"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath}/frontController?command=stations"><b><fmt:message
                            bundle="${i18n}" key="station.title"/></b></a>
                    <div class="dropdown-divider"></div>
                    список всех сот
                </div>
            </li>
        </ul>


        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>

    </div>
</nav>




