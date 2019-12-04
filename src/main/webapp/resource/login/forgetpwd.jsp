<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/11/26
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>忘记密码</title>
</head>
<body>
<hr>

<input type="text" id="username" placeholder="请输入用户名"><br>

<input type="text" id="password" placeholder="请输入您的新密码"><br>

<input type="text" id="password1" placeholder="请确认您的密码"><br>

<input type="button" value="确认修改" id="updatepwd">
<div id="msg"></div>
<script type="text/javascript">

    $(function () {
        $("#updatepwd").click(function () {
            if($("#username").val()==''){
                $("#msg").html("用户名不能为空");
            }else{
                $.ajax({
                    url:"<%=path%>/forgetpwd",
                    type:"post",
                    data:{
                        "username":$("#username").val(),
                        "password":$("#password").val(),
                        "password1":$("#password1").val()
                    },success:function (data) {
                        if(data=='no'){
                            $("#msg").html("您输入的密码不一致,请重新输入");
                        }else if(data=='same'){
                            $("#msg").html("旧密码与新密码不能一样");
                        }else if(data=='yes'){
                            $("#msg").html("密码修改成功");
                        }else if(data=="none"){
                            $("#msg").html("用户信息输入不正确");
                        }else{
                            $("#msg").html("用户名或密码不能为空");
                        }
                    }
                });
            }
        });
    });

</script>


</body>
</html>
