<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../newMsg/lezaigoTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>搜索页面</title>

<meta name="keywords" content="" />
<meta name="description" content="" />

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<!-- CONTENT BEGIN -->
	<div id="content">
		<div class="inner">
			<div class="general_content">
				<div class="main_content">
					<div class="block_breadcrumbs">
						<div class="text">
							<p>你现在的位置:</p>
						</div>

						<ul>
							<li><a href="index.html">全站</a>
							</li>
							<li>搜索</li>
						</ul>
					</div>
					<div class="separator" style="height: 30px;"></div>

					<h2>下面是你搜索到的结果</h2>


					<div class="line_4" style="margin: 0px 0px 20px;"></div>
					<div id="content">
						<a href="<c:url value='/user/add'/>">新增</a> <a
							href="<c:url value='/user'/>">查询</a>
						<table border="1">
							<tr>
								<th>编号</th>
								<th>用户名</th>
								<th>电子邮箱</th>
								<th>密码</th>
								<th>注册时间</th>
								<th>操作</th>
							</tr>
							<c:forEach items="${page.items}" var="t" varStatus="status">
								<tr>
									<td>${ t.id }</td>
									<td>${ t.username }</td>
									<td>${ t.email }</td>
									<td>${ t.password }</td>
									<td>${ t.createdate }</td>
									<td><a href="<c:url value='/user/${t.id}/delete'/>">删除</a>|<a
										href="<c:url value='/user/${t.id}/update'/>">修改</a></td>
								</tr>
							</c:forEach>
						</table>
						<common:pageV2 url="/user" optimize="true" />
					</div>
					<div class="line_2" style="margin: 0px 0px 20px;"></div>
					<div class="block_pager">
						<a href="#" class="prev">上一页</a><a href="#" class="next">下一页</a>
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
					</div>
					<div class="clearboth"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- CONTENT END -->
</body>
</html>