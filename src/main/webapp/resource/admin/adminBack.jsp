<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>后台登录</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="<%=basePath%>resource/js/sidenav.min.js"></script>
    <link rel='stylesheet' href='http://fonts.googleapis.com/icon?family=Material+Icons' type='text/css'>
    <link rel="stylesheet" href="<%=basePath%>resource/css/sidenav.min.css" type="text/css">
    <style type="text/css">
        body{
            background-color: rgb(33,33,33);
        }
        .toggle {
            display: block;
            height: 42px;
            line-height: 72px;
            text-align: center;
            width: 72px;
        }

        #myframe{
            margin: 0;
            padding: 0;
            width:100%;
            height:88%;
            scrolling : no;
            border: 0;
            background-color: rgb(33,33,33);

        }

        .sidenav-brand{
            background-color: rgb(33,33,33);
        }

        a:hover{
            cursor: pointer;
        }
    </style>
</head>
<body>

<nav class="sidenav" data-sidenav data-sidenav-toggle="#sidenav-toggle">
    <div class="sidenav-brand" id="topPage">
        管理菜单
    </div>

    <div class="sidenav-header">
        <small>月明船笛参差起</small>
        <small>风定池莲自在香</small>
    </div>

    <ul class="sidenav-menu">
        <li>
            <a href="javascript:;" data-sidenav-dropdown-toggle class="active">
	          <span class="sidenav-link-icon">
	            <i class="material-icons">store</i>
	          </span>
                <span class="sidenav-link-title">商品管理</span>
                <span class="sidenav-dropdown-icon show" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_down</i>
	          </span>
                <span class="sidenav-dropdown-icon" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_up</i>
	          </span>
            </a>

            <ul class="sidenav-dropdown" data-sidenav-dropdown>
                <li><a id="addPro">添加商品</a></li>
                <li><a id="takeon">上架商品</a></li>
                <li><a id="takeoff">下架商品</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:;" data-sidenav-dropdown-toggle>
	          <span class="sidenav-link-icon">
	            <i class="material-icons">payment</i>
	          </span>
                <span class="sidenav-link-title">订单管理</span>
                <span class="sidenav-dropdown-icon show" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_down</i>
	          </span>
                <span class="sidenav-dropdown-icon" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_up</i>
	          </span>
            </a>

            <ul class="sidenav-dropdown" data-sidenav-dropdown>
                <li><a id="undeliver">待发货</a></li>
                <li><a id="backdeliver">退货</a></li>
            </ul>
        </li>

        <li>
            <a href="javascript:;" data-sidenav-dropdown-toggle>
	          <span class="sidenav-link-icon">
	            <i class="material-icons">shopping_cart</i>
	          </span>
                <span class="sidenav-link-title">Dolore magna</span>
                <span class="sidenav-dropdown-icon show" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_down</i>
	          </span>
                <span class="sidenav-dropdown-icon" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_up</i>
	          </span>
            </a>

            <ul class="sidenav-dropdown" data-sidenav-dropdown>
                <li><a href="javascript:;">Aliqua</a></li>
                <li><a href="javascript:;">Exercitation</a></li>
                <li><a href="javascript:;">Minim veniam</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:;">
	          <span class="sidenav-link-icon">
	            <i class="material-icons">assignment_ind</i>
	          </span>
                <span class="sidenav-link-title">Nostrud ullamco</span>
            </a>
        </li>
        <li>
            <a href="javascript:;">
	          <span class="sidenav-link-icon">
	            <i class="material-icons">alarm</i>
	          </span>
                <span class="sidenav-link-title">Commodo</span>
            </a>
        </li>
    </ul>

    <div class="sidenav-header">
        Another Section Header
    </div>

    <ul class="sidenav-menu">
        <li>
            <a href="javascript:;" data-sidenav-dropdown-toggle>
	          <span class="sidenav-link-icon">
	            <i class="material-icons">date_range</i>
	          </span>
                <span class="sidenav-link-title">Reprehenderit</span>
                <span class="sidenav-dropdown-icon show" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_down</i>
	          </span>
                <span class="sidenav-dropdown-icon" data-sidenav-dropdown-icon>
	            <i class="material-icons">arrow_drop_up</i>
	          </span>
            </a>

            <ul class="sidenav-dropdown" data-sidenav-dropdown>
                <li><a href="javascript:;">Voluptate</a></li>
                <li><a href="javascript:;">Excepteur</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:;">
	          <span class="sidenav-link-icon">
	            <i class="material-icons">backup</i>
	          </span>
                <span class="sidenav-link-title">Occaecat</span>
            </a>
        </li>
        <li>
            <a href="javascript:;">
	          <span class="sidenav-link-icon">
	            <i class="material-icons">settings</i>
	          </span>
                <span class="sidenav-link-title">Deserunt</span>
            </a>
        </li>
    </ul>
</nav>

<a href="javascript:;" class="toggle" id="sidenav-toggle">
    <i class="material-icons">menu</i>
</a>

<iframe src="" id="myframe"></iframe>


<script>

    $(function(){
        $('[data-sidenav]').sidenav();
        $("#myframe").attr("src","resource/admin/timesecharts.jsp");



        $("#topPage").click(function(){
            $("#myframe").attr("src","resource/admin/timesecharts.jsp");
        });


        $("#addPro").click(function(){
            $("#myframe").attr("src","resource/products/addProducts.jsp");
        });

        //上架商品
        $("#takeon").click(function(){
            $("#myframe").attr("src","resource/admin/upProduct.jsp");
        });

        //下架商品
        $("#takeoff").click(function(){
            $("#myframe").attr("src","resource/admin/downProduct.jsp");
        });

        $("#undeliver").click(function(){
            $("#myframe").attr("src","resource/admin/unDeliverOrders.jsp");

        });
    })

</script>
</body>
</html>
