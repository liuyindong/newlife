package cn.javass.DTO;

import java.util.List;

import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.internethome.entity.InternetScroll;
import cn.javass.newfile.newmsg.entity.NewsEntity;

public class HomeInformationDTO
{
	private List<InternetScroll> scrollTop;
	
	private List<InternetScroll> scrollButton;

	private List<NewsEntity> listNews;

	private List<ImageWallEntity> listImageWall;

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

	public List<InternetScroll> getScrollButton()
	{
		return scrollButton;
	}

	public void setScrollButton(List<InternetScroll> scrollButton)
	{
		this.scrollButton = scrollButton;
	}

	public List<InternetScroll> getScrollTop()
	{
		return scrollTop;
	}

	public void setScrollTop(List<InternetScroll> scrollTop)
	{
		this.scrollTop = scrollTop;
	}

}
