<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<html>
<head>
<%@include file="../inc/import.jsp"%>
<link rel="stylesheet" href="${path}/js/masonry/css/style.css" />
<link rel="stylesheet" href="${path}/css/imagewall.css" />
<script src="${path}/js/masonry/js/modernizr-transitions.js"></script>
<title></title>
</head>
<body>
	<%@ include file="../newMsg/lezaigoTop.jsp"%>
	<section id="content" style="padding-left: 0">
		<div class="inner">
			<div class="general_content">
				<div id="container"
					class="transitions-enabled infinite-scroll clearfix">
					<c:forEach items="${page.items}" var="t" varStatus="status">
						<div class="product_box fl">
							<!--249*535 -->
							<div class="img_box big">
								<a href="#"> <img
									src="http://d04.res.meilishuo.net/pic/r/e6/37/3f7afc718b5ffac08be17eb76bd5_800_1080.c1.jpg" />
									<!--20*284 -->
								</a>
								<div class="recive_btn">
									<a href="#" class="general_button w_icon favourite"><span>一键收藏</span></a>
								</div>
								<!-- <div class="price">78.20</div> -->
							</div>
							<div class="info_box flc">${t.title}</div>
							<div class="btn_box flc">
								<div class="fl">
									<a href="#" class="general_button w_icon like"><span>喜欢</span></a>
								</div>
								<!--like_btn end -->
								<div class="count fl">436</div>
								<div>
									<a href="javascript:void(0)"
										class="cbtn general_button w_icon comment"><span>评论:</span></a><span
										style="color: #F24024;">123</span>
								</div>
								<!--comment end -->
							</div>
							<div class="clearboth"></div>
							<div class="line_3 imgbuttion"></div>
							<div class="block_comments imgbuttion">
								<div class="comment imgwall_comment">
									<div class="walluserpic userpic">
										<a href="#"><img src="${path}/css/images/head_ico.png"
											alt="" /></a>
									</div>
									<div class="content">
										<p>
											<span class="name"><a href="#">LD</a></span> <span
												class="text">好看斯蒂芬斯蒂芬森的</span>
										</p>
									</div>
									<div class="line_3"></div>
								</div>
							</div>

							<div class="block_comments imgbuttion">
								<div class="comment">
									<div class="walluserpic userpic">
										<a href="#"><img src="${path}/css/images/head_ico.png"
											alt="" /></a>
									</div>
									<div class="content">
										<p>
											<span class="name"><a href="#">LD</a></span> <span
												class="text">好看斯蒂芬斯蒂芬森的</span>
										</p>
									</div>
									<div class="line_3"></div>
								</div>
							</div>


							<div class="all_comment flc">查看所有评论</div>
							<!--all_comment end -->

							<div class="clearboth"></div>

							<div class="comment_show imgbuttion">
								<div class="userpic fl">
									<a href="#"><img src="${path}/css/images/head_ico.png"
										alt="" /></a>
								</div>
								<div class="rl">
									<textarea class="commit_textarea"></textarea>
								</div>
								<div>
									<div></div>
									<div class="rl postcommit_bt">
										<a href="#" class="general_button w_icon edit"><span>评论</span></a>
									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<!--product_box end -->
					</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<!-- #container -->
	<nav id="page-nav">
		<a href="#"></a>
	</nav>

	<script src="${path}/js/masonry/js/jquery.infinitescroll.min.js"
		type="text/javascript"></script>
	<script src="${path}/js/masonry/js/jquery.masonry.js"></script>

	<script>
		$(function()
		{
			//可以载入任何页面的选择器中的内容，可以是id以及是class，并转化到html存储

			//	$container.load('${path}/imageWall/imageWallDateJsp',function(){$(this).appendTo("#container")});

			//${path}/imageWall/imageWallDate?pn=1&id=2;

			var $container = $('#container');

			againWall();

			$container.infinitescroll(
			{
				navSelector : '#page-nav', // 导航的选择器
				nextSelector : '#page-nav a', //下一页的选择器
				itemSelector : '.product_box', // 你将要取回的选项(内容块)
				debug : false, //启用调试信息
				loading :
				{
					msgText : "亲,正在努力加载中加载中...",
					finishedMsg : '已经到底了...',
					img : '${path}/images/load/6RMhx.gif'
				//		selector: '#test001' // 显示loading信息的div
				},
				pathParse : [ "${path}/imageWall/imageWallDateJsp?pn=", "" ],
				animate : true,//当有新数据加载进来的时候，页面是否有动画效果，默认没有
				extraScrollPx : 100,//入信息的显示时间，时间越大，载入信息显示时间越短
				//	 	errorCallback: function(){alert("出现404");},//当出错的时候，比如404页面的时候执行的函数
				localMode : false
			//是否允许载入具有相同函数的页面，默认为false
			},
			// trigger Masonry as a callback
			function(newElements)
			{
				// hide new items while they are loading
				var $newElems = $(newElements).css(
				{
					opacity : 0
				});
				// ensure that images load before adding to masonry layout
				$newElems.imagesLoaded(function()
				{
					// show elems now they're ready
					$newElems.animate(
					{
						opacity : 1
					});

					$container.masonry('appended', $newElems, true);
				});
			});

			$("a.cbtn").live(
					"click",
					function(e)
					{
						e.stopPropagation();
						$(e.target).parents(".product_box").find(
								'.comment_show').fadeIn(500);
						againWall();
						$("html,body").animate(
						{
							scrollTop : $(e.target).offset().top - 100
						}, 1000);
					});

		});
		function againWall()
		{
			var $container = $('#container');

			$container.masonry(
			{
				itemSelector : '.product_box',
				columnWidth : 15,
				isAnimated : !Modernizr.csstransitions
			});
		}
	</script>
</body>
</html>