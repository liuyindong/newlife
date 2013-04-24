<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                		<c:forEach begin="0" var="showimg" items="${showImgList}" varStatus="index">
	                                    	<li>
	                                        	<img src="${path}/${showimg.filePaths}" alt="${showimg.directions}" />
	                                            <div class="caption"><p><b>Photo${index.index+1}.</b>${showimg.directions}</p></div>
	                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                
                                <div id="media_item_navigation" class="media_item_navigation flexslider">
                                	<ul class="slides">
                                		<c:forEach begin="0" var="showimg" items="${showImgList}" varStatus="index">
                                    	<li><img src="${path}/${showimg.filePath}/thumbnails/${showimg.name}" alt="${showimg.directions}" /><span class="current"></span></li>
                                    	</c:forEach>
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
                          	<p class="title"><a href="#">${imagewall.content}</a></p>
                            
                            <div class="info">
                                <div class="date"><p>${imagewall.createDate}</p></div>
                                    
                            	<div class="r_part">
                                    <a href="#" class="views">650</a>
                                    <a href="#" class="comments">25</a>
                                </div> 
                            </div>
                            
                            <div class="content">
                            	${imagewall.content}
                            </div>
                        </article>
                        
                   <%--      <div class="separator" style="height:6px;">
                        </div> --%>
                        
                        
                        <div class="line_2" style="margin:22px 0px 30px;"></div>
                        
                        <taglabel:comment commentTcid="${imagewall.id}" commentTypeId="1"></taglabel:comment>
                        
                    </div>
                    <%@include file="../newMsg/legtPage.jsp"%>
                	<div class="clearboth"></div>
                </div>
            </div>
        </div>
    	<!-- CONTENT END -->
        
        <!-- FOOTER BEGIN -->
        <%@include file="../newMsg/lezaigoBottom.jsp"%>