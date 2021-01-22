$(function() {
	$('#sub').click(
			function() {
				var loc = $("input[name='basepath']").val();
				var checkValue = $("#id").val();
				var url = loc + "chartBar/chartBar.action?id=" + checkValue;
				$.ajax({
					type : "get",
					url : url,
					dataType : "json",
					success : function(json) {
						var cate = json.cate.replace("[", "").replace("]", "").split(",");
						var allSell = json.allSell.replace("[", "").replace("]", "").split(",");
						var sells = json.sells.replace("[", "").replace("]", "").split(",");
						var needs = json.needs.replace("[", "").replace("]", "").split(",");
						var snum = json.snum.replace("[", "").replace("]", "").split(",");
						var vegsname = json.vegsname.replace("[", "").replace("]", "").split(",");
						var arrNum = [];
						arrNum.push({
							name : '库存',
							type : 'bar',
							"data" :snum
						});
						arrNum.push({
							name : '当日消耗量',
							type : 'bar',
							"data" : sells
						});
						arrNum.push({
							name : '日均消耗量',
							type : 'bar',
							"data" : allSell
						});
						arrNum.push({
							name : '需求量',
							type : 'bar',
							"data" : needs
						});
						var option = {
							title : {
								text : vegsname+'蔬菜信息统计'
							},
							tooltip : {
								trigger : 'axis'
							},
							legend : {
								data : cate
							},
							toolbox : {
								show : true,
								feature : {
									mark : {
										show : true
									},
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'line', 'bar' ]
									},
									restore : {
										show : true
									},
									saveAsImage : {
										show : true
									}
								}
							},
							calculable : true,
							xAxis : [ {
								type : 'category',
								data : cate
							} ],
							yAxis : [ {
								type : 'value'
							} ],
							series : arrNum
						};

						// 初始化echarts实例
						var myChart = echarts.init(document.getElementById('chartmain'));

						// 使用制定的配置项和数据显示图表
						myChart.setOption(option);
					},
					error : function() {
						alert("ajax请求发生错误3");
					}
				});
			});
});