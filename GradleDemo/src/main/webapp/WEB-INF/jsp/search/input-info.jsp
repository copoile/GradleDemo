<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>入库信息</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>
<style type="text/css">
body {
	background: #f3f6f5;
}
</style>

<body class="input-body">
	<div id="header"></div>
	<div class="search">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox">
					<div class="search-title">
						<h5>查询药品入库信息</h5>
					</div>
					<div class="search-content">
						<form method="post" class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-2">
									<label class="label">药品编码</label> <input type="text"
										class="form-control input-sm" id="medicineId"
										name="medicineId">
								</div>
								<div class="col-sm-2">
									<label class="label">药品名称</label> <input type="text"
										class="form-control input-sm" id="medicineName"
										name="medicineName" placeholder="模糊查询">
								</div>
								<div class="col-sm-2" style="display: inline;">
									<label class="label">入库时间</label> <input id="inputtime"
										name="inputtime" class="form-control input-sm" type="text">
								</div>
							</div>
							<div class="btn" style="padding: 0px 17px;">
								<div class="btn-search">
									<a class="btn-xs btn-primary" type="button"
										href="javascript:search();">查 询</a> <a
										class="btn-xs btn-default" type="button"
										href="javascript:reset();">清除</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox">
					<div class="search-title">
						<h5>药品入库信息</h5>
					</div>
					<div class="search-content">
						<table class="search-enter-table" id="table">
						</table>
						<div class="ai-tool">
							<div class="ai-left"></div>
							<div class="ai-right">
								<div class="ai-pagination" id="page"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>






	<script type="text/javascript">
		/* 日期控件 */
		$(function() {
			$("#inputtime").datepicker({
				format : 'yyyy-mm-dd'
			});

		});
		/* 重置清空 */
		function reset() {
			$("#medicineName").val("");
			$("#medicineId").val("");
			$("#inputtime").val("");
		}

		function search() {
			$("#table").datagrid({
				url : "<c:url value='/api/info/input/query'/>",
				type : "get",
				data : {
					medicineId : $("#medicineId").val(),
					medicineName : $("#medicineName").val(),
					inputtime : $("#inputtime").val()
				},
				table : {
					id : "table",
					head : [ {
						item : "medicineId",
						name : "药品编号"
					}, {
						item : "medicineName",
						name : "药品名称"
					}, {
						item : "inputtime",
						name : "入库时间"
					}, {
						item : "unitPrice",
						name : "药品单价"
					}, {
						item : "number",
						name : "数量"
					}, {
						item : "type",
						name : "药品类别"
					}, {
						item : "manufacturerName",
						name : "厂商"
					}, {
						item : "medicineId",
						name : "入库单号"
					}
					],
				},
				page : {
					enable : true,
					id : "page",
					pageSize : 5
				}

			});
		}

	
	</script>
</body>
</html>