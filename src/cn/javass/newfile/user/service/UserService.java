package cn.javass.newfile.user.service;

import cn.javass.common.pagination.Page;
import cn.javass.common.service.IBaseService;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.model.UserQueryModel;

public interface UserService extends IBaseService<UserModel, Integer>
{
	Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
	
	UserModel userLogin(String username,String pwd);
	
	UserModel userIsExtis(String email);
	
	boolean quitUser();
	
}
