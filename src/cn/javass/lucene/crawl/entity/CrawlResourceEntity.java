package cn.javass.lucene.crawl.entity;

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
@Table(name = "tbl_crawl_resource")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CrawlResourceEntity extends AbstractModel
{
	private static final long serialVersionUID = -676922930978576750L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "domain_name", length = 20)
	private String domainName; // 域名

	@Column(name = "crawl_url")
	private String crawlUrl; // 抓取地址

	@Column(name = "select_specific", length = 20)
	private String select; // 第一次从那里区分

	@Column(name = "time_format", length = 20)
	private String timeFormat; // 时间格式

	@Column(name = "end_time", length = 10)
	private int endIsTime; // 最大获取多少时间数据

	@Column(name = "new_status", length = 2)
	private int status = 0; // 新闻状态 0:正常抓取,-1:停止抓取

	@Column(name = "show_new_select", length = 50)
	private String showNewSelect;

	@Column(name = "new_type", length = 50)
	private String newType;

	@Column(name = "date_crawl")
	private String dateCrawl; // 抓取时间的格式

	@Column(name = "title_crawl")
	private String titleCrawl;

	@Column(name = "url_ref_crawl")
	private String urlRefCrawl;

	@Column(name = "news_img_crawl")
	private String newsImgCrawl;

	@Column(name = "new_tag_crawl")
	private String newTagsCrawl;

	@Column(name = "news_msg_crawl")
	private String newsMsgCrawl;

	public String getDateCrawl()
	{
		return dateCrawl;
	}

	public void setDateCrawl(String dateCrawl)
	{
		this.dateCrawl = dateCrawl;
	}

	public String getTitleCrawl()
	{
		return titleCrawl;
	}

	public void setTitleCrawl(String titleCrawl)
	{
		this.titleCrawl = titleCrawl;
	}

	public String getUrlRefCrawl()
	{
		return urlRefCrawl;
	}

	public void setUrlRefCrawl(String urlRefCrawl)
	{
		this.urlRefCrawl = urlRefCrawl;
	}

	public String getNewsImgCrawl()
	{
		return newsImgCrawl;
	}

	public void setNewsImgCrawl(String newsImgCrawl)
	{
		this.newsImgCrawl = newsImgCrawl;
	}

	public String getNewTagsCrawl()
	{
		return newTagsCrawl;
	}

	public void setNewTagsCrawl(String newTagsCrawl)
	{
		this.newTagsCrawl = newTagsCrawl;
	}

	public String getNewsMsgCrawl()
	{
		return newsMsgCrawl;
	}

	public void setNewsMsgCrawl(String newsMsgCrawl)
	{
		this.newsMsgCrawl = newsMsgCrawl;
	}

	public String getDomainName()
	{
		return domainName;
	}

	public void setDomainName(String domainName)
	{
		this.domainName = domainName;
	}

	public String getSelect()
	{
		return select;
	}

	public void setSelect(String select)
	{
		this.select = select;
	}

	public String getTimeFormat()
	{
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat)
	{
		this.timeFormat = timeFormat;
	}

	public int getEndIsTime()
	{
		return endIsTime;
	}

	public void setEndIsTime(int endIsTime)
	{
		this.endIsTime = endIsTime;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getCrawlUrl()
	{
		return crawlUrl;
	}

	public void setCrawlUrl(String crawlUrl)
	{
		this.crawlUrl = crawlUrl;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getShowNewSelect()
	{
		return showNewSelect;
	}

	public void setShowNewSelect(String showNewSelect)
	{
		this.showNewSelect = showNewSelect;
	}

	public String getNewType()
	{
		return newType;
	}

	public void setNewType(String newType)
	{
		this.newType = newType;
	}

}
