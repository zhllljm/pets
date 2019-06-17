<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/mobile/css/pintuer.css">
    <link rel="stylesheet" href="/mobile/css/admin.css">
    <script type="text/javascript" src="/mobile/js/js.js"></script>

    <title>js验证码</title>
    <style type="text/css">
        .code {
            background: url(images/bg.jpg);
            font-family: Arial;
            font-style: italic;
            color: blue;
            font-size: 30px;
            border: 0;
            padding: 2px 3px;
            letter-spacing: 3px;
            font-weight: bolder;
            float: left;
            cursor: pointer;
            width: 150px;
            height: 60px;
            line-height: 60px;
            text-align: center;
            vertical-align: middle;
        }

        a {
            text-decoration: none;
            font-size: 12px;
            color: #288bc4;
        }

        a:hover {
            text-decoration: underline;
        }

        body {
            background: url("images/bg.jpg");
        }

        .bg {
            background: url("images/timg.jpg");
        }
    </style>
    <script type="text/javascript">
        var code;

        function createCode() {
            code = "";
            var codeLength = 4; //验证码的长度
            var checkCode = document.getElementById("checkCode");
            var codeChars = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); //所有候选组成验证码的字符，当然也可以用中文的
            for (var i = 0; i < codeLength; i++) {
                var charNum = Math.floor(Math.random() * 52);
                code += codeChars[charNum];
            }
            if (checkCode) {
                checkCode.className = "code";
                checkCode.innerHTML = code;
            }
        }

        function validateCode() {

            var uname = document.getElementById("uname").value;
            var upsw = document.getElementById("upsw").value;
            var inputCode = document.getElementById("inputCode").value;
            if (uname.length == 0) {
                alert("对不起账号不能为空！")
                return false;
            }
            else if (upsw.length == 0) {
                alert("对不起密码不能为空！")
                return false;
            }
            else if (inputCode.length == 0) {
                alert("对不起验证码不能为空！")
                return false;
            }
            else if (inputCode.length == 0) {
                alert("请输入验证码！");
                return false;
            }
            else if (inputCode.toUpperCase() != code.toUpperCase()) {
                alert("验证码输入有误！");
                createCode();
                document.getElementById("uname").value = '';
                document.getElementById("upsw").value = '';
                document.getElementById("inputCode").value = '';
                document.getElementById("uname").focus();
                var input = document.getElementById("uname");

                var val = input.value; //将光标的值位置给val

                input.value = "";//将光标的值设置为空

                input.value = val;
                return false;
            }
            else {
                return true;
            }
        }
    </script>

</head>

<body onload="createCode()">
<form action="/mobile/localss" method="post" id="form1" runat="server"
      onsubmit="validateCode()">
    <div class="bg"></div>
    <div class="container">
        <div class="line bouncein">
            <div class="xs6 xm4 xs3-move xm4-move">
                <div style="height: 150px;"></div>
                <div class="media media-y margin-big-bottom">
                </div>
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top">
                        <h1>
                            宠物帮领养管理中心
                        </h1>
                    </div>
                    <div class="panel-body"
                         style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                        <span style="color: red">
                         <#if Session["msg"]?exists>
                             ${Session["msg"]}
                         </#if>
                        </span>
                                <input type="text" class="input input-big" id="uname" name="uname"
                                       placeholder="登录账号"/>
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" id="upsw" class="input input-big"
                                       name="pwd" placeholder="登录密码"
                                />
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <table border="0" cellspacing="5" cellpadding="5">
                                    <tr>

                                        <td>
                                            <input style="float:left;" placeholder="填写右侧验证码" type="text"
                                                   id="inputCode" class="input input-big"/>
                                        <td>
                                            <div class="code" id="checkCode" onclick="createCode()"></div>
                                        </td>
                                        </td>
                                    </tr>
                                </table>
                                <div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div style="padding: 30px;">
                        <input type="submit"
                               class="button button-block bg-main text-big input-big"
                               value="登录" onclick="return validateCode();">
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>