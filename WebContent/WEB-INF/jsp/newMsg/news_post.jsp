<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="lezaigoTop.jsp"%>
<!DOCTYPE html>
<html>

<head>
<title>新闻详细信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body>
        <!-- CONTENT BEGIN -->
        <div id="content" class="right_sidebar">
        	<div class="inner">
            	<div class="general_content">
                	<div class="main_content">
                    	<div class="block_breadcrumbs">
                        	<div class="text"><p>你当前地址:</p></div>
                            
                            <ul>
                            	<li><a href="index.html">首页</a></li>
                                <li><a href="business.html">新闻</a></li>
                                <li>${showSearch.newType}</li>
                            </ul>
                        </div>
                        <div class="separator" style="height:30px;"></div>
                        
                        <article class="block_single_news">
                          <p class="title"><a href="#">${showSearch.title}</a></p>
                            <p class="subtitle">尼玛太贵了啊</p>
                            <div class="info">
                                <div class="date"><p>${showSearch.downDate}</p></div>
                                <div class="author"><p>作者: <a href="#">Admin</a></p></div>
                                    
                            	<div class="r_part">
                                	<div class="category"><p><a href="#">信息</a></p></div>
                                    <a href="#" class="views">220</a>
                                    <a href="#" class="comments">25</a>
                                </div>
                            </div>
                            
                            <div class="content">
								<p class="content_copyright">${showSearch.newMsgOne}</p>
                          	
                            </div>
                        </article>
                        
                        <div class="separator" style="height:4px;"></div>
                        
                        <div class="block_post_tags">
                        	<p>标签: <a href="#">MX2</a><a href="#">详细信息</a></p>
                        </div>
                        
                        <div class="block_post_social">
                        	<h4><span>B</span></h4>
                            
                            <section class="rating">
                            	<p class="title"><span>点击率</span></p>
                                
                                <ul>
                                	<li><span>1024</span>观看</li>
                                    <li><span>4</span>浏览</li>
                                </ul>
                            </section>
                            
                            <section class="subscribe">
                            	<p class="title"><span>评论</span></p>
                                <a href="#">点击评论</a>
                            </section>
                            
                            <section class="recommend">
                            	<p class="title"><span>分享</span></p>
                                
                                <ul>
                                	<li><a href="" target="_blank"><img src="${path}/images/button_social_1.png" alt="" /></a></li>
                                    <li><a href="" target="_blank"><img src="${path}/images/button_social_2.png" alt="" /></a></li>
                                    <li><a href="" target="_blank"><img src="${path}/images/button_social_3.png" alt="" /></a></li>
                                    <li><a href="" target="_blank"><img src="${path}/images/button_social_4.png" alt="" /></a></li>
                                </ul>
                            </section>
                            
                            <div class="clearboth"></div>
                        </div>
                        
                        <div class="line_2" style="margin:22px 0px 29px;"></div>
                        
                        <div class="block_related_posts">
                        	<h3>相关文章</h3>
                            
                            <div class="block_main_news">
                            	<article class="block_news_post">
                                    <div class="f_pic"><a href="#" class="general_pic_hover scale_small"><img src="${path}/images/pic_main_news_9.jpg" alt="" /></a></div>
                                  <p class="category"><a href="#">mx3</a></p>
                                    <p class="title"><a href="#">明年发布嘿嘿</a></p>
                                    <div class="info">
                                        <div class="date"><p>2013-11-12</p></div>
                                        <a href="#" class="views">183</a>
                                        
                                        <div class="clearboth"></div>
                                    </div>
                                </article>
                                
                                <article class="block_news_post">
                                    <div class="f_pic"><a href="#" class="general_pic_hover scale_small"><img src="${path}/images/pic_main_news_4.jpg" alt="" /></a></div>
                                  <p class="category"><a href="#">mx4</a></p>
                                    <p class="title"><a href="#">后年</a></p>
                                    <div class="info">
                                        <div class="date"><p>2014-11-12</p></div>
                                        <a href="#" class="views">183</a>
                                        
                                        <div class="clearboth"></div>
                                    </div>
                                </article>
                                
                                <article class="block_news_post">
                                    <div class="f_pic"><a href="#" class="general_pic_hover scale_small"><img src="${path}/images/pic_main_news_6.jpg" alt="" /></a></div>
                                  <p class="category"><a href="#">mxx</a></p>
                                    <p class="title"><a href="#">世界末日</a></p>
                                    <div class="info">
                                        <div class="date"><p>2015-11-12</p></div>
                                        <a href="#" class="views">183</a>
                                        
                                        <div class="clearboth"></div>
                                    </div>
                                </article>
                            	<div class="clearboth"></div>
                            </div>
                        </div>
                        
                        <div class="line_2" style="margin:5px 0px 30px;"></div>
                        
                        <div class="block_comments_type_2">
                        	<h3>2 条评论</h3>
                            <a href="#" class="add_new">我要评论</a>
                            
                            <div class="comment">
                            	<div class="userpic"><a href="#"><img src="${path}/images/ava_default_1.jpg" alt="" /></a></div>
                                
                                <div class="comment_wrap">
                                    <div class="name"><p><a href="#">马化腾</a></p></div>
                                    <div class="date"><p>2012-10-15 15：33：23</p></div>
                                    <div class="content">
                                        <p>不错给力 麻帝哥P</p>
                                    </div>
                                </div>
                                <div class="clearboth"></div>
                                <div class="line_3"></div>
                            </div>
                            
                            <div class="comment">
                            	<div class="userpic"><a href="#"><img src="${path}/images/ava_default_1.jpg" alt="" /></a></div>
                                
                                <div class="comment_wrap">
                                    <div class="name"><p><a href="#">雷军</a></p></div>
                                    <div class="date"><p>2012/10/15 21：33：23</p></div>
                                    <div class="content">
                                        <p>我卖死小米</p>
                                    </div>
                                </div>
                                <div class="clearboth"></div>
                                <div class="line_3"></div>
                            </div>
                            
                        </div>
                        
                        <div class="separator" style="height:30px;"></div>
                        
                        <div class="block_leave_reply">
                        	<h3>发表评论</h3>
                        	<p class="text">您的电子邮件地址不会被公开。必填项已被标记为 <span>*</span></p>
                            
                        	<form class="w_validation" action="#" />
                            	<p>名字<span>*</span></p>
                            	<div class="field"><input type="text" class="req" /></div>
                                
                                <p>邮箱<span>*</span></p>
                            	<div class="field"><input type="text" class="req" /></div>
                                
                                <p>评论内容</p>
                                <div class="textarea"><textarea cols="1" rows="1"></textarea></div>
                                
                                <input type="submit" class="general_button" value="提交评论" />
                            </form>
                        </div>
                        
                    </div>
                    	<%@include file="legtPage.jsp"%>
					<div class="clearboth"></div>
				</div>
			</div>
		</div>
		<!-- CONTENT END -->
		<%@include file="lezaigoBottom.jsp"%>
