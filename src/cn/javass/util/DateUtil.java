package cn.javass.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtil
{

	@SuppressWarnings("static-access")
	/**
	 * 返回当前时间+天数
	 * @param nowTime 2012-06-05)
	 * @param number  3
	 * @return 		  2012-06-08 00:00:00
	 */
	public static String after(String nowTime, Integer number)
	{
		String time = "";
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date now = null;
		try
		{
			now = sdf.parse(nowTime);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DAY_OF_MONTH, number);
		time = c.get(c.YEAR) + "-" + ((c.get(Calendar.MONTH) + 1) < 10 ? "0" + (c.get(Calendar.MONTH) + 1) : (c.get(Calendar.MONTH) + 1)) + "-" + (c.get(Calendar.DAY_OF_MONTH) < 10 ? "0" + c.get(Calendar.DAY_OF_MONTH) : c.get(Calendar.DAY_OF_MONTH)) + " " + (c.get(Calendar.HOUR_OF_DAY) < 10 ? "0" + c.get(Calendar.HOUR_OF_DAY) : c.get(Calendar.HOUR_OF_DAY)) + ":" + (c.get(Calendar.MINUTE) < 10 ? "0" + c.get(Calendar.MINUTE) : c.get(Calendar.MINUTE)) + ":" + (c.get(Calendar.SECOND) < 10 ? "0" + c.get(Calendar.SECOND) : c.get(Calendar.SECOND));
		return time;
	}

	// 当前时间
	public static String timeToString(Date date)
	{
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String timeToString(Date date, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	// string转成规定格式
	public static String stringToTime(String data, String pattern) throws Exception
	{
		DateFormat fmt = new SimpleDateFormat(pattern);
		Date date = fmt.parse(data);
		return fmt.format(date);
	}

	// 两个时间相减
	public static double jisuan(String startTime, String endTime,String pattern) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date start = sdf.parse(startTime);
		Date end = sdf.parse(endTime);
		long cha = end.getTime() - start.getTime();
		double result = cha * 1.0 / (1000 * 60 * 60);
		return result;
	}

	/**
	 * 生成随即的名字
	 * 
	 * @param fileName
	 * @return
	 */
	public static String generateFileName(String fileName)
	{
		String formatDate = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		int random = new Random().nextInt(10000);
		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);
		return formatDate + random + extension;
	}

	/**
	 * 今天的路径
	 * 
	 * @param imgTypeFor
	 * @return
	 */
	public static String addressRadom()
	{
		Date date = new Date();
		String uploadMM = DateUtil.timeToString(date, "yyyy/MM");
		String uploadDD = DateUtil.timeToString(date, "dd");
		String uploadDir = uploadMM + "/" + uploadDD + "/";
		
		return uploadDir;
	}

	/**
	 * 图片类型
	 * 
	 * @param imgName
	 * @return
	 */
	public static String imgType(String imgName)
	{
		try
		{
			int position = imgName.lastIndexOf(".");
			String imgType = imgName.substring(position);
			return imgType;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}
	public static void main(String[] args) throws Exception
	{
		String t = "2012-12-23 18:02:58";
		String DOWN_DATE_TIME = "yyyy-MM-dd HH";
		
		boolean d = DateUtil.jisuan(DateUtil.stringToTime(t, DOWN_DATE_TIME), DateUtil.timeToString(new Date(), DOWN_DATE_TIME), DOWN_DATE_TIME) == 0;
		
		System.out.println(d);
	}

}
