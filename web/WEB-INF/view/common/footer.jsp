<%@ page  pageEncoding="utf-8" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="messages" var="i18n"/>
    <footer class="newFooter">
        <div class="footer">
            &#169;<fmt:message
                bundle="${i18n}" key="footer"/>
        </div>
    </footer>

