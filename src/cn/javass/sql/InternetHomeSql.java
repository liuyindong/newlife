package cn.javass.sql;

public class InternetHomeSql
{
	//根据滚动类型查询滚动内容
	public final static String HQL_INTERNET_SCROLL_BY_TYPE = "from InternetScroll where typeScroll = ?";
	//获取推荐信息
	public final static String HQL_NEWS_BY_RECOMMEND = "from NewsEntity where booelanRecommend = 1 and createDate = ?";
}