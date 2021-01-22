$(function() {

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
				$("#num").after("<span id='num_msg' style='color: red'>采购数量不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>采购单价不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>采购日期不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var vegsid = $("#vegsid").val();
var num = $("#num").val();
var price = $("#price").val();
var addtime = $("#addtime").val();
var memo = $("#memo").val();
$("#vegsid_msg").empty();
$("#num_msg").empty();
$("#price_msg").empty();
$("#addtime_msg").empty();
$("#memo_msg").empty();
if (vegsid == "" || vegsid == null) {
	$("#vegsid").after("<span id='vegsid_msg' style='color: red'>蔬菜不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>采购数量不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>采购单价不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>采购日期不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#vegsid_msg").empty();
$("#num_msg").empty();
$("#price_msg").empty();
$("#addtime_msg").empty();
$("#memo_msg").empty();
});

});
