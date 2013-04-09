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

<style type="text/css">
.left{float: left;}
</style>
</head>

<body>
	<div>
		<c:forEach items="${page.items}" var="t" varStatus="status">
			<div class="left">
				地址：
			</div>
			<div>
				${t.id}
			</div>
		</c:forEach>
		<common:pageV2 url="${ctx}/imageWall/index" optimize="true" />
	</div>
</body>
</html>