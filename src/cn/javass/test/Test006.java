package cn.javass.test;

public class Test006
{
	public static void main(String[] args)
	{
		String aa = "[www.tiantangbbs.com][电影天堂论坛][720P]奥斯陆，8月31日 Oslo, 31. august (2011).720P 中英字幕 高清下载.torrent";
		
		int a = aa.lastIndexOf("[");
		
		System.out.println(aa.substring(a));
		
	}
}
