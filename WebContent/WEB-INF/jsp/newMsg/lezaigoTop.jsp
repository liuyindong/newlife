<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
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
							<li><a href="${path}/user/listUser">联系我们</a></li>
						</ul>
					</div>
				</div>

				<div class="fr">
					<div class="block_top_menu">
						<ul>
							<c:if test="${sessionScope.user.username == null}">
								<li class="current"><a href="#login" class="open_popup">登录</a></li>
								<li><a href="${path}/user/toregistration">注册</a></li>
							</c:if>
							<c:if test="${sessionScope.user.username != null}">
								<li><a href="javascript:void(0)">你好：${sessionScope.user.username}</a></li>
								<li><a href="javascript:void(0)">你有<label class="current"><em><font>10</font></em></label> 条新消息</a></li>
							</c:if>
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
						<div class="text">
							<p>Language:</p>
						</div>
						<!-- <ul>
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
					<li class="current_page_item"><a href="${path }/index">首页</a>

						<ul>
							<li><a href="">样式1</a></li>
							<li><a href="">样式2</a></li>
						</ul></li>
					<li class="big_dropdown" data-content="business"><a href="">数码产品</a></li>
					<li class="big_dropdown" data-content="technology"><a href="">IT资讯</a></li>
					<li class="big_dropdown" data-content="education"><a href="">Win8</a></li>
					<li><a href="">游戏</a>
						<ul>
							<li><a href="">媒体</a></li>
							<li><a href="">媒体项目页</a></li>
						</ul></li>
					<li><a href="#">关于我们</a>

						<ul>
							<li><a href="">关于我们</a></li>
							<li><a href="">关于这页</a></li>
							<li><a href="">联系我们</a></li>
							<li><a href="">注册页</a></li>
							<li><a href="">主页新闻</a></li>
							<li><a href="">带有滚动条的新闻</a></li>
							<li><a href="">新视频发表</a></li>
						</ul></li>
					<li><a href="">博客</a>

						<ul>
							<li><a href="">样式1</a></li>
							<li><a href="">样式 2</a></li>
							<li><a href="">博客文章页</a></li>
							<li><a href="">发表</a></li>
							<li><a href="">发布视频</a></li>
						</ul></li>
					<li><a href="">论坛</a>

						<ul>
							<li><a href="">手拉琴</a></li>
							<li><a href="">引用</a></li>
							<li><a href="">表</a></li>
							<li><a href="">列</a></li>
							<li><a href="">价格表</a></li>
							<li><a href="">奖状</a></li>
							<li><a href="">信息框 </a></li>
						</ul></li>
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

				<div class="block_big_dropdown" data-menu="technology">
					<div class="content">
						<div class="image">
							<a href="l" class="pic">
							<img src="${path}/images/pic_big_drop_5.jpg" alt="" /></a>
							<p>
								<a href="">It新闻1</a>
							</p>
						</div>
						<div class="line"></div>

						<div class="image">
							<a href="" class="pic"><img
								src="${path}/images/pic_big_drop_6.jpg" alt="" /></a>
							<p>
								<a href="">22</a>
							</p>
						</div>
						<div class="line"></div>

						<div class="popular_posts">
							<div class="title">
								<p>IT新闻</p>
							</div>
							<ul>
								<li><a href=""><span>2012/12/18</span>台湾启动4G网络</a></li>
								<li><a href=""><span>2012/12/18</span>台湾启动4G网络</a></li>
								<li><a href=""><span>2012/12/18</span>台湾启动4G网络</a></li>
								<li><a href=""><span>2012/12/18</span>台湾启动4G网络</a></li>
							</ul>
						</div>
						<div class="line"></div>

						<div class="more">
							<div class="title">
								<p>新闻其他</p>
							</div>
							<ul>
								<li><a href="#">mx2明天开售</a></li>
								<li><a href="#">oppo finder 5 下个月开卖</a></li>
								<li><a href="#">MacBook 价格昂贵</a></li>
								<li><a href="#">铞丝买不起</a></li>
								<li><a href="#">新闻头条</a></li>
							</ul>
						</div>

						<div class="clearboth"></div>
					</div>
				</div>

				<div class="block_big_dropdown" data-menu="education">
					<div class="content">
						<div class="image">
							<a href="" class="pic">
							<img src="${path}/images/pic_big_drop_1.jpg" alt="" /></a>
							<p>
								<a href="">新产品MX2</a>
							</p>
						</div>
						<div class="line"></div>

						<div class="image">
							<a href="" class="pic"><img
								src="${path}/images/pic_big_drop_2.jpg" alt="" /></a>
							<p>
								<a href="">新产品Oppo Finder 5</a>
							</p>
						</div>
						<div class="line"></div>

						<div class="popular_posts">
							<div class="title">
								<p>产品列表</p>
							</div>
							<ul>
								<li><a href=""><span>2012/12/18</span>MX2明天开售</a></li>
								<li><a href=""><span>2012/12/18</span>MX2明天开售</a></li>
								<li><a href=""><span>2012/12/18</span>MX2明天开售</a></li>
								<li><a href=""><span>2012/12/18</span>MX2明天开售</a></li>
							</ul>
						</div>
						<div class="line"></div>

						<div class="more">
							<div class="title">
								<p>其他</p>
							</div>
							<ul>
								<li><a href="#">我预定</a></li>
								<li><a href="#">mx2参数信息</a></li>
								<li><a href="#">我预定</a></li>
								<li><a href="#">我预定</a></li>
							</ul>
						</div>

						<div class="clearboth"></div>
					</div>
				</div>
			</div>
			</section>

			<section class="section_secondary_menu">
			<div class="inner">
				<nav class="secondary_menu">
				<ul>
					<li><a href="">中国</a></li>
					<li><a href="">产品</a></li>
					<li><a href="">价格</a></li>
					<li><a href="">IT</a></li>
					<li><a href="">test</a></li>
					<li><a href="">最新新闻</a></li>
				</ul>
				</nav>

				<div class="block_clock">
					<p>
						Time: <span id="time"></span>
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
								<input type="checkbox" />
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
<!--[if lte IE]><script src="${path}/js/ie6/warning.js"></script><script>window.onload=function(){e("${path}/js/ie6/")}</script><![endif]-->