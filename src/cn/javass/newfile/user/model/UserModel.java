package cn.javass.newfile.user.model;

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
@Table(name = "tbl_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserModel extends AbstractModel
{

	private static final long serialVersionUID = 6129619356724468683L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(length = 30)
	private String username;

	@Column(length = 30)
	private String email;

	@Column(length = 100)
	private String password;
	
	@Column(length = 100)
	private String createdate;
	
	@Column(length = 100)
	private String userioc;
	
	//0 男 1女
	@Column(length = 2)
	private Integer usersix = 0;
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getCreatedate()
	{
		return createdate;
	}

	public void setCreatedate(String createdate)
	{
		this.createdate = createdate;
	}

	public Integer getUsersix()
	{
		return usersix;
	}

	public void setUsersix(Integer usersix)
	{
		this.usersix = usersix;
	}

	public String getUserioc()
	{
		return userioc;
	}

	public void setUserioc(String userioc)
	{
		this.userioc = userioc;
	}
}
