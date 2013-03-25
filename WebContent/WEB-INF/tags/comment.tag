<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="moduleType" required="true" rtexprvalue="true" description="评论模块 ID" %>
<%@ attribute name="moduleId" required="true" rtexprvalue="true" description="评论对象 ID" %>

<link rel="stylesheet" type="text/css" href="${ctx}/css/comment.css" />
<div class="comment_panel">
	<div class="comment_new">
		<c:if test="${authority.login}">
			<textarea id="comment" name="comment"></textarea>
			<input type="button" class="r_button r_button80" id="addComment" value="立即评论" />
		</c:if>
		<c:if test="${!authority.login}">
			<div class="login_tip">
				登录以后才可以发表评论。
				<a href="${ctx}/user/login" target="_top">点击这里立即登录</a>
			</div>
		</c:if>
	</div>
		
	<!-- 评论数 -->
	<div class="comment_count">当前共有 <span id="commentCount"></span> 条评论</div>
	
	<!-- 评论列表 -->
	<div class="comment_list">
		<ul id="comments"></ul>
	</div>
	
	<!-- 评论分页 -->
	<div id="pager" class="pager"></div>
</div>

<script>
// 评论对象
var commentTarget = {
	moduleType: ${moduleType},
	moduleId: ${moduleId}
};
// 初始化
$(document).ready(function(){
	// 显示第一页评论
	getComments(1);
	// 发表评论
	$("#addComment").click(function(){
		if ($("#comment").val().length > 80) { alert("字数不要超过 80 个"); return false;}
		if ($("#comment").val().length < 6) { alert("评论内容不能为空，字数不能少于6个"); return false;}
		$("#addComment").attr("disabled", "disabled");
		var url = "${ctx}/comment/add/moduletype/" + commentTarget.moduleType + "/moduleid/" + commentTarget.moduleId;
		var data = {comment: $("#comment").val()};
		$.post(url, data, function(data){
			$("#comment").val("");
			$("#addComment").removeAttr("disabled");
			getComments(1);
		});
	});
});
// 设置评论对象
function setCommentTarget(moduleType, moduleId) {
	commentTarget.moduleType = moduleType;
	commentTarget.moduleId = moduleId;
	getComments(1);
}
// 返回评论列表分页
function getComments(page) {
	var url = "${ctx}/comment/list/moduletype/" + commentTarget.moduleType + "/moduleid/" + commentTarget.moduleId + "/page/" + page;
	$.getJSON(url, function(data){
		var pageCount = Math.floor((data.commentCount + data.commentPageSize - 1) / data.commentPageSize);
		$("#commentCount").html("<b>" + data.commentCount + "</b>");
		$("#comments").empty();
		for (var i=0; i<data.comments.length; i++) {
			var comment = data.comments[i];
			$("<li id='comment_" + comment.comment_id + "'>"
				+ "<h4><a class='nickname' href='${ctx}/user/" + comment.user_id + "' target='_blank'>" + comment.nickname + "</a> "
				+ "<span class='time'>" + $.formatDate(comment.create_time) + "</span> "
				+ "<a class='reply' href='javascript:replyComment(" + comment.comment_id + ")'>回复</a></h4>"
				+ "<p class='comment'>" + comment.comment + "</p>"
			+ "</li>").appendTo($("#comments"));
		}
		var pagerHtml = "";
		if (page <= 1) {
			pagerHtml += ("<a href='javascript:alert(\"已经是第一页\")'>首页</a> ");
			pagerHtml += ("<a href='javascript:alert(\"已经是第一页\")'>上一页</a> ");
		} else {
			pagerHtml += ("<a href='javascript:getComments(1)'>首页</a> ");
			pagerHtml += ("<a href='javascript:getComments(" + (page - 1) + ")'>上一页</a> ");
		}
		var pageStart = 0;
		var pageEnd = 0;
		if (pageCount <= 10) {
			pageStart = 1;
			pageEnd = pageCount;
		} else {
			pageStart = page - 4;
			pageEnd = page + 5;
			if (pageStart < 1) {
				pageStart = 1;
				pageEnd = 10;
			} else if (pageEnd > pageCount) {
				pageEnd = pageCount;
				pageStart = pageEnd - 9;
			}
		}
		for (var i=pageStart; i<=pageEnd; i++) {
			if (i == page) {
				pagerHtml += ("<span class='currentPage'>" + i + "</span> ");
			} else {
				pagerHtml += ("<a href='javascript:getComments(" + i + ")'>" + i + "</a> ");
			}
		}
		if (page < pageCount) {
			pagerHtml += ("<a href='javascript:getComments(" + (page + 1) + ")'>下一页</a> ");
			pagerHtml += ("<a href='javascript:getComments(" + pageCount + ")'>末页</a> ");
		} else {
			pagerHtml += ("<a href='javascript:alert(\"已经是最后一页\")'>下一页</a> ");
			pagerHtml += ("<a href='javascript:alert(\"已经是最后一页\")'>末页</a> ");
		}
		pagerHtml += ("当前 " + page + "/" + pageCount + " 页");
		$("#pager").html(pagerHtml);
	});
}
// 回复
function replyComment(commentId) {
	$("#comment").val(" //@" + $("#comment_" + commentId + " .nickname").text() + ": " + $("#comment_" + commentId + " .comment").text())
				 .focus();
}
</script>