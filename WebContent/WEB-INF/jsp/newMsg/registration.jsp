<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="lezaigoTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BusinessNews - Registration</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet"
	href="${path}/js/formValidator/css/validationEngine.jquery.css"
	type="text/css" />
<link rel="stylesheet" href="${path}/js/formValidator/css/template.css"
	type="text/css" />
<script src="${path}/js/formValidator/jquery.js" type="text/javascript"></script>
<script src="${path}/js/formValidator/js/jquery.validationEngine-cn.js"
	type="text/javascript"></script>
<script src="${path}/js/formValidator/js/jquery.validationEngine.js"
	type="text/javascript"></script>
<script>
	$(document).ready(function()
	{
		$("#userFRegistration").validationEngine(
		{
			validationEventTriggers : "blur", //触发的事件  validationEventTriggers:"keyup blur",
			inlineValidation : true,//是否即时验证，false为提交表单时验证,默认true
			success : false,//为true时即使有不符合的也提交表单,false表示只有全部通过验证了才能提交表单,默认false
			promptPosition : "topRight",//提示所在的位置，topLeft, topRight, bottomLeft,  centerRight, bottomRight
		});
		$('#kaptchaImage').click(function () 
		{   
		    $(this).attr('src', '${path}/kaptcha.jpg?' + Math.floor(Math.random()*100) ); 
		});  

	});
</script>
</head>

<body>
	<!-- CONTENT BEGIN -->
	<div id="content" class="">
		<div class="inner">
			<div class="general_content">
				<div class="main_content">
					<div class="block_breadcrumbs">
						<div class="text">
							<p>你现在的位置:</p>
						</div>

						<ul>
							<li><a href="index.html">首页</a></li>
							<li>注册</li>
						</ul>
					</div>
					<div class="separator" style="height: 28px;"></div>

					<p class="general_title">
						<span>加 入 我 们</span>
					</p>
					<div class="separator" style="height: 39px;"></div>

					<div class="block_registration">
						<form action="${path}/user/registration" class="w_validation" method="post" id="userFRegistration" />
						<div class="col_1">
							<div class="label">
								<p>
									邮箱<span>*</span>:
								</p>
							</div>
							<div class="field">
								<input type="text" class="validate[required,custom[email]],ajax[ajaxUser]] text-input" name="email" id="email" />
							</div>
							<div class="clearboth"></div>
							<div class="separator" style="height: 12px;"></div>

							<div class="label">
								<p>
									密码<span>*</span>:
								</p>
							</div>
							<div class="field">
								<input type="password"
									class="validate[required,length[6,11]] text-input"
									name="password" id="password" />
							</div>
							<div class="clearboth"></div>
							<div class="separator" style="height: 12px;"></div>

							<div class="label">
								<p>
									确认密码<span>*</span>:
								</p>
							</div>
							<div class="field">
								<input type="password" class="validate[required,confirm[password]] text-input" id="passwordW" />
							</div>
							<div class="clearboth"></div>
							<div class="separator" style="height: 14px;"></div>
							
							<div class="label">
								<p>名字:</p>
							</div>
							<div class="field">
								<input type="text" name="username" id="username" class="validate[required] text-input"/>
							</div>
							<div class="clearboth"></div>
							<div class="separator" style="height: 14px;"></div>

							<div class="label">
								<p>性别:</p>
							</div>
							<div class="checkbox">
								<label>男</label><input value = "0" class="sliding_checkbox" type="radio" name="usersix" checked="checked"/>
								<label>女</label><input value = "1" class="sliding_checkbox" type="radio" name="usersix" />
							</div>
						
							<div class="clearboth"></div>
							<div class="separator" style="height: 12px;"></div>
							
							<div class="label">
								<p>验证吗:</p>
							</div>
							<div>
								<div class="field" style="height: 30px;width:100px;  float: right;">
									<img alt="" src="${path}/kaptcha.jpg" id="kaptchaImage">
								</div>
								<div class="field" style="height: 30px;width:160px;  float: right;">
									<input type="text" class="validate[required,ajax[ajaxCode]] text-input" name="lezaicode" id="lezaicode" />
								</div>
							</div>
							<div class="clearboth"></div>
							<div class="separator" style="height: 14px;"></div>
						</div>

						<div class="clearboth"></div>
						<div class="separator" style="height: 32px;"></div>

						<p class="info_text">
							当你点击注册的时候你已经同意了网站的协议要求 (<a href="#">用户协议</a>)
						</p>
						<p class="info_text">
							<input type="submit" class="general_button" value="	立	即	注  	  册" />
						</p>
						<p class="info_text">你可以使用以下账号登陆我们的网站</p>
						<div align="center">
							<a href=""><img alt="QQ登陆"
								src="${path}/layout/images/btn/btn_qq.gif"></a> <a href=""><img
								alt="新浪微博登陆" src="${path}/layout/images/btn/btn_weibo.gif"></a>
						</div>
						</form>
					</div>

					<div class="line_3" style="margin: 42px 0px 0px;"></div>

				</div>

				<div class="clearboth"></div>
			</div>
		</div>
	</div>
	<!-- CONTENT END -->
	<%@include file="lezaigoBottom.jsp"%>