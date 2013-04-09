<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/js/helper.js"></script>
<link rel="stylesheet" href="${path}/js/zTreeStyle/demo.css" type="text/css">
<link rel="stylesheet" href="${path}/js/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${path}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${path}/js/zTreeStyle/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${path}/js/zTreeStyle/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${path}/js/zTreeStyle/jquery.ztree.exedit-3.5.js"></script>
	<!-- url:"${path}/tree/createTree", -->
<SCRIPT type="text/javascript">
		<!--
		var setting = {
			async: {
				enable: true,
				url:"${path}/tree/createTree",
				autoParam:["id", "name=n", "level=lv","filePath"],
				dataFilter: filter
			},
			view: {expandSpeed:"",
		//		addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				isCopy: false,
				isMove: false,
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeRemove: beforeRemove,
				beforeRename: beforeRename
			}
		};

		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeRemove(treeId, treeNode) 
		{
			if(treeNode.isParent)
			{
				alert("你删除的是目录");
				return false;
			}
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			if(confirm("确认删除 文件 -- " + treeNode.name + " 吗？"))
			{
				alert("点击了删除" + treeNode.filePath);
			}
			
			return ;
		}		
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) 
			{
				alert("节点名称不能为空.");
				return false;
			}
			alert(treeNode.name + "修改成了" + newName);
			return true;
		}

	/* 	var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if ($("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.id + "' title='add node' onfocus='this.blur();'></span>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
			});
		}; */
		function removeHoverDom(treeId, treeNode) 
		{
			$("#addBtn_"+treeNode.id).unbind().remove();
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
		});
		//-->
	</SCRIPT>
	<style type="text/css">
		.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
	</style>
<body>
		<div id="treeDemo" class="ztree"></div>
</body>
</html>