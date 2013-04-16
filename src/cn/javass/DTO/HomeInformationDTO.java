package cn.javass.DTO;

import java.util.List;

import cn.javass.common.pagination.Page;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.internethome.entity.InternetScrollEntity;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.sql.InternetHomeSql;

public class HomeInformationDTO
{
	private List<InternetScrollEntity> scrollTop;
	private List<InternetScrollEntity> scrollButton;
	private List<NewsEntity> listNews;
	private List<ImageWallEntity> listImageWall;
	private List<NewsEntity> listNewsYaoW; // 要闻
	private List<NewsEntity> listNewsYdhl;// 移动互联
	private List<NewsEntity> listNewsDzsw;// 电子商务
	private List<NewsEntity> listNewsSjwl; // 社交网络
	private List<NewsEntity> listNewsWlyx; // 网络游戏
	private List<NewsEntity> listNewsIt;// it
	private List<NewsEntity> listNewsSm; // 数码

	public List<NewsEntity> getListNewsYaoW()
	{
		return listNewsYaoW;
	}

	public void setListNewsYaoW(List<NewsEntity> listNewsYaoW)
	{
		this.listNewsYaoW = listNewsYaoW;
	}

	public List<NewsEntity> getListNewsYdhl()
	{
		return listNewsYdhl;
	}

	public void setListNewsYdhl(List<NewsEntity> listNewsYdhl)
	{
		this.listNewsYdhl = listNewsYdhl;
	}

	public List<NewsEntity> getListNewsDzsw()
	{
		return listNewsDzsw;
	}

	public void setListNewsDzsw(List<NewsEntity> listNewsDzsw)
	{
		this.listNewsDzsw = listNewsDzsw;
	}

	public List<NewsEntity> getListNewsSjwl()
	{
		return listNewsSjwl;
	}

	public void setListNewsSjwl(List<NewsEntity> listNewsSjwl)
	{
		this.listNewsSjwl = listNewsSjwl;
	}

	public List<NewsEntity> getListNewsWlyx()
	{
		return listNewsWlyx;
	}

	public void setListNewsWlyx(List<NewsEntity> listNewsWlyx)
	{
		this.listNewsWlyx = listNewsWlyx;
	}

	public List<NewsEntity> getListNewsIt()
	{
		return listNewsIt;
	}

	public void setListNewsIt(List<NewsEntity> listNewsIt)
	{
		this.listNewsIt = listNewsIt;
	}

	public List<NewsEntity> getListNewsSm()
	{
		return listNewsSm;
	}

	public void setListNewsSm(List<NewsEntity> listNewsSm)
	{
		this.listNewsSm = listNewsSm;
	}

	public Page<NewsEntity> getPageSm()
	{
		return pageSm;
	}

	public void setPageSm(Page<NewsEntity> pageSm)
	{
		this.pageSm = pageSm;
	}

	Page<NewsEntity> pageSm;

	public List<NewsEntity> getListNews()
	{
		return listNews;
	}

	public void setListNews(List<NewsEntity> listNews)
	{
		this.listNews = listNews;
	}

	public List<ImageWallEntity> getListImageWall()
	{
		return listImageWall;
	}

	public void setListImageWall(List<ImageWallEntity> listImageWall)
	{
		this.listImageWall = listImageWall;
	}

	public List<InternetScrollEntity> getScrollButton()
	{
		return scrollButton;
	}

	public void setScrollButton(List<InternetScrollEntity> scrollButton)
	{
		this.scrollButton = scrollButton;
	}

	public List<InternetScrollEntity> getScrollTop()
	{
		return scrollTop;
	}

	public void setScrollTop(List<InternetScrollEntity> scrollTop)
	{
		this.scrollTop = scrollTop;
	}
}
