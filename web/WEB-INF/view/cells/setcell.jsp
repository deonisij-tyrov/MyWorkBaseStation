<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 15.7.18
  Time: 12.56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="information">${infoMsg}</div>
    <form action="frontController?command=cells&stationid=${stationid}" method="post">
        <td width="5%"><input type="submit" value="Назад"></td>
    </form>
</div>
