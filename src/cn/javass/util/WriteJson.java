package cn.javass.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class WriteJson
{
	public static void returnJson(HttpServletResponse response, Object sendContent)
	{
		PrintWriter out;
		response.setCharacterEncoding("UTF-8");
		try
		{
			out = response.getWriter();
			out.write(JSON.toJSONString(sendContent).toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void returnJSONP(String callback, HttpServletRequest request, HttpServletResponse response, Object jsonpNeiRong) throws IOException
	{
		StringBuffer sb = new StringBuffer();
		response.setContentType("application/javascript");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		sb.append(callback);
		sb.append("(");
		sb.append(JSON.toJSONString(jsonpNeiRong).toString());
		sb.append(")");
		writer.write(sb.toString());
		writer.flush();
		sb = null;
	}

	public static void returnImg(HttpServletRequest request, HttpServletResponse response, String imgPath) throws Exception
	{
		OutputStream os = response.getOutputStream();
		try
		{
			FileInputStream fis = new FileInputStream(imgPath);
			int size = fis.available(); // 得到文件大小
			byte data[] = new byte[size];
			fis.read(data); // 读数据
			fis.close();
			response.setContentType("image/gif"); // 设置返回的文件类型
			os.write(data);
		}
		catch (Exception e)
		{
			if (e.getClass().getName().equals("org.apache.catalina.connector.ClientAbortException"))
			{
				// 用户取消下载任务报的错，无需处理
			}
		}
		finally
		{
			os.flush();
			os.close();
		}
	}
}
