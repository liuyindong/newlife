<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<# include="${freepath}1.ftl">
	<img src="${path}/images/biaoqin/wugu.gif"/>
	${name}
	
	<#assign test1 = "2009-01-22"?date("yyyy-MM-dd") />;
            <#assign test2 ="16:34:43"?time("HH:mm:ss") />
            <#assign test2 = "2009-01-22 17:23:45"?datetime("yyyy-MM-dd HH:mm:ss") />
            ${test1?string.full}
</body>
</html>
