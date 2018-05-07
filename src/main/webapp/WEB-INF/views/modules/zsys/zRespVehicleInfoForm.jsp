<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>责任经营车辆信息查询管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/zsys/zRespVehicleInfo/">责任经营车辆信息查询列表</a></li>
		<li class="active"><a href="${ctx}/zsys/zRespVehicleInfo/form?id=${zRespVehicleInfo.id}">责任经营车辆信息查询<shiro:hasPermission name="zsys:zRespVehicleInfo:edit">${not empty zRespVehicleInfo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zsys:zRespVehicleInfo:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zRespVehicleInfo" action="${ctx}/zsys/zRespVehicleInfo/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">实际上线运营时间：</label>
			<div class="controls">
				<input name="actualOnlineOperationTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zRespVehicleInfo.actualOnlineOperationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">营运证截止日期：</label>
			<div class="controls">
				<input name="operationCertificateExpireDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zRespVehicleInfo.operationCertificateExpireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">营运证发证日期：</label>
			<div class="controls">
				<input name="operationCertificateIssueDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zRespVehicleInfo.operationCertificateIssueDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">营运证号：</label>
			<div class="controls">
				<form:input path="operationCertificateNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发动机号：</label>
			<div class="controls">
				<form:input path="engineNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车架号：</label>
			<div class="controls">
				<form:input path="frameNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车辆出厂日期：</label>
			<div class="controls">
				<input name="vehicleProductionDate" type="text" readonly="readonly" maxlength="20" class="required input-medium Wdate "
					value="<fmt:formatDate value="${zRespVehicleInfo.vehicleProductionDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计价器编号：</label>
			<div class="controls">
				<form:input path="taximeterNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车辆型号：</label>
			<div class="controls">
				<form:input path="vehicleType" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">新车号：</label>
			<div class="controls">
				<form:input path="newVehicleNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">原车号：</label>
			<div class="controls">
				<form:input path="oriVehicleNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办理日期：</label>
			<div class="controls">
				<input name="handleDate" type="text" readonly="readonly" maxlength="20" class="required input-medium Wdate "
					value="<fmt:formatDate value="${zRespVehicleInfo.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zsys:zRespVehicleInfo:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>