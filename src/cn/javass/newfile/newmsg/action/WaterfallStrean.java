package cn.javass.newfile.newmsg.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/imageWall")
public class WaterfallStrean
{
	@RequestMapping(value = "/index")
	@ResponseBody
	public Object imageWallIndex()
	{
		
		return null;
	}
}
