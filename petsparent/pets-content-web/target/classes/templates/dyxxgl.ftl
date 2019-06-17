<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <title>商品信息管理</title>
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="/mobile/css/bootstrap.css"/>
    <script charset="utf-8" src="/mobile/w/kindeditor-4.1.10/kindeditor.js"></script>
    <script charset="utf-8" src="/mobile/w/kindeditor-4.1.10/lang/zh_CN.js"></script>
    <link href="/mobile/w/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="/mobile/common.js"></script>

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
        .detailed{
            width: 100px;
        }
        .modal-content {
            position: relative;
            background-color: #fff;
            -webkit-background-clip: padding-box;
            background-clip: padding-box;
            border: 1px solid #999;
            border: 1px solid rgba(0, 0, 0, .2);
            border-radius: 6px;
            outline: 0;
            -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
            box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
            width: 680px;
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
        <p class="navbar-text">管理员：
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
                              <#--  <li><a href="/mobile/ep/queryemp.action"><span class="glyphicon glyphicon-play"></span>
                                        员工信息管理</a></li>
                                <li><a href="/show/querylist.action"><span class="glyphicon glyphicon-play"></span>
                                        放映信息管理</a></li>
                                <li><a href="/se/t.action"><span class="glyphicon glyphicon-play"></span>
                                        售票信息管理</a></li>
                                <li><a href="/se/in.action"><span class="glyphicon glyphicon-play"></span>
                                        收益管理</a></li>
                                <li><a href="/se/zong.action"><span class="glyphicon glyphicon-play"></span>
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
                <li class="active">商品信息管理</li>
            </ol>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" style="margin-bottom: 15px;">
                        <i class="glyphicon glyphicon-tasks"></i> 操作信息管理
                    </h3>
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <button class="btn btn-info" data-toggle="modal" data-target="#myModalAdd">
                                <i class="glyphicon glyphicon-plus"></i> 增加
                            </button>
                        </div>
                        <div class="btn-group">
                            <button class="btn btn-danger" id="batchDelBtn">
                                <i class="glyphicon glyphicon-remove"></i> 批量下架
                            </button>
                        </div>
                        <form class="form-inline pull-right" action="/film/querylist.action">
                            <input class="form-control" name="fname" placeholder="请输入搜索的内容"/>
                            <button class="btn btn-success">
                                <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered table-striped table-hover text-center">
                        <thead>
                        <tr>
                            <th class="text-center"><input type="checkbox" id="selectAll"/></th>
                            <th class="text-center">商品编号</th>
                            <th class="text-center">商品类别</th>
                            <th class="text-center">商品名称</th>
                            <th class="text-center">商品价格</th>
                            <th class="text-center">发布时间</th>
                            <th class="text-center">库存</th>
                            <th class="text-center">首页图</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody id="ta">

                        </tbody>


                    </table>
                    <form class="form-inline pull-right" action="#">
                        <input class="form-control" type="submit" value="查看下架内容"/>
                    </form>
                </div>
                <div class="panel-footer">
                    <p:page url="#"/>
                </div>
            </div>
        </div>
        <!--右边内容end-->
    </div>
</div>

<!-- 增加模态框begin -->
<div class="modal fade" id="myModalAdd">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">增加商品</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="addForm" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="warename" name="warename" placeholder="请输入商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="proprice" placeholder="请输入商品价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">发售量</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="warefreight" placeholder="请输入发售量">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品类别</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="lei" name="cid">
                                <option value="-1">--请选择商品类别--</option>
                                <#--<c:forEach items="${sortList}" var="sortList">
                                    <option value="${sortList.sid}">${sortList.sname}</option>
                                </c:forEach>-->
                                <!-- 	<option value="动作片">动作片</option>
                            <option value="爱情片">爱情片</option>
                            <option value="热血片">热血片</option>
                            <option value="科幻片">科幻片</option> -->
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品详情</label>
                    </div>
                    <textarea style="width:300px;height:400px;visibility:hidden;" name="waredetailed"></textarea>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品图片</label>
                        <div class="col-sm-10">
                            <input type="file" name="file" placeholder="请输入商品图片1"/>
                            <input type="file" name="file" placeholder="请输入商品图片2"/>
                            <input type="file" name="file" placeholder="请输入商品图片3"/>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary save">确定</button>
            </div>
        </div>
    </div>
</div>
<!-- 增加模态框end -->

<!-- 修改模态框 begin-->
<div class="modal fade" id="myModalEdit">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改商品信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="editForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_wareid" name="wareid" placeholder="请输入商品编号"
                                   readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_warename" name="warename" placeholder="请输入商品名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品价格</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_proprice" name="proprice" placeholder="请输入商品价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品库存</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_warefreight" name="warefreight"
                                   placeholder="请输入商品库存">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品类别</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="edit_cid" name="cid">
                                <option value="-1">--请选择商品类别--</option>
                                <#--<#list items as item >-->
                                    <#--<option value="${item.cid}">--${item.itemCat.name}--</option>-->
                                <#--</#list>-->
                                <#--<c:forEach items="${sortList}" var="sortList">
                                    <option value="${sortList.sid}">${sortList.sname}</option>
                                </c:forEach>-->
                                <!-- <option value="动作片">动作片</option>
                            <option value="爱情片">爱情片</option>
                            <option value="热血片">热血片</option>
                            <option value="科幻片">科幻片</option> -->
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">商品图片</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="edit_wareimg" name="wareimg"
                                   placeholder="请输入商品图片">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary edit">确定</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改模态框 end-->

<script type="text/javascript" src="/mobile/js/jquery.js"></script>
<script type="text/javascript" src="/mobile/js/bootstrap.js"></script>

<script type="text/javascript">
    $.ajax({
        type: "get",
        url: "/mobile/getItems",
        async: true,
        dataType: "json",
        success: function (data) {
            console.log(data);
            var strHTML = "";
            $.each(data, function (index, item) {
                strHTML += "<tr data-id='" + item.wareid + "'>";
                strHTML += "<td><input type='checkbox' name='ck' value='" + item.wareid + "'/></td>";
                strHTML += "<td>" + item.wareid + "</td>";
                strHTML += "<td>" + item.itemCat.name + "</td>";
                strHTML += "<td>" + item.warename + "</td>";
                strHTML += "<td>" + item.proprice + "</td>";
                strHTML += "<td>" + item.waretime + "</td>";
                strHTML += "<td>" + item.warefreight + "</td>";
                strHTML += "<td>" + item.wareimg + "</td>";
                strHTML += "<td><button class='btn btn-danger editUI'data-target='#myModalEdit' data-toggle='modal'><i class='glyphicon glyphicon-edit'></i> 修改</button><button class='btn btn-warning del'><i class='glyphicon glyphicon-remove'></i> 删除</button><button class='btn btn-info view'><i class='glyphicon glyphicon-sort'></i> 查看</button></td>";
                strHTML += "</tr>";
            })
            console.log(strHTML);
            $("#ta").append(strHTML);
        }
    });

    /*$.ajax({
        type: "get",
        url: "/SortServlet?method=query",
        async: true,
        dataType: "json",
        success: function(res) {
            console.log(res);
            var strHTML = "";
            $.each(res, function(index, item) {
                strHTML += "<option value='" + item.sid + "'>" + item.sname + "</option>";
            });
            console.log(strHTML);
            $("select").append(strHTML);
        }
    }); */

    $(document).on("click", ".del", function () {
        /*获取删除的这一行的id*/
        var id = $(this).parents("tr").data("id");
        console.log("id:" + id);
        var _this = $(this); /*缓存当前节点*/

        if (confirm('您是真的要下架吗？')) {
            $.ajax({
                type: "post",
                /*请求的方法*/
                url: "/mobile/deleteItem0",
                /*请求服务器的url*/
                async: true,
                data: { /*请求的参数数据*/
                    id: id
                },
                dataType: "json",
                /*返回的数据格式，可以是xml、text、json*/
                success: function (res) { /*服务器响应成功，返回数据res*/
                    console.log(res);
                    if (res.code == 200) {
                        _this.parents("tr").remove(); /*删除当前行*/
                        alert("删除成功")
                    }
                }
            });
        }

    });


    var itemAddEditor;

    $(document).on("click", ".btn-info", function () {

        //创建富文本编辑器
        itemAddEditor = E3.createEditor("#addForm [name=waredetailed]");
        //初始化类目选择和图片上传器
        E3.init({
            fun: function (node) {
                //根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
                //E3.changeItemParam(node, "itemAddForm");
            }
        });

        console.log("进入增加模态框");
        $.ajax({
                type: "get",
                url: "/mobile/getItemcat",
                async: true,
                dataType: "json",
                success: function (res) {
                    console.log(res);
                    var strHTML = "";
                    $.each(res, function (index, item) {
                        strHTML += "<option value=" + item.id + ">" + item.name + "</option>";
                    })
                    console.log(strHTML);
                    $("#lei").append(strHTML);
                }
        });
    })


    $(document).on("click", ".save", function () {
        var data = new FormData($("#addForm")[0]);
        console.log(data)
        $.ajax({
            type: "post",
            url: "/mobile/saveItem",
            async: true,
            data: data,
            /*序列化表单元素的值  fname=123&fauto=123&ontime=2010-10-10&sid=14&fremark=asdfasdfasdf*/
            processData: false,
            contentType: false,
            success: function (res) {
                console.log(res);
                if (res.code == 200) {
                    //添加成功
                    //隐藏模态框
                    $("#myModalAdd").modal("hide");
                    alert("添加成功")
                    //重新加载页面
                    //方式1：构造tr节点，追加到table后面
                    //方式2：刷新页面
                    window.location.reload();
                }
            }
        })
    })

    /*批量删除*/
    $("#selectAll").click(function () {
        $("input[type=checkbox][name=ck]").prop("checked", this.checked); // this指代的你当前选择的这个元素的JS对象
    });

    $("#batchDelBtn").click(function () {
        //获取选中的checkbox
        var $ck = $("input[type=checkbox][name=ck]:checked");
        if ($ck.length == 0) {
            alert("请选择要下架的商品！");
            return false;
        }

        var cks = "";
        //遍历选中的checkxbox，获取每一个值，用“,”拼接
        $ck.each(function () {
            cks += $(this).val() + ",";
        });
        //去掉最后一个“，”
        cks = cks.substr(0, cks.length - 1);
        console.log(cks);

        $.ajax({
            type: "post",
            url: "/mobile/deleteItemTo0",
            async: true,
            data: {
                cks: cks
            },
            dataType: "json",
            success: function (res) {
                console.log(res);
                if (res.code == 200) {
                    alert("移除成功");
                    //移除选中的checkbox对应的行
                    $ck.parents("tr").remove();
                }

            },
            error: function () {
                alert("请求操作失败！");
            }
        });
    })

    /*进入修改页面，根据id查询修改的数据，绑定到修改模态框的表单上*/
    $(document).on("click", ".editUI", function () {
        /*获取修改的这一行的id*/
        var id = $(this).parents("tr").data("id");
        console.log("id:" + id);
        var _this = $(this); /*缓存当前节点*/

        $.ajax({
            type: "post",   /*请求方法*/
            url: "/mobile/getItemById",   /*请求服务器地址*/
            async: true,          /*异步请求*/
            data: {          /*请求的参数，在服务器端根据名字获取对应的额值*/
                id: id
            },
            dataType: "json",/*服务器返回的数据格式 xml 、text 、json*/
            success: function (res) {   /*success表示服务器请求成功回调函数,res表示服务器返回的数据*/
                console.log(res);
                $("#edit_wareid").val(res.wareid);
                $("#edit_warename").val(res.warename);
                $("#edit_proprice").val(res.proprice);
                $("#edit_warefreight").val(res.warefreight);
                $("#edit_cid").val(res.cid);
                $("#edit_wareimg").val(res.wareimg);
            }
        });
        $.ajax({
            type: "get",
            url: "/mobile/getItemcat",
            async: true,
            dataType: "json",
            success: function (res) {
                console.log(res);
                var strHTML = "";
                $.each(res, function (index, item) {
                    strHTML += "<option value=" + item.id + ">" + item.name + "</option>";
                })
                console.log(strHTML);
                $("#edit_cid").append(strHTML);
            }
        });
    });

    $(document).on("click", ".edit", function () {
        console.log($("#editForm").serialize());
        $.ajax({
            type: "post",
            url: "/mobile/updateItem",
            async: true,
            data: $("#editForm").serialize(),   /*表单序列化成字符串*/
            /*序列化表单元素的值  fname=123&fauto=123&ontime=2010-10-10&sid=14&fremark=asdfasdfasdf*/
            dataType: "json",
            success: function (res) {
                console.log(res);
                if (res.code == 200) {
                    //修改成功
                    alert("修改成功");
                    //隐藏模态框
                    $("#myModalEdit").modal("hide");
                    //重新加载页面
                    //方式1：构造tr节点，追加到table后面   ??????????????????????????????
                    //方式2：刷新页面
                    window.location.reload();
                }
            },
            error: function () {
                alert("请求操作失败！");
            }
        });
    })


</script>

</body>

</html>