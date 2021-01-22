$(function() {

$("#ordercode").blur(
		function() {
			$("#ordercode_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
			}
	});

$("#adminid").blur(
		function() {
			$("#adminid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#adminid").after("<span id='adminid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#vegsid").blur(
		function() {
			$("#vegsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#vegsid").after("<span id='vegsid_msg' style='color: red'>蔬菜不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
			}
	});







$('#sub').click(function(){
var ordercode = $("#ordercode").val();
var adminid = $("#adminid").val();
var vegsid = $("#vegsid").val();
var num = $("#num").val();
var price = $("#price").val();
$("#ordercode_msg").empty();
$("#adminid_msg").empty();
$("#vegsid_msg").empty();
$("#num_msg").empty();
$("#price_msg").empty();
if (ordercode == "" || ordercode == null) {
	$("#ordercode").after("<span id='ordercode_msg' style='color: red'>订单号不能为空</span>");
	return false;
}
if (adminid == "" || adminid == null) {
	$("#adminid").after("<span id='adminid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (vegsid == "" || vegsid == null) {
	$("#vegsid").after("<span id='vegsid_msg' style='color: red'>蔬菜不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ordercode_msg").empty();
$("#adminid_msg").empty();
$("#vegsid_msg").empty();
$("#num_msg").empty();
$("#price_msg").empty();
});

});
