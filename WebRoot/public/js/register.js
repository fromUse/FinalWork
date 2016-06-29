/*
 * Created by chenq on 2016/5/29.
 */

//window.onload当网页加载完执行
window.onload = function(){
	  var flag = false;
  $('#register').bind('click',function()
  {
    if($('#userName').val().length<1)
      {
          alert('先输入账户吧....');
          return;
      } else if($('input:password').val().length<1)
      {
          alert('密码没输,还想注册.....');
          return;
      }
 
    if(flag){ $('form').submit(); }
  });

//一次密码
$('#passWord').bind('keyup',function()
{
	checkpass1();
	checkpass2();
	
});


//二次密码
$('#NotpassWord').bind('keyup',function()
{
			//正则匹配密码规则
			checkpass1();
			checkpass2();
		});

function checkpass1(){

	//正则匹配密码规则
	var reg=/^[A-Za-z][\da-zA-Z._-]{5,15}$/;
	
	//alert(reg.test($('input:password').val()));
	
     if(!reg.test($('#passWord').val()))
     {
         $('#passwdmsg').removeClass('mes_ok');
         $('#passwdmsg').addClass('mes_error');
         $('#passwdmsg').text('首字母,长度6~16,不能纯数字');
  
         flag=false;
    }else
    {
         $('#passwdmsg').removeClass('mes_error');
         $('#passwdmsg').addClass('mes_ok');
         $('#passwdmsg').text('　　　　Ok');
         flag = true;
     }

}

function checkpass2(){
	var reg=/^[A-Za-z][\da-zA-Z._-]{5,15}$/;
	
	//alert(reg.test($('passWord').val()));

	var notpass = $('#NotpassWord').val();
	var pass = $('#passWord').val();

    	 if(notpass != pass){
	         $('#notpasswdmsg').removeClass('mes_ok');
	         $('#notpasswdmsg').addClass('mes_error');
	         $('#notpasswdmsg').text('密码不一致呀......');
	         flag=false;
    	 }else{
    	       $('#notpasswdmsg').removeClass('mes_error');
		         $('#notpasswdmsg').addClass('mes_ok');
		         $('#notpasswdmsg').text('　　　　Ok');
		         flag = true;
    	 }
    	 
}


$('input:text').bind('keyup',function(){
	//正则匹配账户
		var reg=/^[a-zA-Z][a-zA-Z\d]{3,15}$/;
		if(!reg.test($('input:text').val())){
			 $('#usermsg').removeClass('mes_ok');
	         $('#usermsg').addClass('mes_error');
	         $('#usermsg').text("首字母,长度4~16,不含\[\]\<\>\{\\\}\/");
	         flag=false;
		}else{
		
	         $('#usermsg').removeClass('mes_error');
	         $('#usermsg').addClass('mes_ok');
	         $('#usermsg').text('　　　　Ok');
	         flag = true;
		}

});

//点击切换验证码
$('#code_img').bind('click',function(){
	this.src = 'Code.jpg?tm='+Math.random();
});
}


