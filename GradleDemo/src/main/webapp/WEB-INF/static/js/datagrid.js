//全局变量
var sdpBtnAction;
var sdpData;
var sdpPage;
var pageAction;
//插件方法
(function ($) {
    $.fn.datagrid = function (options) {
        // 默认配置
        var defaults = {};

        // 参数配置
        var opts = $.extend(defaults, options);
        var tableNode = $("#"+opts.table.id);
        var pageNode = $("#"+opts.page.id);
        // 清空内容
        loadData();

        // 方法
        // 创建表格头数据
        function createThead(){
            var html = "<thead><tr>";
            for(var i = 0; i < opts.table.head.length; i++){
                html += "<th>";
                html += opts.table.head[i].name;
                html += "</th>";
            }
            if(opts.table.showBtns){
                html += "<th>操作</th>";
            }
            html += "</tr></thead>";
            tableNode.append(html);
        }

        // 创建表格体数据2
        function createTbody(data){
            var html = "<tbody>";
            for(var i = 0; i < data.length; i++){
                html += "<tr>";
                for(var j = 0; j < opts.table.head.length; j++){
                    html += "<td>";
                    var val = data[i][opts.table.head[j].item];
                    if(val == null || val == undefined){
                    	val = "";
                    }
                    html += val;
                    html += "</td>";
                }
                if(opts.table.showBtns){
                    html += "<td>";
                    for(var j = 0; j < opts.table.btns.length; j++){
                        sdpBtnAction = function (callback,index){
                            callback(sdpData[index],index);
                        }
                        html += "<a href='javascript:sdpBtnAction("+opts.table.btns[j].todo+","+i+");' class='btn btn-xs btn-primary'>"+opts.table.btns[j].name+"</a> ";
                    }
                    html += "</td>";
                }
                html += "</tr>";
            }
            html += "</tbody>";
            tableNode.append(html);
        }

        // 创建分页栏
        function createPagination(data){
            if(opts.page.enable){
                var html = "<div class='ai-pagination-head'>共<span class='ai-pagination-val'>"
                    +data.pageCount+"</span>页<span class='ai-pagination-val'>"
                    +data.recordCount+"</span>条数据</div>";
                html += "<ul class='pagination ai-pagination-body'>";
                // 分页头
                if(data.currentPage <= 1){
                    html += "<li class='disabled active'><a href='javascript:void(0);'>&laquo;</a></li>";
                }else{
                    html += "<li class='active'><a href='javascript:pageAction(1);'>&laquo;</a></li>";
                }
                // 分页内部
                var minPage = (data.currentPage - 3) < 1 ? 1 : (data.currentPage - 3);
                var maxPage = (data.currentPage + 3) > data.pageCount ? data.pageCount : (data.currentPage + 3);
                for(var i = minPage; i <= maxPage; i++){
                    if(i == data.currentPage){
                        html += "<li class='active'><a href='javascript:void(0);'>"+i+"</a></li>";
                    }else{
                        html += "<li class='active'><a href='javascript:pageAction("+i+");'>"+i+"</a></li>";
                    }
                }
                // 分页尾
                if(data.currentPage >= data.pageCount){
                    html += "<li class='disabled active'><a href='javascript:void(0);'>&raquo;</a></li>";
                }else{
                    html += "<li class='active'><a href='javascript:pageAction("+data.pageCount+");'>&raquo;</a></li>";
                }
                html += "</ul>";
                pageNode.append(html);
            }
        }

        pageAction = function (index){
        	if(typeof(_aiDatagridFlag) == "undefined"){
        		_aiDatagridFlag = false;
        	}
        	if(_aiDatagridFlag){
        		return;
        	}
        	// 节点清空
            tableNode.html("");
            pageNode.html("");
            var queryParams = "";
            if(opts.url.indexOf("?") == -1) {
            	queryParams = "?currentPage=" + index +"&pageSize="+opts.page.pageSize;
            } else {
            	queryParams = "&currentPage=" + index +"&pageSize="+opts.page.pageSize;
            }
            if(opts.page.enable) {
                opts.data.currentPage = index;
                opts.data.pageSize = opts.page.pageSize;
            }
            $.ajax({
                type: opts.type,
                url: opts.url+queryParams,
                data: opts.data,
                contentType:opts.contentType,
                dataType: "json",
                beforeSend:function(){
                	_aiDatagridFlag = true;
                	tableNode.after("<div class='sk-spinner sk-spinner-circle'>"
                			+"<div class='sk-circle1 sk-circle'></div>"
                			+"<div class='sk-circle2 sk-circle'></div>"
                			+"<div class='sk-circle3 sk-circle'></div>"
                			+"<div class='sk-circle4 sk-circle'></div>"
                			+"<div class='sk-circle5 sk-circle'></div>"
                			+"<div class='sk-circle6 sk-circle'></div>"
                			+"<div class='sk-circle7 sk-circle'></div>"
                			+"<div class='sk-circle8 sk-circle'></div>"
                			+"<div class='sk-circle9 sk-circle'></div>"
                			+"<div class='sk-circle10 sk-circle'></div>"
                			+"<div class='sk-circle11 sk-circle'></div>"
                			+"<div class='sk-circle12 sk-circle'></div>"
                			+"</div>");
                },
                complete : function(xhr,textstatus) {
                	tableNode.next().remove();
                	_aiDatagridFlag = false;
    				var ct = xhr.getResponseHeader("content-type");
    				if(ct.indexOf("text/html") > -1){
    					document.write(xhr.responseText);
    					document.close();
    				}
    			},
                
                success:function(data){
                	// 全局数据加载
                	if(data && data.message !="success") {
                		swal("失败",data.message,"error");
            			return;
            		}
                	data =data.data;
                	if(typeof(data)!="undefined"){
                		sdpData = data.tbody;
                		sdpPage = data.page;
                		// 节点清空
                		tableNode.html("");
                		pageNode.html("");
                		// 创建节点
                		createThead();
                		createTbody(data.tbody);
                		createPagination(data.page);
                	}
                	
                }
            });
        }

        //数据加载
        function loadData(){
        	if(typeof(_aiDatagridFlag) == "undefined"){
        		_aiDatagridFlag = false;
        	}
        	if(_aiDatagridFlag){
        		return;
        	}
        	// 节点清空
            tableNode.html("");
            pageNode.html("");
            var queryParams = "";
            if(opts.type != "GET") {
            	if(opts.url.indexOf("?") == -1) {
                	queryParams =  "?currentPage=" + 1 +"&pageSize="+opts.page.pageSize;
                } else {
                	queryParams = "&currentPage=" + 1 +"&pageSize="+opts.page.pageSize;
                }
            }
            if(opts.page.enable){
                opts.data.currentPage = 1;
                opts.data.pageSize = opts.page.pageSize;
            }
            $.ajax({
                type: opts.type,
                url: opts.url+queryParams,
                data: opts.data,
                dataType: "json",
                contentType:opts.contentType,
                beforeSend:function(){
                	_aiDatagridFlag = true;
                	tableNode.after("<div class='sk-spinner sk-spinner-circle'>"
                			+"<div class='sk-circle1 sk-circle'></div>"
                			+"<div class='sk-circle2 sk-circle'></div>"
                			+"<div class='sk-circle3 sk-circle'></div>"
                			+"<div class='sk-circle4 sk-circle'></div>"
                			+"<div class='sk-circle5 sk-circle'></div>"
                			+"<div class='sk-circle6 sk-circle'></div>"
                			+"<div class='sk-circle7 sk-circle'></div>"
                			+"<div class='sk-circle8 sk-circle'></div>"
                			+"<div class='sk-circle9 sk-circle'></div>"
                			+"<div class='sk-circle10 sk-circle'></div>"
                			+"<div class='sk-circle11 sk-circle'></div>"
                			+"<div class='sk-circle12 sk-circle'></div>"
                			+"</div>");
                },
                complete : function(xhr,textstatus) {
                	tableNode.next().remove();
                	_aiDatagridFlag = false;
    				var ct = xhr.getResponseHeader("content-type");
    				if(ct.indexOf("text/html") > -1){
    					document.write(xhr.responseText);
    					document.close();
    				}
    			},
                
                success:function(data){
                	if(data && data.message !="success") {
            			swal("失败",data.message,"error");
            			return;
            		}
                	// 全局数据加载
            		data =data.data;
            		if(typeof(data)!="undefined"){
            			sdpData = data.tbody;
            			sdpPage = data.page;
            			// 节点清空
            			tableNode.html("");
            			pageNode.html("");
            			// 创建节点
            			createThead();
            			createTbody(data.tbody);
            			createPagination(data.page);
            		}
                }
            });
        }
    };
})(jQuery);