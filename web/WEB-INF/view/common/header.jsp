<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
    <!-- Классы navbar и navbar-default (базовые классы меню) -->
    <nav class="navbar navbar-default">
        <!-- Контейнер (определяет ширину Navbar) -->
        <div class="container-fluid">
            <!-- Заголовок -->
            <div class="navbar-header">
                <!-- Кнопка «Гамбургер» отображается только в мобильном виде (предназначена для открытия основного содержимого Navbar) -->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-main">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- Бренд или название сайта (отображается в левой части меню) -->
                <a class="navbar-brand" href="#"><fmt:message bundle="${i18n}" key="login.title"/></a>
            </div>
            <!-- Основная часть меню (может содержать ссылки, формы и другие элементы) -->
            <div class="collapse navbar-collapse" id="navbar-main">
                <!-- Содержимое основной части -->
            </div>
        </div>
    </nav>




