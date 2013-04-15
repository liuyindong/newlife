package cn.javass.newfile.newmsg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.javass.common.model.AbstractModel;

@Entity
@Table(name = "tbl_news_msg")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NewsEntity extends AbstractModel
{
	private static final long serialVersionUID = -7032400219519106321L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "title", length = 100)
	private String title;

	@Column(name = "url_ref", length = 1000)
	private String urlRef;

	@Column(name = "new_type", length = 40)
	private String newType;
	

	@Column(name = "click_num", length = 100)
	private Integer clickNum = 0;
	
	@Column(name="news_image")
	private String newsImage;    //展示图片
	
	@Column(name="tech_tag")   //标签
	private String techTag;

	@Column(name = "boolean_recommend", length = 2)
	private int booelanRecommend = 0; // 0:不推荐 1:推荐

	@Column(name = "products_home", length = 2)
	private int productsHome = 0; // -1:删除;0:不展示 1：展示

	@Column(name = "create_date", length = 40)
	private String createDate;

	@Column(name = "down_date", length = 40)
	private String downDate;

	@Column(name = "new_msg_one", length = 999999)
	private String newMsgOne;

	@Column(name = "new_msg_two", length = 999999)
	private String newMsgTwo;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrlRef()
	{
		return urlRef;
	}

	public void setUrlRef(String urlRef)
	{
		this.urlRef = urlRef;
	}

	public String getNewType()
	{
		return newType;
	}

	public void setNewType(String newType)
	{
		this.newType = newType;
	}

	public String getNewMsgOne()
	{
		return newMsgOne;
	}

	public void setNewMsgOne(String newMsgOne)
	{
		this.newMsgOne = newMsgOne;
	}

	public String getNewMsgTwo()
	{
		return newMsgTwo;
	}

	public void setNewMsgTwo(String newMsgTwo)
	{
		this.newMsgTwo = newMsgTwo;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public String getDownDate()
	{
		return downDate;
	}

	public void setDownDate(String downDate)
	{
		this.downDate = downDate;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public Integer getClickNum()
	{
		return clickNum;
	}

	public void setClickNum(Integer clickNum)
	{
		this.clickNum = clickNum;
	}

	public int getProductsHome()
	{
		return productsHome;
	}

	public void setProductsHome(int productsHome)
	{
		this.productsHome = productsHome;
	}

	public int getBooelanRecommend()
	{
		return booelanRecommend;
	}

	public void setBooelanRecommend(int booelanRecommend)
	{
		this.booelanRecommend = booelanRecommend;
	}

	public String getNewsImage()
	{
		return newsImage;
	}

	public void setNewsImage(String newsImage)
	{
		this.newsImage = newsImage;
	}

	public String getTechTag()
	{
		return techTag;
	}

	public void setTechTag(String techTag)
	{
		this.techTag = techTag;
	}
}
