<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row">
    <div class="col-md-2 table-responsive">
        <table class="table">
            <thead>
            <tr class="active-fluid">
                <td align="center">Station Id</td>
                <td align="center">Statiom name</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="station" items="${stations}" varStatus="status">
                <tr class="active">
                    <td align="center">${station.id}</td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/frontController?command=cells&stationid=${station.id}">
                                ${station.name}
                        </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <jsp:directive.include file="../stations/pagination.jsp"/>
    </div>
</div>





