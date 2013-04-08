package cn.javass.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

public class JavaDown
{
	public static void main(String[] args) throws Exception
	{
		String path = "http://www.tiantangbbs.com/forum.php?mod=attachment&aid=MjQ5NDB8ZmJjNzcyNmZ8MTM2NTMxODgzN3wwfDMwMjE%3D";
		String a = "http://images.51cto.com/files/uploadimg/20120508/154629214.png";

		String imgurl = path;
		URL url = new URL(imgurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();

		// 获取文件名和扩展名
		// 先连接一次，解决跳转下载
		conn.getResponseCode();
		imgurl = conn.getURL().toString();
		// 第一种方式，针对 img.png
		String fileName = imgurl.substring(imgurl.lastIndexOf("/") + 1);
		String extName;
		if (fileName.lastIndexOf(".") > 0)
		{
			extName = fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		// 第二种方式，获取header 确定文件名和扩展名
		System.out.println(conn.getContentType());
		System.out.println( conn.getHeaderField("Content-Disposition"));

		// 还找不到的话，我也没辙了。

	}
}
