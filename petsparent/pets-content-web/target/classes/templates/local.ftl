
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link rel="stylesheet" type="text/css" href="/mobile/css/bootstrap.css" />
<title>主页</title>
<style type="text/css">
.logo {
	padding: 0 15px;
}

.side_menu {
	background: #f8f8f8;
	border-radius: 4px;
	min-height: 800px;
}

.side_menu .panel-body {
	padding: 5px;
}

.side_menu .panel-body ul li a {
	color: #3C3C3C;
}
</style>

</head>

<body>

	<!--导航bengin-->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand logo" href="#"> <img src="/mobile/images/10.jpg"
					class="img-circle img-responsive" />
				</a>
			</div>
			<p class="navbar-text">管理员：
			<#if Session["name"]?exists>
				${Session["name"]}
			</#if>
			</p>
			<p class="navbar-text">23:32:08 下午好</p>
			<button type="button" class="btn btn-danger navbar-btn">
                <a href="manager.ftl"><span class="glyphicon glyphicon glyphicon-off"></span>退出登录</a>
			</button>
		</div>
	</nav>
	<!--导航end-->

	<div class="container-fluid">

		<div class="row">
			<!--左侧栏begin-->
			<div class="col-md-2 side_menu">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne"> <i
									class="glyphicon glyphicon-th-list"></i> 菜单列表
								</a>
							</h4>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"> <i
									class="glyphicon glyphicon-user"></i> 基本类别管理
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<ul class="nav nav-pills nav-stacked">
                                    <li><a href="/mobile/dylb"><span
                                            class="glyphicon glyphicon-play"></span> 商品分类管理</a></li>
                                    <li><a href="/mobile/dyxxgl"><span
                                            class="glyphicon glyphicon-play"></span> 商品信息管理</a></li>
                                    <li><a href="/mobile/index-item"><span
                                            class="glyphicon glyphicon-play"></span> 索引库管理</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--左侧栏end-->

			<!--右边栏begin-->
			<div class="col-md-10">
				<ul class="breadcrumb">
					<li><a href="#"><span class="glyphicon glyphicon-home"></span>
							首页</a></li>
					<li class="active"> 宠物帮领养管理中心</li>
				</ul>
				<div class="row">
					<img src="/mobile/images/123.jpeg" class="img-responsive" />
				</div>
				<!--右边栏end-->
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="/mobile/js/jquery.js"></script>
	<script type="text/javascript"
		src="/mobile/js/bootstrap.js"></script>
</body>

</html>