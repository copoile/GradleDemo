//插件方法
(function ($) {
    $.fn.bar = function (options) {
        // 默认配置
        var defaults = {
            type: "green", // 颜色样式 green、orange、puple、yellow
            value: 0.00, // 值
            width: "30%",
            path: "ai-percent-bar/"
        };

        // 参数配置
        var opts = $.extend(defaults, options);
        // 获取节点ID名称
        var id = $(this).attr("id");
        var font_color = "#fff";

        var this_bar = opts.path+"white-mid.png";
        var bar_left = opts.path+opts.type+"-left.png";
        var bar_right = opts.path+"white-right.png";
        var bar_mid = opts.path+opts.type+"-mid.png";
        var bar_end = opts.path+opts.type+"-right.png";

        if(opts.value <= 0){
            bar_left = opts.path+"white-left.png";
            bar_end = opts.path+"white-right.png";
            font_color = "#666";
        }
        if(opts.value >= 100){
            bar_right = opts.path+opts.type+"-right.png";
        }

        // 方法定义
        function createHtml(){
            var html = "<div id='"+id+"-bar-left'></div>";
            html += "<div id='"+id+"-bar-right'></div>";
            html += "<div id='"+id+"-bar-text'></div>";
            html += "<div id='"+id+"-bar-color'>";
            html += "<div id='"+id+"-bar-mid'></div>";
            html += "<div id='"+id+"-bar-end'></div>";
            html += "</div>";
            return html;
        }

        // 创建结构
        $(this).html(createHtml());
        // 设置样式
        // 主节点样式
        $(this).css({"position":"relative", "margin":"0 16px", "width":opts.width, "height":"17px", "background":"url('"+this_bar+"') repeat-x"});
        $("#"+id+"-bar-left").css({"position":"absolute", "width":"16px", "height":"17px", "left":"-16px", "background":"url('"+bar_left+"') no-repeat"});
        $("#"+id+"-bar-right").css({"position":"absolute", "width":"16px", "height":"17px", "right":"-16px", "background":"url('"+bar_right+"') no-repeat"});
        $("#"+id+"-bar-text").css({"position":"absolute", "left":(opts.value-8)/2+"%","color":font_color, "height":"17px", "line-height":"18px", "font-size":"10px"});
        $("#"+id+"-bar-color").css({"overflow":"hidden", "height":"17px"});
        $("#"+id+"-bar-mid").css({"float":"left", "width":opts.value+"%", "height":"17px", "background":"url('"+bar_mid+"') repeat-x"});
        $("#"+id+"-bar-end").css({"float":"left", "width":"16px", "height":"17px", "background":"url('"+bar_end+"') no-repeat"});
        $("#"+id+"-bar-text").html(opts.value+"%");
        if(opts.value <= 0){
            $("#"+id+"-bar-end").css("display","none");
        }
    }
})(jQuery);
