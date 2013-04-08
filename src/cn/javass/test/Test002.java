package cn.javass.test;

import java.io.File;

import cn.javass.util.FileSorter;

public class Test002
{
	
	private static final String name = "[www.ai2y.com][爱2Y网络]";
	
	public static void main(String[] args)
	{
		test("D://test");
		
	//	String aa = "[www.tiantangbbs.com][电影天堂论坛]魔戒、指环王三部曲加长版字幕下载";
	//	System.out.println(aa.substring(0,29));
	}

	public static void test(String path)
	{
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++)
		{
			// 判断是否目录
			if (files[i].isDirectory())
			{
			//	System.out.println("目录" + files[i].getPath());
				test(files[i].getPath());
			}
			else
			{
				int endIngNum = files[i].getName().lastIndexOf(".");
				String aaaa = files[i].getName().substring(endIngNum+1);
				if(aaaa.equals("torrent") || aaaa.equals("zip"))
				{
					String newName = files[i].getName();
					if(newName.substring(0,29).equals("[www.tiantangbbs.com][电影天堂论坛]"))
					{
					//	System.out.println(files[i].getName());
					}
					
					newName = name + newName.substring(29);
					FileSorter.renameFile(files[i].getParent(), files[i].getName(), newName);
				}
				
			}
		}
	}
}