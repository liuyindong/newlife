package cn.javass.newfile.user.dao;

import java.util.List;

import cn.javass.common.dao.IBaseDao;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.model.UserQueryModel;

public interface UserDao extends IBaseDao<UserModel, Integer>
{

	List<UserModel> query(int pn, int pageSize, UserQueryModel command);

	int countQuery(UserQueryModel command);

	UserModel userLogin(String loginModel);
	
	UserModel userIsExtis(String email);

}
