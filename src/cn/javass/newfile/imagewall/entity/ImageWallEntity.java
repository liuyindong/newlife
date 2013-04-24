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
 * 图片墙信息
 * 
 * @author LD
 * 
 */

@Entity
@Table(name = "tbl_image_wall")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ImageWallEntity extends AbstractModel
{
	private static final long serialVersionUID = -7201123149861071013L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "file_path")
	private String filePath;

	@Column(name = "img_height")
	private int imgHeight;

	@Column(name = "img_width")
	private int imgWidth;

	@Column(name = "create_date")
	private String createDate;

	@Column(name = "update_date")
	private String updateDate;

	@Column(name = "click_num")
	private int clickNum;

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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getClickNum()
	{
		return clickNum;
	}

	public void setClickNum(int clickNum)
	{
		this.clickNum = clickNum;
	}

	public int getImgWidth()
	{
		return imgWidth;
	}

	public void setImgWidth(int imgWidth)
	{
		this.imgWidth = imgWidth;
	}

	public int getImgHeight()
	{
		return imgHeight;
	}

	public void setImgHeight(int imgHeight)
	{
		this.imgHeight = imgHeight;
	}

}
