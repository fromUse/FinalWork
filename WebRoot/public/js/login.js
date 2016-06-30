/**
 * Created by chenq on 2016/5/29.
 */

// window.onload当网页加载完执行
window.onload = function() {
	var flag = false;
	var passflag = false;
	$('#login_btn').bind('click', function() {
		checkPasswd();
		checkName();
		if ($('input:text').val().length < 1) {
			alert('登陆嘚用账户吧....');
			return;
		} else if ($('input:password').val().length < 1) {
			alert('密码没输,还想登陆.....');
			return;
		}
		if (flag && passflag) {
			$('#login').submit();
		}
	});

	$('input:password').bind('keyup', function() {
		checkPasswd();
		checkName();
	});

	$('input:text').bind('keyup', function() {
		checkName();
	});
	
	function checkName() {
		// 正则匹配账户
		var reg = /^[a-zA-Z][a-zA-Z\d]{3,15}$/;
		if (!reg.test($('input:text').val())) {
			$('#username').removeClass('mes_ok');
			$('#username').addClass('mes_error');
			$('#username').text("首字母,长度4~16,不含\[\]\<\>\{\\\}\/");
			flag = false;
		} else {

			$('#username').removeClass('mes_error');
			$('#username').addClass('mes_ok');
			$('#username').text('Ok');
			flag = true;
		}
	}
	
	function checkPasswd(){
		// 正则匹配密码规则
		var reg = /^[A-Za-z][\da-zA-Z._-]{5,15}$/;

		// alert(reg.test($('input:password').val()));

		if (!reg.test($('input:password').val())) {
			$('#pwd').removeClass('mes_ok');
			$('#pwd').addClass('mes_error');
			$('#pwd').text('首字母,长度6~16,不能纯数字');
			passflag = false;
		} else {
			$('#pwd').removeClass('mes_error');
			$('#pwd').addClass('mes_ok');
			$('#pwd').text('Ok');
			passflag = true;
		}
	}
}