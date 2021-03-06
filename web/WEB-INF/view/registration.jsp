<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
<div class="container text-center">
    <form action="frontController?command=registration" method="post"><br>
        <div class="input-group md-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b><fmt:message bundle="${i18n}"
                                                                                 key="login.username"/></b></span>
            </div>
            <c:set var="fff" value="${requestScope.command}"/>
            <input class="form-control" type="text" name="username" maxlength="30" value="${username}"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b><fmt:message bundle="${i18n}"
                                                                                 key="login.login"/></b></span>
            </div>
            <input class="form-control" type="text" name="userlogin" maxlength="30" value="${userlogin}"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b><fmt:message bundle="${i18n}"
                                                                                 key="login.password"/></b></span>
            </div>
            <input class="form-control" type="password" name="password1" maxlength="20"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b><fmt:message bundle="${i18n}"
                                                                                 key="login.repeatpassword"/></b></span>
            </div>
            <input class="form-control" type="password" name="password2" maxlength="20"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b><fmt:message bundle="${i18n}"
                                                                                 key="login.birthday"/></b></span>
            </div>
            <input class="form-control" id="dr" type="date" name="userbirthday" maxlength="20" value="${userbirthday}"/><br>
        </div>
        <input type="submit" value=<fmt:message bundle="${i18n}" key="registration.button"/>>
    </form>
</div>