package cn.javass.DTO;

import java.util.List;

import cn.javass.common.pagination.Page;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.internethome.entity.InternetScrollEntity;
import cn.javass.newfile.newmsg.entity.NewsEntity;

public class HomeInformationDTO
{
	private List<InternetScrollEntity> scrollTop;
	
	private List<InternetScrollEntity> scrollButton;

	private List<NewsEntity> listNews;

	private List<ImageWallEntity> listImageWall;
	
	private Page<?> page;

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

	public Page getPage()
	{
		return page;
	}

	public void setPage(Page page)
	{
		this.page = page;
	}

}
