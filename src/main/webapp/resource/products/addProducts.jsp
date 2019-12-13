<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加商品</title>
    <meta charset="utf-8" >
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="<%=basePath%>resource/js/updateimg.js" ></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">


    <style type="text/css">

        body{
            background: #A3D0C3;
        }

        div.search {padding: 10px 0}

        .d1 input {
            width: 100%;
            height: 42px;
            padding-left: 10px;
            border: 2px solid #7BA7AB;
            border-radius: 5px;
            outline: none;
            background: #F9F0DA;
            color: #9E9C9C;
        }

        .d1 textarea {
            width: 278px;
            padding-left: 10px;
            border: 2px solid #7BA7AB;
            border-radius: 5px;
            outline: none;
            background: #F9F0DA;
            color: #9E9C9C;
            font-family: 微软雅黑;
            font-size:13px;
        }

        .a1,.a2,.a3{
            float: left;
            margin-left: 140px;
        }
        .a3{
            clear: both;
        }


        .main {
            width: 80%;

        }
        .btn {
            padding: 9px 18px;
            background: #40AFFE;
            color: #FFFFFF;
            border-radius: 5px;
        }

        .upimg {
            position: absolute;
            width: 100px;
            height: 100px;
            border-radius: 5px;
            border: dashed #999999;
            background: url('<%=basePath%>resource/images/addimg.svg') no-repeat;
            background-position: 33px;
            left:100px;
            top:300px;
        }

        .upimg input {
            width: 100px;
            height: 100px;
            border:2px solid red;
            opacity: 0;
        }

        #showui {
            display: flex;
            justify-content: flex-start;
        }

        #showui li {
            width: 150px;
            height: 150px;
            position: relative;
            overflow: hidden;
            display: inline-block;
            margin-right: 5px;
        }

        #showui li img .showimg {
            position: absolute;
            text-align: center;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 6;
        }

        .showdiv {
            position: absolute;
            z-index: 9;
            bottom: 0;
            width: calc(100% - 20px);
            padding: 10px;
            display: flex;
            justify-content: space-around;
            background: rgba(0, 0, 0, .6);
        }

        .showdiv img {
            width: 20px;
            height: 20px;
            cursor: pointer;
        }

        #showui li:first-child img.left {
            opacity: .6;
            cursor: no-drop;
        }

        #showui li:last-child img.right {
            opacity: .6;
            cursor: no-drop;
        }

        .oneright {
            opacity: .6;
            cursor: no-drop !important;
        }

        #showimg{
            position: absolute;
            width:300px;
            height: 300px;
            top:280px;
            left:200px;
        }

        img{
            width:170px;
            height:170px;
        }

        #subDiv{
            width: 150px;
            height:50px;
            position: absolute;
            top:390px;
            left:450px;
        }

    </style>
</head>
<body>
<form action="addProducts" method="post" enctype="multipart/form-data">

<div class="search d1 a1" id="div1">

        <input type="text" placeholder="请输入商品编号" name="p_code">

</div>

<div class="search d1 a1" id="div2">

        <input type="text" placeholder="请输入商品名称" name="p_name">

</div>

<div class="search d1 a1" id="div3">

        <input type="text" placeholder="请输入商品类别" name="p_type">

</div>


<div class="search d1 a2">

        <input type="text" placeholder="请输入商品品牌" name="brand">

</div>


<div class="search d1 a2">

        <input type="text" placeholder="请输入商品数量" name="p_num">

</div>


<div class="search d1 a2">

        <input type="text" placeholder="请输入商品价格" name="price">

</div>




<div class="search d1 a3">
        <textarea rows="4" cols="6" placeholder="请输入商品介绍" name="intro"></textarea>
</div>



<div class="main">
    <div id="showimg">
        <ul id="showui">
        </ul>

        <div id="showinput">

        </div>

    </div>


    <div class="upimg">
        <input type="file" id="upgteimg"  name="pic" />
        <button class="btn" id="submit">开始上传</button>
    </div>


 <div id="subDiv">
    <button type="submit" class="btn btn-success" id="saveBtn">保存</button>
</div>
 

</div>
</form>



</body>

</html>
