package cn.javass.newfile.lucene.manger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.highlight.Highlighter;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.wltea.analyzer.lucene.IKAnalyzer;

import cn.javass.newfile.newmsg.entity.NewsEntity;

public class LuceneResultCollector
{
	@SuppressWarnings("unused")
	private LuceneIndexSettings luceneIndexSettings; // lucene设置类

	/**
	 * 初始化方法
	 * 
	 * @param luceneIndexSettings
	 */
	public LuceneResultCollector(LuceneIndexSettings luceneIndexSettings)
	{
		this.luceneIndexSettings = luceneIndexSettings;
	}

	public List<Object> collect(ScoreDoc[] result, IndexSearcher indexSearcher, Highlighter highlighter, int begin, int end,boolean newMsgSubmit) throws CorruptIndexException, IOException, Exception
	{
		Analyzer analyzer = new IKAnalyzer();// 词库分词

		List<Object> posts = new ArrayList<Object>();
		for (int i = begin; i < end; i++)
		{
			int docID = result[i].doc;
			Document doc = indexSearcher.doc(docID);
			NewsEntity post = new NewsEntity();
			post.setId(new Integer(doc.get("msgId")));
			post.setDownDate(doc.get("downdate"));
			String newMsg = doc.get("newMsg");
			String msgTitle = doc.get("title");
			if(newMsgSubmit)
			{
				// =========== 高亮
				newMsg = Jsoup.clean(newMsg, Whitelist.none());
				newMsg = highlighter.getBestFragment(analyzer, null,newMsg)+"...";
				msgTitle = highlighter.getBestFragment(analyzer, null,msgTitle);
				if(null == msgTitle)
				{
					msgTitle = doc.get("title");
				}
			}
			post.setTitle(msgTitle);
			post.setNewMsgOne(newMsg);
			posts.add(post);
		}

		return posts;
	}
}
