package cn.javass.newfile.internethome.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.javass.common.model.AbstractModel;

/**
 * 滚动信息
 * @author liuyd
 *
 */
@Entity
@Table(name = "tbl_internet_scroll")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class InternetScrollEntity extends AbstractModel
{
	private static final long serialVersionUID = 4017722618928742292L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "image_name")
	private String name;
	
	@Column(name = "image_title")
	private String title;
	
	@Column(name = "recommend_time")
	private String recommendTime;

	@Column(name = "type_scroll")
	private int typeScroll; //1:首页的   2:是首页底部
	
	@Column(name = "img_url")
	private String imgUrl;
	
	@Column(name = "click_url")
	private String clickUrl;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getRecommendTime()
	{
		return recommendTime;
	}

	public void setRecommendTime(String recommendTime)
	{
		this.recommendTime = recommendTime;
	}

	public int getTypeScroll()
	{
		return typeScroll;
	}

	public void setTypeScroll(int typeScroll)
	{
		this.typeScroll = typeScroll;
	}

	public String getImgUrl()
	{
		return imgUrl;
	}

	public void setImgUrl(String imgUrl)
	{
		this.imgUrl = imgUrl;
	}

	public String getClickUrl()
	{
		return clickUrl;
	}

	public void setClickUrl(String clickUrl)
	{
		this.clickUrl = clickUrl;
	}
	
	
}
