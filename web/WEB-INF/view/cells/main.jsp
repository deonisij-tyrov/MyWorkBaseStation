<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="font-size: large">
    <c:if test="${not empty message}">INFO : ${message}</c:if> <br/>
</div>
<div class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
<div>
    Cells
    <TABLE>
        <thead>
        <tr class="active-fluid">
            <td width="5%">cellid</td>
            <td width="5%">cell name</td>
            <td width="5%">cell secor</td>
            <td width="5%">cell power</td>
            <td width="5%">cell bsNumber</td>
            <td width="5%">cell band</td>
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
    </TABLE>
</div>