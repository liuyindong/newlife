<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="sidebar">
				<!-- 		<div class="block_subscribes_sidebar">
							<div class="service">
								<a href="#" class="rss"> <span class="num">11 234</span> <span
									class="people">Subscribers</span>
								</a>
							</div>

							<div class="service">
								<a href="#" class="tw"> <span class="num">781</span> <span
									class="people">Followers</span>
								</a>
							</div>

							<div class="service">
								<a href="#" class="fb"> <span class="num">341</span> <span
									class="people">Subscribers</span>
								</a>
							</div>
						</div>

						<div class="separator" style="height: 31px;"></div> -->

						<div class="block_popular_posts">
							<h4>产品新闻</h4>

							<div class="article">
								<div class="pic">
									<a href="#" class="w_hover"> <img
										src="${path}/images/pic_popular_post_1.jpg" alt="" /> <span></span>
									</a>
								</div>

								<div class="text">
									<p class="title">
										<a href="#">MX2给力</a>
									</p>
									<div class="date">
										<p>2012/12/18</p>
									</div>
									<div class="icons">
										<ul>
											<li><a href="#" class="views">41</a></li>
											<li><a href="#" class="comments">22</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="line_3"></div>

							<div class="article">
								<div class="pic">
									<a href="#" class="w_hover"> <img
										src="${path}/images/pic_popular_post_2.jpg" alt="" /> <span></span>
									</a>
								</div>

								<div class="text">
									<p class="title">
										<a href="#">小米垃圾啊</a>
									</p>
									<div class="date">
										<p>2012/12/11</p>
									</div>
									<div class="icons">
										<ul>
											<li><a href="#" class="views">24</a></li>
											<li><a href="#" class="comments">16</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="line_3"></div>

							<div class="article">
								<div class="pic">
									<a href="#" class="w_hover"> <img
										src="${path}/images/pic_popular_post_3.jpg" alt="" /> <span></span>
									</a>
								</div>

								<div class="text">
									<p class="title">
										<a href="#">雷军好恶心</a>
									</p>
									<div class="date">
										<p>2012/10/11</p>
									</div>
									<div class="icons">
										<ul>
											<li><a href="#" class="views">33</a></li>
											<li><a href="#" class="comments">25</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="line_2"></div>
						</div>

						<div class="separator" style="height: 31px;"></div>

						<div class="block_popular_stuff">
							<h4>视频</h4>

							<div class="content">
								<a href="#" class="view_all">看视频</a>
								<div class="media">
									<a href=""
										class="general_pic_hover play no_fx" data-rel="prettyPhoto"
										title="Popular Video"><img src="${path}/images/uploadimg/xx_img3.gif"
										alt="" /></a>
								</div>
								<p>
									<a href="">mx2发布会视频</a> <img
										src="${path}/images/icon_video.gif" alt="" />
								</p>
								<p class="date">2012/12/18</p>
							</div>

							<div class="info">
								<ul>
									<li class="comments"><a href="#">115</a></li>
									<li class="views"><a href="#">220</a></li>
								</ul>
							</div>

							<div class="clearboth"></div>

							<div class="line_2"></div>
						</div>

						<div class="separator" style="height: 31px;"></div>

						<div class="block_calendar">
							<%@ include file="lezaigoDate.jsp"%>
						</div>

						<div class="separator" style="height: 31px;"></div>

						<div class="block_popular_stuff">
							<h4>发布图片</h4>

							<div class="content">
								<a href="#" class="view_all">查看</a>
								<div class="media">
									<a href="images/pic_pop_photo_big.jpg"
										class="general_pic_hover zoom no_fx" data-rel="prettyPhoto"
										title="美图"><img src="${path}/images/pic_pop_photo.jpg"
										alt="" /></a>
								</div>
								<p>
									<a href="">mx2发布了嘿嘿</a> <img
										src="${path}/images/icon_photo.gif" alt="" />
								</p>
								<p class="date">2012/12/18</p>
							</div>

							<div class="info">
								<ul>
									<li class="comments"><a href="#">100</a></li>
									<li class="views"><a href="#">134</a></li>
								</ul>
							</div>

							<div class="clearboth"></div>

							<div class="line_2"></div>
						</div>

						<div class="separator" style="height: 31px;"></div>

						<div class="block_newsletter">
							<h4>搜索新闻</h4>

							<form action="${path}/news/search" method="post">
							<div class="field">
								<input type="text" class="w_def_text" name="searchName" 
									title="请输入搜索的内容" />
							<input type="hidden" name="searchType" name="newMsg"/>
							</div>
							<input type="submit" class="button" value="Subscribe" />

							<div class="clearboth"></div>
							</form>
						</div>

					</div>
