$(function() {
	$(":button").click(function() {
		var objT0 = $(this).closest("tr").find(".m0").val();// 找到同行的t0元素
		window
		.open(
				"win.jsp?id="+objT0,
				"",
				"toolbar=no,location=no,directories=no,status=no,menubar=no,resizable=yes,copyhistory=no,scrollbars=yes,width=800,height=560,top="
						+ (screen.availHeight - 660)
						/ 2
						+ ",left="
						+ (screen.availWidth - 800) / 2 + "");
	});
});