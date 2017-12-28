<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流程步骤管理管理</title>
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
		<li><a href="${ctx}/zprocess/zProcessLink/">流程步骤管理列表</a></li>
		<li class="active"><a href="${ctx}/zprocess/zProcessLink/form?id=${zProcessLink.id}">流程步骤管理<shiro:hasPermission name="zprocess:zProcessLink:edit">${not empty zProcessLink.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zprocess:zProcessLink:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zProcessLink" action="${ctx}/zprocess/zProcessLink/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">开始节点：</label>
			<div class="controls">
				<form:select path="startNode" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getZProcessNodeList()}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">结束节点：</label>
			<div class="controls">
				<form:select path="endNode" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getZProcessNodeList()}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">流程ID：</label>
			<div class="controls">
				<form:select path="processId" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getZProcessList()}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zprocess:zProcessLink:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>