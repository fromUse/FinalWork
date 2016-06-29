/**
 * Created by chenq on 2016/5/29.
 */

// window.onload当网页加载完执行
window.onload = function() {
	var flag=false;
	var contentFlag = false;
	
	
	$('#send').bind('click',function(){
		if(!flag){
			alert('标题不少于1个字符');
		}else{
			if(!contentFlag){
				alert('内容不少于15个字符');
			}else{
				alert('ssssssss');
				$('#inforelease').submit();
			}
		}
		
	});
	
	$('#h').bind('keyup',function(){
		checkTitle() ;
	});
	
	$('#content').bind('keyup',function(){
		checkContent() ;
	});
	
	//开发时间紧张,粗滤验证.....
	function checkTitle() {
		var len = $('#h').val().length ;
		if (len> 0 && len<140) {
			flag = true;
		}else{
			flag = false;
		}
	}
	
	function checkContent() {
		var len = $('#content').val().length ;
		if (len> 15 && len<5000) {
			contentFlag = true;
		}else{
			contentFlag = false;
		}
	}
	
	
}