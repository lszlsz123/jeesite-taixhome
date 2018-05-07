<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆投保情况查询管理</title>
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
		
		$(function(){
			$("#vehicleNum").blur(function(){
				$.ajax({
					   type: "POST",
					   url: "${pageContext.request.contextPath}${fns:getFrontPath()}/zsys/zVehicleInsurance/queryDetail",
					   data: "vehicleNum="+$("#vehicleNum").val(),
					   async: false,
					   dataType:"json",
					   success: function(data){
						   if(data.vehicleNum&&data.vehicleNum!=""){
							   $("#vehicleNum").val(data.vehicleNum);
							   $("#vehicleType").val(data.vehicleType);
							   $("#frameNum").val(data.frameNum);
							   $("#engineNum").val(data.engineNum);
							   
						   }
					     	
					   }
					});
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/zsys/zVehicleInsurance/">车辆投保情况查询列表</a></li>
		<li class="active"><a href="${ctx}/zsys/zVehicleInsurance/form?id=${zVehicleInsurance.id}">车辆投保情况查询<shiro:hasPermission name="zsys:zVehicleInsurance:edit">${not empty zVehicleInsurance.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="zsys:zVehicleInsurance:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="zVehicleInsurance" action="${ctx}/zsys/zVehicleInsurance/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车号：</label>
			<div class="controls">
				<form:input path="vehicleNum"  htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车型：</label>
			<div class="controls">
				<form:input path="vehicleType" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车架号：</label>
			<div class="controls">
				<form:input path="frameNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发动机号：</label>
			<div class="controls">
				<form:input path="engineNum" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登记日期：</label>
			<div class="controls">
				<input name="regDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zVehicleInsurance.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">保险公司：</label>
			<div class="controls">
				<form:input path="insuranceCompany" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交强险-保费：</label>
			<div class="controls">
				<form:input path="premium" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交强险-截止日期：</label>
			<div class="controls">
				<input name="closingDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zVehicleInsurance.closingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-三者/保费：</label>
			<div class="controls">
				<form:input path="thirdPartyPremium" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-三者/保额：</label>
			<div class="controls">
				<form:input path="thirdPartyInsuredAmount" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-车损险：</label>
			<div class="controls">
				<form:input path="carDamageInsurance" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-自燃险：</label>
			<div class="controls">
				<form:input path="riskSpontaneousCombustion" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-不计免赔：</label>
			<div class="controls">
				<form:input path="nonDeductible" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-其他险种：</label>
			<div class="controls">
				<form:input path="otherInsurance" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险-截止日期：</label>
			<div class="controls">
				<input name="closingDate1" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${zVehicleInsurance.closingDate1}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">道路客运承运人责任险-保费：</label>
			<div class="controls">
				<form:input path="premium1" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">道路客运承运人责任险-保额：</label>
			<div class="controls">
				<form:input path="insuredAmount1" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">道路客运承运人责任险-截止日期：</label>
			<div class="controls">
				<input name="closingDate2" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="${zVehicleInsurance.closingDate2}"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">车船税：</label>
			<div class="controls">
				<form:input path="vehicleVesselTax" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">保费总合计：</label>
			<div class="controls">
				<form:input path="totalPremium" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交强险保单号：</label>
			<div class="controls">
				<form:input path="compulsoryInsuranceNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商业险保单号：</label>
			<div class="controls">
				<form:input path="commercialInsuranceOrderNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">承运人保单号：</label>
			<div class="controls">
				<form:input path="carrierWarrantyNum" htmlEscape="false" maxlength="50" class="input-xlarge "/>
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
				<form:input path="driverLicense" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">查询码：</label>
			<div class="controls">
				<form:input path="queryCode" htmlEscape="false" maxlength="50" class="required input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">交强险保单图片：</label>
			<div class="controls">
				<form:hidden id="pic" path="pic" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="pic" type="images" uploadPath="/zsys/zVehicleInsurance" selectMultiple="true"/>
			</div>
			
		</div>
		
		<div class="control-group">
			<label class="control-label">商业险保单图片：</label>
			<div class="controls">
				<form:hidden id="pic1" path="pic1" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="pic1" type="images" uploadPath="/zsys/zVehicleInsurance" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">承运人保单图片：</label>
			<div class="controls">
				<form:hidden id="pic2" path="pic2" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="pic2" type="images" uploadPath="/zsys/zVehicleInsurance" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">办理日期：</label>
			<div class="controls">
				<input name="handleDate" type="text" readonly="readonly" maxlength="20" class="required input-medium Wdate "
					value="<fmt:formatDate value="${zVehicleInsurance.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="zsys:zVehicleInsurance:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>