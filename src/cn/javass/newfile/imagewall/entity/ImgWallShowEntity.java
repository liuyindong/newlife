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
 * 图片墙底下的图片
 * @author LD
 *
 */
@Entity
@Table(name = "tbl_imgwall_show")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ImgWallShowEntity extends AbstractModel
{
	private static final long serialVersionUID = 4774122489323014718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "directions")
	private String 	directions;//说明
	
	@Column(name = "pertain_wall_id")
	private int pertainWallId; //图片墙id
	
	@Column(name = "file_path")
	private String filePath;
	
	@Column(name = "create_date")
	private String createDate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDirections()
	{
		return directions;
	}

	public void setDirections(String directions)
	{
		this.directions = directions;
	}

	public int getPertainWallId()
	{
		return pertainWallId;
	}

	public void setPertainWallId(int pertainWallId)
	{
		this.pertainWallId = pertainWallId;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	
	

}
