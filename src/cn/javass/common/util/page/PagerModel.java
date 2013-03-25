package cn.javass.common.util.page;

import java.util.List;

public class PagerModel
{
	private List<Object> datas;
	private int total;
	private int offset;
	private int pagesize;
	@SuppressWarnings("unused")
	private int pageNumber;
	@SuppressWarnings("unused")
	private int totalPage;

	public int getOffset()
	{
		return offset;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public int getPagesize()
	{
		return pagesize;
	}

	public void setPagesize(int pagesize)
	{
		this.pagesize = pagesize;
	}

	public List<Object> getDatas()
	{
		return datas;
	}

	public void setDatas(List<Object> datas)
	{
		this.datas = datas;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getPageNumber()
	{
		return (offset / pagesize + 1);
	}

	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}

	public int getTotalPage()
	{
		return total % pagesize == 0 ? total / pagesize : total / pagesize + 1;
	}

	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

}
