package cn.javass.test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtils
{
	static class CompratorByLastModified implements Comparator<Object>
	{
		public int compare(Object o1, Object o2)
		{
			File file1 = (File) o1;
			File file2 = (File) o2;
			long diff = file1.lastModified() - file2.lastModified();
			if (diff > 0)
				return 1;
			else if (diff == 0)
				return 0;
			else
				return -1;
		}

		public boolean equals(Object obj)
		{
			return true; // 简单做法
		}
	}

	static class CompratorBySize implements Comparator<Object>
	{
		public int compare(Object o1, Object o2)
		{
			File file1 = (File) o1;
			File file2 = (File) o2;
			long diff = file1.length() - file2.length();
			if (diff > 0)
				return 1;
			else if (diff == 0)
				return 0;
			else
				return -1;
		}

		public boolean equals(Object obj)
		{
			return true; // 简单做法
		}
	}

	public static void main(String[] args)
	{
		File dir = new File("E:\\android-sdk-windows");
		File[] files = dir.listFiles();

		System.out.print("before sort: ");
		for (int i = 0; i < files.length; i++)
		{
			System.out.print(files[i].getName());
			System.out.println();
		}
		System.out.println("----------------------");
		Arrays.sort(files);
		System.out.print("sort by name: ");
		for (int i = 0; i < files.length; i++)
		{
			System.out.print(files[i].getName());
			System.out.println();
		}
		System.out.println("----------------------");
		Arrays.sort(files, new FileUtils.CompratorBySize());
		System.out.print("sort by size: ");
		for (int i = 0; i < files.length; i++)
		{
			System.out.print(files[i].getName());
			System.out.println();
		}
		System.out.println("----------------------");
		Arrays.sort(files, new FileUtils.CompratorByLastModified());
		System.out.print("sort by last modified: ");
		for (int i = 0; i < files.length; i++)
		{
			System.out.print(files[i].getName());
			System.out.println();
		}
	}

}
