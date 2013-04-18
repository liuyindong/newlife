package cn.javass.newfile.imagewall.entity;

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
import cn.javass.newfile.newmsg.entity.NewsTypesEntity;
import cn.javass.newfile.user.model.UserModel;

@Entity
@Table(name = "tbl_imgwall_comment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ImageWallCommentEntity extends AbstractModel
{
	private static final long serialVersionUID = -7739985824051402819L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "parent_id", length = 20)
	private int parentId;
	
	@Column(name = "image_wall_id", length = 20)
	private int imageWallId;

	@ManyToOne(targetEntity = UserModel.class)
	@JoinColumn(name = "user")
	private UserModel user;

	@Column(name = "content")
	private String content;

	@Column(name = "create_date", length = 30)
	private String createDate;

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

	public int getImageWallId()
	{
		return imageWallId;
	}

	public void setImageWallId(int imageWallId)
	{
		this.imageWallId = imageWallId;
	}

	public UserModel getUser()
	{
		return user;
	}

	public void setUser(UserModel user)
	{
		this.user = user;
	}

}
