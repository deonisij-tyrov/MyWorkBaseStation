<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  import="entities.Cell"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    Товары
    <div class="productTable">
        <c:forEach var="cell" items="${products}" varStatus="status">
            <div id="${cell.id}">${cell.name} ${cell.model} ${cell.sector}</div>
        </c:forEach>
    </div>
</div>




