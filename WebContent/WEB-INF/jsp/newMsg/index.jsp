<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="lezaigoTop.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>乐再新闻</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
		<!-- CONTENT BEGIN -->
		<div id="content" class="right_sidebar">
			<div class="inner">
				<div class="general_content">
					<div class="main_content">
						<div class="block_special_topic">
							<div class="type">
								<p>特别专题</p>
							</div>
							<div class="title">
								<p>
									<a href="#">新闻发布会</a>
								</p>
							</div>
						</div>
						<div class="separator" style="height: 17px;"></div>

						<div class="block_home_slider">
							<div id="home_slider" class="flexslider">
								<ul class="slides">
									<li>
										<div class="slide">
											<a href=""><img src="images/pic_home_slider_1.jpg" alt="" /></a>
											<div class="caption">
												<p class="title">MX2发布会</p>
												<p>MX2很不错的手机</p>
											</div>
										</div>
									</li>

									<li>
										<div class="slide">
											<img src="images/pic_home_slider_2.jpg" alt="" />
											<div class="caption">
												<p class="title">MX2发布会</p>
												<p>MX2很不错的手机</p>
											</div>
										</div>
									</li>

									<li>
										<div class="slide">
											<img src="images/pic_home_slider_3.jpg" alt="" />
											<div class="caption">
												<p class="title">MX2发布会</p>
												<p>MX2很不错的手机</p>
											</div>
										</div>
									</li>

									<li>
										<div class="slide">
											<img src="<c:url value='images/pic_home_slider_4.jpg'/>" alt="" />
											<div class="caption">
												<p class="title">MX2发布会</p>
												<p>MX2很不错的手机</p>
											</div>
										</div>
									</li>
								</ul>
							</div>

							<script type="text/javascript">
								$(function() {
									$('#home_slider').flexslider({
										animation : 'slide',
										controlNav : true,
										directionNav : true,
										animationLoop : true,
										slideshow : false,
										useCSS : false
									});

								});
							</script>
						</div>

						<div class="line_2" style="margin: 34px 0px 28px;"></div>

						<c:forEach items="${listNewMsg}" var="todayNewMsg" varStatus="status">
						<div class="block_home_col_4">
							<div class="block_home_post">
								<div class="pic">
									<a href="" class="w_hover"> <img
										src="images/pic_home_news_1.jpg" alt="" /> <span></span>
									</a>
								</div>

								<div class="text">
									<p class="title">
										<a href=""><a href="${path}/news/${todayNewMsg.id}/search">${todayNewMsg.title}</a></a>
									</p>
									<div class="date">
										<p>${todayNewMsg.downDate}</p>
									</div>
									<div class="icons">
										<ul>
											<li><a href="#" class="views">56</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="line_3" style="margin: 14px 0px 17px;"></div>
						</div>
						</c:forEach>
						<div class="clearboth"></div>

						<div class="line_3" style="margin: 14px 0px 13px;"></div>
						<a href="" class="lnk_all_news fl">更多新闻</a>
						<div class="clearboth"></div>
						<div class="line_3" style="margin: 13px 0px 35px;"></div>

						<h3 style="font-size: 16px;">重要新闻</h3>
						<div class="line_4" style="margin: -4px 0px 18px;"></div>

						<div class="block_topic_news">
							<article class="block_topic_post">
							<p class="title">
								<a href="">QQ爆炸新闻</a>
							</p>
							<div class="f_pic">
								<a href="" class="general_pic_hover scale"><img
									src="images/pic_home_main_news_1.jpg" alt="" /></a>
							</div>
							<p class="text">QQ求盗</p>
							<div class="info">
								<div class="date">
									<p>2012/12/18</p>
								</div>

								<div class="r_part">
									<div class="category">
										<p>
											<a href="#">Shet</a>
										</p>
									</div>
									<a href="#" class="views">183</a>
								</div>
							</div>
							</article>

							<article class="block_topic_post">
							<p class="title">
								<a href="">MX2发布</a>
							</p>
							<div class="f_pic">
								<a href="" class="general_pic_hover scale"><img
									src="images/pic_home_main_news_2.jpg" alt="" /></a>
							</div>
							<p class="text">明天发货</p>
							<div class="info">
								<div class="date">
									<p>2012/12/18</p>
								</div>

								<div class="r_part">
									<div class="category">
										<p>
											<a href="#">Business</a>
										</p>
									</div>
									<a href="#" class="views">183</a>
								</div>
							</div>
							</article>
						</div>

						<div class="line_3" style="margin: 20px 0px 24px;"></div>

						<div class="block_pager">
							<a href="#" class="prev">上一页</a> <a href="#" class="next">下一页</a>

							<div class="pages">
								<ul>
									<li class="current"><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">6</a></li>
								</ul>
							</div>

							<div class="clearboth"></div>
						</div>

						<div class="line_2" style="margin: 24px 0px 35px;"></div>

						<h3 style="font-size: 16px;">It新闻</h3>
						<div class="line_4" style="margin: -4px 0px 18px;"></div>

						<div class="block_best_materials">
							<div class="slider">
								<div id="best_materials_slider" class="flexslider">
									<ul class="slides">
										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="" class="w_hover"><img
														src="images/pic_home_best_materials_1.jpg" alt="" /><span></span></a>
												</div>
												<p class="title">
													<a href="">我是一只笨小鸟啊</a>
												</p>
												<div class="info">
													<div class="date">
														<p>2012/12/18</p>
													</div>
													<div class="category">
														<p>
															<a href="#">shet</a>
														</p>
													</div>
												</div>
											</div>
										</li>

										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="" class="w_hover"><img
														src="images/pic_home_best_materials_2.jpg" alt="" /><span></span></a>
												</div>
												<p class="title">
													<a href="">我是一只笨程序员啊</a>
												</p>
												<div class="info">
													<div class="date">
														<p>2012/12/18</p>
													</div>
													<div class="category">
														<p>
															<a href="#">People</a>
														</p>
													</div>
												</div>
											</div>
										</li>

										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="" class="w_hover"><img
														src="images/pic_home_best_materials_3.jpg" alt="" /><span></span></a>
												</div>
												<p class="title">
													<a href="">找工作急啊Fuck</a>
												</p>
												<div class="info">
													<div class="date">
														<p>2012/12/18</p>
													</div>
													<div class="category">
														<p>
															<a href="#">Technology</a>
														</p>
													</div>
												</div>
											</div>
										</li>

										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="" class="w_hover"><img
														src="images/pic_home_best_materials_4.jpg" alt="" /><span></span></a>
												</div>
												<p class="title">
													<a href="">我是一只笨小鸟啊</a>
												</p>
												<div class="info">
													<div class="date">
														<p>08 July, 2012</p>
													</div>
													<div class="category">
														<p>
															<a href="#">Business</a>
														</p>
													</div>
												</div>
											</div>
										</li>

										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="" class="w_hover"><img
														src="images/pic_home_best_materials_5.jpg" alt="" /><span></span></a>
												</div>
												<p class="title">
													<a href="">我是一只笨小鸟啊
														</a>
												</p>
												<div class="info">
													<div class="date">
														<p>08 July, 2012</p>
													</div>
													<div class="category">
														<p>
															<a href="#">People</a>
														</p>
													</div>
												</div>
											</div>
										</li>

										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="" class="w_hover"><img
														src="images/pic_home_best_materials_6.jpg" alt="" /><span></span></a>
												</div>
												<p class="title">
													<a href="">我是一只笨小鸟啊</a>
												</p>
												<div class="info">
													<div class="date">
														<p>08 July, 2012</p>
													</div>
													<div class="category">
														<p>
															<a href="#">Technology</a>
														</p>
													</div>
												</div>
											</div>
										</li>
									</ul>
								</div>
							</div>

							<script type="text/javascript">
								$(function() {
									$('#best_materials_slider').flexslider({
										animation : 'slide',
										controlNav : false,
										directionNav : true,
										animationLoop : false,
										slideshow : false,
										itemWidth : 213,
										itemMargin : 0,
										minItems : 1,
										maxItems : 3,
										move : 1,
										useCSS : false
									});
								});
							</script>
						</div>

						<div class="line_2" style="margin: 20px 0px 0px;"></div>

					</div>
					<%@include file="legtPage.jsp"%>
					<div class="clearboth"></div>
				</div>
			</div>
		</div>
		<!-- CONTENT END -->
		<%@include file="lezaigoBottom.jsp"%>
