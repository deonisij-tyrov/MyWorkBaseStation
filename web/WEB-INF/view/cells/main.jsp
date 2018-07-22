<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-12 table-responsive">
        <table class="table">
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
                <tr class="active">
                    <form class="table" action="frontController?command=setcell" method="post">
                        <td><input readonly="readonly" name="cellid" value=${cell.id}></td>
                        <td><input name="cellname" value=${cell.name}></td>
                        <td><input name="cellsector" value=${cell.sector}></td>
                        <td><input name="cellpower" value=${cell.power}></td>
                        <td><input readonly="readonly" name="bsid" value=${cell.bsNumber}></td>
                        <td><input name="cellband" value=${cell.band}></td>
                        <td><input name="chenge" type="submit" value="Изменить"
                                   button type="button"></td>

                    </form>
                    <td>
                        <form class="table" action="frontController?command=removecell" method="post">
                            <input type="hidden" readonly="readonly" name="cellid" value=${cell.id}>
                            <input name="delete" type="submit" value="Удалить"
                                   button type="button">
                        </form>
                    </td>
                </tr>
                <c:set var="bsNumber" value="${cell.bsNumber}"/>
            </c:forEach>

            <form class="table" action="frontController?command=addcell" method="post">
                <tr class="active">
                    <td><input readonly="readonly" name="cellid" value=""></td>
                    <td><input name="cellname" value=""></td>
                    <td><input name="cellsector" value=""></td>
                    <td><input name="cellpower" value=""></td>
                    <td><input readonly="readonly" name="bsid" value="${bsNumber}"></td>
                    <td><input name="cellband" value=""></td>
                    <td><input type="submit" value="Добавить"
                               button type="button"></td>
                </tr>
            </form>
            </tbody>
        </table>
    </div>
</div>