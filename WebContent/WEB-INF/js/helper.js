function obj2str(o)
{
	var r = [];
	if (typeof o == "string" || o == null)
	{
		return o;
	}
	if (typeof o == "object")
	{
		if (!o.sort)
		{
			r[0] = "{";
			for ( var i in o)
			{
				r[r.length] = i;
				r[r.length] = ":";
				r[r.length] = obj2str(o[i]);
				r[r.length] = ",";
			}
			r[r.length - 1] = "}";
		}
		else
		{
			r[0] = "[";
			for ( var i = 0; i < o.length; i++)
			{
				r[r.length] = obj2str(o[i]);
				r[r.length] = ",";
			}
			r[r.length - 1] = "]";
		}
		return r.join("");
	}
	return o.toString();
}

String.prototype.Trim = function()
{
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
String.prototype.LTrim = function()
{
	return this.replace(/(^\s*)/g, "");
};
String.prototype.RTrim = function()
{
	return this.replace(/(\s*$)/g, "");
};
