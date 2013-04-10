<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<link rel="stylesheet" href="${path}/js/masonry/css/style.css" />

<script src="${path}/js/helper.js" type="text/javascript"></script>
<script src="${path}/js/jquery-1.8.3.min.js"></script>
<script src="${path}/js/masonry/js/jquery.masonry.js"></script>
<script src="${path}/js/masonry/js/jquery.infinitescroll.min.js"
	type="text/javascript"></script>
<title></title>
</head>
<body class="demos ">



	<section id="content"><!-- ${t.filePath} -->
	<div id="container"
		class="transitions-enabled infinite-scroll clearfix">
		<c:forEach items="${page.items}" var="t" varStatus="status">
			<div class="box example">
				<img
					src="http://www.baidu.com/img/shouye_b5486898c692066bd2cbaeda86d74448.gif"></br>${t.title}
			</div>
		</c:forEach>
	</div>
	</section>

	<!-- #container -->
	<nav id="page-nav"> <a href="#"></a> </nav>
	<script>
		$(function()
		{
			//可以载入任何页面的选择器中的内容，可以是id以及是class，并转化到html存储

			//	$container.load('${path}/imageWall/imageWallDateJsp',function(){$(this).appendTo("#container")});

			//${path}/imageWall/imageWallDate?pn=1&id=2;

			var $container = $('#container');

			$container.imagesLoaded(function()
			{
				$container.masonry(
				{
					itemSelector : '.box',
					columnWidth : 20
				});
			});
			$container.infinitescroll(
			{
				navSelector : '#page-nav', // 导航的选择器
				nextSelector : '#page-nav a', //下一页的选择器
				itemSelector : '.box', // 你将要取回的选项(内容块)
				debug : true, //启用调试信息
				loading :
				{
					msgText: "亲,正在努力加载中加载中...",
					finishedMsg : '已经到底了...',
					img : '${path}/images/load/6RMhx.gif',
			//		selector: '#test001' // 显示loading信息的div
				},
				pathParse : [ "${path}/imageWall/imageWallDateJsp?pn=", "" ],
				animate : true,//当有新数据加载进来的时候，页面是否有动画效果，默认没有
				extraScrollPx : 50, //滚动条距离底部多少像素的时候开始加载，默认150
				bufferPx : 40,//载入信息的显示时间，时间越大，载入信息显示时间越短
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

					//		$imgWallId = $($newElems[$newElems.length - 1]).find("span").html();
					$container.masonry('appended', $newElems, true);
				});
			});

		});
	</script>
</body>
</html>