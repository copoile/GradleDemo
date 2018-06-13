<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>demo页面</title>
<%@ include file="/WEB-INF/jsp/inc/css-link.inc"%>
<%@ include file="/WEB-INF/jsp/inc/js-link.inc"%>
</head>

<body class="gray-bg">
	<div id="header"></div>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox">
					<div class="ibox-title">
						<h5>查询条件</h5>
					</div>
					<div class="ibox-content">
						<form method="post" class="form-horizontal">
							<div class="form-group">
								<label class="rol-sm-1 control-label">时间</label>
								<div class="row-sm-2" style="display: inline;">
									<input id="startDate" name="startDate" type="text"> <span>-</span>
									<input id="endDate" type="text" name="endDate">
								</div>
								<label class="col-sm-1 control-label">用户编码</label>
								<div class="col-sm-2">
									<input type="text" class="form-control input-sm" id="id">
								</div>
								<label class="col-sm-1 control-label">客户名称</label>
								<div class="col-sm-2">
									<input type="text" class="form-control input-sm" id="name"
										placeholder="模糊查询">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-9">
									<a class="btn btn-xs btn-primary" type="button"
										href="javascript:search();">查 询</a> <a
										class="btn btn-xs btn-default" type="button"
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
					<div class="ibox-title">
						<h5>查询结果</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-bordered" id="table"></table>
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


	<!-- 用户信息修改模态框 -->
	<div class="modal fade" id="updateusermodel" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h5 class="modal-title" style="text-align: center">用户信息修改</h5>
				</div>
				<form id="updateuserform" action="javascript:register()">
					<div class="modal-body">
						<!-- id项隐藏 -->
						<input type="text" id="up_id" hidden="true">
						<div class="input-group">
							<span class="input-group-addon">&nbsp;用&nbsp;户&nbsp;名</span> <input
								type="text" class="form-control" name="name" id="up_name">
						</div>
						<br />
						<div class="input-group">
							<span class="input-group-addon">&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;</span>
							<input type="password" class="form-control" id="up_password">
						</div>
						<br />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<a type="button" href="javascript:update2()"
							class="btn btn-primary">提交</a>
					</div>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>



	<script type="text/javascript">
	/* 日期控件 */
	$(function(){
		$("#startDate").datepicker({format:'yyyy-mm-dd'});
		$("#endDate").datepicker({format:'yyyy-mm-dd'});
	});
		/* 重置清空 */
		function reset(){
			$("#name").val("");
			$("#id").val("");
			$("#startDate").val("");
			$("#endDate").val("");
		}
		
		function search() {
			$("#table").datagrid({
				url : "<c:url value='/api/user/query'/>",
				type : "get",
				data : {
					id : $("#id").val(),
					name : $("#name").val(),
					startDate : $("#startDate").val(),
					endDate : $("#endDate").val()
				},
				table : {
					id : "table",
					head : [ {
						item : "id",
						name : "用户编码"
					}, {
						item : "name",
						name : "用户名称"
					}, {
						item : "createdate",
						name : "创建时间"
					} ],

					showBtns : true,
					btns : [ {
						name : "修改",
						todo : function(row, index) {
							/* 这里的row即为userDo */
							/* 这个方法块中可以定义方法,如 */
							updateuser(row.id);
						}
					}, {
						name : "删除",
						todo : function(row, index) {
							del(row.id);
						}
					}]
				},
				page : {
					enable : true,
					id : "page",
					pageSize : 5
				}

			});
		}
		
		
		
			/* id查询用户信息,成功后调用showQuery方法将数据放到用户编辑模态框中 */
			function updateuser(id) {
				$.ajax({
					url : "<c:url value='/api/user/query/'/>" + id,
					type : "get",
					// 成功后开启模态框
					dataType : "json",
					success : showQuery
				});
			}

			function showQuery(data) {
				var data = data.data;
				$("#up_id").val(data.id);
				$("#up_name").val(data.name);
				$("#up_password").val(data.password);
				// 显示模态框
				$('#updateusermodel').modal('show');
			}
			
			
			function del(id){
				swal(  
						{  
						   title: "是否删除？",  
						   text: "用户一旦删除将无法恢复,确认删除吗?",  
						   type: "warning",  
						   showCancelButton: true,                //是否显示“取消”按钮。  
						   cancelButtonText:"取消",            //按钮内容  
						   cancelButtonColor:"#B9B9B9",  
						   showConfirmButton: true,               //是否显示“确认”按钮。  
						   confirmButtonColor: "#DD6B55",  
						   confirmButtonText: "确认",  
						   closeOnConfirm:false,  
						   closeOnCancel:true                //点击返回上一步操作  
						},  
						function(){  
						   $.ajax({  
						      type: "get",  
						      dataType: "JSON",  
						      url:"<c:url value='/api/user/del/'/>" + id, 
						      success: function (data) {  
						         if(data.message == "success") {  
						            swal("成功","删除成功", "success");  
						         } else {  
						            swal("失败",data.message, "error");  
						         }  
						      }, 
						   });  
						}  
						);  
				
			}
		
	</script>
</body>
</html>