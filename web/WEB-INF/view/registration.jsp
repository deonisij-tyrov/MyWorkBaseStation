<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <div class="information">${infoMsg}</div>
    <form action="frontController?command=registration" method="post">
        <br><fmt:message bundle="${i18n}" key="login.username"/></br><input type="text" name="username" maxlength="30"/>
        <br><fmt:message bundle="${i18n}" key="login.login"/></br><input type="text" name="userlogin" maxlength="30"/>
        <br><fmt:message bundle="${i18n}" key="login.password"/></br><input type="password" name="password1" maxlength="20"/>
        <br><fmt:message bundle="${i18n}" key="login.repeatpassword"/></br><input type="password" name="password2" maxlength="20"/>
        <br><fmt:message bundle="${i18n}" key="login.birthday"/></br><input id="dr" type="date" name="userbirthday" maxlength="20"/>
        <br><input type="submit" value="Войти">
    </form>
</div>