<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<div>
	<c:forEach items="${page.items}" var="t" varStatus="status">
		<div class="box">
			<img src="http://www.baidu.com/img/shouye_b5486898c692066bd2cbaeda86d74448.gif"></br>${t.title}///${t.id}
		</div>
	</c:forEach>
</div>
