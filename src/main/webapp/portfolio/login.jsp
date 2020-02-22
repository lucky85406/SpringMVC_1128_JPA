<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <title>登入</title>
        <style>
            td {
                padding-bottom: 50px;
                padding-top: 50px;
                padding-left: 150px;
                padding-right: 150px;
                border-width:1px;
                border-style:solid;
                border-color:#CCCCCC;
            }
        </style>

    </head>
    <body style="padding:15px" bgcolor="#DDDDDD">
    <center>
        <table bgcolor="#FFFFFF">
            <td>
                <form class="pure-form">
                    <fieldset>
                        <legend><h1><img src="/SpringMVC/images/user.png" width="40" valign="middle"> Login Form</h1></legend>

                        <input type="text" name="username" placeholder="Username"><p />
                        <input type="password" name="password" placeholder="Password"><p />

                        <button id="log" type="submit" class="pure-button pure-button-primary" formmethod="post" formaction="/SpringMVC/mvc/portfolio/login">Sign in</button>
                        <input type="button" value="regist" class="pure-button pure-button-primary" onclick="location.href = '${pageContext.request.contextPath}/portfolio/regist.jsp'">
                    </fieldset>
                </form>
            </td>
        </table>
    </center>
</body>
</html>