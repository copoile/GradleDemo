<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>采购药品</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>
<style type="text/css">
#se{
	border-color: #e1e1f3;
	border-style: ridge;
	height: 52px;
}
</style>
<body>

	<!-- 采购药品 -->
	<div class="enter-title">采购药品</div>
	<div class="notice">注意：带&nbsp;*&nbsp;号的必须填写</div>
	<div class="enter" id="enter">
		<form method="post" name="input" id="input"
			action="javascript:input()">
			<table class="enter-table">
				<tbody>

					<tr>
						<td><FONT color=#ff0000>*</FONT>药品名称</td>
						<td><input type="text" class="input-info" name="medicineName" /></td>
					</tr>

					<tr>
						<td>规格</td>
						<td><input type="text" class="input-info"
							name="specification" /></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>生产日期</td>
						<td><input type="text" class="input-info" name="producedDate"
							id="producedDate" /></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>有限期</td>
						<td><input type="text" class="input-info" name="limited"
							id="limited" /></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>入库日期</td>
						<td><input type="text" class="input-info" name="inputtime"
							id="inputtime" /></td>
					</tr>
					<tr>
						<td>包装</td>
						<td><input type="text" class="input-info" name="packaging" /></td>
					</tr>
					<tr>
					<tr>
						<td>类别</td>
						<td><input type="text" class="input-info" name="type" /></td>
					</tr>
					<tr>
						<td>批号</td>
						<td><input type="text" class="input-info" name="batchNumber" /></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>入库单价</td>
						<td><input type="text" class="input-info" name="unitPrice" /></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>数量</td>
						<td><input type="text" class="input-info" name="number" /></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" class="input-info" name="unit" /></td>
					</tr>

					<tr>
						<td>备注</td>
						<td><input type="text" class="input-info" name="remark" /></td>
					</tr>


					<tr>
						<td><FONT color=#ff0000>*</FONT>厂商名称</td>
						<td>
							<select  id="se" class="input-info" name="manufacturerId">
								<c:forEach items="${list}" var="manufacturer">
									<option value="${manufacturer.manufacturerId}">${manufacturer.manufacturerName}</option>
								</c:forEach>
						</select>
							</td>
					</tr>
				</tbody>
				<tfoot>
					<TR>
						<TD colSpan=3 style="background: none;">
							<DIV align=center>
								<INPUT class="buttom" type="button" value=确认采购
									onclick="javascript:checkuinput()" /> &nbsp;&nbsp; <INPUT
									class="buttom" type="reset" value=重置 />
							</DIV>
						</TD>
					</TR>
				</tfoot>
			</table>
		</form>
		<iframe id="rfFrame" name="rfFrame" src="about:blank"
			style="display: none;"></iframe>
	</div>
	<script type="text/javascript">
		/* 日期控件 */
		$(function() {
			var producedDate = $("#producedDate").datepicker({
				format : 'yyyy-mm-dd'

			});
			var limitedDate = $("#limited").datepicker({
				format : 'yyyy-mm-dd'
			});
			$("#inputtime").datepicker({
				format : 'yyyy-mm-dd'
			});
		});
		/* 注册表单提交 */
		function input() {
			$.ajax({
				type : "post",
				url : "<c:url value='/api/info/input'/>",
				data : $('#input').serialize(),
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						swal("成功", "采购成功", "success");
					} else {
						swal("失败", "采购失败", "error");
					}
				}
			});
		}
	</script>
</body>
</html>




