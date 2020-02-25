<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>

        <!-- head -->
        <%@include file="/WEB-INF/jsp/include/head.jspf"  %>
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
        <script>
            $(document).ready(function () {
                if (true) {
                    setInterval(function () {
                        check();
                    }, 1000);
                }

                $("#verbtn").on("click", function () {
                    var jsonObj = $('#myform').serializeObject();
                    var jsonStr = JSON.stringify(jsonObj);
                    var email = $("#myform").find("#email").val();

                    $.ajax({
                        url: "/SpringMVC/mvc/portfolio/forget/send/" + email,
                        type: "PUT",
                        contentType: "application/json; charset=utf-8",
                        data: jsonStr,
                        async: true,
                        cache: false,
                        processData: false,
                        success: function (resposeJsonObject) {
                            alert("驗證信件已送出");
                            console.log("OK");
                        }
                    });


                });

                $("#chkbtn").on("click", function () {
                    var jsonObj = $('#myform').serializeObject();
                    var jsonStr = JSON.stringify(jsonObj);
                    var email = $("#myform").find("#email").val();

                    $.ajax({
                        url: "/SpringMVC/mvc/portfolio/forget/update/" + email,
                        type: "PUT",
                        contentType: "application/json; charset=utf-8",
                        data: jsonStr,
                        async: true,
                        cache: false,
                        processData: false,
                        success: function (resposeJsonObject) {
                            alert("OK");
                        }
                    });


                });

            })
            function check() {
                var vcode = $("#myform").find("#verify").val();
                if (vcode.length >= 6) {
                    $("#chkbtn").attr("disabled", false);
                    $("#pass").attr("disabled", false);
                }
                if (vcode.length < 6) {
                    $("#chkbtn").attr("disabled", true);
                    $("#pass").attr("disabled", true);

                }


            }

        </script>
    </head>
    <body style="padding:15px" bgcolor="#DDDDDD">
    <center>
        <table bgcolor="#FFFFFF">
            <td>
                <form id="myform" class="pure-form">
                    <fieldset>
                        <legend><h1><img src="/SpringMVC/images/user.png" width="40" valign="middle"> forget Form</h1></legend>

                        <input id="email" type="text" name="email" placeholder="UserEmail"><p />
                        <input id="verify" type="text" name="verify" placeholder="VerifyCode"><p/>
                        <input id="pass" type="text" name="pass" placeholder="New PassWord"><p />

                        <input id="verbtn" type="button" value="寄送驗證碼" class="pure-button pure-button-primary" onclick="alert('驗證碼已送出')">
                        <input id="chkbtn" type="button" value="確認" class="pure-button pure-button-primary" disabled="disabled">


                    </fieldset>
                </form>
            </td>
        </table>
    </center>
</body>
</html>