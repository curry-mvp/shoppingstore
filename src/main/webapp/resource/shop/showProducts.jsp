<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head id="hh">
    <base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath%>resource/js/modernizr.custom.js"></script>
    <script src="<%=basePath%>resource/js/jquery.page.js"></script>
    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resource/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resource/css/component.css" />

    <style>

        body{
            background: #2A2B30;
        }

        .tcdPageCode{padding: 5px 0px 20px 10px;color: #ccc;text-align:right;margin-right: 5%;float: right;}
        .tcdPageCode a,.tcdPageCode .notcdNumber,.ellipsis{display: inline-block;color: #428bca;display: inline-block;height: 25px;	line-height: 25px;	padding: 0 10px;border-right: 1px solid #ddd;border-top: 1px solid #ddd;border-bottom: 1px solid #ddd;vertical-align: middle;}
        .prevPage{border-left: 1px solid #ddd;}
        .tcdPageCode a:hover{text-decoration: none;background-color: #F5F5F5;}
        .tcdPageCode span.current{display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;color: #fff;background-color: #428bca;	border: 1px solid #428bca;vertical-align: middle;}
        .tcdPageCode span.disabled{	display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;vertical-align: middle;}

    </style>

</head>
<body >
<!-- Compare basket -->
<div class="compare-basket">
    <button class="action action--button action--compare"><i class="fa fa-check"></i><span class="action__text">Compare</span></button>
</div>
<!-- Main view -->
<div class="view">
    <!-- Product grid -->
    <section class="grid">
        <!-- Products -->

    </section>
</div><!-- /view -->

<!-- product compare wrapper -->
<section class="compare">
    <button class="action action--close"><i class="fa fa-remove"></i><span class="action__text action__text--invisible">Close comparison overlay</span></button>
</section>

<div class="tcdPageCode"></div>

<script src="<%=basePath%>resource/js/classie.js"></script>
<script src="<%=basePath%>resource/js/main.js"></script>

<script>
    $(function(){
        $(".tcdPageCode").createPage({
            pageCount: 100,
            current: 1,
            backFn: function(p) {
            }
        });

        $.ajax({
            url:"selectAllProductsByP_type",
            type:"post",
            data:{
                "p_type":getQueryString("p_type")
            },
            success:function(data){

                for(var i=0;i<data.length;i++){
                    var str="<div class='product'>" +
                        "            <div class='product__info'>" +
                        "                <img class='product__image' src='<%=basePath%>resource/images/1.png' alt='Product 1' />" +
                        "                <h3 class='product__title'>"+data[i].pName+"</h3>" +
                        "                <span class='product__region extra highlight'>"+data[i].intro+"</span>" +
                        "                <span class='product__price highlight'>"+data[i].price+"</span>" +
                        "                <button class='action action--button action--buy' pid='"+data[i].pId+"'><i class='fa fa-shopping-cart'></i><span class='action__text cd-add-to-cart'>加入购物车</span></button>" +
                        "            </div>" +
                        "            <label class='action action--compare-add'><input class='check-hidden' type='checkbox' /><i class='fa fa-plus'></i><i class='fa fa-check'></i><span class='action__text action__text--invisible'>比较商品</span></label>'" +
                        "        </div>";

                    $(".grid").append(str);
                }
                loadjscssfile("<%=basePath%>resource/js/classie.js","js");
                loadjscssfile("<%=basePath%>resource/js/main.js","js");
            }
        });

        $(".grid").on("click",".action",function(){
            //alert($(this).attr("pid"));

            //alert($(this).children().eq(1).attr("pid"));

            if(getCookie("username")=="null"||getCookie("username")==""||getCookie("username")==undefined) {
                window.location.href = "<%=basePath%>resource/login/login.jsp";
            }else {
                $.ajax({
                    url:"addCar",
                    type:"post",
                    data:{
                        "pid":$(this).attr("pid"),
                        "username":getCookie("username")
                    },
                    success:function(data){

                    }
                })
            }
        });
    });

    function getQueryString(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)
            return  decodeURI(r[2]);
        return null;
    }

    function loadjscssfile(filename, filetype) {
        if (filetype == "js") { //判定文件类型
            var fileref = document.createElement('script');//创建标签
            fileref.setAttribute("type", "text/javascript");//定义属性type的值为text/javascript
            fileref.setAttribute("src", filename);//文件的地址
        }
        else if (filetype == "css") { //判定文件类型
            var fileref = document.createElement("link");
            fileref.setAttribute("rel", "stylesheet");
            fileref.setAttribute("type", "text/css");
            fileref.setAttribute("href", filename);
        }
        if (typeof fileref != "undefined")
            document.getElementsByTagName("head")[0].appendChild(fileref);
    }

    function getCookie(name) {
        //获取cookie字符串
        var strcookie = document.cookie;
        //分割
        var arrcookie = strcookie.split("; ");
        //遍历匹配
        for (var i = 0; i < arrcookie.length; i++) {
            var arr = arrcookie[i].split("=");
            if (arr[0] == name) {
                return arr[1];
            }
        }
        return "";
    }
</script>
</body>
</html>
