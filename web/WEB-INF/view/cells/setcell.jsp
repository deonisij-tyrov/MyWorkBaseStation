<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 15.7.18
  Time: 12.56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-group">
    <div style="color:#ff4038;" class="information">${errorMsg}</div>
    <form action="frontController?command=cells&stationid=${stationid}" method="post">
        <td><input type="submit" value="Назад"></td>
    </form>
</div>

