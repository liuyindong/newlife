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


<script src="${path}/js/jquery-1.8.3.min.js"></script>
<script src="${path}/js/masonry/js/modernizr-transitions.js"></script>
<script src="${path}/js/masonry/js/jquery.masonry.js"></script>
<script src="${path}/js/helper.js" type="text/javascript"></script>

<style type="text/css">
.example {
	background: red;
	border: 2px dotted #ddd;
	margin-bottom: 10px;
}
</style>

<title></title>
</head>
<body class="homepage ">

	<div id="container" class="transitions-enabled clearfix">
		<div class="item big-text">
			After: Masonry
			<div id="mini-container" class="mini">

				<div class="w1 h1">1</div>

				<div class="w1 h1">2</div>

				<div class="w1 h2">3</div>

				<div class="w1 h1">4</div>

				<div class="w2 h1">5</div>

				<div class="w1 h2">6</div>

				<div class="w1 h1">7</div>

				<div class="w2 h2">8</div>

				<div class="w2 h1">9</div>

				<div class="w1 h1">10</div>

				<div class="w2 h2">11</div>

				<div class="w2 h1">12</div>

			</div>
		</div>

		<div class="item big-text loading">
			<img src="http://i.imgur.com/6RMhx.gif" /> 正在加载请稍后
		</div>
	</div>
	
	<script src="${path}/js/masonry/js/jquery.infinitescroll.min.js"></script>
	<script>
		$(function()
		{

			var $container = $('#container');

			$container.masonry(
			{
				itemSelector : '.item',
				columnWidth : 20,    //  一列的宽度
				isAnimated : !Modernizr.csstransitions,
				isFitWidth:true,
				isResizableL:true
			});

			// Sites using Masonry markup
			$loadingItem = $container.find('.loading');
			
			
			show();
			var pn = 1;
			var id = -1;

			var isOn = true;

			function show()
			{
				
				$.ajax(
				{
					url : '${path}/imageWall/imageWallDate',
					type : 'post',
					dataType : "json",
					data :
					{
						"pn" : pn,
						"id" : id
					},
					success : function(data)
					{
						if (data.items <= 0)
						{
							isOn = false;
					//		alert("已经到底部了");
							return true;
						}
						var itemsJsWalls = [], item;
						$.each(data.items, function(i, datum)
						{
							item = '<div class="item example"><img src="${path}/'+datum.filePath+'"></br>' + datum.title + '</div>';
							itemsJsWalls.push(item);
							id = datum.id;
						});
						var $itemsJsWall = $(itemsJsWalls.join(''));
						$itemsJsWall.imagesLoaded(function()
						{
							$container.masonry('remove', $loadingItem).masonry();
							$container.append($itemsJsWall);
							$container.masonry('appended', $itemsJsWall, true);
						});
					}
				});
			}

			$(window).scroll(function()
			{		
				if ($(document).scrollTop()+200 >= $(document).height() - $(window).height())
				{
					//	alert("到底部了");
					pn = parseInt(pn) + 1;
					if (!isOn)
					{
					//	alert("已经没有资源了亲");
						return true;
					}
					show();
				}
			});

		});
	</script>
	<!-- #content -->
	
	<div align="center">
		____________________________________底部啦________________________________________
	</div>

</body>
</html>