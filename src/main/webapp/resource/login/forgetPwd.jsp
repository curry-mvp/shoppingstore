<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/11/26
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
%>

<html>
<head>
    <title>忘记密码</title>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
</head>
<body>
<h1>忘记密码</h1>
<hr>
<h2>请按步骤依次完成操作</h2>
<input type="text"     id="username3"  placeholder="用户名"><br><br>
<input type="password" id="password3"  placeholder="新密码" ><br><br>
<div class="send-button w3layouts agileits">
    <input type="button" value="确认修改" id="btnforgetPwd">
    <div id="msg3"></div>
</div>


<script type="text/javascript">
$(function () {
    $("#btnforgetPwd").click(function () {
        if($("#username3").val()!=''&&$("#password3").val()!=''){
            $.ajax({
                <%--url:"<%=path%>/forgetpwd",--%>
                url:"../../forgetpwd",
                type:"post",
                data:{
                    "username":$("#username3").val(),
                    "password":$("#password3").val(),
                },success:function (data) {
                    if(data=="none"){
                        $("#msg3").html("用户不存在！");
                    }else if(data=="no"){
                        $("#msg3").html("新密码与旧密码一致，请重新输入！");
                    }else if(data=="error"){
                        $("#msg3").html("信息填写不正确");
                    }else{
                        $("#msg3").html("修改成功！");
                    }
                }
            })
        }else{
            $("#msg3").html("用户名或密码不能为空！");
        }
    })
})
</script>
</body>
</html>
