<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>药品出库</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>
<style type="text/css">
</style>
<body>

	<!-- 采购药品 -->
	<div class="enter-title">药品出库</div>
	<div class="notice">注意：带&nbsp;*&nbsp;号的必须填写</div>
	<div class="output" id="output-div">
		<form method="post" name="output" id="output"
			action="javascript:output()">
			<table class="output-table">
				<tbody>

					<tr>
						<td><FONT color=#ff0000>*</FONT>药品</td>
						<td><select  class="input-info" name="medicineId" id="medicineId">
								<c:forEach items="${inventorylist}" var="inventory">
									<option value="${inventory.medicineId}">${inventory.medicineId}-${inventory.medicineName}</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td><FONT color=#ff0000>*</FONT>出库日期</td>
						<td><input type="text" class="input-info" name="outTime"
							id="outTime" /></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>出库单价</td>
						<td><input type="text" class="input-info" name="unitPrice" id="unitPrice"/></td>
					</tr>
					<tr>
						<td><FONT color=#ff0000>*</FONT>数量</td>
						<td><input type="text" class="input-info" name="number" id="number"/></td>
					</tr>

					<tr>
						<td><FONT color=#ff0000>*</FONT>客户名称</td>
						<td><select  id="customerId" class="input-info" name="customerId">
								<c:forEach items="${customerlist}" var="customer">
									<option value="${customer.customerId}">${customer.customerName}</option>
								</c:forEach>
						</select></td>
					</tr>
				</tbody>
				<tfoot>
					<TR>
						<TD colSpan=3 style="background: none;">
							<DIV align=center>
								<INPUT class="buttom" type="button" value=确认出库
									onclick="javascript:checkuoutput()" /> &nbsp;&nbsp; <INPUT
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
			$("#outTime").datepicker({
				format : 'yyyy-mm-dd'
			});
		});
		/* 注册表单提交 */
		function output() {
			var json = {
						"medicineId" : $("#medicineId").val(),
						"outTime" : $("#outTime").val(),
						"unitPrice" : $("#unitPrice").val(),
						"number" : $("#number").val(),
						"customerId" : $("#customerId").val()
				};
			$.ajax({
				type : "post",
				url : "<c:url value='/api/info/out'/>",
				contentType : "application/json;charset=utf-8",
				data : JSON.stringify(json),
				dataType : "json",
				success : function(data) {
					if (data.message == "success") {
						swal("成功", "出库成功", "success");
					} else {
						swal("失败", data.message, "error");
					}
				}
			});
		}
	</script>
</body>
</html>




