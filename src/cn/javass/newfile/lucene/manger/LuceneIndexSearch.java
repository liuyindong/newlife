package cn.javass.newfile.lucene.manger;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.util.Version;

public class LuceneIndexSearch
{
	private IndexSearcher indexSearcher; // indexSearcher对象
	private LuceneIndexSettings indexSettings;
	private LuceneResultCollector contentCollector;

	/**
	 * 构造方法对：indexSearcher、indexSettings、contentCollector进行初始化
	 * 
	 * @param indexSettings
	 * @param contentCollector
	 */
	public LuceneIndexSearch(LuceneIndexSettings indexSettings, LuceneResultCollector contentCollector)
	{
		this.indexSettings = indexSettings;
		this.contentCollector = contentCollector;
		// 调用初始化indexSearch对象的方法
		createIndexSearch();
	}

	/**
	 * 初始化indexSearch对象的方法
	 * 
	 * @throws Exception
	 */
	public void createIndexSearch()
	{
		try
		{
			IndexReader indexReader = DirectoryReader.open(this.indexSettings.directory);
			this.indexSearcher = new IndexSearcher(indexReader);

			// 输出现在的索引
		//	for (int i = 0; i < indexReader.numDocs(); i++)
		//	{
			//	System.out.println(indexReader.document(i));
		//	}
		//	System.out.println("索引内文档数量：" + indexReader.numDocs());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 查询方法
	 * 
	 * @throws Exception
	 */
	public List<Object> Search(String searchString, LuceneResultCollector luceneResultCollector, String queryType, int pageSize, int currentPage) throws Exception
	{

		// 方法一:
		QueryParser q = new QueryParser(Version.LUCENE_40, queryType, this.indexSettings.getAnalyzer());
		Query query = q.parse(searchString);
		// 方法二:
		// Term t = new Term("fileName", searchString);
		// TermQuery query = new TermQuery(t);
		ScoreDoc[] docs = this.indexSearcher.search(query, 100).scoreDocs;

		List<Object> result = null;

		if (docs.length == 0)
		{
			System.out.println("没有查询到");
			result = new ArrayList<Object>();
			return result;
		}
		// ============== 准备高亮器
		Formatter formatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
		Scorer scorer = new QueryScorer(query);
		Highlighter highlighter = new Highlighter(formatter, scorer);
		Fragmenter fragmenter = new SimpleFragmenter(200);
		highlighter.setTextFragmenter(fragmenter);

		// 查询起始记录位置
		int begin = pageSize * (currentPage - 1);
		// 查询终止记录位置
		int end = Math.min(begin + pageSize, docs.length);

		if ("msgId".equals(queryType))
		{
			result = luceneResultCollector.collect(docs, this.indexSearcher, highlighter, begin, end, false);
		}
		else
		{
			result = luceneResultCollector.collect(docs, this.indexSearcher, highlighter, begin, end, true);
		}
		return result;

	}

	/**
	 * 调用查询方法
	 * 
	 * @param searchString
	 * @return
	 * @throws Exception
	 */
	public List<?> serarchFile(String searchString, String queryType, int pageSize, int currentPage) throws Exception
	{
		return this.Search(searchString, this.contentCollector, queryType, pageSize, currentPage);
	}
	
}
