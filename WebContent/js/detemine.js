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
				$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
			}
	});







$('#sub').click(function(){
var vegsid = $("#vegsid").val();
var num = $("#num").val();
$("#vegsid_msg").empty();
$("#num_msg").empty();
if (vegsid == "" || vegsid == null) {
	$("#vegsid").after("<span id='vegsid_msg' style='color: red'>蔬菜不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#vegsid_msg").empty();
$("#num_msg").empty();
});

});
