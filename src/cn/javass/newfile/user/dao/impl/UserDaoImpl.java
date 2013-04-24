package cn.javass.newfile.user.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.javass.common.dao.hibernate4.BaseHibernateDao;
import cn.javass.newfile.user.dao.UserDao;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.newfile.user.model.UserQueryModel;
import cn.javass.util.MD5Util;

@Repository("UserDao")
public class UserDaoImpl extends BaseHibernateDao<UserModel, Integer> implements UserDao {

    private static final String HQL_LIST = "from UserModel ";
    private static final String HQL_COUNT = "select count(*) from UserModel ";

    private static final String HQL_LIST_QUERY_CONDITION = " where username like ?";
    private static final String HQL_LIST_QUERY_ALL = HQL_LIST + HQL_LIST_QUERY_CONDITION + "order by id desc";
    private static final String HQL_COUNT_QUERY_ALL = HQL_COUNT + HQL_LIST_QUERY_CONDITION;
    
    private static final String SQL_USER_LOGIN = HQL_LIST + " where email = ? and password = ?";
    
    private static final String HQL_USER_EXTIS = HQL_LIST + " where email = ?";
    
    @Override
    public List<UserModel> query(int pn, int pageSize, UserQueryModel command) {
        return list(HQL_LIST_QUERY_ALL, pn, pageSize, getQueryParam(command));
    }

    @Override
    public int countQuery(UserQueryModel command) {
        return this.<Number>aggregate(HQL_COUNT_QUERY_ALL, getQueryParam(command)).intValue();
    }
    

    private Object[] getQueryParam(UserQueryModel command) {
        //TODO 改成全文索引
        String usernameLikeStr = "%" + command.getUsername() + "%";
        return new Object[]{
            usernameLikeStr
        };
    }

	@Override
	public UserModel userLogin(String username,String pwd)
	{
		return this.unique(SQL_USER_LOGIN, username,pwd);
	}

	@Override
	public UserModel userIsExtis(String email)
	{
		return this.unique(HQL_USER_EXTIS, email);
	}
}
