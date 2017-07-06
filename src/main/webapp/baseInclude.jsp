<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<div class="navbar">
	<div class="navbar-inner">
		<ul class="nav pull-right">

			<!-- <li><a href="#"
					class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a></li>  -->
			<li id="fat-menu" class="dropdown"><a href="#" role="button"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="icon-user"></i> ${sessionScope.USER_SESSION.loginName} <i
					class="icon-caret-down"></i>
			</a>

				<ul class="dropdown-menu">
					<li><a tabindex="-1" href="resetPassword.jsp">修改密码</a></li>
					<li class="divider"></li>
					<li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
					<li class="divider visible-phone"></li>
					<li><a tabindex="-1" href="login.jsp">注销</a></li>
				</ul></li>

		</ul>
		<a class="brand" href="main.jsp"><span class="first"></span>ggsleeper<span
			class="second">车辆管理系统</span></a>
	</div>
</div>




<div class="sidebar-nav">
	
	<div id="dangAnPage">
		<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
			class="icon-dashboard"></i>档案及状态管理</a>
		<ul id="dashboard-menu" class="nav nav-list collapse in">
			<li><a href="carInfoList">车辆信息及状态</a></li>
			<li><a href="driverInfoList">驾驶员信息及状态</a></li>

		</ul>
	</div>
<div id="carDiaodu">
	<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i
		class="icon-legal"></i>车辆调度<span class="label label-info">${sessionScope.TASK_NUM}</span></a>
	<ul id="legal-menu" class="nav nav-list collapse">
		<li><a href="carApplyList">车辆使用申请</a></li>
		<li><a href="carApply3List">当前申请</a></li>
		<li id="shenpiPage"><a href="carApply4List">车辆使用审批<span
				class="label label-info">${sessionScope.TASK_NUM}</span></a></li>

	</ul>
</div>

<div id="runbackCarInfo">
	<a href="#error-menu" class="nav-header collapsed"
		data-toggle="collapse"><i class="icon-exclamation-sign"></i>车辆进出记录
		<i class="icon-chevron-up"></i></a>
	<ul id="error-menu" class="nav nav-list collapse">
		<li><a href="RunbackInfoCarDriverList">出车记录</a></li>
		<li><a href="RunbackInfoCarDriverList2">进车记录</a></li>
		<li><a href="carRunBackInfoList">查看进出车记录</a></li>
	</ul>
</div>
<input type="hidden" id="aa"
					value="${sessionScope.ROLE_PRIVILEGE_SETTING}" />
	<!-- <a href="faq.html" class="nav-header"><i class="icon-comment"></i>车辆维护</a> -->
</div>


<script type="text/javascript">


</script>
