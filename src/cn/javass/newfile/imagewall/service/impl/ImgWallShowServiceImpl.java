package cn.javass.newfile.imagewall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.javass.common.dao.IBaseDao;
import cn.javass.common.service.impl.BaseService;
import cn.javass.newfile.imagewall.dao.ImgWallShowDao;
import cn.javass.newfile.imagewall.entity.ImgWallShowEntity;
import cn.javass.newfile.imagewall.service.ImgWallShowService;

@Service("ImgWallShowService")
public class ImgWallShowServiceImpl extends BaseService<ImgWallShowEntity,Integer> implements ImgWallShowService
{
	private final String HQL_IMGWALL_SHOW = "from ImgWallShowEntity";
	
	private final String HQL_IMGWALL_SHOW_BY_WALL_ID = " where pertainWallId = ? ";
	
	
	private ImgWallShowDao imgWallShowDao;
	
	@Autowired
	@Qualifier("ImgWallShowDao")
	
	@Override
	public void setBaseDao(IBaseDao<ImgWallShowEntity, Integer> imgWallShowDao)
	{
		this.baseDao = imgWallShowDao;
		this.imgWallShowDao = (ImgWallShowDao) imgWallShowDao;
		
	}

}
