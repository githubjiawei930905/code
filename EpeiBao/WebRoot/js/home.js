$(function() {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('div_bar'));

	// 指定图表的配置项和数据
	option = {
		color : [ '#3398DB' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'cross' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		grid : {
			top : 5,
			left : '3%',
			right : '4%',
			bottom : 5,
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : [ '培训考核', '车况维护', '费用缴纳', '数据上传' ],
			axisTick : {
				alignWithLabel : true
			}
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '完成情况',
			type : 'bar',
			barWidth : '20%',
			data : [ 34, 90, 30, 20 ]
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('div_pie1'));

	// 指定图表的配置项和数据
	option = {
		title : {
			text : '培训考核',
			left : 'center',
			top : 50
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			selectedMode:false,
			orient : 'horizontal',
			left : 'left',
			data : [ '已完成', '未完成' ]
		},
		series : [ {
			name : '完成情况',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '60%' ],
			data : [ {
				value : 10,
				name : '已完成',
				itemStyle : {
					normal : {
						color : '#5B9BD5'
					}
				}

			}, {
				value : 90,
				name : '未完成',
				itemStyle : {
					normal : {
						color : '#D1E8FF'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('div_pie2'));

	// 指定图表的配置项和数据
	option = {
		title : {
			text : '车况维护',
			left : 'center',
			top : 50
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},

		series : [ {
			name : '完成情况',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '60%' ],
			data : [ {
				value : 20,
				name : '已完成',
				itemStyle : {
					normal : {
						color : '#5B9BD5'
					}
				}

			}, {
				value : 80,
				name : '未完成',
				itemStyle : {
					normal : {
						color : '#D1E8FF'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('div_pie3'));

	// 指定图表的配置项和数据
	option = {
		title : {
			text : '费用缴纳',
			left : 'center',
			top : 50
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [ {
			name : '完成情况',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '60%' ],
			data : [ {
				value : 30,
				name : '已完成',
				itemStyle : {
					normal : {
						color : '#5B9BD5'
					}
				}

			}, {
				value : 70,
				name : '未完成',
				itemStyle : {
					normal : {
						color : '#D1E8FF'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('div_pie4'));

	// 指定图表的配置项和数据
	option = {
		title : {
			text : '数据上传',
			left : 'center',
			top : 50
		},
		tooltip : {
			trigger : 'item',								
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		series : [ {
			name : '完成情况',
			type : 'pie',
			radius : '60%',
			center : [ '50%', '60%' ],
			data : [ {
				value : 50,
				name : '已完成',
				itemStyle : {
					normal : {
						color : '#5B9BD5'
					}
				}

			}, {
				value : 50,
				name : '未完成',
				itemStyle : {
					normal : {
						color : '#D1E8FF'
					}
				}
			} ],
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);

});
