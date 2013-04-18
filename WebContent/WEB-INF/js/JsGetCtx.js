function getRootPath()
{
	// 获取当前网址，如： http://localhost:8083/bbs/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： bbs/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/bbs
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
function addToFav(url, title)
{
	if (window.sidebar)
	{ // Mozilla Firefox Bookmark
		window.sidebar.addPanel(title, url, "");
	} else if (document.all && window.external)
	{ // IE Favorite
		if (window.external.addToFavoritesBar)
		{
			window.external.addToFavoritesBar(url, title); // IE8
		} else
		{
			window.external.AddFavorite(url, title);
		}
	} else if (window.opera)
	{ // Opera 7+
		document.getElementById("addlink").href = url;
		document.getElementById("addlink").title = title;
		document.getElementById("addlink").rel = "sidebar";
	} else
	{// Chrome不好处理
		alert("你的浏览器不支持此操作，请尝试快捷键 Ctrl + D 收藏");
	}
}