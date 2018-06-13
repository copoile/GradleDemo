<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>盈利情况</title>
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
						<h5>查询盈利情况</h5>
					</div>
					<div class="search-content">
						<form method="post" class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-2">
									<label class="label">药品编码</label> <input type="text"
										class="form-control input-sm" id="medicineId">
								</div>
								<div class="col-sm-2">
									<label class="label">药品名称</label> <input type="text"
										class="form-control input-sm" id="medicineName" placeholder="模糊查询">
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
						<h5>药品盈利信息</h5>
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
		
		/* 重置清空 */
		function reset() {
			$("#medicineId").val("");
			$("#medicineName").val("");
		}

		function search() {
			$("#table").datagrid({
				url : "<c:url value='/api/info/profit/query'/>",
				type : "get",
				data : {
					medicineId : $("#medicineId").val(),
					medicineName : $("#medicineName").val(),
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
						item : "unitPrice",
						name : "入库单价"
					}, {
						item : "out_unitPrice",
						name : "零售单价"
					}, {
						item : "unitProfit",
						name : "单个盈利"
					}, {
						item : "out_number",
						name : "销售数量"
					}, {
						item : "totalProfit",
						name : "盈利总额"
					} ],
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