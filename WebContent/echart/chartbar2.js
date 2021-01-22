$(window).load(
		function() {
			var loc = $("input[name='basepath']").val();
			var checkValue = $("input[name='id']").val();
			var url = loc + "chartBar/chartBar1.action?id=" + checkValue;
			$.ajax({
				type : "get",
				url : url,
				dataType : "json",
				success : function(json) {
					var cate = json.cate.replace("[", "").replace("]", "")
							.split(",");
					var allSell = json.allSell.replace("[", "")
							.replace("]", "").split(",");
					var sells = json.sells.replace("[", "").replace("]", "")
							.split(",");
					var needs = json.needs.replace("[", "").replace("]", "")
							.split(",");
					var snum = json.snum.replace("[", "").replace("]", "")
							.split(",");
					var vegsname = json.vegsname.replace("[", "").replace(
							"]", "").split(",");
					var html = json.html.replace("[", "").replace("]", "");
					$("#html").html(html);
					var arrNum = [];
					arrNum.push({
						name : '库存',
						type : 'bar',
						"data" : snum
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
							text : vegsname + '蔬菜信息统计'
						},
						//提示框组件
						tooltip : {
							//坐标轴触发
							trigger : 'axis'
						},
						legend : {
							data : cate
						},
						calculable : true,
						xAxis : [ {
							//类目轴，适用于离散的类目数据，为该类型时必须通过 data 设置类目数据
							type : 'category',
							data : cate
						} ],
						yAxis : [ {
							//坐标轴类型。'value' 数值轴，适用于连续数据
							type : 'value'
						} ],
						series : arrNum
					};

					// 初始化echarts实例
					var myChart = echarts.init(document
							.getElementById('chartmain'));

					// 使用制定的配置项和数据显示图表
					myChart.setOption(option);
				},
				error : function() {
					alert("ajax请求发生错误3");
				}
			});
		});