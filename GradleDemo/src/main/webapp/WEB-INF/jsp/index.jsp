<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药店管理系统</title>
<style>
/* 左菜单背景色及高度样式 */
.col-md-2 {
	background-color: #C0C0C0;
	height: 660px;
}
/* 左菜单顶部按钮距离 */
#left-content {
	margin-top: 20px;
}
/* 头部背景色 */
#topMeun {
	background-color: #41e7ac;
}

#sidebar {
	background: #2cde93;
	width: 15%;
}

#myiframe {
	width: 100%;
	height: 99%;
	border-top: outset;
	border-left: outset;
	border-bottom: none;
}

.navbar-nav {
	margin: 6px;
	right: 5%;
	position: absolute;
}
</style>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
<script>
	/* 菜单按钮激活状态修改 */
	$(function() {
		$(".list-group-item").click(function() {
			$(".list-group-item").removeClass("active");
			$(this).addClass("list-group-item active");
		});
	})
</script>
</head>

<body>
	<!-- 头部 -->
	<div class="topMeun" id="topMeun">
		<div class="navbar-header" style="text-align: center">
			<p class="navbar-brand">药店管理系统</p>
		</div>
		<!-- 个人信息 -->
		<div class="collapse navbar-collapse" id="demo-navbar">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdown-toggle"
					style="color: #2b2532; font-size: x-large;" data-toggle="dropdown">${user.loginName}<span
						class="caret"></span></a>
					<ul class="dropdown-menu" role="menu"
						style="background: mintcream;">
						<li><a
							href="javascript:chagemenuPage('<c:url value='/menu/manager-info'/>')">查看个人信息</a></li>
						<li><a
							href="javascript:chagemenuPage('<c:url value='/menu/manager-info-modify'/>')">修改个人信息</a></li>
						<li><a href="../user/login">安全退出</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- 下体 -->
	<div style="width: 100%">

		<!-- 左侧菜单栏 -->
		<div id="main-container">
			<div id="sidebar" class="col-md-2 column">
				<div class="text-center" id="left-content">
					<div class="list-group">
						<a
							href="javascript:chagemenuPage('<c:url value='/menu/input-info'/>')"
							class="list-group-item active">入库信息</a>
					</div>
					<div class="list-group">
						<a
							href="javascript:chagemenuPage('<c:url value='/menu/output-info'/>')"
							class="list-group-item">出库信息</a>
					</div>
					<div class="list-group">
						<a href="javascript:chagemenuPage('<c:url value='/menu/inventory-info'/>')"
							class="list-group-item">库存信息</a>
					</div>
					<div class="list-group">
						<a
							href="javascript:chagemenuPage('<c:url value='/menu/input-medicine'/>')"
							class="list-group-item">采购药品</a>
					</div>
					<div class="list-group">
						<a
							href="javascript:chagemenuPage('<c:url value='/menu/output-medicine'/>')"
							class="list-group-item">药品出库</a>
					</div>
					<div class="list-group">
						<a
							href="javascript:chagemenuPage('<c:url value='/menu/profit-info'/>')"
							class="list-group-item">盈利情况</a>
					</div>
					<div class="list-group">
						<a href="javascript:chagemenuPage('<c:url value='/menu/search-customer'/>')"
							class="list-group-item">数据查询</a>
					</div>
				</div>
			</div>
		</div>

		<!-- 右中内容展示页 -->
		<div class="col-md-10 column">
			<div style="text-align: center; width: 100%; height: 665px;">
				<!-- 默认入库查询页面 -->
				<iframe frameborder="none" scrolling="auto" id="myiframe"
					src="../menu/input-info"></iframe>
			</div>
		</div>

	</div>



	<script type="text/javascript">
		/* 点击菜单按钮更新iframe中的页面内容 */
		function chagemenuPage(url) {
			document.getElementById("myiframe").src = url
		}
		/* 跳转登录页面,因为在iframe中所有请求都属于iframe,需要iframe中调用父级方法跳转登录页面 */
		function toLoginPage() {
			window.location.href = "<c:url value='/user/login'/>"
		}
	</script>

</body>
</html>