<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib tagdir="tags" prefix="boboland"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function aa()
	{
		alert("d");
	};
</script>
</head>

<body>
	<boboland:pager pageCount="${pageCount}" currentPage="${page}"
		pageUrl="${ctx}/mv/list/{page}" />
</body>
</html>
