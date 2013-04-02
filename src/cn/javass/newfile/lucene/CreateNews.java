package cn.javass.newfile.lucene;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.javass.newfile.lucene.manger.LuceneIndexManager;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.util.JdbcUtil;

public class CreateNews
{
	static Connection conn;

	static Statement st;

	public static void insert(NewsEntity newEntity)
	{

		conn = JdbcUtil.getConnection(); // 首先要获取连接，即连接到数据库

		try
		{
			String sql = "INSERT INTO tbl_news_msg(create_date, new_msg_one, title,url_ref)" + " VALUES ('"+newEntity.getCreateDate()+"', '"+newEntity.getNewMsgOne()+"', '"+newEntity.getTitle()+"', '"+newEntity.getUrlRef()+"')"; // 插入数据的sql语句

			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象

			int count = st.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数

			System.out.println("向staff表中插入 " + count + " 条数据"); // 输出插入操作的处理结果

			conn.close(); // 关闭数据库连接

		}
		catch (SQLException e)
		{
			System.out.println("插入数据失败" + e.getMessage());
		}
	}
	
	public static List<NewsEntity> selectNewsEntity(int num)
	{
		conn = JdbcUtil.getConnection();
		
		List<NewsEntity> listnewsEntity = new ArrayList<NewsEntity>();
		
		int start = num * 5000 - 5000;
		
		try
		{
			String sql = "select * from tbl_news_msg limit " + start + ",5000";
			
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象
			
			ResultSet rs = st.executeQuery(sql);
			
			
			
			while(rs.next())
			{
				NewsEntity newsEntity = new NewsEntity();
				
				newsEntity.setDownDate(rs.getString("create_date"));
				
				newsEntity.setNewMsgOne(rs.getString("new_msg_one"));
				
				newsEntity.setTitle(rs.getString("title"));
				
				newsEntity.setUrlRef(rs.getString("url_ref"));
				
				newsEntity.setId(rs.getInt("id"));
				
				listnewsEntity.add(newsEntity);
				
		//		lim.create(newsEntity);
			}
			System.out.println("本次查询到:"+listnewsEntity.size());
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return listnewsEntity;
	}
	public static void main(String[] args)
	{
		List<NewsEntity> listnewsEntity = null;
		
		LuceneIndexManager lim = new LuceneIndexManager();
		try
		{
			lim.indexInit();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
		
		for (int i = 1; i < 10; i++)
		{
			
			listnewsEntity = null;
			
			listnewsEntity = selectNewsEntity(i);
			
			lim.createALL(listnewsEntity);
			
			if(listnewsEntity.size() < 5000)
			{
				break;
			}
		}
		
	}
}
