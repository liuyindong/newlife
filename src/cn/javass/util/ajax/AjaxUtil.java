package cn.javass.util.ajax;

import java.util.List;
import java.util.Map;

public class AjaxUtil
{
	
	private boolean result = false;
	
	private String failMsg;
	
	private List<Object> listObj;
	
	private Map<?,?> mapType;
	
	private String jsonValidateReturn;
	
	private Object object;
	
	public String getFailMsg()
	{
		return failMsg;
	}

	public void setFailMsg(String failMsg)
	{
		this.failMsg = failMsg;
	}

	public List<Object> getListObj()
	{
		return listObj;
	}

	public void setListObj(List<Object> listObj)
	{
		this.listObj = listObj;
	}

	public Map<?, ?> getMapType()
	{
		return mapType;
	}

	public void setMapType(Map<?, ?> mapType)
	{
		this.mapType = mapType;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getJsonValidateReturn()
	{
		return jsonValidateReturn;
	}

	public void setJsonValidateReturn(String jsonValidateReturn)
	{
		this.jsonValidateReturn = jsonValidateReturn;
	}

	public Object getObject()
	{
		return object;
	}

	public void setObject(Object object)
	{
		this.object = object;
	}
	
}
