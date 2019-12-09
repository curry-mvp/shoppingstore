(function($){
	var ms = {
		init:function(obj,args){
			return (function(){
				ms.fillHtml(obj,args);
				ms.bindEvent(obj);
			})();
		},
		//填充html
		fillHtml:function(obj,args){
			return (function(){
				obj.empty();
				//上一页
				if(args.current > 1){
					obj.append('<a href="javascript:;" class="prevPage">上一页</a>');
				}else{
					obj.remove('.prevPage');
					obj.append('<span class="disabled">上一页</span>');
				}
				
				//中间页码
				if(args.current != 1 && args.current >= 4 && args.pageCount != 4){
					obj.append('<a href="javascript:;" class="tcdNumber">'+1+'</a>');
				}
				if(args.current-2 > 2 && args.current <= args.pageCount && args.pageCount > 5){
					obj.append('<span class="ellipsis">...</span>');
				}
				var start = args.current -2,end = args.current+2;
				if((start > 1 && args.current < 4)||args.current == 1){
					end++;
				}
				if(args.current > args.pageCount-4 && args.current >= args.pageCount){
					start--;
				}
				for (;start <= end; start++) {
					if(start <= args.pageCount && start >= 1){
						if(start != args.current){
							obj.append('<a href="javascript:;" class="tcdNumber">'+ start +'</a>');
						}else{
							obj.append('<span class="current">'+ start +'</span>');
						}
					}
				}
				if(args.current + 2 < args.pageCount - 1 && args.current >= 1 && args.pageCount > 5){
					obj.append('<span class="ellipsis">...</span>');
				}
				if(args.current != args.pageCount && args.current < args.pageCount -2  && args.pageCount != 4){
					obj.append('<a href="javascript:;" class="tcdNumber">'+args.pageCount+'</a>');
				}
				//下一页
				if(args.current < args.pageCount){
					obj.append('<a href="javascript:;" class="nextPage">下一页</a>');
				}else{
					obj.remove('.nextPage');
					obj.append('<span class="disabled">下一页</span>');
				}
				
			})();
		},
		//绑定事件
		bindEvent:function(obj){
			return (function(){
				obj.off("click");
				obj.on("click","a.tcdNumber",function(){
					var current = parseInt($(this).text());
					v_current = current;
					ms.fillHtml(obj,{"current":v_current,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(v_current);
					}
				});
				//上一页
				obj.on("click","a.prevPage",function(){
					v_current = v_current-1;
					ms.fillHtml(obj,{"current":v_current,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(v_current);
					}
				});
				//下一页
				obj.on("click","a.nextPage",function(){
					v_current = v_current+1;
					ms.fillHtml(obj,{"current":v_current,"pageCount":args.pageCount});
					if(typeof(args.backFn)=="function"){
						args.backFn(v_current);
					}
				});
			})();
		}
	}
	$.fn.createPage = function(options){
		args = $.extend({
			pageCount : 10,
			current : 1,
			backFn : function(){}
		},options);
		ms.init(this,args);
	}
	$.fn.createPage2 = function(options){
		args = $.extend({
			pageCount : 10,
			current : 1,
			backFn : function(){}
		},options);
		ms.fillHtml(this,args);
	}
})(jQuery);