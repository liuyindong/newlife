<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h4>日期</h4>
	<div class="calendar" id="calendar_sidebar"></div>
		<script type="text/javascript">
			var today = new Date();
			var date = today.getFullYear() + '-'+ (today.getMonth() + 1) + '-'+ today.getDate();
			$('#calendar_sidebar').DatePicker(
			{
				flat : true,
				date : date,
				calendars : 1,
				starts : 1,
				locale : {
					days : [ '星期天','星期一','星期二','星期三','星期四','星期五','星期六','星期天' ],
					daysShort : ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
					daysMin : [ '日', '一','二', '三', '四','五', '六', '日' ],
					months : [ '1月','2月','3月','4月', '5月','6月', '7月','8月','9月','10月','11月','12月' ],
					monthsShort : ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
					weekMin : 'wk'
						}
				});
			</script>
	<div class="line_2"></div>