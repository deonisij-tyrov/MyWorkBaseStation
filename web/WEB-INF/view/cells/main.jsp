<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div>
    Cells!!!!!
    <TABLE>
        <tr>
            <td width="5%">cellid</td>
            <td width="5%">cell name</td>
            <td width="5%">cell secor</td>
            <td width="5%">cell power</td>
            <td width="5%">cell bsNumber</td>
            <td width="5%">cell band</td>
        </tr>
        <div class="cellTable">
            <c:forEach var="cell" items="${cells}" varStatus="status">
            <form action="frontController?command=setcell" method="post">
                <tr>
                    <td width="5%"><input readonly="readonly" name="cellid" value=${cell.id}></td>
                    <td width="5%"><input name="cellname" value=${cell.name}></td>
                    <td width="5%"><input name="cellsector" value=${cell.sector}></td>
                    <td width="5%"><input name="cellpower" value=${cell.power}></td>
                    <td width="5%"><input readonly="readonly" name="bsid" value=${cell.bsNumber}></td>
                    <td width="5%"><input name="cellband" value=${cell.band}></td>
                    <td width="5%"><input type="submit" value="Изменить"></td>
                </tr>
            </form>
            </c:forEach>
        </div>
    </TABLE>

</div>




