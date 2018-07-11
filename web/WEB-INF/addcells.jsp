<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.7.18
  Time: 16.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add cells station</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
    <%
        if (request.getAttribute("bs_name") != null) {
            out.println("<p>base '" + request.getAttribute("userName") + "' added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add base station</h2>
        </div>

        <form method="post">
            <label>Name:
                <input type="text" name="bs_name"><br />
            </label>
            <label>Base id:
                <input type="text" name="bs_id"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/main'">Back to main</button>
</div>
</body>
</html>