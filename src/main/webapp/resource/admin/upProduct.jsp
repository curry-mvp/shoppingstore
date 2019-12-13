<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>商品上下架</title>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <style>


        .downcancle{
            width: 90px;
            height: 35px;
            background-color: blue;
            color: white;
            font-family: 微软雅黑;
        }

        .active{
            color: white;
        }
        th{
            color: white;
        }

    </style>

</head>
<body id="tbody">
<table>
    <thead>
    <tr>
        <th>商品ID</th>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品类型</th>
        <th>品牌</th>
        <th>商品数量</th>
        <th>商品价格</th>
        <th>商品折扣</th>
        <th>商品状态</th>
    </tr>
    </thead>

</table>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url:"getOnProducts",
            type:"post",
            success:function (data) {
                for(var i=0;i<data.length;i++){
                    if(data[i].status==0) {
                        data[i].status = '上架';
                    }

                    var tr="<tr class='active'>"+
                        "<td>"+data[i].pId+"</td>"+
                        "<td>"+data[i].pCode+"</td>"+
                        "<td>"+data[i].pName+"</td>"+
                        "<td>"+data[i].pType+"</td>"+
                        "<td>"+data[i].brand+"</td>"+
                        "<td>"+data[i].pNum+"</td>"+
                        "<td>"+data[i].price+"</td>"+
                        "<td>"+data[i].sale+"</td>"+
                        "<td>"+data[i].intro+"</td>"+
                        "<td><button class='downcancle'>下架</button></td>"+
                    "</tr>";
                    $("#tbody").append(tr);
                }
            }
        });

        $("#tbody").on("click","button",function () {
            var pId=$(this).parent().parent().find("td").eq(0).text();
            $.ajax({
                url:"OnProduct",
                type:"post",
                data:{
                    "pId":pId
                },success:function (data) {
                    if(data=="yes"){
                        alert("下架成功");
                    }else {
                        alert("下架失败");
                    }
                }
            })
        })
    })

</script>
</body>
</html>
