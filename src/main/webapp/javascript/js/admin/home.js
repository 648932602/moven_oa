// 全局变量
var basePath;
var topPanel;
var leftPanel;
var centerPanel;
$(function() {
	bathPath = getBasePath();
	// 初始化当前时间
	timer();
	// 计时器开始计时
	setInterval("timer()", 1000);
	// 桌面布局
	$("#homeFrame").layout();
	topPanel = $("#homeFrame").layout('panel', 'north');
	leftPanel = $("#homeFrame").layout('panel', 'west');
	centerPanel = $("#homeFrame").layout('panel', 'center');

	leftPanel.panel({
		href : bathPath + "/admin/home_menu"
	});
	centerPanel.panel({
		href : bathPath + "/admin/home_dashboard"
	});
});
// 时钟控件
function timer() {
	var now = new Date();// 当前时间
	var YY = now.getFullYear(); // 获取完整的年份(4位,1970-????)
	var MM = now.getMonth() + 1; // 获取当前月份(0-11,0代表1月)
	var DD = now.getDate(); // 获取当前日(1-31)
	var hh = now.getHours(); // 获取当前时(0-23)
	var mm = now.getMinutes(); // 获取当前分(0-59)
	var ss = now.getSeconds(); // 获取当前秒(0-59)
	var nowStr = YY + " 年 " + MM + " 月 " + DD + " 日 " + hh + " 时 " + mm + " 分 " + ss + " 秒";
	$("#timer").html(nowStr);
}
// 检测时间，不足10则补0
function checkTime(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}