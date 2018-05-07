<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>责任经营者变更业务办理查询管理</title>
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
		<li><a href="${ctx}/zsys/zOperatorBusinessChange/">责任经营者变更业务办理查询列表</a></li>
		<li class="active"><a href="${ctx}/zsys/zOperatorBusinessChange/form?id=${zOperatorBusinessChange.id}">责任经营者变更业务办理查询<shiro:hasPermission name="zsys:zOperatorBusinessChange:edit">${not empty zOperatorBusinessChange.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zsys:zOperatorBusinessChange:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zOperatorBusinessChange" action="${ctx}/zsys/zOperatorBusinessChange/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">编号：</label>
			<div class="controls">
				<form:input path="num" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">原车牌号：</label>
			<div class="controls">
				<form:input path="oriVehicleNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">新车牌号：</label>
			<div class="controls">
				<form:input path="newVehicleNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				<form:input path="idCard" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">准驾车型：</label>
			<div class="controls">
				<form:input path="allowedDriveModel" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">初领日期：</label>
			<div class="controls">
				<input name="initialDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zOperatorBusinessChange.initialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">从业资格证号：</label>
			<div class="controls">
				<form:input path="quaCertNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">从业资格证初领日期：</label>
			<div class="controls">
				<input name="quaCertInitialDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zOperatorBusinessChange.quaCertInitialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话：</label>
			<div class="controls">
				<form:input path="phoneNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址：</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上车时间：</label>
			<div class="controls">
				<input name="boardingTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zOperatorBusinessChange.boardingTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">查询号码：</label>
			<div class="controls">
				<form:input path="queryCode" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车架号码：</label>
			<div class="controls">
				<form:input path="frameNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办理日期：</label>
			<div class="controls">
				<input name="handleDate" type="text" readonly="readonly" maxlength="20" class="required input-medium Wdate "
					value="<fmt:formatDate value="${zOperatorBusinessChange.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批流程：</label>
			<div class="controls">
				<form:select path="step" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('operator_business_change')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zsys:zOperatorBusinessChange:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>