$(function() {

$("#vegsname").blur(
		function() {
			$("#vegsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#vegsname").after("<span id='vegsname_msg' style='color: red'>蔬菜名称不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>蔬菜类型不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>销售价格不能为空</span>");
			}
	});

$("#product").blur(
		function() {
			$("#product_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#product").after("<span id='product_msg' style='color: red'>产地不能为空</span>");
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
var vegsname = $("#vegsname").val();
var cateid = $("#cateid").val();
var price = $("#price").val();
var product = $("#product").val();
var memo = $("#memo").val();
$("#vegsname_msg").empty();
$("#cateid_msg").empty();
$("#price_msg").empty();
$("#product_msg").empty();
$("#memo_msg").empty();
if (vegsname == "" || vegsname == null) {
	$("#vegsname").after("<span id='vegsname_msg' style='color: red'>蔬菜名称不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>蔬菜类型不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>销售价格不能为空</span>");
	return false;
}
if (product == "" || product == null) {
	$("#product").after("<span id='product_msg' style='color: red'>产地不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#vegsname_msg").empty();
$("#cateid_msg").empty();
$("#price_msg").empty();
$("#product_msg").empty();
$("#memo_msg").empty();
});

});
