<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
<div class="container text-center">
    <div style="color:#ff4038;" class="information">${errorMsg}</div>
    <form action="frontController?command=login" method="post">
        <div class="form-group">
            <a href="#" class="navbar-brand">
                <label for="exampleInputEmail1"><fmt:message bundle="${i18n}" key="login.login"/></label><br/>
                <input type="text" name="login" maxlength="30" placeholder=<fmt:message bundle="${i18n}"
                                                                                        key="login.login"/>>
            </a>
        </div>
        <div class="form-group">
            <a href="#" class="navbar-brand">
                <label for="exampleInputPassword1"><fmt:message bundle="${i18n}" key="login.password"/></label><br/>
                <input type="password" name="password" maxlength="20" placeholder=<fmt:message bundle="${i18n}"
                                                                                               key="login.password"/>><br/>
            </a>
        </div>
        <input type="submit" value="<fmt:message bundle="${i18n}" key="login.submit"/>">

    </form>
</div>
