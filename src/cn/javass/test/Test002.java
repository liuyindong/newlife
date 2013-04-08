package cn.javass.test;

import java.io.File;

public class Test002
{
	public static void main(String[] args)
	{
		test("E:\\android-sdk-windows");
	}
	public static void test(String path)
	{
		File file = new File(path);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++)
		{
		  //判断是否目录
		  if(files[i].isDirectory())
		  {
			 test(files[i].getPath());
		  }
		  System.out.println(files[i]);
		}
	}
}