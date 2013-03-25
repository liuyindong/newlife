package cn.javass.newfile.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.pagination.Page;
import cn.javass.common.pagination.PageUtil;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.user.dao.UserDao;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.model.UserQueryModel;
import cn.javass.newfile.user.service.UserService;


@Service("UserService")
public class UserServiceImpl extends BaseService<UserModel, Integer> implements UserService {

 //   private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    @Autowired
    @Qualifier("UserDao")
    @Override
    public void setBaseDao(IBaseDao<UserModel, Integer> userDao) {
        this.baseDao = userDao;
        this.userDao = (UserDao) userDao;
    }
    


    @Override
    public Page<UserModel> query(int pn, int pageSize, UserQueryModel command) {
        return PageUtil.getPage(userDao.countQuery(command) ,pn, userDao.query(pn, pageSize, command), pageSize);
    }



	@Override
	public UserModel userLogin(String loginModel)
	{
		return userDao.userLogin(loginModel);
	}



	@Override
	public UserModel userIsExtis(String email)
	{
		return userDao.userIsExtis(email);
	}

   
}