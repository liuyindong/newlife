package cn.javass.sql;

public class CommentHql
{
	// 查询评论
	
	public static final String HQL_COMMENT_BY_TCID = " where commentTcId = ?";
	
	public static final String HQL_COMMENT_WHERE = " where commentType.id = ? and commentTcId = ?";
	//条件查询
	public static final String HQL_COMMENT_TWO_WHERE = HQL_COMMENT_WHERE;
	//评论数
	public static final String HQL_COMMENT_COUNT =  HQL_COMMENT_WHERE;
	//
	//查询前3条评论
	public static final String HQL_COMMENT_TOP_TRHEE = HQL_COMMENT_WHERE;
	
}
