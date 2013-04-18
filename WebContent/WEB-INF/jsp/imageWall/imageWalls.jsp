<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<c:forEach items="${listImgWall}" var="listwall" varStatus="status">
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
							<div class="info_box flc">${listwall.title}</div>
							<div class="btn_box flc">
								<div class="fl">
									<c:choose>
										<c:when test="${listwall.userIsLoveWall}">
											<a href="javascript:void(0)" class="general_button w_icon like_i imgwall_user_love"><span>已喜欢</span></a>
										</c:when>
										<c:otherwise>
											<a href="javascript:void(0)" class="general_button w_icon like imgwall_user_love"><span>喜欢</span></a>
										</c:otherwise>
									</c:choose>
								</div>
								<!--like_btn end -->
								<div class="count fl">${listwall.loveNum}</div>
								<div>
									<a href="javascript:void(0)" class="cbtn general_button w_icon comment"><span>评论:</span></a>
									<span style="color: #F24024;" class="comment_num">${listwall.commentNum}</span>
								</div>
								<!--comment end -->
							</div>
							<div class="clearboth"></div>
							<div class="line_3 imgbuttion"></div>
								<div class="block_comments imgbuttion">
									<c:forEach items="${listwall.listWallComment}" var="wallcomment" varStatus="status">
									<div class="comment imgwall_comment">
										<div class="walluserpic userpic">
											<a href="#"><img src="${path}/css/images/head_ico.png" alt="${wallcomment.user.username}" /></a>
										</div>
										<div class="content">
											<p>
												<span class="name">
													<a href="#">${wallcomment.user.username}</a></span> 
												<span class="text">${wallcomment.content}</span>
											</p>
										</div>
										<div class="line_3"></div>
									</div>
									</c:forEach>
								</div>

							<div class="all_comment flc">查看所有评论</div>
							<!--all_comment end -->

							<div class="clearboth"></div>

							<div class="comment_show imgbuttion">
								<input type="hidden" class="imgwall_id" value="${listwall.id}"/>
								<div class="userpic fl">
									<a href="#"><img src="${path}/css/images/head_ico.png" alt="" /></a>
								</div>
								<div class="rl">
									<textarea class="commit_textarea"></textarea>
								</div>
								<div>
									<div></div>
									<div class="rl postcommit_bt">
										<a href="javascript:void(0)" class="general_button w_icon edit imgwall_pos_comment"><span>评论</span></a>
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
			
			 $('.product_box').fadeIn();  

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
				pathParse : [ "${path}/imageWall/imageWallDateJsp.html?pn=", "" ],
				animate : true,//当有新数据加载进来的时候，页面是否有动画效果，默认没有
				extraScrollPx : 50,//入信息的显示时间，时间越大，载入信息显示时间越短
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
						
						if($("#inter_user_is_login").val() == '')
						{
							$(".open_popup").click();
							return true;
						}	
						
						$(e.target).parents(".product_box").find('.comment_show').fadeIn(500);
						
						againWall();
						
						$("html,body").animate(
						{
							scrollTop : $(e.target).offset().top - 100
						}, 1000);
			});
			
			$("a.imgwall_user_love").live("click",function(e)
			{
				e.stopPropagation();
				
				if($("#inter_user_is_login").val() == '')
				{
					$(".open_popup").click();
					return true;
				}	
				
				var wallId = $(e.target).parents(".product_box").find(".imgwall_id").val();
				
				$.ajax({
					url:'${path}/imageWall/imgWallLove',
					type:'post',
					dataType:'json',
					data:
					{
						"imageWallId":wallId
					},
					success : function(data)
					{
						if(data.result)
						{
							var loveNum = $(e.target).parents(".btn_box").find(".count");
							
							if(data.jsonValidateReturn == 1)
							{
								$(e.target).html("已喜欢");
								$(e.target).parent().removeClass("like").addClass("like_i");
								$(loveNum).html(parseInt($(loveNum).html()) + 1);
							}else if(data.jsonValidateReturn == 0)
							{
								$(e.target).html("喜欢");//
								$(e.target).parent().removeClass("like_i").addClass("like");
								var lovenum = parseInt($(loveNum).html()) - 1;
								if(lovenum <= -1){return;};
								$(loveNum).html(lovenum);
							}
						}else
						{
							alert(data.failMsg);
						}
					}
				});
				
				
			});
			
			
			$("a.imgwall_pos_comment").live("click",function(e)
			{
				e.stopPropagation();
				var commentHtml = $(e.target).parents(".comment_show");
				var contentVal = commentHtml.find('.commit_textarea').val();
				var imageWallId = commentHtml.find('.imgwall_id').val();
				if(contentVal.length < 1)
				{
					alert("请正确输入评论的内容！");
					return;
				}	
				$.ajax({
					url:"${path}/imageWall/imgWallComment",
					type:"post",
					dataType:"json",
					data:{
						"content":contentVal,
						"imageWallId":imageWallId
					},
					success : function(data)
					{
						if(data.result)
						{
							var commenttemporary = "<div class='comment imgwall_comment'>"+
							"	<div class='walluserpic userpic'>"+
							"	<a href=''><img src='${path}/css/images/head_ico.png' alt='${wallcomment.user.username}' /></a>"+
							"</div>"+
							"<div class='content'>"+
							"	<p>"+
							"		<span class='name'>"+
							"			<a href=''>${sessionScope.user.username}</a></span> "+
							"		<span class='text'>"+contentVal+"</span>"+
							"	</p>"+
							"</div>"+
							"<div class='line_3'></div></div>";
							
							$(commentHtml).find('.commit_textarea').val('');
							
							var productNbox = $(e.target).parents(".product_box");
							
							$(productNbox).find(".block_comments").append(commenttemporary);
							
							$(productNbox).find('.comment_show').hide();
							var commentnum = $(productNbox).find('.comment_num');
							$(commentnum).html(parseInt($(commentnum).html())+ 1);
							againWall();
						}
						else
						{
							$(".open_popup").click();
							return true;
							
						}
					}
				});
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