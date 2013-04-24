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

//@Entity
//@Table(name = "tbl_comment_news")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommentNewsEntity extends AbstractModel
{
	private static final long serialVersionUID = -8811560654949342625L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "comment_msg", length = 1000)
	private String commentMsg;

	@Column(name = "new_msg_id", length = 50)
	private Integer newsMsgId;

	@Column(name = "user_id", length = 50)
	private Integer userId;

	@Column(name = "create_date", length = 30)
	private String createDate;

	@Column(name = "user_browser", length = 30)
	private String browser;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCommentMsg()
	{
		return commentMsg;
	}

	public void setCommentMsg(String commentMsg)
	{
		this.commentMsg = commentMsg;
	}

	public Integer getNewsMsgId()
	{
		return newsMsgId;
	}

	public void setNewsMsgId(Integer newsMsgId)
	{
		this.newsMsgId = newsMsgId;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getBrowser()
	{
		return browser;
	}

	public void setBrowser(String browser)
	{
		this.browser = browser;
	}
}
