<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    Cells
    <table class="table table-striped table-hover table-responsive">
        <thead>
        <tr class="active-fluid">
            <td>cellid</td>
            <td>cell name</td>
            <td>cell secor</td>
            <td>cell power</td>
            <td>cell bsNumber</td>
            <td>cell band</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cell" items="${cells}" varStatus="status">
            <form class="table" action="frontController?command=setcell" method="post">
                <tr class="active">
                    <td><input readonly="readonly" name="cellid" value=${cell.id}></td>
                    <td><input name="cellname" value=${cell.name}></td>
                    <td><input name="cellsector" value=${cell.sector}></td>
                    <td><input name="cellpower" value=${cell.power}></td>
                    <td><input readonly="readonly" name="bsid" value=${cell.bsNumber}></td>
                    <td><input name="cellband" value=${cell.band}></td>
                    <td><input type="submit" onclick="alert('cell${cell.name} (локализация!!!)')" value="Изменить" button type="button"></td>
                </tr>
            </form>
        </c:forEach>
        </tbody>
    </table>
</div>