<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>从业司机业务办理查询管理</title>
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
		<li><a href="${ctx}/zsys/zDriverBusiness/">从业司机业务办理查询列表</a></li>
		<li class="active"><a href="${ctx}/zsys/zDriverBusiness/form?id=${zDriverBusiness.id}">从业司机业务办理查询<shiro:hasPermission name="zsys:zDriverBusiness:edit">${not empty zDriverBusiness.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zsys:zDriverBusiness:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zDriverBusiness" action="${ctx}/zsys/zDriverBusiness/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车型：</label>
			<div class="controls">
				<form:input path="vehicleType" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">自编号：</label>
			<div class="controls">
				<form:input path="selfNumber" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车牌：</label>
			<div class="controls">
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备班驾驶员：</label>
			<div class="controls">
				<form:input path="driver" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">联系电话：</label>
			<div class="controls">
				<form:input path="contactPhone" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">身份证号：</label>
			<div class="controls">
				<form:input path="idCard" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">地址：</label>
			<div class="controls">
				<form:input path="address" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">准驾车型：</label>
			<div class="controls">
				<form:input path="allowedDriveModel" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">驾照初领日期：</label>
			<div class="controls">
				<input name="licenseInitialDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zDriverBusiness.licenseInitialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
					value="<fmt:formatDate value="${zDriverBusiness.quaCertInitialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备班日期：</label>
			<div class="controls">
				<input name="driverDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zDriverBusiness.driverDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">退出日期：</label>
			<div class="controls">
				<input name="quitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zDriverBusiness.quitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">审批流程：</label>
			<div class="controls">
				<form:select path="step" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('driverBusinessStep')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
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
					value="<fmt:formatDate value="${zDriverBusiness.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zsys:zDriverBusiness:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>