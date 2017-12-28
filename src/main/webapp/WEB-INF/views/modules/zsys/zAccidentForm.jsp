<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>交通事故查询管理</title>
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
		<li><a href="${ctx}/zsys/zAccident/">交通事故查询列表</a></li>
		<li class="active"><a href="${ctx}/zsys/zAccident/form?id=${zAccident.id}">交通事故查询<shiro:hasPermission name="zsys:zAccident:edit">${not empty zAccident.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zsys:zAccident:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zAccident" action="${ctx}/zsys/zAccident/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故时间：</label>
			<div class="controls">
				<input name="accTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zAccident.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故地点：</label>
			<div class="controls">
				<form:input path="accAddress" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">责任情况：</label>
			<div class="controls">
				<form:select path="respSituation" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('accident_response')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故等级：</label>
			<div class="controls">
				<form:select path="level" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('accident_level')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故原因、种类：</label>
			<div class="controls">
				<form:textarea path="accReasonType" htmlEscape="false" rows="4" maxlength="50" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车辆承保公司：</label>
			<div class="controls">
				<form:input path="vehicleInsuranceCompany" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">预估损失金额（元）：</label>
			<div class="controls">
				<form:input path="estimationAmount" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">受伤人数：</label>
			<div class="controls">
				<form:input path="injuredCount" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">死亡人数：</label>
			<div class="controls">
				<form:input path="deathCount" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">案件进展情况：</label>
			<div class="controls">
				<form:textarea path="caseProgress" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">保险理赔金额（元）：</label>
			<div class="controls">
				<form:input path="claimAmount" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结案日期：</label>
			<div class="controls">
				<input name="closeDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zAccident.closeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="mark" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故车号：</label>
			<div class="controls">
				<form:input path="accVehcileNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">驾驶员姓名：</label>
			<div class="controls">
				<form:input path="driverName" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故编号：</label>
			<div class="controls">
				<form:input path="accidentNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">自编号：</label>
			<div class="controls">
				<form:input path="selfNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">驾照：</label>
			<div class="controls">
				<form:input path="driverLicense" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">查询码：</label>
			<div class="controls">
				<form:input path="queryCode" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">流程</label>
			<div class="controls">
				<form:select path="step" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getNextStepList(zAccident.processId,zAccident.nodeId)}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">当前节点：</label>
			<div class="controls">
				${zAccident.nodeName}
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zsys:zAccident:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>