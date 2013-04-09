package cn.javass.test;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.util.DateUtil;
import cn.javass.util.ImageCut;
import cn.javass.util.JdbcUtil;
import cn.javass.util.WritePath;

public class AddImgWallTest
{
	public static void imageWall(ImageWallEntity imgWall)
	{
		Connection conn = JdbcUtil.getConnection(); // 首先要获取连接，即连接到数据库

		try
		{
			String sql = "insert into tbl_image_wall(content,create_date,file_path,title)" + "values('"+imgWall.getContent()+"','"+imgWall.getCreateDate()+"','"+imgWall.getFilePath()+"','"+imgWall.getTitle()+"')"; // 插入数据的sql语句

			System.out.println(sql);
			
			Statement st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象

			int count = st.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数

			System.out.println("向staff表中插入 " + count + " 条数据"); // 输出插入操作的处理结果

			conn.close(); // 关闭数据库连接

		}
		catch (SQLException e)
		{
			System.out.println("插入数据失败" + e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		String pp = "D://Workspaces/eclipseword/newlife/WebContent/WEB-INF/images/Girl/";
		String pp1 = "D://Workspaces/eclipseword/newlife/WebContent/WEB-INF/images/Girl/suo/";
		File file = new File(pp);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++)
		{
			if(!files[i].isDirectory())
			{
				ImageCut.scale(pp +files[i].getName() , pp1+files[i].getName(), 5, false);
			}
		}
		
	}
	
}
