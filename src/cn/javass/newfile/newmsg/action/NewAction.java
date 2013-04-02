package cn.javass.newfile.newmsg.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.javass.newfile.lucene.SearchNewMsg;
import cn.javass.newfile.lucene.manger.LuceneIndexManager;
import cn.javass.newfile.newmsg.entity.NewsEntity;
import cn.javass.newfile.newmsg.service.NewService;

@Controller
public class NewAction
{
	
	private static final String SQL_CLICK_NUM_ADDONE =  "update tbl_news_msg set click_num=click_num+1 where id = ?";;
	
	@Autowired
	@Qualifier("NewService")
	private NewService newService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/news/search", method = { RequestMethod.POST })
	public String searchNews(Model model, HttpServletRequest request) throws Exception
	{
		LuceneIndexManager lim = new LuceneIndexManager();
		lim.indexInit();
//		List<NewsEntity> listNews = newService.listAll("from NewsEntity order by downDate");
//    	lim.createALL(listNews);
		
		String searchName = request.getParameter("searchName");
		List listSearch = SearchNewMsg.searchNews(searchName, "title", 1000, 1);

		if (listSearch.size() != 0)
		{
			model.addAttribute("page", listSearch);
		}
		else
		{
			NewsEntity newsMsg = new NewsEntity();
			newsMsg.setNewMsgOne("<h2>亲,搜你这个问题我鸭梨山大啊,你能换个问题搜么?<img src='/"+request.getContextPath()+"/images/biaoqin/wugu.gif'/></h2>");
			listSearch.add(newsMsg);
			model.addAttribute("page", listSearch);
		}

		return "newMsg/srarchList";
	}

	@RequestMapping(value = "/news/{id}/search", method = { RequestMethod.GET })
	public String searchNewsById(Model model, @PathVariable Integer id) throws Exception
	{
		List<?> listSearch = SearchNewMsg.searchNews(id + "", "msgId", 100, 1);
		model.addAttribute("showSearch", listSearch.get(0));
		newService.updateNewsOn(SQL_CLICK_NUM_ADDONE,id);
		return "newMsg/news_post";
	}
}
