<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<html>

<head>
<%@include file="../inc/import.jsp"%>

<body>
	<%@ include file="../newMsg/lezaigoTop.jsp"%>
        <!-- CONTENT BEGIN -->
        <div id="content" class="right_sidebar">
        	<div class="inner">
            	<div class="general_content">
                	<div class="main_content">
                    	<div class="block_breadcrumbs">
                        	<div class="text"><p>你现在的位置:</p></div>
                            
                            <ul>
                            	<li><a href="${path}/imageWall/imageWallDateJsp.html">美图</a></li>
                                <li>${imagewall.title}</li>
                            </ul>
                        </div>
                        <div class="separator" style="height:30px;"></div>
                        
                        <article class="block_media_item">
                        	<div class="f_item">
                            	<div id="media_item_slider" class="media_item_slider flexslider">
                                	<ul class="slides">
                                    	<li>
                                        	<img src="${path}/images/pic_media_item_1.jpg" alt="" />
                                            <div class="caption"><p><b>Photo1.</b> Many desktop publishing packages and web page.</p></div>
                                        </li>
                                    </ul>
                                </div>
                                
                                <div id="media_item_navigation" class="media_item_navigation flexslider">
                                	<ul class="slides">
                                    	<li><img src="${path}/images/pic_media_item_1_sm.jpg" alt="" /><span class="current"></span></li>
                                    </ul>
                                </div>
                                
                                <script type="text/javascript">
									$(function() {
										$('#media_item_navigation').flexslider({
											animation : 'slide',
											controlNav : false,
											directionNav : false,
											animationLoop : false,
											slideshow : false,
											itemWidth : 91,
											itemMargin : 4,
											asNavFor : '#media_item_slider',
											useCSS : false
										});
										$('#media_item_slider').flexslider({
											animation : 'fade',
											controlNav : false,
											animationLoop : false,
											slideshow : false,
											sync : '#media_item_navigation'
										});
									});
								</script>
                            </div>
                          	<p class="title"><a href="#">Randomised words which don't look even slightly.</a></p>
                            
                            <div class="info">
                                <div class="date"><p>15 July, 2012</p></div>
                                    
                            	<div class="r_part">
                                    <a href="#" class="views">650</a>
                                    <a href="#" class="comments">25</a>
                                </div>
                            </div>
                            
                            <div class="content">
                            	<p>There are many <b>variations of passages</b> <a href="#" class="lnk_blue"><b>of available, but the majority have suffered</b></a> alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text.</p>
                            	<p>All the generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over words, combined with a <b>handful of model sentence</b> structures, to generate which looks reasonable.</p>
                            	<p>The generated Lorem Ipsum is therefore always free from repetition, injected humour words etc. Available, but the majority have <b>suffered alteration</b>.By injected humour, or randomised words which don't look.</p>
                            </div>
                        </article>
                        
                        <div class="separator" style="height:6px;"></div>
                        
                        <div class="block_post_social">
                        	<h4><span>B</span></h4>
                            
                            <section class="rating">
                            	<p class="title"><span>Rating</span></p>
                                
                                <ul>
                                	<li><span>1024</span>views</li>
                                    <li><span>4</span>comments</li>
                                </ul>
                            </section>
                            
                            <section class="subscribe">
                            	<p class="title"><span>Subscribe</span></p>
                                <a href="#">Subscribe to comments</a>
                            </section>
                            
                            <section class="recommend">
                            	<p class="title"><span>recommend to friends</span></p>
                                
                                <ul>
                                	<li><a href="http://www.facebook.com/share.php?u=http://google.com" target="_blank"><img src="images/button_social_1.png" alt="" /></a></li>
                                    <li><a href="https://twitter.com/share?text=I like BusinessNews Template and You?" target="_blank"><img src="images/button_social_2.png" alt="" /></a></li>
                                    <li><a href="https://plusone.google.com/_/+1/confirm?url=http://google.com" target="_blank"><img src="images/button_social_3.png" alt="" /></a></li>
                                    <li><a href="http://pinterest.com/pin/create/button/?url=http://google.com" target="_blank"><img src="images/button_social_4.png" alt="" /></a></li>
                                </ul>
                            </section>
                            
                            <div class="clearboth"></div>
                        </div>
                        
                        <div class="line_2" style="margin:22px 0px 30px;"></div>
                        
                        <div class="block_comments">
                        	<h3>2 Comments</h3>
                            
                            <div class="comment">
                            	<div class="userpic"><a href="about_author.html"><img src="images/ava_default_1.jpg" alt="" /></a></div>
                                <div class="content">
                                	<p class="name"><a href="about_author.html">John Doe</a></p>
                                    <p class="info"><span class="date">Febr 16, 2012 at 4:43 pm</span><a href="#" class="control">Reply</a></p>
                                    <p class="text">Established fact that a reader will be distracted by the readable content of a page. When looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using.</p>
                                </div>
                                <div class="clearboth"></div>
                                <div class="line_3"></div>
                            </div>
                            
                            <div class="comment">
                            	<div class="userpic"><a href="about_author.html"><img src="images/ava_default_1.jpg" alt="" /></a></div>
                                <div class="content">
                                	<p class="name"><a href="about_author.html">Sara Gordon</a></p>
                                    <p class="info"><span class="date">Febr 16, 2012 at 4:43 pm</span><a href="#" class="control">Reply</a></p>
                                    <p class="text">Distracted by the readable content of a page. When looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed.</p>
                                </div>
                                <div class="clearboth"></div>
                                <div class="line_3"></div>
                            </div>
                            
                        </div>
                        
                        <div class="separator" style="height:30px;"></div>
                        
                        <div class="block_leave_reply">
                        	<h3>Leave a Reply</h3>
                        	<p class="text">Your email address will not be published. Required fields are marked <span>*</span></p>
                            
                        	<form class="w_validation" action="#" />
                            	<p>Name<span>*</span></p>
                            	<div class="field"><input type="text" class="req" /></div>
                                
                                <p>E-mail<span>*</span></p>
                            	<div class="field"><input type="text" class="req" /></div>
                                
                                <p>Comment</p>
                                <div class="textarea"><textarea cols="1" rows="1"></textarea></div>
                                
                                <input type="submit" class="general_button" value="Post comment" />
                            </form>
                        </div>
                        
                    </div>
                    <%@include file="../newMsg/legtPage.jsp"%>
                	<div class="clearboth"></div>
                </div>
            </div>
        </div>
    	<!-- CONTENT END -->
        
        <!-- FOOTER BEGIN -->
        <%@include file="../newMsg/lezaigoBottom.jsp"%>