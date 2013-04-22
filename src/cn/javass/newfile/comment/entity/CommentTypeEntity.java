package cn.javass.newfile.comment.entity;

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
 * 评论类型
 * @author LD
 *
 */
@Entity
@Table(name = "tbl_comment_type")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CommentTypeEntity extends AbstractModel
{
	private static final long serialVersionUID = 1743124653662797768L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "name", length = 100)
	private String name;
	
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
}
