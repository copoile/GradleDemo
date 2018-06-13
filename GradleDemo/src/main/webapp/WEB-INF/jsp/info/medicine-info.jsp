<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>药品信息</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>
<style type="text/css">
</style>
<body>

	<!-- 药品信息 -->
	<div class="manager-title">药品信息</div>
	<div class="manager" id="maneger">
		<table class="maneger-table">
			<tbody>
				<tr>
					<td>药品编号</td>
					<td><span class="baseinfo">${user.userId}</span></td>
				</tr>
				<tr>
				<tr>
					<td>药品名称</td>
					<td><span class="baseinfo">${user.userName}</span></td>
				</tr>

				<tr>
					<td>规格</td>
					<td><span class="baseinfo">${user.address}</span></td>
				</tr>
				<tr>
					<td>生产日期</td>
					<td><span class="baseinfo">${user.phone}</span></td>
				</tr>
				<tr>
					<td>有限期</td>
					<td><span class="baseinfo">${user.email}</span></td>
				</tr>
				<tr>
					<td>包装</td>
					<td><span class="baseinfo">${user.userId}</span></td>
				</tr>
				<tr>
				
				<tr>
					<td>类别</td>
					<td><span class="baseinfo">${user.address}</span></td>
				</tr>
				<tr>
					<td>批号</td>
					<td><span class="baseinfo">${user.phone}</span></td>
				</tr>
				<tr>
					<td>入库单价</td>
					<td><span class="baseinfo">${user.email}</span></td>
				</tr>
				<tr>
					<td>出库单价</td>
					<td><span class="baseinfo">${user.userId}</span></td>
				</tr>
				<tr>
				<tr>
					<td>单位</td>
					<td><span class="baseinfo">${user.userName}</span></td>
				</tr>

				<tr>
					<td>备注</td>
					<td><span class="baseinfo">${user.address}</span></td>
				</tr>

			</tbody>
		</table>

	</div>
</body>
</html>




