package cn.javass.newfile.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.javass.common.Constants;
import cn.javass.common.pagination.Page;
import cn.javass.newfile.comment.entity.CommentEntity;
import cn.javass.newfile.comment.service.CommentService;
import cn.javass.newfile.comment.service.CommentTypeService;
import cn.javass.newfile.imagewall.entity.ImageWallEntity;
import cn.javass.newfile.user.model.UserModel;
import cn.javass.spring.mvc.bind.annotation.RequestJsonParam;
import cn.javass.sql.CommentHql;
import cn.javass.util.Ai2YCOM;
import cn.javass.util.DateUtil;
import cn.javass.util.ajax.AjaxUtil;

@Controller
@RequestMapping("/comment")
public class CommentController
{
	private AjaxUtil ajaxUtil = null;

	@Autowired
	@Qualifier("CommentService")
	private CommentService commentService;

	@Autowired
	@Qualifier("CommentTypeService")
	private CommentTypeService commentTypeService;

	private HttpServletRequest request;
	private HttpSession session;
	private Model model;

	@ModelAttribute
	public void initModel(Model model, HttpServletRequest request, HttpSession session)
	{
		this.request = request;
		this.session = session;
		this.model = model;
	}

	/**
	 * 添加评论
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Object addComment(@RequestJsonParam(value = "model", required = true) CommentEntity comment)
	{
		ajaxUtil = new AjaxUtil();
		UserModel user = (UserModel) session.getAttribute(Constants.USER_SESSION);
		if (user == null)
		{
			ajaxUtil.setFailMsg("请登陆...");
			ajaxUtil.setResult(false);
			return ajaxUtil;
		}

		try
		{
			comment.setUser(user);
			comment.setCreateDate(DateUtil.timeNow());
			comment.setCommentType(commentTypeService.get(comment.getCommentType().getId()));
			CommentEntity commentEntity = commentService.save(comment);
			ajaxUtil.setResult(true);
			ajaxUtil.setObject(commentEntity);
		}
		catch (Exception e)
		{
			ajaxUtil.setFailMsg(Ai2YCOM.FAIL_MSG);
		}
		return ajaxUtil;
	}

	@RequestMapping("/select")
	@ResponseBody
	public Object listComment(Integer commentTcid, Integer commentTypeId)
	{
		model.addAttribute(Constants.COMMAND, new CommentEntity());
		int pn = ServletRequestUtils.getIntParameter(this.request, "pn", 1);
		Integer id = ServletRequestUtils.getIntParameter(this.request, "id", -1);
		if (id == -1)
		{
			id = null;
		}
		Page<CommentEntity> page = commentService.page(CommentHql.HQL_COMMENT_TWO_WHERE, id, pn, 5,commentTypeId,commentTcid);
		page.setCondition("&commentTcid="+commentTcid+"&commentTypeId="+commentTypeId);
		return page;
	}
}
