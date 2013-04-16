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
@Table(name = "tbl_news_types")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class NewsTypesEntity extends AbstractModel
{
	private static final long serialVersionUID = 1804046722202394417L;

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
