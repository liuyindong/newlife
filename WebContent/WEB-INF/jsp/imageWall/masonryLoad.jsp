<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
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
						<a href="javascript:void(0)"
							class="general_button w_icon like_i imgwall_user_love"><span>已喜欢</span></a>
					</c:when>
					<c:otherwise>
						<a href="javascript:void(0)"
							class="general_button w_icon like imgwall_user_love"><span>喜欢</span></a>
					</c:otherwise>
				</c:choose>
			</div>
			<!--like_btn end -->
			<div class="count fl">${listwall.loveNum}</div>
			<div>
				<a href="javascript:void(0)"
					class="cbtn general_button w_icon comment"><span>评论:</span></a> <span
					style="color: #F24024;" class="comment_num">${listwall.commentNum}</span>
			</div>
			<!--comment end -->
		</div>
		<div class="clearboth"></div>
		<div class="line_3 imgbuttion"></div>
		<div class="block_comments imgbuttion">
			<c:forEach items="${listwall.listWallComment}" var="wallcomment"
				varStatus="status">
				<div class="comment imgwall_comment">
					<div class="walluserpic userpic">
						<a href="#"><img src="${path}/css/images/head_ico.png"
							alt="${wallcomment.user.username}" /></a>
					</div>
					<div class="content">
						<p>
							<span class="name"> <a href="#">${wallcomment.user.username}</a></span>
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
			<input type="hidden" class="imgwall_id" value="${listwall.id}" />
			<div class="userpic fl">
				<a href="#"><img src="${path}/css/images/head_ico.png" alt="" /></a>
			</div>
			<div class="rl">
				<textarea class="commit_textarea"></textarea>
			</div>
			<div>
				<div></div>
				<div class="rl postcommit_bt">
					<a href="javascript:void(0)"
						class="general_button w_icon edit imgwall_pos_comment"><span>评论</span></a>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!--product_box end -->
</c:forEach>