package cn.javass.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.ProcessingInstruction;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;

public class DomTest
{

	public static void main(String[] args)
	{

		SAXReader saxReader = new SAXReader();
		try
		{
			String filePath = "init_date.xml";
			Document document = new SAXReader().read(Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath));

			document.accept(new MyVisitor());
			
			System.out.println("------------------" + document.selectNodes("//InitDatas/newstypes/newstype"));

		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
	}

	private static class MyVisitor extends VisitorSupport
	{

		public void visit(Attribute node)
		{
			System.out.println("Attribute: " + node.getName() + "=" + node.getValue());
		}

		public void visit(Element node)
		{

			if (node.isTextOnly())
			{
				System.out.println("Element: " + node.getName() + " " + node.getText());
			}
			else
			{
				System.out.println("------------" + node.getName() + "-------------");
			}
		}

		public void visit(ProcessingInstruction node)
		{
			System.out.println("PI: " + node.getTarget() + " " + node.getText());
		}

	}
}