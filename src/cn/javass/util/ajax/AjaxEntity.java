package cn.javass.util.ajax;

public class AjaxEntity
{
	private String validateId;
	
	private String validateValue;
	
	private String validateError;
	
	private boolean result;
	

	public String getValidateId()
	{
		return validateId;
	}

	public void setValidateId(String validateId)
	{
		this.validateId = validateId;
	}

	public String getValidateValue()
	{
		return validateValue;
	}

	public void setValidateValue(String validateValue)
	{
		this.validateValue = validateValue;
	}

	public String getValidateError()
	{
		return validateError;
	}

	public void setValidateError(String validateError)
	{
		this.validateError = validateError;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}
}
