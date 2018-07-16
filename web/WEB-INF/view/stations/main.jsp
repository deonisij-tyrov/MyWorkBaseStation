<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<TABLE>
    <tr>
        <th>Station Id</th>
        <th>Statiom name</th>
    </tr>

    <c:forEach var="station" items="${stations}" varStatus="status">
        <tr>
            <td>${station.id}</td>
            <td><a href="${pageContext.request.contextPath}/frontController?command=cells&stationid=${station.id}">
                    ${station.name}
            </a></td>
        </tr>
    </c:forEach>
</TABLE>





