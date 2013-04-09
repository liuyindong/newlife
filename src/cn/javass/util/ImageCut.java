package cn.javass.util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageCut extends Thread
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		// scale("E:\\Travel\\photo\\1208011507326861.jpg", "C:\\缩小后的2.jpg",
		// 585, 543);
		// zoomPicture("E:\\Penguins.jpg", "C:\\缩放.jpg", 100.100);
		abscut("C:\\2.jpg", "C:\\剪切后的图片2.jpg", 215, 11, 350, 350);
		zoomPicture("C:\\2.jpg", "C:\\缩放.jpg");
		scale("C:\\2.jpg", "C:\\缩放后的一个.jpg", 100, 100);
		scale("C:\\2.jpg", "C:\\压缩后的一个.jpg", 1, false);
	}

	/**
	 * 图像切割（改） *
	 * 
	 * @param srcImageFile
	 *            源图像地址
	 * @param dirImageFile
	 *            新图像地址
	 * @param x
	 *            目标切片起点x坐标
	 * @param y
	 *            目标切片起点y坐标
	 * @param destWidth
	 *            目标切片宽度
	 * @param destHeight
	 *            目标切片高度
	 */
	public static void abscut(String srcImageFile, String dirImageFile, int x, int y, int destWidth, int destHeight)
	{
		try
		{
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(new File(srcImageFile));
			int srcWidth = bi.getWidth(); // 源图宽度
			int srcHeight = bi.getHeight(); // 源图高度
			// 获取图片格式
			int index = srcImageFile.lastIndexOf(".");
			String imgType = srcImageFile.substring(index + 1);
			if (srcWidth >= destWidth && srcHeight >= destHeight)
			{
				Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);
				// 改进的想法:是否可用多线程加快切割速度
				// 四个参数分别为图像起点坐标和宽高
				// 即: CropImageFilter(int x,int y,int width,int height)
				cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
				img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
				BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				// tag.getGraphics().drawImage(src.getScaledInstance(widthdist,
				// heightdist, Image.SCALE_SMOOTH), 0, 0, null);

				g.drawImage(img, 0, 0, null); // 绘制缩小后的图
				g.dispose();
				// 输出为文件
				ImageIO.write(tag, imgType, new File(dirImageFile));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 缩放加清晰度
	 * 
	 * @param inputFile
	 * @param outputPicName
	 * @param max
	 */
	public static void zoomPicture(String srcImg, String outputPicName)
	{
		BufferedImage sizeImage = null;
		try
		{
			sizeImage = ImageIO.read(new File(srcImg));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int srcWidth = sizeImage.getWidth(); // 源图宽度
		int srcHeight = sizeImage.getHeight(); // 源图高度
		/*
		 * if ((srcWidth > 600 && srcHeight < 600) || (srcWidth < 600 &&
		 * srcHeight > 600) || (srcWidth > 600 && srcHeight > 600))
		 * {
		 * srcWidth = srcWidth / 2;
		 * srcHeight = srcHeight / 2;
		 * System.out.println("图片已经剪切");
		 * }
		 */
		// 判断图片是否是长方形的
		int num = Math.abs(srcWidth - srcHeight);
		if (num > srcWidth || num > srcHeight)
		{
			System.out.println("上传的图片可能不合法");
		}
		String imageBig = (srcWidth + "." + srcHeight);
		double maxLimit = Double.parseDouble(imageBig);
		double ratio = 1.0;
		try
		{
			BufferedImage Bi = ImageIO.read(new File(srcImg));
			if ((Bi.getWidth() > maxLimit))
			{
				ratio = maxLimit / Bi.getWidth();
			}
			int widthdist = (int) Math.floor(Bi.getWidth() * ratio), heightdist = (int) Math.floor(Bi.getHeight() * ratio);
			BufferedImage tag = new BufferedImage(widthdist, heightdist, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(Bi.getScaledInstance(widthdist, heightdist, BufferedImage.SCALE_SMOOTH), 0, 0, null);
			File littleFile = new File(outputPicName);
			ImageIO.write(tag, "JPEG", littleFile);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	/**
	 * 缩放图像
	 * 
	 * @param srcImageFile
	 *            源图像文件地址
	 * @param result
	 *            缩放后的图像地址
	 * @param scale
	 *            缩放比例
	 * @param flag
	 *            缩放选择:true 放大; false 缩小;
	 */
	public static void scale(String srcImageFile, String result, int scale, boolean flag)
	{
		try
		{
			// 获取图片格式
			int index = srcImageFile.lastIndexOf(".");
			String imgType = srcImageFile.substring(index + 1);
			BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
			int width = src.getWidth(); // 得到源图宽
			int height = src.getHeight(); // 得到源图长
			if (flag)
			{
				// 放大
				width = width * scale;
				height = height * scale;
			}
			else
			{
				// 缩小
				width = width / scale;
				height = height / scale;
			}
			Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			ImageIO.write(tag, imgType, new File(result));// 输出到文件流
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 重新生成按指定宽度和高度的图像
	 * 
	 * @param imgsrc
	 *            源图像文件地址
	 * @param imgdist
	 *            新的图像地址
	 * @param widthdist
	 *            设置新的图像宽度
	 * @param heightdist
	 *            设置新的图像高度
	 */
	public static void scale(String imgsrc, String imgdist, int widthdist, int heightdist)
	{
		try
		{
			File srcfile = new File(imgsrc);
			if (!srcfile.exists())
			{
				return;
			}
			Image src = javax.imageio.ImageIO.read(srcfile);

			BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist, BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);
			// tag.getGraphics().drawImage(src.getScaledInstance(widthdist,
			// heightdist, Image.SCALE_AREA_AVERAGING), 0, 0, null);

			FileOutputStream out = new FileOutputStream(imgdist);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag);
			out.close();

		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}

	/**
	 * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X)
	 */
	public static void convert(String source, String result)
	{
		try
		{
			// 获取图片格式
			int index = source.lastIndexOf(".");
			String imgType = source.substring(index + 1);
			File f = new File(source);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, imgType, new File(result));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 彩色转为黑白
	 * 
	 * @param source
	 * @param result
	 */
	public static void gray(String source, String result)
	{
		try
		{
			// 获取图片格式
			int index = source.lastIndexOf(".");
			String imgType = source.substring(index + 1);
			BufferedImage src = ImageIO.read(new File(source));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, imgType, new File(result));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}