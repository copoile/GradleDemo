<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改个人信息</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>
<style type="text/css">
.maneger-table td:first-child {
	/* background: #bae6df; */
	width: 165px;
}

#bottom {
	color: #fff;
	background-color: #1abc9c;
	border-radius: 4px;
}
</style>
<body>

	<!-- 修改个人信息 -->
	<div class="manager-title">管理员个人信息</div>
	<div class="notice">注意：带&nbsp;*&nbsp;号的必须填写</div>
	<div class="manager" id="maneger" style="left: 15%;">
		<form method="post" name="update" id="modify" 
			action="javascript:modify()">
			<table class="maneger-table" style="width: 800px;">
				<tbody>
					<tr>
						<td>管理员编号</td>
						<td><span class="baseinfo"><input readonly="readonly"
								style="background: none;; border: 0; text-align: center;"
								value="${user.userId}" name="userId" /></span></td>
						<TH><FONT color=#ff0000>管理员编号不可更改</FONT></TH>
					</tr>
					<tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>姓名</td>
						<td><span class="baseinfo"><input
								value="${user.userName}" name="userName" /> </span></td>
						<TH><FONT color=#ff0000>请填写管理员真实姓名</FONT></TH>
					</tr>

					<tr>
						<td><FONT color=#ff0000>*</FONT>登录名</td>
						<td><span class="baseinfo"><input
								value="${user.loginName}" name="loginName" /> </span></td>
						<TH><FONT color=#ff0000>登录名可使用长度为0-16的任何字符</FONT></TH>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>密码</td>
						<td><span class="baseinfo"><input
								value="${user.password}" type="password" name="password" /> </span></td>
						<TH><FONT color=#ff0000>密码可使用长度为3-14的任何字符，并区分英文字母大小写</FONT>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>确认密码</td>
						<td><span class="baseinfo"><input
								value="${user.password}" type="password" name="confirmpassword" />
						</span></td>
						<TH><FONT color=#ff0000>请再输入一次密码</FONT></TH>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>密码提示问题</td>
						<td><span class="baseinfo"><input
								value="${user.questionPassword}" name="questionPassword" /></span></td>
						<TH><FONT color=#ff0000>例如：我的哥哥是谁？</FONT></TH>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>密码提示答案</td>
						<td><span class="baseinfo"><input
								value="${user.answerPassword}" name="answerPassword" /></span></td>
						<TH><FONT color=#ff0000>例如：我的哥哥是小明</FONT></TH>
					</tr>
					<tr>
						<td>地址</td>
						<td><span class="baseinfo"><input
								value="${user.address}" name="address" /></span></td>
						<TH><FONT color=#ff0000>请输入你的常住地址</FONT></TH>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>电话</td>
						<td><span class="baseinfo"><input
								value="${user.phone}" name="phone" /></span></td>
						<TH><FONT color=#ff0000>请输入你的电话号码或手机号</FONT></TH>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>电子邮箱</td>
						<td><span class="baseinfo"><input
								value="${user.email}" name="email" /></span></td>
						<TH><FONT color=#ff0000>请输入您常用的电子邮箱</FONT></TH>
					</tr>
				</tbody>
				<tfoot>
					<TR>
						<TD colSpan=3 style="background: none;">
							<DIV align=center>
								<INPUT class="buttom" type="button" value=修改 onclick="javascript:checkupdate()" /> &nbsp;&nbsp; <INPUT
									class="buttom" type="reset" value=重置 />
							</DIV>
						</TD>
					</TR>
				</tfoot>
			</table>
		</form>
		<iframe id="rfFrame" name="rfFrame" src="about:blank" style="display:none;"></iframe>  
	</div>
	<script type="text/javascript">
		/* 注册表单验证 */
		

		/* 注册表单提交 */
		function modify() {
			$.ajax({
				type : "post",
				url : "<c:url value='/api/user/modify'/>",
				data : $('#modify').serialize(),
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						swal("成功", "修改成功", "success");
					} else {
						alert(data.message);
						/* swal("失败", data.message, "error"); */
					}
				}
			});
		}
	</script>
</body>
</html>




