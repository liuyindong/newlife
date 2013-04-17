<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<c:forEach items="${page.items}" var="t" varStatus="status">
			<div class="product_box fl"><!--249*535 -->
		    	<div class="img_box big">
		        	<a href="#">
		            	<img src="http://d04.res.meilishuo.net/pic/r/e6/37/3f7afc718b5ffac08be17eb76bd5_800_1080.c1.jpg" /><!--20*284 -->
		            </a>
		            <div class="recive_btn">
		            	<a href="#" class="general_button w_icon favourite"><span>一键收藏</span></a>
		            </div>
		            <!-- <div class="price">78.20</div> -->
		        </div>
		        <div class="info_box flc">${t.title}</div>
		        <div class="btn_box flc">
		        	<div class="fl"><a href="#" class="general_button w_icon like"><span>喜欢</span></a></div><!--like_btn end -->
		            <div class="count fl">436</div>
		            <div><a href="javascript:void(0)" class="cbtn general_button w_icon comment"><span>评论:</span></a><span style="color:#F24024;">123</span></div><!--comment end -->
		        </div>
		        <div class="clearboth"></div>
		        <div class="line_3 imgbuttion"></div>
		        <div class="block_comments imgbuttion">
		        	<div class="comment">
		        		<div class="walluserpic userpic"><a href="#"><img src="${path}/css/images/head_ico.png" alt="" /></a></div>
		        		 <div class="content">
                            <p>
                            	<span class="name"><a href="#">LD</a></span>
                            	<span class="text">好看斯蒂芬斯蒂芬森的</span>
                            </p>
                         </div>
                         <div class="line_3"></div>
		        	</div>
		        </div>
		        
		        <div class="block_comments imgbuttion">
		        	<div class="comment">
		        		<div class="walluserpic userpic"><a href="#"><img src="${path}/css/images/head_ico.png" alt="" /></a></div>
		        		 <div class="content">
                            <p>
                            	<span class="name" ><a href="#">LD</a></span>
                            	<span class="text">好看斯蒂芬斯蒂芬森的</span>
                            </p>
                         </div>
                         <div class="line_3"></div>
		        	</div>
		        </div>
		        
		        
		        <div class="all_comment flc">查看所有评论</div><!--all_comment end -->
		        
		        <div class="clearboth"></div>
		        
		        <div class="comment_show imgbuttion">
		        	<div class="userpic fl"><a href="#"><img src="${path}/css/images/head_ico.png" alt="" /></a></div>
		        	<div class="rl"><textarea class="commit_textarea"></textarea></div>
		        	<div>
		        		<div></div>
		        		<div class="rl postcommit_bt"> <a href="#" class="general_button w_icon edit"><span>评论</span></a></div>
		        	</div>
		        </div>
		    </div><!--product_box end -->
		</c:forEach>