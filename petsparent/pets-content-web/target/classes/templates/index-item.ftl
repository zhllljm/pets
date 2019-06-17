<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>商品分类管理</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="/mobile/css/bootstrap.css"/>
    <style type="text/css">
        .logo {
            padding: 0 15px;
        }

        .menu_slide {
            background: #f8f8f8;
            border-radius: 10px;
            min-height: 800px;
        }

        .menu_slide .panel-body {
            padding: 0px;
        }

        .menu_slide .panel-body ul li a {
            color: #3C3C3C;
        }

        .table tbody tr td {
            vertical-align: middle;
        }

        .im {
            height: 100px;
            width: 100px;
        }
    </style>
    <!-- <script type="text/javascript">
        window.onload = function() {
            setInterval(function() {
                var date = new Date();
                var seperator1 = "-";
                var seperator2 = ":";
                var month = date.getMonth() + 1;
                var strDate = date.getDate();
                if(month >= 1 && month <= 9) {
                    month = "0" + month;
                }
                if(strDate >= 0 && strDate <= 9) {
                    strDate = "0" + strDate;
                }
                var currentdate = date.getFullYear() + seperator1 + month +
                    seperator1 + strDate + " " + date.getHours() + seperator2 +
                    date.getMinutes() + seperator2 + date.getSeconds();

                var d = document.getElementById('showDate');
                d.innerHTML = currentdate;
            }, 1000);
        }
    </script> -->
</head>

<body>

<!--导航begin-->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand logo" href="#"> <img src="/mobile/images/10.jpg" class="img-circle"/>
            </a>
        </div>
        <p class="navbar-text">管理员:
        <#if Session["name"]?exists>
            ${Session["name"]}
        </#if>
        </p>
        <p class="navbar-text">
            <span id="showDate"></span>
        </p>
        <button type="button" class="btn btn-danger navbar-btn">
            <a href="manager.ftl"><i class="glyphicon glyphicon glyphicon-off"></i>退出登录</a>
        </button>
    </div>
</nav>
<!--导航end-->

<div class="container-fluid">
    <div class="row">
        <!--左边导航菜单begin-->
        <div class="col-md-2 menu_slide">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne"> <i class="glyphicon glyphicon-th-list"></i>
                                菜单列表
                            </a>
                        </h4>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse"
                               data-parent="#accordion" href="#collapseTwo"> <i
                                    class="glyphicon glyphicon-user"></i> 基本类别管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="/mobile/dylb"><span
                                                class="glyphicon glyphicon-play"></span> 商品分类管理</a></li>
                                <li><a href="/mobile/dyxxgl"><span
                                                class="glyphicon glyphicon-play"></span> 商品信息管理</a></li>
                                <li><a href="/mobile/index-item"><span
                                                class="glyphicon glyphicon-play"></span> 索引库管理</a></li>
                                <#--<li><a href="/mobile/ep/queryemp.action"><span class="glyphicon glyphicon-play"></span>
                                    员工信息管理</a></li>
                                <li><a href="/mobile/show/querylist.action"><span
                                        class="glyphicon glyphicon-play"></span>
                                    放映信息管理</a></li>
                                <li><a href="/mobile/se/t.action"><span class="glyphicon glyphicon-play"></span>
                                    售票信息管理</a></li>
                                <li><a href="/mobile/se/in.action"><span class="glyphicon glyphicon-play"></span>
                                    收益管理</a></li>
                                <li><a href="/mobile/se/zong.action"><span class="glyphicon glyphicon-play"></span>
                                    总收入明细</a></li>-->
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--左边导航菜单end-->
        <!--右边内容begin-->
        <div class="col-md-10">
            <ol class="breadcrumb">
                <li>
                    <a href="index.html"> <i class="glyphicon glyphicon-home"></i> 首页
                    </a>
                </li>
                <li>基本类别管理</li>
                <li class="active">商品分类管理</li>
            </ol>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="margin-bottom: 15px;">
                        <i class="glyphicon glyphicon-tasks"></i> 操作信息管理
                    </h3>
                </div>
                <div class="panel-body">
                    <a class="easyui-linkbutton" onclick="importItems()">一键导入商品数据到索引库</a>
                </div>
            </div>
        </div>
        <!--右边内容end-->
    </div>
</div>



<script type="text/javascript" src="/mobile/js/jquery.js"></script>
<script type="text/javascript" src="/mobile/js/bootstrap.js"></script>

<script type="text/javascript">
    function importItems() {
        $.post("/mobile/index/item/import",null,function(data){
            console.log(data.code);
            if (data.code==200){
                alert("导入成功")
			}
        });
    }
</script>

</body>

</html>