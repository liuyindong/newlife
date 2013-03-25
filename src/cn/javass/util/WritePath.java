package cn.javass.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class WritePath
{
	/**
	 * 读取文本文件.
	 * 
	 */
	public static String readTxtFile(String path)
	{
		BufferedReader bufread;
		// 指定文件路径和名称
		File filename = new File(path);
		String readStr = "";

		String read;
		FileReader fileread;
		try
		{
			fileread = new FileReader(filename);
			bufread = new BufferedReader(fileread);
			try
			{
				while ((read = bufread.readLine()) != null)
				{
					readStr = readStr + read + "\r\n";
					readStr = readStr.replaceAll("\\s*", "");
				}
		//		System.out.println("读取到的内容是:"+readStr);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return readStr;
	}

	/**
	 * 向文本文件中写入内容或追加新内容,如果append为true则直接追加新内容,<br>
	 * 如果append为false则覆盖原来的内容<br>
	 * 
	 * @param path
	 *            路径
	 * @param content
	 *            内容
	 * @param append
	 */
	public static boolean writeFile(String path, String content, boolean append)
	{
		File writefile;
		try
		{
			// 通过这个对象来判断能不能 向文本文件中追加内容
			boolean addStr = append;

			writefile = new File(path);

			// 如果文本文件不存在则建立 它
			if (writefile.exists() == false)
			{
				writefile.createNewFile();
				writefile = new File(path); // 重新实例化
			}

			FileOutputStream fw = new FileOutputStream(writefile, addStr);
			
	//		content = new String(content.getBytes(),"gbk");
			
			fw.write(content.getBytes());
			fw.flush();
			fw.close();
			return true;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
	}

	/**
	 * 
	 */
	public static String zhuanHuanIp(String loginAddress)
	{
		String loginZuiHou = null;
		String loginPath = loginAddress.toString();
		if (loginPath.startsWith("/"))
		{
			loginZuiHou = loginPath.substring(1);
			loginZuiHou = loginZuiHou.replaceAll("\\.", "");
			loginZuiHou = loginZuiHou.replaceAll("\\:", "");
		}else
		{
			loginZuiHou = loginPath.replaceAll("\\.", "");
			loginZuiHou = loginZuiHou.replaceAll("\\:", "");
		}
		return loginZuiHou;
	}
}
