<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保险理赔业务查询管理</title>
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
		<li><a href="${ctx}/zsys/zInsuranceClaimSettlement/">保险理赔业务查询列表</a></li>
		<li class="active"><a href="${ctx}/zsys/zInsuranceClaimSettlement/form?id=${zInsuranceClaimSettlement.id}">保险理赔业务查询<shiro:hasPermission name="zsys:zInsuranceClaimSettlement:edit">${not empty zInsuranceClaimSettlement.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zsys:zInsuranceClaimSettlement:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zInsuranceClaimSettlement" action="${ctx}/zsys/zInsuranceClaimSettlement/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">事故编号：</label>
			<div class="controls">
				<form:input path="accNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">自编号：</label>
			<div class="controls">
				<form:input path="selfNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车牌号：</label>
			<div class="controls">
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">肇事时间：</label>
			<div class="controls">
				<input name="accTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单车经营者：</label>
			<div class="controls">
				<form:input path="individualVehicleOperator" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">肇事地点：</label>
			<div class="controls">
				<form:input path="accidentAddress" htmlEscape="false" maxlength="50" class="input-xlarge "/>
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
			<label class="control-label">肇事司机：</label>
			<div class="controls">
				<form:input path="accDriver" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">肇事原因：</label>
			<div class="controls">
				<form:textarea path="accReason" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交强险（车）赔款：</label>
			<div class="controls">
				<form:input path="vehicleIndemnity" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交强险（人伤）赔款：</label>
			<div class="controls">
				<form:input path="humanInjuryIndemnity" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车损险赔款：</label>
			<div class="controls">
				<form:input path="lossIndemnity" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">三者险（车）赔款：</label>
			<div class="controls">
				<form:input path="thirdPartyVehicleIndemnity" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">三者险（人）赔款：</label>
			<div class="controls">
				<form:input path="thirdPartyHumanInjuryIndemnity" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">承运人险赔款：</label>
			<div class="controls">
				<form:input path="carrierInsuranceIndemnity" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">赔款总金额：</label>
			<div class="controls">
				<form:input path="totalAmount" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结案日期：</label>
			<div class="controls">
				<input name="closingDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.closingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">公司发放时间：</label>
			<div class="controls">
				<input name="companyRealseTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.companyRealseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="mark" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
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
		<div class="form-actions">
			<shiro:hasPermission name="zsys:zInsuranceClaimSettlement:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>