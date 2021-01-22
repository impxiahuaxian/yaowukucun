$(function() {

$("#cycles").blur(
		function() {
			$("#cycles_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cycles").after("<span id='cycles_msg' style='color: red'>进货周期不能为空</span>");
			}
	});

$("#themax").blur(
		function() {
			$("#themax_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#themax").after("<span id='themax_msg' style='color: red'>库存最大值不能为空</span>");
			}
	});

$("#themin").blur(
		function() {
			$("#themin_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#themin").after("<span id='themin_msg' style='color: red'>库存最小值不能为空</span>");
			}
	});

$("#parama").blur(
		function() {
			$("#parama_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#parama").after("<span id='parama_msg' style='color: red'>参数A不能为空</span>");
			}
	});

$("#paramb").blur(
		function() {
			$("#paramb_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#paramb").after("<span id='paramb_msg' style='color: red'>参数B不能为空</span>");
			}
	});







$('#sub').click(function(){
var cycles = $("#cycles").val();
var themax = $("#themax").val();
var themin = $("#themin").val();
var parama = $("#parama").val();
var paramb = $("#paramb").val();
$("#cycles_msg").empty();
$("#themax_msg").empty();
$("#themin_msg").empty();
$("#parama_msg").empty();
$("#paramb_msg").empty();
if (cycles == "" || cycles == null) {
	$("#cycles").after("<span id='cycles_msg' style='color: red'>进货周期不能为空</span>");
	return false;
}
if (themax == "" || themax == null) {
	$("#themax").after("<span id='themax_msg' style='color: red'>库存最大值不能为空</span>");
	return false;
}
if (themin == "" || themin == null) {
	$("#themin").after("<span id='themin_msg' style='color: red'>库存最小值不能为空</span>");
	return false;
}
if (parama == "" || parama == null) {
	$("#parama").after("<span id='parama_msg' style='color: red'>参数A不能为空</span>");
	return false;
}
if (paramb == "" || paramb == null) {
	$("#paramb").after("<span id='paramb_msg' style='color: red'>参数B不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#cycles_msg").empty();
$("#themax_msg").empty();
$("#themin_msg").empty();
$("#parama_msg").empty();
$("#paramb_msg").empty();
});

});
