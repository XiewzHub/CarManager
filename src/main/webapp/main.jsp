<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<title>车辆管理系统</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>

<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="../assets/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->
<!--页头开始-->
<%@include file="baseInclude.jsp" %>


	<div class="content">

		<div class="header">
			<div class="stats">
				<!-- <p class="stat">
					<span class="number">53</span>tickets
				</p> -->
				<p class="stat">
					<span class="number">${sessionScope.TASK_NUM}</span>任务
				</p>
				<!-- <p class="stat">
					<span class="number">15</span>waiting
				</p> -->
			</div>

			<h1 class="page-title">
				您好,${sessionScope.USER_SESSION.name} 
			</h1>
		</div>

		<ul class="breadcrumb">
			<li><a href="main.jsp">主页</a> <span class="divider">/</span></li>

		</ul>
		<div class="container-fluid">
			<div class="row-fluid">


				<div class="row-fluid">

					<div class="alert alert-info">
						<button type="button" class="close" data-dismiss="alert">×</button>
						<strong>消息提醒:</strong>${sessionScope.DRIVER_NOTICE}
					</div>

					<div class="block">
						<a href="#page-stats" class="block-heading" data-toggle="collapse">公司动态</a>
						<div id="page-stats" class="block-body collapse in">

							<div class="stat-widget-container">
								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">重要通知</p>
										<br>为规范公司驾驶员的岗位职责，以及约束公司人员使用车辆和驾驶员的随意性，特通知如下：
										<br>1、公司配设专业的驾驶员，如无特殊情况下一切驾驶工作都应交予专业驾驶员，其他人员在无领导授意下禁止驾驶公司车辆，一经发现，严肃处理；
										<br>2、自通知发布之日起，公司实行驾驶员值班制：即驾驶员以一周为周期分别在公司值班，方便公司人员用车，请公司使用车辆人员用车时对照值班表，严禁一切随意支配驾驶员的行为，使用车辆前必须走申请审批的流程；
										<!-- class="detail" -->
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">驾驶小技巧</p>
										<br>自动挡频繁换挡损耗大。
<br>在短暂停车时，如在等待红绿灯转换时，很多驾驶员都会将挡位放到N挡(空挡)上。其实，自动挡的车是由电脑控制的，因此并不需要将挡位放到N挡上，只需要将挡位放在低挡位置。频繁地换挡对变速箱有着很大的影响，变速箱会随着挡位频繁的变换而减少其寿命。比如，原本可以使用10万公里的变速箱，因为频繁换挡，其真正的使用时间可能会减少到只能行驶7万-8万公里。
<br>许多司机在上坡道时，由于方法不当，总是感觉比较吃力。此时，驾驶员首先是要保持的是心情平和，千万不能急躁。
<br>(1)拉手刹;
<br>(2)加油门，车辆转速保持1500转;
<br>(3)慢踩离合器，让发动机转速降到1400转，稳住离合器，再放开手刹;
<br>(4)加油门。在正确的操控下，车辆上坡其实也是件很容易的事。
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">公司计划</p>
										<p >预计于6月3日会有多名员工出差</p>
									</div>
								</div>

								<div class="stat-widget">
									<div class="stat-button">
										<p class="title">生活小贴士</p>
										<p >最佳饮料——热茶：夏天离不开饮料，首选的既非各种冷饮制品，也不是啤酒或咖啡，而是极普通的热茶。茶叶中富含钾元素（每100克茶水中钾的平均含量分别为绿茶10.7毫克，红茶24.1毫克），既解渴又解乏。据英国专家的试验表明，热茶的降温能力大大超过冷饮制品，乃是消暑饮品中的佼佼者。
　　夏天，茶叶生霉，切忌在阳光下晒，放在锅中干焙10分钟左右，味道便可恢复，但锅内要清洁，火不宜太大。</p>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
		var priSet = $("#aa").val();
		var sArr = priSet.split(",");
		/* if($.inArray(9,sArr)==-1 ){
			 alert($.inArray(9,sArr)==-1);
		      	var ui =document.getElementById("shenpiPage");
		  		ui.style.display="none";
		      }
		if($.inArray(4,sArr)==-1){
			var ui =document.getElementById("dangAnPage");
			ui.style.display="none";
		}
		 */
			var s = 0;
			var r = 0;
			var k = 0;
			var l = 0;
			for (var i = 0; i < sArr.length; i++) {

				if (sArr[i] == 9) {
					s = 1;
				}
				if (sArr[i] == 4) {
					r = 1;
				}
				if (sArr[i] == 10) {
					k = 1;
				}
				if (sArr[i] == 11) {
					l = 1;
				}
			}
			//9审批页面权限
			if (s == 0) {
				var ui = document.getElementById("shenpiPage");
				ui.style.display = "none";
			}
			//4档案页面权限
			if (r == 0) {
				var ui = document.getElementById("dangAnPage");
				ui.style.display = "none";
			}
			//10车辆调度权限
			if (k == 0) {
				var ui = document.getElementById("carDiaodu");
				ui.style.display = "none";
			}
			////11进出车记录功能
			if (l == 0) {
				var ui = document.getElementById("runbackCarInfo");
				ui.style.display = "none";
			}
			

	</script>

</body>
</html>
