package cn.javass.newfile.newmsg.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.javass.file.DTO.MenuTreeDto;
import cn.javass.util.FileSorter;

@Controller
@RequestMapping("/tree")
public class MenuTreeController
{
	@RequestMapping(value = "/createTree")
	@ResponseBody
	public Object createMenuTree(String id, String n, String lv,String filePath, HttpServletResponse response)
	{
		List<MenuTreeDto> listMenuTree = new ArrayList<MenuTreeDto>();

		if (filePath == null || filePath.length() <= 0)
		{
			filePath = "D://";
		}

		File[] files = FileSorter.sorterSuccess(filePath, 4);
		for (File filname : files)
		{
			MenuTreeDto menuTreeDto = new MenuTreeDto();

			menuTreeDto.setId(UUID.randomUUID().toString().substring(0,8));

			menuTreeDto.setName(filname.getName());

			if (!filname.isDirectory())
			{
				menuTreeDto.setIsParent("false");
				// String fileType = DateUtil.imgType(filname.getName());
			}
			else
			{
				menuTreeDto.setIsParent("true");
			}
			menuTreeDto.setDrag(false);
			menuTreeDto.setFilePath(filname.getPath());
			listMenuTree.add(menuTreeDto);
		}
		// WriteJson.returnJson(response, listMenuTree);
		return listMenuTree;
	}
}
