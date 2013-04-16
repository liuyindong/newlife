<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>乐再新闻</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
		<%@ include file="lezaigoTop.jsp"%>	
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
						
						 <div class="block_home_col_1">
						 	<h3 style="font-size: 12px;">移动互联</h3>
						 	<div class="line_3"></div>
						 	<c:forEach items="${homeInformation.listNewsYdhl}" var="homenews" varStatus="status">
						 	 <div class="block_home_post">
								 <div class="pic">
									<a href="${path}/news/search${homenews.id}.html" class="w_hover">
										<img src="${homenews.newsImage}" alt="homenews.title" width="67" height="45"/>
										<span></span>
									</a>
								</div> 
                                        
								<div class="text">
									<p class="title"><a href="${path}/news/search_${homenews.id}.html" target="view_window">${homenews.title}</a></p>
									<div class="date"><p>${homenews.downDate}</p></div>
                                    <div class="icons">
                                    	<ul>
                                        	<li><a href="#" class="views">${homenews.clickNum}</a></li>
                                        </ul>
                                    </div>
								</div>
							</div>
                            <div class="line_3" style="margin:14px 0px 17px;"></div>
						 	</c:forEach>
						 </div>
						 
						 <div class="block_home_col_2">
							 <h3 style="font-size: 12px;">电子商务</h3>
						 	<div class="line_3"></div>
						 	<c:forEach items="${homeInformation.listNewsDzsw}" var="homenews" varStatus="status">
						 	<div class="block_home_post">
								 <div class="pic">
									<a href="${path}/news/search${homenews.id}.html" class="w_hover">
										<img src="${homenews.newsImage}" alt="homenews.title" width="67" height="45"/>
										<span></span>
									</a>
								</div> 
                                        
								<div class="text">
									<p class="title"><a href="${path}/news/search_${homenews.id}.html" target="view_window">${homenews.title}</a></p>
									<div class="date"><p>${homenews.downDate}</p></div>
                                    <div class="icons">
                                    	<ul>
                                        	<li><a href="#" class="views">${homenews.clickNum}</a></li>
                                        </ul>
                                    </div>
								</div>
							</div>
							 <div class="line_3" style="margin:14px 0px 17px;"></div>
						 	</c:forEach>
						 </div>
						 
						 
						  <div class="block_home_col_1">
						 	<h3 style="font-size: 12px;">社交网络</h3>
						 	<div class="line_3"></div>
						 	<c:forEach items="${homeInformation.listNewsSjwl}" var="homenews" varStatus="status">
						 	 <div class="block_home_post">
								 <div class="pic">
									<a href="${path}/news/search${homenews.id}.html" class="w_hover">
										<img src="${homenews.newsImage}" alt="homenews.title" width="67" height="45"/>
										<span></span>
									</a>
								</div> 
                                        
								<div class="text">
									<p class="title"><a href="${path}/news/search_${homenews.id}.html" target="view_window">${homenews.title}</a></p>
									<div class="date"><p>${homenews.downDate}</p></div>
                                    <div class="icons">
                                    	<ul>
                                        	<li><a href="#" class="views">${homenews.clickNum}</a></li>
                                        </ul>
                                    </div>
								</div>
							</div>
                            <div class="line_3" style="margin:14px 0px 17px;"></div>
						 	</c:forEach>
						 </div>
						 
						 <div class="block_home_col_2">
							 <h3 style="font-size: 12px; color: #f24024">网络游戏</h3>
						 	<div class="line_3"></div>
						 	<c:forEach items="${homeInformation.listNewsWlyx}" var="homenews" varStatus="status">
						 	<div class="block_home_post">
								 <div class="pic">
									<a href="${path}/news/search${homenews.id}.html" class="w_hover">
										<img src="${homenews.newsImage}" alt="${homenews.title}" width="67" height="45"/>
										<span></span>
									</a>
								</div> 
                                        
								<div class="text">
									<p class="title"><a href="${path}/news/search_${homenews.id}.html" target="view_window">${homenews.title}</a></p>
									<div class="date"><p>${homenews.downDate}</p></div>
                                    <div class="icons">
                                    	<ul>
                                        	<li><a href="#" class="views">${homenews.clickNum}</a></li>
                                        </ul>
                                    </div>
								</div>
							</div>
							 <div class="line_3" style="margin:14px 0px 17px;"></div>
						 	</c:forEach>
						 </div>
						 
						 
						<div class="clearboth"></div>

						<a href="" class="lnk_all_news fl">更多新闻</a>
						<div class="clearboth"></div>
						<div class="line_3" style="margin: 13px 0px 35px;"></div>

						<h3 style="font-size: 16px;">重要新闻</h3>
						<div class="line_4" style="margin: -4px 0px 18px;"></div>

						<div class="block_topic_news">
							<c:forEach items="${homeInformation.listNewsYaoW}" var="homenews" varStatus="status">
							<article class="block_topic_post">
							<p class="title">
								<a href="${path}/news/search_${homenews.id}.html" target="view_window">${homenews.title}</a>
							</p>
							<div class="f_pic">
								<a href="" class="general_pic_hover scale"><img
									src="${homenews.newsImage}" alt="${homenews.title}" /></a>
							</div>
							<p class="text">${homenews.techTag}</p>
							<div class="info">
								<div class="date">
									<p>${homenews.downDate}</p>
								</div>

								<div class="r_part">
									<div class="category">
										<p>
											<a href="#">重要新闻</a>
										</p>
									</div>
									<a href="#" class="views">${homenews.clickNum}</a>
								</div>
							</div>
							</article>
							</c:forEach>
						</div>

						<div class="line_3" style="margin: 20px 0px 24px;"></div>

						<div class="line_2" style="margin: 24px 0px 35px;"></div>

						<h3 style="font-size: 16px;">数码产品</h3>
						<div class="line_4" style="margin: -4px 0px 18px;"></div>

						<div class="block_best_materials">
							<div class="slider">
								<div id="best_materials_slider" class="flexslider">
									<ul class="slides">
										<c:forEach items="${homeInformation.listNewsSm}" var="homenews" varStatus="status">
										<li>
											<div class="block_best_material_post">
												<div class="f_pic">
													<a href="${path}/news/search_${homenews.id}.html" target="view_window" class="w_hover">
													<img src="${homenews.newsImage}" alt="${homenews.title}"/><span></span></a>
												</div>
												<p class="title">
													<a href="${path}/news/search_${homenews.id}.html" target="view_window"></a>
												</p>
												<div class="info">
													<div class="date">
														<p>${homenews.downDate}</p>
													</div>
													<div class="category">
														<p>
															<a href="#">数码信息</a>
														</p>
													</div>
												</div>
											</div>
										</li>
										</c:forEach>
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
