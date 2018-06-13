<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>厂商信息</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>
<style type="text/css">

</style>
<body>

	<!-- 客户信息 -->
	<div class="manager-title">厂商信息</div>
	<div class="manager" id="maneger">
		<table class="maneger-table">
			<tbody>
				<tr>
					<td> 厂商编号</td>
					<td><span class="baseinfo">${user.userId}</span></td>
				</tr>
				<tr>
				<tr>
					<td>厂商名称</td>
					<td><span class="baseinfo">${user.userName}</span></td>
				</tr>
				
				<tr>
					<td>地址</td>
					<td><span class="baseinfo">${user.address}</span></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><span class="baseinfo">${user.phone}</span></td>
				</tr>
				<tr>
					<td>电子邮箱</td>
					<td><span class="baseinfo">${user.email}</span></td>
				</tr>
			</tbody>
		</table>

	</div>
	</body>
</html>




