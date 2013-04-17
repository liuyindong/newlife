function userLogin(userEmail, userPwd)
{
	if (userEmail == null || userEmail == "")
	{
		alert("请输入邮箱");
		return false;
	}
	if (userPwd == null || userPwd == "")
	{
		alert("请输入密码");
		return false;
	}
	$.ajax(
	{
		url : 'user/login',
		type : 'post',
		data :
		{
			"loginMod" : userEmail + "/" + userPwd
		},
		dataType : 'json',
		success : function(data)
		{
			if (data.result)
			{
				location.reload();
			} else
			{
				alert(data.failMsg);
			}
		},
		error : function()
		{
			alert('服务器异常亲稍后再试...');
		}

	});
}