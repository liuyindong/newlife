package cn.javass.DTO;

import java.util.List;

import cn.javass.newfile.imagewall.entity.ImageWallCommentEntity;

public class ImageWallDTO
{
	private int id;

	private String name;

	private String title;

	private String content;

	private String filePath;

	private String createDate;

	private String updateDate;

	private int loveNum; // 喜欢数

	private int commentNum; // 评论数
	
	private boolean userIsLoveWall = false;

	private List<ImageWallCommentEntity> listWallComment; // 显示3条评论

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

	public int getLoveNum()
	{
		return loveNum;
	}

	public void setLoveNum(int loveNum)
	{
		this.loveNum = loveNum;
	}

	public int getCommentNum()
	{
		return commentNum;
	}

	public void setCommentNum(int commentNum)
	{
		this.commentNum = commentNum;
	}

	public List<ImageWallCommentEntity> getListWallComment()
	{
		return listWallComment;
	}

	public void setListWallComment(List<ImageWallCommentEntity> listWallComment)
	{
		this.listWallComment = listWallComment;
	}

	public boolean isUserIsLoveWall()
	{
		return userIsLoveWall;
	}

	public void setUserIsLoveWall(boolean userIsLoveWall)
	{
		this.userIsLoveWall = userIsLoveWall;
	}
}
