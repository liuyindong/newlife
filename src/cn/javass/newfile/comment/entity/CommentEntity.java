package cn.javass.newfile.comment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import cn.javass.common.model.AbstractModel;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.util.DateUtil;

/**
 * 评论
 * 
 * @author LD
 * 
 */

@Entity
@Table(name = "tbl_comment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommentEntity extends AbstractModel
{
	private static final long serialVersionUID = -7739985824051402819L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "parent_id", length = 20)
	private int parentId;

	@Column(name = "comment_tc_id", length = 20)
	private int commentTcId;

	@ManyToOne(targetEntity = CommentTypeEntity.class)
	@JoinColumn(name = "comment_type")
	private CommentTypeEntity commentType;

	@ManyToOne(targetEntity = UserModel.class)
	@JoinColumn(name = "user")
	private UserModel user;

	@Column(name = "content")
	private String content;

	@Column(name = "create_date", length = 30)
	private String createDate = DateUtil.timeNow();

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getParentId()
	{
		return parentId;
	}

	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public UserModel getUser()
	{
		return user;
	}

	public void setUser(UserModel user)
	{
		this.user = user;
	}

	public int getCommentTcId()
	{
		return commentTcId;
	}

	public void setCommentTcId(int commentTcId)
	{
		this.commentTcId = commentTcId;
	}

	public CommentTypeEntity getCommentType()
	{
		return commentType;
	}

	public void setCommentType(CommentTypeEntity commentType)
	{
		this.commentType = commentType;
	}

}
