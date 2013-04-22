package cn.javass.newfile.imagewall.entity;

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
 * 喜欢图片墙
 * @author LD
 *
 */

@Entity
@Table(name = "tbl_wall_love")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ImgWallLoveEntity extends AbstractModel
{
	private static final long serialVersionUID = 7928288984102996942L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "image_wall_id", length = 10)
	private int imageWallId;

	@Column(name = "user_id", length = 10)
	private int userId;

	@Column(name = "create_date", length = 20)
	private String createDate;

	@Column(name = "update_date", length = 20)
	private String updateDate;
	@Column(name = "status", length = 1)
	private int status = 0;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getImageWallId()
	{
		return imageWallId;
	}

	public void setImageWallId(int imageWallId)
	{
		this.imageWallId = imageWallId;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getUpdateDate()
	{
		return updateDate;
	}

	public void setUpdateDate(String updateDate)
	{
		this.updateDate = updateDate;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}
}
