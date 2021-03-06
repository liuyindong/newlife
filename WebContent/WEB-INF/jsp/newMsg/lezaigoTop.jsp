<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div class="wrapper sticky_footer">
		<!-- HEADER BEGIN -->
		<header>
		<div id="header">
			<section class="top">
			<div class="inner">
				<div class="fl">
					<div class="block_top_menu">
						<ul>
							<li class="current"><a href="${path }/index">首页</a></li>
							<li><a href="#">网站地图</a></li>
							<li><a href="">模版</a></li>
							<li><a href="">联系我们</a></li>
						</ul>
					</div>
				</div>

				<div class="fr">
					<div class="block_top_menu">
						<ul>
							<c:choose>
								<c:when test="${sessionScope.user != null}">
									<li><a href="javascript:void(0)">你好：${sessionScope.user.username}</a></li>
									<li><a href="javascript:void(0)">你有<label class="current"><em><font>10</font></em></label> 条新消息</a></li>
									<li><a href="${path}/logout">退出</a></li>	
								</c:when>
								<c:otherwise>
									<li class="current"><a href="#login" class="open_popup">登录</a></li>
									<li><a href="${path}/user/toregistration">注册</a></li>
								</c:otherwise>
							</c:choose>
							<li><a href="#">订阅</a></li>
						</ul>
					</div>

					<div class="block_social_top">
						<ul>
							<li><a href="#" class="fb">新浪</a></li>
							<li><a href="#" class="tw">人人</a></li>
							<li><a href="#" class="rss">腾讯</a></li>
						</ul>
					</div>
				</div>

				<div class="clearboth"></div>
			</div>
			</section>

			<section class="bottom">
			<div class="inner">
				<div id="logo_top">
					<a href=""><img src="<c:url value='/images/logo_top.png'/>"
						alt="BusinessNews" title="BusinessNews" /></a>
				</div>

				<div class="block_today_date">
					<div class="num">
						<p id="num_top" />
					</div>
					<div class="other">
						<p class="month_year">
							<span id="month_top"></span>, <span id="year_top"></span>
						</p>
						<p id="day_top" class="day" />
					</div>
				</div>

				<div class="fr">
					<div class="block_languages">
						<!-- <div class="text">
							<p>Language:</p>
						</div>
						<ul>
							<li class="current"><a href="#" class="eng">English(英国)</a></li>
							<li><a href="#" class="french">French(法国)</a></li>
							<li><a href="#" class="ger">German(德国)</a></li>
						</ul> -->

						<div class="clearboth"></div>
					</div>

					<div class="block_search_top">
						<form action="${path}/news/search" method="post">
						<div class="field">
							<input type="text" class="w_def_text" name="searchName" title="请输入搜索关键字" />
							<input type="hidden" name="searchType" name="newMsg"/>
						</div>
						<input type="submit" class="button" value="搜索" />
						<div class="clearboth"></div>
						</form>
					</div>
				</div>

				<div class="clearboth"></div>
			</div>
			</section>

			<section class="section_main_menu">
			<div class="inner">
				<nav class="main_menu">
				<ul>
					<li class="${tab=='home'?'current_page_item':''}"><a href="${path}/index">首页</a></li>
					<li class="${tab=='imagewall'?'current_page_item big_dropdown':''}" data-content="business"><a href="${path}/imageWall/imageWallDateJsp.html">美图</a></li>
					<li class="${tab=='wishingwall'?'current_page_item':''}"><a href="">许愿墙</a></li>
					<li class="${tab=='blog'?'current_page_item':''}"><a href="">博客</a></li>
					<li class="${tab=='entertainment'?'current_page_item':''}">
						<a href="#">娱乐</a>
						<ul>
							<li><a href="">视频</a></li>
						</ul>
					</li>
					
					<li class="${tab=='about'?'current_page_item':''}">
						<a href="#">关于</a>
						<ul>
							<li><a href="">关于我</a></li>
						</ul>
					</li>
				</ul>
				</nav>
			</div>
			</section>

			<section class="section_big_dropdown">
			<div class="inner">
				<div class="block_big_dropdown" data-menu="business">
					<div class="content">
						<div class="image">
							<a href="" class="pic"> <img
								src="${path}/images/pic_big_drop_3.jpg" alt="" /></a>
							<p>
								<a href="">大事1</a>
							</p>
						</div>
						<div class="line"></div>

						<div class="image">
							<a href="" class="pic"><img
								src="${path}/images/pic_big_drop_4.jpg" alt="" /></a>
							<p>
								<a href="">大事2</a>
							</p>
						</div>
						<div class="line"></div>

						<div class="popular_posts">
							<div class="title">
								<p>大事列表</p>
							</div>
							<ul>
								<li><a href="#"><span>12/18</span>事件1</a></li>
								<li><a href="#"><span>12/18</span>事件2</a></li>
								<li><a href="#"><span>12/18</span>事件3</a></li>
								<li><a href="#"><span>12/18</span>事件4</a></li>
							</ul>
						</div>
						<div class="line"></div>

						<div class="more">
							<div class="title">
								<p>其他</p>
							</div>
							<ul>
								<li><a href="#">111111</a></li>
								<li><a href="#">222222</a></li>
								<li><a href="#">333333</a></li>
								<li><a href="#">444444</a></li>
							</ul>
						</div>

						<div class="clearboth"></div>
					</div>
				</div>
			</div>
			</section>
			<script type="text/javascript">
			
				function AutoScroll(obj)
				{
					$(obj).find("ul:first").animate(
					{
						marginTop : "-39px"
					}, 500, function()
					{
						$(this).css(
						{
							marginTop : "0px"
						}).find("li:first").appendTo(this);
					});
				}
				$(document).ready(function()
				{
					setInterval('AutoScroll(".secondary_menu")', 3000);
				});
			</script>
			<section class="section_secondary_menu">
			<div class="inner">
				<nav class="secondary_menu" style="width:700px;height:39px;line-height:39px;overflow:hidden">
				<ul>
					<li><a href="">Zynga CEO首次访问中国 旗下新卡牌游戏上市</a></li>
					<li><a href="">艺电做艰难决定：裁员300人提高效率</a></li>
					<li><a href="">黑客软件能让手机控制飞机</a></li>
					<li><a href="">塑料再见！三星下一代旗舰机或配置铝制外壳</a></li>
					<li><a href="">盛大《零世界》内测启动 开启GAME3.0新时代</a></li>
					<li><a href="">Facebook Home上架Google Play 暂支持部分机型</a></li>
				</ul>
				</nav>
				<div class="block_clock">
					<p>
						时间: <span id="time"></span>
					</p>
				</div>
			</div>
			</section>
		</div>
		</header>
		<!-- HEADER END -->
		<!-- POPUP BEGIN -->
	<div id="overlay"></div>
	<div id="login" class="block_popup">
		<div class="popup">
			<a href="#" class="close">关闭</a>

			<div class="content">
				<div class="title">
					<p>登陆</p>
				</div>

				<div class="form">
					<div class="column">
						<p class="label">邮箱</p>
						<div class="field">
							<input type="text" id="username"/>
						</div>
					</div>

					<div class="column">
						<p class="label">密码</p>
						<div class="field">
							<input type="password" id="userpwd"/>
						</div>
					</div>

					<div class="column_2">
						<div class="remember">
							<div class="checkbox">
								<input type="checkbox" id="rememberuser"/>
							</div>
							<div class="remember_label">
								<p>记住我</p>
							</div>
						</div>
					</div>

					<div class="column_2">
						<p class="forgot_pass">
							<a href="#">忘记密码?</a>
						</p>
					</div>

					<div class="column button">
						<a href="javascript:void(0)" onclick="userLogin($('#username').val(),$('#userpwd').val())" class="enter"><span>登陆</span></a>
					</div>

					<div class="clearboth"></div>
				</div>

				<div class="subtitle">
					<p>使用第三方账号登录</p>
				</div>

				<div class="fb_button">
					<a href="#"></a>
				</div>
				<div class="text">
					<p>QQ登陆-----新浪微博登陆</a></p>
				</div>
			</div>
		</div>
	</div>
	<!-- POPUP END -->
<!--[if lte IE 6]><script src="${path}/js/ie6/warning.js"></script><script>window.onload=function(){e("${path}/js/ie6/")}</script><![endif]-->