<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <title>註冊</title>
        <!-- head -->
        <%@include file="/WEB-INF/jsp/include/head.jspf"  %>
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
        <script>
            $(document).ready(function () {

                $("#add").on("click", function () {
                    var jsonObj = $('#myform').serializeObject();
                    var jsonStr = JSON.stringify(jsonObj);
                    var balInt = $("#myform").find("#balance").val();
                    if (confirm("請確認資料是否正確?")) {
                        if (parseInt(balInt) == 0 || balInt == null) {
                            alert('Error:現金不為空值或為0，請重新輸入!!');
                            return;
                        }

                        $.ajax({
                            url: "/SpringMVC/mvc/portfolio/investor/",
                            type: "POST",
                            contentType: "application/json; charset=utf-8",
                            data: jsonStr,
                            async: true,
                            cache: false,
                            processData: false,
                            success: function (resposeJsonObject) {
                                alert("驗證信件已送出");
//                                console.log("OK");
                                window.location.href="${pageContext.request.contextPath}/portfolio/login.jsp";
                            }
                        });
                    }

                });

            })


        </script>
    </head>
    <body style="padding:15px" bgcolor="#DDDDDD">
    <center>
        <table bgcolor="#FFFFFF">
            <td>
                <form id="myform" class="pure-form">
                    <fieldset>
                        <legend><h1><img src="/SpringMVC/images/user.png" width="40" valign="middle"> Regist Form</h1></legend>
                        
                        <input id="id" vslue="0" name="id" placeholder="ID" readonly="true"/><p />
                        <input id="username" name="username" placeholder="username"/><p />
                        <input id="password" name="password" placeholder="password"/><p />
                        <input id="email" name="email" placeholder="email"/><p />
                        <input id="balance" name="balance" placeholder="balance" type="number"/><p />
                        <button id="add" type="button" class="pure-button pure-button-primary">Sign up</button>
                    </fieldset>
                </form>
            </td>
        </table>
    </center>
</body>
</html>