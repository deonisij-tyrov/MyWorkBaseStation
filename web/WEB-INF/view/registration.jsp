<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container text-center">
    <div class="error">${errorMsg}</div>
    <div class="information">${infoMsg}</div>
    <form action="frontController?command=registration" method="post"><br>
        <div class="input-group md-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>Name</b></span>
            </div>
            <input class="form-control" type="text" name="username" maxlength="30"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>Login</b></span>
            </div>
            <input class="form-control" type="text" name="userlogin" maxlength="30"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>Password</b>/b></span>
            </div>
            <input class="form-control" type="password" name="password1" maxlength="20"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>Repeat password</b>/b></span>
            </div>
            <input class="form-control" type="password" name="password2" maxlength="20"/><br>
        </div>
        <div class="input-group md-2">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon1"><b>Birthday</b>/b></span>
            </div>
            <input class="form-control" id="dr" type="date" name="userbirthday" maxlength="20"/><br>
        </div>
        <input type="submit" value="Войти!!!!!!local">
    </form>
</div>