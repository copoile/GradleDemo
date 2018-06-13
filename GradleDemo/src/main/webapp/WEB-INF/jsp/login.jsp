<!-- 定义页面编码及导入c标签等 -->
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>登录</title>
<!--  css样式及js统一导入 -->
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
<style type="text/css">
/*  登录页背景图片 */
body {
	background-image: url(<c:url value='/st/image/login.jpg'/>);
	background-size: cover;
}
.modal-content {
    width: 100%;
    position: fixed;
    margin-top: -44%;
}
*{margin:0;padding:0;}
   ul,li{list-style:none;}
   .auto-tip li{width:100%;height:22px;line-height:22px;font-size:14px;}
   .auto-tip li.hoverBg{background:#ddd;cursor:pointer;}
   .red{color:red;}
   .hidden {display:none;}
</style>

</head>

<body class="signin">
	<div class="signinpanel">
		<div class="row">
			<div class="col-sm-7">
				<div class="signin-info">
					<!-- 这个div中写标题 -->
					<div class="logopanel m-b ai-login-title">药品管理系统</div>
					<!-- pre标签中写系统简介,该标签可以自由换行,可定义字体颜色 -->
					<pre style="opacity: 0.6;">药品管理系统可以清楚了了解药品入库出库信息，方便管理药品的进出。</pre>
				</div>
			</div>
			<!--  登录框部分 -->
			<div class="col-sm-5">
				<form id="loginForm" style="text-align: center">
					<h6 class="no-margins">系统登录</h6>
					<input type="text" class="form-control uname" placeholder="登录名"
						name="loginname" /> <input class="form-control pword m-b"
						type="password" placeholder="密码" name="password" /> <a
						class="btn btn-primary btn-block" onclick="javascript:login()">登录</a>
					<div>
						<a data-toggle="modal" data-target="#registermodal"> <span>注册</span>
						</a> <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <a
							data-toggle="modal" data-target="#forgetpasswordmodal"> <span>忘记密码</span>
						</a>
					</div>
				</form>
			</div>
		</div>

	</div>


	<!-- 注册模态框 -->
	<div class="modal fade" id="registermodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h5 class="modal-title" style="text-align: center">注册</h5>
				</div>
				<form id="registerform" action="javascript:register()" name="registerform">
					<div class="modal-body">
						<div style="height: 40px;"></div>
						<div class="input-group">
							<span class="input-group-addon">&nbsp;登&nbsp;录&nbsp;名</span> <input
								type="text" class="form-control" name="loginName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;</span>
							<input type="text" class="form-control" name="userName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;</span>
							<input type="password" class="form-control" name="password"
								id="password">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">确认密码</span> <input
								type="password" class="form-control" name="confirmpassword">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">密码提示问题</span> <input type="text"
								class="form-control" name="questionPassword">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">密码提示答案</span> <input type="text"
								class="form-control" name="answerPassword">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;地&nbsp;&nbsp;&nbsp;址&nbsp;&nbsp;&nbsp;</span>
							<input type="text" class="form-control" name="address">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;&nbsp;话&nbsp;&nbsp;&nbsp;</span>
							<input type="text" class="form-control" name="phone">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">电子邮件</span> <input type="text"
								class="form-control email" name="email">
						</div>
						<br />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<a type="button" href="javascript:registervalite()"
							class="btn btn-primary">提交</a>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 忘记密码模态框 -->
	<div class="modal fade" id="forgetpasswordmodal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h5 class="modal-title" style="text-align: center">忘记密码</h5>
				</div>
				<form id="forgetPasswordform" action="javascript:forgetPassword()" name="forgetPasswordform">
					<div class="modal-body">
						<div style="height: 40px;"></div>
						<div class="input-group">
							<span class="input-group-addon">&nbsp;登&nbsp;录&nbsp;名</span> <input
								type="text" class="form-control" name="loginName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;姓&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;</span>
							<input type="text" class="form-control" name="userName">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;</span>
							<input type="password" class="form-control" name="password"
								id="password">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">确认密码</span> <input
								type="password" class="form-control" name="confirmpassword">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">密码提示问题</span> <input type="text"
								class="form-control" name="questionPassword">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">密码提示答案</span> <input type="text"
								class="form-control" name="answerPassword">
						</div>
						
						<br />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<a type="button" href="javascript:forgetpasswordvalite()"
							class="btn btn-primary">提交</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function login() {
			/*  ajax表单提交 */
			$.ajax({
				type : "post",
				url : "<c:url value='/api/user/login'/>",
				data : $('#loginForm').serialize(),
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						/* 返回成功后跳转菜单页 */
						window.location.href = "<c:url value='/menu/index'/>"
					} else {
						/* swal是一样弹窗提示,第一个参数为标题,第二个参数为提示内容,第三个参数为类型,常用有error和success */
						swal("登录失败", data.message, "error");
					}
				}
			});

		}

		/* 注册表单验证 */
		function registervalite() {
			$('#registerform').submit();
		}
		$(function() {
			$("#registerform").validate({
				rules : {
					loginName : {
						required : true,
						maxlength : 16
					},
					userName : {
						required : true,
						maxlength : 16
					},
					password : {
						required : true,
						minlength : 3,
						maxlength : 14
					},
					confirmpassword : {
						equalTo : "#password"
					},
					questionPassword : {
						required : true
					},
					answerPassword : {
						required : true
					},
					phone : {
						required : true,
						maxlength : 12
					},
					email : {
						required : true
					}
				},
				messages : {
					loginName : {
						required : "请输入登录名,并且长度不超过16位数"
					},
					userName : {
						required : "请输入真实姓名"
					},
					password : {
						required : "请输入密码",
						minlength : "密码长度为3-14位数"
					},
					confirmpassword : {
						equalTo : "两次密码不一致"
					},
					questionPassword : {
						required : "密码提示问题不能为空"
					},
					answerPassword : {
						required : "密码提示答案不能为空"
					},
					phone : {
						required : "电话不能为空",
						maxlength : "电话号码不能多于12位数"
					},
					email : {
						required : "电子邮件不能为空"
					}

				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});

		/* 注册表单提交 */
		function register() {
			$.ajax({
				type : "post",
				url : "<c:url value='/api/user/register'/>",
				data : $('#registerform').serialize(),
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						swal("成功", "注册成功", "success");
						/* 注册成功后点击确定按钮后隐藏注册模态框 */
						$('#registermodal').modal('hide');
					} else {
						/* alert(data.message); */
						 swal("失败", data.message, "error") ;
					}
				}
			});
		}
		/* 忘记密码表单验证 */
		function forgetpasswordvalite() {
			$('#forgetPasswordform').submit();
		}
		$(function() {
			$("#forgetPasswordform").validate({
				rules : {
					loginName : {
						required : true,
						maxlength : 16
					},
					userName : {
						required : true,
						maxlength : 16
					},
					password : {
						required : true,
						minlength : 3,
						maxlength : 14
					},
					confirmpassword : {
						equalTo : "#password"
					},
					questionPassword : {
						required : true
					},
					answerPassword : {
						required : true
					}
				},
				messages : {
					loginName : {
						required : "请输入登录名"
					},
					userName : {
						required : "请输入真实姓名"
					},
					password : {
						required : "请输入密码",
						minlength : "密码长度为3-14位数"
					},
					confirmpassword : {
						equalTo : "两次密码不一致"
					},
					questionPassword : {
						required : "密码提示问题不能为空"
					},
					answerPassword : {
						required : "密码提示答案不能为空"
					}
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
		});

		/* 忘记密码表单提交 */
		function forgetPassword() {
			$.ajax({
				type : "post",
				url : "<c:url value='/api/user/forgetPassword'/>",
				data : $('#forgetPasswordform').serialize(),
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						swal("成功", "修改密码成功", "success");
						/* 注册成功后点击确定按钮后隐藏注册模态框 */
						$('#forgetpasswordmodal').modal('hide');
					} else {
						 swal("失败", data.message, "error") ;
					}
				}
			});
		}
	</script>
</body>
</html>