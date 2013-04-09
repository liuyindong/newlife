package cn.javass.test;

import java.io.File;

public class Test002
{
	public static void main(String[] args)
	{
		test("D://2013/04/08");
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
				System.out.println("目录" + files[i].getPath());
				// test(files[i].getPath());
			}
			else
			{
				System.out.println("文件：" + files[i].getName());
			}
		}
	}
}