<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head id="hh">
    <base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="<%=basePath%>resource/js/sHover.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>resource/css/example.css">


</head>
<body id="body">
<div id="part3" class="part">
    <div class="container">


    </div><!-- /container -->
</div>


<script>
    $(function () {

        $.ajax({
            url: "selectAllProductsByP_type",
            type: "post",
            data: {
                "p_type": getQueryString("p_type")
            },
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var str = "<div  class='sHoverItem'>" +
                        "    <img  src='" + data[i].pic + "'>" +
                        "    <span  class='sIntro'>" +
                        "<h4 style='color: blue'>" + data[i].pName + "</h4>" +
                        "<p>" + data[i].intro + "</p>" +
                        "<p>$" + data[i].price + "</p>" +
                        "<button>立即购买</button>" +
                        "<button pid='"+data[i].pId+"' class='addCart'>加入购物车</button>" +
                        "</span>" +
                        " </div>";
                    $(".container").append(str);
                }

                $(this).next().attr("pid");

                var b = new sHover('head', 'headIntro');
                var a = new sHover("sHoverItem", "sIntro");
                a.set({
                    slideSpeed: 5,
                    opacityChange: true,
                    opacity: 80
                })

                var example1Btn = document.getElementById('example1Btn');
                var part1arrow = document.getElementById('part1arrow');
                var example1 = document.getElementById('example1');

                var example2 = new sHover('example2', 'intro2');
                example2.set({
                    slideSpeed: 7,
                    opacity: 80,
                    opacityChange: true
                });

                var example2prev = new sHover('example2prev', 'intro2prev');
                example2prev.set({});

            }
        });

        $(".container").on("click",".addCart",function () {
            alert($(this).attr("pid"));
        })


    });

    function scrollToBottom(a) {
        if (windowHeight()) {
            clearInterval(a.scrollTimer);
            var scrollSpeed = 100;
            a.scrollTimer = setInterval(function () {
                document.documentElement.scrollTop += scrollSpeed;
                document.body.scrollTop += scrollSpeed;
                if ((document.documentElement.scrollTop >= (document.documentElement.scrollHeight - windowHeight())) || (document.body.scrollTop >= (document.documentElement.scrollHeight - windowHeight()))) {
                    clearInterval(a.scrollTimer);
                }
            }, 13);
        } else {
            //a.setAttribute('href', 'http://www.baidu.com');
        }
    }

    function windowHeight() {
        if (document.documentElement) {
            return document.documentElement.clientHeight;
        } else {
            return document.body.clientHeight;
        }
    }

    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null)
            return decodeURI(r[2]);
        return null;
    }

    function loadjscssfile(filename, filetype) {
        if (filetype == "js") { //判定文件类型
            var fileref = document.createElement('script');//创建标签
            fileref.setAttribute("type", "text/javascript");//定义属性type的值为text/javascript
            fileref.setAttribute("src", filename);//文件的地址
        } else if (filetype == "css") { //判定文件类型
            alert("css");
            var fileref = document.createElement("link");
            fileref.setAttribute("rel", "stylesheet");
            fileref.setAttribute("type", "text/css");
            fileref.setAttribute("href", filename);
            document.getElementsByTagName("head")[0].appendChild(fileref);
            alert("拼接到head");
        }
        // if (typeof fileref != "undefined")
        //     document.getElementsByTagName("head")[0].appendChild(fileref);
    }


</script>


</body>
</html>
