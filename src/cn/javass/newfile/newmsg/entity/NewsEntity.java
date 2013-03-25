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

	@Column(name = "url_ref",length = 1000)
	private String urlRef;

	@Column(name = "new_type", length = 40)
	private String newType;

	@Column(name = "create_date", length = 40)
	private String createDate;

	@Column(name = "down_date", length = 40)
	private String downDate;

	@Column(name = "new_msg_one", length = 999999)
	private String newMsgOne;

	@Column(name = "new_msg_two", length = 999999)
	private String newMsgTwo;
	
	@Column(name = "click_num", length = 100)
	private Integer clickNum = 0;

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
}
