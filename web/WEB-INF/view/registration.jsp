<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <div class="information">${infoMsg}</div>
    <form action="frontController?command=registration" method="post"><br>>
        <b>Name</b><input type="text" name="username" maxlength="30"/><br>>
        <b>Login</b><input type="text" name="userlogin" maxlength="30"/><br>>
        <b>Password</b><input type="password" name="password1" maxlength="20"/><br>>
        <b>Repeat password</b><input type="password" name="password2" maxlength="20"/><br>>
        <b>Birthday</b><input id="dr" type="date" name="userbirthday" maxlength="20"/><br/>
        <input type="submit" value="Войти">
    </form>
</div>