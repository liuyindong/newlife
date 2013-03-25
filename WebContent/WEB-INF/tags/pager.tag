<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="pageUrl" required="true" rtexprvalue="true" description="分页链接地址，页码占位符为 {page}" %>
<%@ attribute name="pageCount" required="true" rtexprvalue="true" description="总页数" %>
<%@ attribute name="currentPage" required="true" rtexprvalue="true" description="当前页" %>

<div class="pager">
	<c:set var="currentPage" value="${currentPage*1}" />
	<c:set var="pageCount" value="${pageCount*1}" />
	<c:if test="${currentPage<=1}">
		<a href="javascript:alert('已经是第一页')">首页</a>
		<a href="javascript:alert('已经是第一页')">上一页</a>
	</c:if>
	<c:if test="${currentPage>1}">
		<a href="${fn:replace(pageUrl, '{page}', 1)}">首页</a>
		<a href="${fn:replace(pageUrl, '{page}', currentPage-1)}">上一页</a>
	</c:if>
	<c:if test="${pageCount<=10}">
		<c:set var="pageStart" value="1" />
		<c:set var="pageEnd" value="${pageCount}" />
	</c:if>
	<c:if test="${pageCount>10}">
		<c:set var="pageStart" value="${currentPage-4}" />
		<c:set var="pageEnd" value="${currentPage+5}" />
		<c:if test="${pageStart<1}">
			<c:set var="pageStart" value="1" />
			<c:set var="pageEnd" value="10" />
		</c:if>
		<c:if test="${pageEnd>pageCount}">
			<c:set var="pageEnd" value="${pageCount}" />
			<c:set var="pageStart" value="${pageEnd-9}" />
		</c:if>
	</c:if>
	<c:forEach var="pageIndex" begin="${pageStart}" end="${pageEnd}">
		<c:if test="${pageIndex==currentPage}">
			<span class="currentPage">${pageIndex}</span>
		</c:if>
		<c:if test="${pageIndex!=currentPage}">
			<a href="${fn:replace(pageUrl, '{page}', pageIndex)}">${pageIndex}</a>
		</c:if>
	</c:forEach>
	<c:if test="${currentPage<pageCount}">
		<a href="${fn:replace(pageUrl, '{page}', currentPage+1)}">下一页</a>
		<a href="${fn:replace(pageUrl, '{page}', pageCount)}">末页</a>
	</c:if>
	<c:if test="${currentPage>=pageCount}">
		<a href="javascript:alert('已经是最后一页')">下一页</a>
		<a href="javascript:alert('已经是最后一页')">末页</a>
	</c:if>
	当前 ${currentPage}/${pageCount} 页
</div>