<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-12 table-responsive">
        <table class="table">
            <thead>
            <tr class="active-fluid">
                <td>user id</td>
                <td>user name</td>
                <td>user login</td>
                <td>user status</td>
                <td>user role</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}" varStatus="status">
                <tr class="active">
                    <form class="table" action="frontController?command=users" method="post">
                        <td><input readonly="readonly" name="userid" value=${user.id}></td>
                        <td><input readonly="readonly" name="username" value=${user.name}></td>
                        <td><input readonly="readonly" name="userlogin" value=${user.login}></td>
                        <td><input readonly="readonly" name="userstatus" value=${user.status}></td>
                        <td><input readonly="readonly" name="userrole" value=${user.role}></td>
                        <td><input name="delete" type="submit" value="Изменить статус"
                                   button type="button"></td>
                    </form>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>