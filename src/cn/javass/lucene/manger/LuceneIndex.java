package cn.javass.lucene.manger;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import cn.javass.newfile.newmsg.entity.NewsEntity;

/**
 * 索引创建、删除、更新、添加
 * 
 * @author Administrator
 * 
 */
public class LuceneIndex
{
	private static final Object MUTEX = new Object();
	private LuceneIndexSettings indexSettings;
	private Directory ramDirectory;

	/**
	 * 构造方法
	 */
	public LuceneIndex(LuceneIndexSettings luceneIndexSettings)
	{
		this.indexSettings = luceneIndexSettings;
	}

	/**
	 * 刷新内存索引
	 */
	public void flushRAMDirectory()
	{
		synchronized (MUTEX)
		{
			IndexWriterConfig indexWriterConfig = null;
			IndexWriter indexWriter = null;
			ramDirectory = new RAMDirectory();
			try
			{
				indexWriterConfig = new IndexWriterConfig(Version.LUCENE_40, this.indexSettings.getAnalyzer());
				indexWriter = new IndexWriter(this.indexSettings.getDirectory(), indexWriterConfig);
				indexWriter.addIndexes(new Directory[] { this.ramDirectory });
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					indexWriter.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * 创建索引
	 * 
	 * @param newMsg
	 */
	public void createIndex(NewsEntity newMsg)
	{
		synchronized (MUTEX)
		{
			IndexWriterConfig indexWriterConfig = null;
			IndexWriter indexWriter = null;
			try
			{
				indexWriterConfig = new IndexWriterConfig(Version.LUCENE_40, this.indexSettings.getAnalyzer());
				indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
				indexWriter = new IndexWriter(this.indexSettings.getDirectory(), indexWriterConfig);
				// 调用创建document的方法
				Document doc = createDocument(newMsg);
				System.out.println("我创建的doc:" + doc);
				indexWriter.addDocument(doc);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					indexWriter.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 批量创建索引
	 * 
	 * @param newMsg
	 */
	public void createIndexALL(List<?> list)
	{
		synchronized (MUTEX)
		{
			IndexWriterConfig indexWriterConfig = null;
			IndexWriter indexWriter = null;
			try
			{
				indexWriterConfig = new IndexWriterConfig(Version.LUCENE_40, this.indexSettings.getAnalyzer());
				indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
				indexWriter = new IndexWriter(this.indexSettings.getDirectory(), indexWriterConfig);
				// 调用创建document的方法
				List<Document> docs = createDocumentAll(list);
				System.out.println("总共需要创建:" + docs.size());
				for (int i = 0; i < docs.size(); i++)
				{
					indexWriter.addDocument((Document) docs.get(i));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					indexWriter.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新索引：先删除对应的索引，再更新。
	 * 
	 * @param newMsg
	 */
	public void updateIndex(NewsEntity newMsg)
	{
		if (delIndex(newMsg))
		{
			createIndex(newMsg);
		}
	}

	/**
	 * 删除索引
	 * 
	 * @param p
	 *            实体对象
	 * @return isOK删除结果
	 */
	public boolean delIndex(NewsEntity newMsg)
	{
		boolean isOK = false;
		synchronized (MUTEX)
		{
			IndexWriter indexWriter = null;
			IndexWriterConfig indexWriterConfig = null;
			try
			{
				indexWriterConfig = new IndexWriterConfig(Version.LUCENE_40, this.indexSettings.getAnalyzer());
				indexWriter = new IndexWriter(this.indexSettings.getDirectory(), indexWriterConfig);
				indexWriter.deleteDocuments(new Term("msgId", newMsg.getId()+""));
				isOK = true;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					indexWriter.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return isOK;
	}

	/**
	 * 创建document对象
	 * 
	 * @param newMsg
	 *            实体类
	 * @return document document对象
	 */
	public Document createDocument(NewsEntity newMsg)
	{
		//TextField
		Document document = new Document();
		document.add(new StringField("downdate", newMsg.getDownDate(), Store.YES));
		document.add(new TextField("newMsg", newMsg.getNewMsgOne(), Store.YES));
		document.add(new TextField("title", newMsg.getTitle(), Store.YES));
		document.add(new StringField("msgId", newMsg.getId()+"", Store.YES));
		return document;
	}

	/**
	 * 批量创创建document
	 * 
	 * @param list
	 * @return
	 */
	public List<Document> createDocumentAll(List<?> list)
	{
		List<Document> documents = new ArrayList<Document>();
		for (int i = 0; i < list.size(); i++)
		{
			NewsEntity newMsg = (NewsEntity) list.get(i);
			String newMsgText = Jsoup.clean(newMsg.getNewMsgOne(), Whitelist.basicWithImages());
			Document document = new Document();
			document.add(new StringField("downdate", newMsg.getDownDate(), Store.YES));
			document.add(new TextField("newMsg", newMsgText, Store.YES));
			document.add(new TextField("title", newMsg.getTitle(), Store.YES));
			document.add(new StringField("msgId", newMsg.getId()+"", Store.YES));
			documents.add(document);
		}
		return documents;
	}

	/**
	 * 判断索引是否存在
	 * 
	 * @param newMsg
	 * @return
	 */
	public boolean exist(NewsEntity newMsg)
	{
		boolean isExits = false;
		IndexReader indexReader = null;
		try
		{
			indexReader = DirectoryReader.open(this.indexSettings.getDirectory());
			int count = indexReader.docFreq(new Term("msgId", newMsg.getId()+""));
			isExits = count > 0;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				indexReader.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return isExits;
	}

}
