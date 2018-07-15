<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <div class="information">${infoMsg}</div>
    <form action="frontController?command=registration" method="post">
        <br>Name</br><input type="text" name="username" maxlength="30"/>
        <br>Login</br><input type="text" name="userlogin" maxlength="30"/>
        <br>Password</br><input type="password" name="password1" maxlength="20"/><br/>
        <br>Repeat password</br><input type="password" name="password2" maxlength="20"/><br/>
        <br>Birthday</br><input type="date" name="userbirthday" maxlength="20"/><br/>
        <input type="submit" value="Войти">
    </form>
</div>