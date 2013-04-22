<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<html>
<head>
<%@ include file="../inc/import.jsp"%>
<title>${showNew.title}</title>
<body>
	<%@ include file="lezaigoTop.jsp"%>
	<!-- CONTENT BEGIN -->
	<div id="content" class="right_sidebar">
		<div class="inner">
			<div class="general_content">
				<div class="main_content">
					<div class="block_breadcrumbs">
						<div class="text">
							<p>你当前地址:</p>
						</div>

						<ul>
							<li><a href="index.html">首页</a></li>
							<li><a href="business.html">新闻</a></li>
							<li>${showNew.newType.name}</li>
						</ul>
					</div>
					<div class="separator" style="height: 30px;"></div>

					<article class="block_single_news">
						<p class="title">
							<a href="#">${showNew.title}</a>
						</p>
						<p class="subtitle"></p>
						<div class="info">
							<div class="date">
								<p>${showNew.downDate}</p>
							</div>
							<div class="author">
								<p>
									作者: <a href="${path}/">Admin</a>
								</p>
							</div>

							<div class="r_part">
								<div class="category">
									<p>
										<a href="#">信息</a>
									</p>
								</div>
								<a href="javascript:void(0)" class="views">${showNew.clickNum}</a> 
								<a  href="javascript:void(0)" onclick="scrolltop()" class="comments" >25</a>
							</div>
						</div>

						<div class="content">
							<p class="content_copyright">${showNew.newMsgOne}</p>

						</div>
					</article>

					<div class="separator" style="height: 4px;"></div>

					<div class="block_post_tags">
						<p>
							标签:
							<c:forEach items="${tags}" var="tag" varStatus="status">
								<a href="#">${tag}</a>
							</c:forEach>
						</p>
					</div>

					<div class="block_post_social">
						<h4>
							<span>B</span>
						</h4>

						<section class="rating">
							<p class="title">
								<span>点击率</span>
							</p>

							<ul>
								<li><span>${showNew.clickNum}</span>浏览</li>
							</ul>
						</section>

						<section class="subscribe">
							<p class="title">
								<span>评论</span>
							</p>
							<a  href="javascript:void(0)" onclick="scrolltop()">点击评论</a>
						</section>

						<section class="recommend">
							<p class="title">
								<span>分享</span>
							</p>

							<ul>
								<li><a href="" target="_blank"><img
										src="${path}/images/button_social_1.png" alt="" /></a></li>
								<li><a href="" target="_blank"><img
										src="${path}/images/button_social_2.png" alt="" /></a></li>
								<li><a href="" target="_blank"><img
										src="${path}/images/button_social_3.png" alt="" /></a></li>
								<li><a href="" target="_blank"><img
										src="${path}/images/button_social_4.png" alt="" /></a></li>
							</ul>
						</section>

						<div class="clearboth"></div>
					</div>

					<div class="line_2" style="margin: 22px 0px 29px;"></div>

					<div class="block_related_posts">
						<h3>相关文章</h3>

						<div class="block_main_news">
							<article class="block_news_post">
								<div class="f_pic">
									<a href="#" class="general_pic_hover scale_small"><img
										src="${path}/images/pic_main_news_9.jpg" alt="" /></a>
								</div>
								<p class="category">
									<a href="#">mx3</a>
								</p>
								<p class="title">
									<a href="#">明年发布嘿嘿</a>
								</p>
								<div class="info">
									<div class="date">
										<p>2013-11-12</p>
									</div>
									<a href="#" class="views">183</a>

									<div class="clearboth"></div>
								</div>
							</article>

							<article class="block_news_post">
								<div class="f_pic">
									<a href="#" class="general_pic_hover scale_small"><img
										src="${path}/images/pic_main_news_4.jpg" alt="" /></a>
								</div>
								<p class="category">
									<a href="#">mx4</a>
								</p>
								<p class="title">
									<a href="#">后年</a>
								</p>
								<div class="info">
									<div class="date">
										<p>2014-11-12</p>
									</div>
									<a href="#" class="views">183</a>

									<div class="clearboth"></div>
								</div>
							</article>

							<article class="block_news_post">
								<div class="f_pic">
									<a href="#" class="general_pic_hover scale_small"><img
										src="${path}/images/pic_main_news_6.jpg" alt="" /></a>
								</div>
								<p class="category">
									<a href="#">mxx</a>
								</p>
								<p class="title">
									<a href="#">世界末日</a>
								</p>
								<div class="info">
									<div class="date">
										<p>2015-11-12</p>
									</div>
									<a href="#" class="views">183</a>

									<div class="clearboth"></div>
								</div>
							</article>
							<div class="clearboth"></div>
						</div>
					</div>
					<div class="line_2" style="margin: 5px 0px 30px;"></div>
					<taglabel:comment commentTcid="${showNew.id}" commentTypeId="2"></taglabel:comment>
				</div>
				<%@include file="legtPage.jsp"%>
				<div class="clearboth"></div>
			</div>
		</div>
	</div>
	<!-- CONTENT END -->
	<%@include file="lezaigoBottom.jsp"%>