<%@ tag pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="uploadUrl" required="true" rtexprvalue="true" description="上传 URL" %>
<%@ attribute name="fileTypes" rtexprvalue="true" description="允许上传的文件类型（多个类型用分号隔开），默认所有文件" %>
<%@ attribute name="fileSizeLimit" rtexprvalue="true" description="单个文件大小限制（允许使用 KB MB 等单位），默认 100 MB" %>
<%@ attribute name="fileUploadLimit" rtexprvalue="true" description="最多可以上传的文件数量，默认 100" %>
<%@ attribute name="uploadComplete" rtexprvalue="true" description="全部上传完成后回调 js 方法" %>

<link href="${ctx}/css/swfupload.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/inner_comm.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/sigup.css"/>

<script type="text/javascript" src="${ctx}/js/swfupload/swfupload.js"></script>
<script type="text/javascript" src="${ctx}/js/swfupload/swfupload.queue.js"></script>
<script type="text/javascript" src="${ctx}/js/swfupload/fileprogress.js"></script>
<script type="text/javascript" src="${ctx}/js/swfupload/handlers.js"></script>
<script type="text/javascript">
var swfu;
window.onload = function() {
	var settings = {
		flash_url : "${ctx}/js/swfupload/swfupload.swf",
		upload_url: "${uploadUrl}",
		file_size_limit : "${empty fileSizeLimit ? '100 MB' : fileSizeLimit}",		// 单个文件大小限制，默认 100 MB
		file_types : "${empty fileTypes ? '*.*' : fileTypes}",						// 允许上传的文件类型，默认所有文件
		file_types_description : "${empty fileTypes ? 'All Files' : fileTypes}",
		file_upload_limit : ${empty fileUploadLimit ? 100 : fileUploadLimit},		// 最多可以上传的文件数量，默认 100
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			startButtonId : "btnUpload",
			cancelButtonId : "btnCancel"
		},
		debug: false,

		// Button settings
		button_image_url: "${ctx}/images/button_two.png",
		button_width: "61",
		button_height: "22",
		button_placeholder_id: "spanButtonPlaceHolder",
		button_text: "浏览..",
		button_text_left_padding: 12,
		
		
		// The event handler functions are defined in handlers.js
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete	// Queue plugin event
	};

	swfu = new SWFUpload(settings);
    };
    
    function queueComplete(numFilesUploaded) {
		var status = document.getElementById("divStatus");
		status.innerHTML = numFilesUploaded + " 个文件" + (numFilesUploaded === 1 ? "" : "s") + " 上传成功.";
		alert("成功上传了 " + numFilesUploaded + " 个文件！");
		var fn = ${empty uploadComplete ? "null" : uploadComplete};
		if (typeof fn == "function") fn(numFilesUploaded);
	}
</script>

<div class="swfuploadcontainer png">
	<form id="form1" action="about:blank" method="post" enctype="multipart/form-data">
		<div class="fieldset flash" id="fsUploadProgress">
			<span class="legend">上传列表</span>
		</div>
		<div id="divStatus">0个文件被上传</div>
		<div>
			<span id="spanButtonPlaceHolder"></span>&nbsp;
			<input class="r_button r_button80" id="btnUpload" type="button" value="开始上传" onclick="swfu.startUpload();" disabled="disabled" />
			<input class="r_button r_button80" id="btnCancel" type="button" value=" 取消 " onclick="swfu.cancelQueue();" disabled="disabled" />
		</div>
	</form>
</div>