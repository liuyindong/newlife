package cn.javass.file.entity;

public class MenuTreeDto
{
	private String id;
	
	private String name;
	
	private String isParent;
	
	private String filePath;
	
	private boolean drag; //是否拖拽
	
//	private String pId;
	
//	private String icon;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public String getIsParent()
	{
		return isParent;
	}

	public void setIsParent(String isParent)
	{
		this.isParent = isParent;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public boolean getDrag()
	{
		return drag;
	}

	public void setDrag(boolean drag)
	{
		this.drag = drag;
	}

}
