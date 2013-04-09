package cn.javass.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test005
{
	private static final String RAGEX = "[0x00-0x07]";

	public static void main(String[] args) throws IOException
	{
		String id = "D://2013";
		File file = new File(id);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++)
		{
			if(!files[i].isDirectory())
			{
				System.out.println(files[i].getName() + "\t" + getCheck(files[i]));
			}
		}
	}

	public static boolean getCheck(File f) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String temp = "";
		while ((temp = br.readLine()) != null)
		{
			for (int i = 0; i < temp.length(); i++)
			{
				if ((temp.charAt(i) + "").matches(RAGEX))
				{
					return true;
				}
			}
		}
		br.close();
		return false;
	}
}
