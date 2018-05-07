<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆投保情况查询管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/zsys/zVehicleInsurance/">车辆投保情况查询列表</a></li>
		<shiro:hasPermission name="zsys:zVehicleInsurance:edit"><li><a href="${ctx}/zsys/zVehicleInsurance/form">车辆投保情况查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zVehicleInsurance" action="${ctx}/zsys/zVehicleInsurance/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车号：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>车架号：</label>
				<form:input path="frameNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>发动机号：</label>
				<form:input path="engineNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>登记日期：</label>
				<input name="beginRegDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zVehicleInsurance.beginRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endRegDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zVehicleInsurance.endRegDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>交强险保单号：</label>
				<form:input path="compulsoryInsuranceNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>商业险保单号：</label>
				<form:input path="commercialInsuranceOrderNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>承运人保单号：</label>
				<form:input path="carrierWarrantyNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>驾照：</label>
				<form:input path="driverLicense" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>查询码：</label>
				<form:input path="queryCode" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>办理日期</th>
				<th>备注信息</th>
				<th>车号</th>
				<th>车型</th>
				<th>车架号</th>
				<th>发动机号</th>
				<th>登记日期</th>
				<th>保险公司</th>
				<th>交强险-保费</th>
				<th>交强险-截止日期</th>
				<th>商业险-三者/保费</th>
				<th>商业险-三者/保额</th>
				<th>商业险-车损险</th>
				<th>商业险-自燃险</th>
				<th>商业险-不计免赔</th>
				<th>商业险-其他险种</th>
				<th>商业险-截止日期</th>
				<th>道路客运承运人责任险-保费</th>
				<th>道路客运承运人责任险-保额</th>
				<th>道路客运承运人责任险-截止日期</th>
				<th>车船税</th>
				<th>保费总合计</th>
				<th>交强险保单号</th>
				<th>商业险保单号</th>
				<th>承运人保单号</th>
				<th>备注</th>
				<th>驾照</th>
				<th>查询码</th>
				<th>保单图片</th>
				<shiro:hasPermission name="zsys:zVehicleInsurance:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zVehicleInsurance">
			<tr>
				<td><a href="${ctx}/zsys/zVehicleInsurance/form?id=${zVehicleInsurance.id}">
					<fmt:formatDate value="${zVehicleInsurance.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zVehicleInsurance.remarks}
				</td>
				<td>
					${zVehicleInsurance.vehicleNum}
				</td>
				<td>
					${zVehicleInsurance.vehicleType}
				</td>
				<td>
					${zVehicleInsurance.frameNum}
				</td>
				<td>
					${zVehicleInsurance.engineNum}
				</td>
				<td>
					<fmt:formatDate value="${zVehicleInsurance.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zVehicleInsurance.insuranceCompany}
				</td>
				<td>
					${zVehicleInsurance.premium}
				</td>
				<td>
					<fmt:formatDate value="${zVehicleInsurance.closingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zVehicleInsurance.thirdPartyPremium}
				</td>
				<td>
					${zVehicleInsurance.thirdPartyInsuredAmount}
				</td>
				<td>
					${zVehicleInsurance.carDamageInsurance}
				</td>
				<td>
					${zVehicleInsurance.riskSpontaneousCombustion}
				</td>
				<td>
					${zVehicleInsurance.nonDeductible}
				</td>
				<td>
					${zVehicleInsurance.otherInsurance}
				</td>
				<td>
					<fmt:formatDate value="${zVehicleInsurance.closingDate1}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zVehicleInsurance.premium1}
				</td>
				<td>
					${zVehicleInsurance.insuredAmount1}
				</td>
				<td>
					${zVehicleInsurance.closingDate2}
				</td>
				<td>
					${zVehicleInsurance.vehicleVesselTax}
				</td>
				<td>
					${zVehicleInsurance.totalPremium}
				</td>
				<td>
					${zVehicleInsurance.compulsoryInsuranceNum}
				</td>
				<td>
					${zVehicleInsurance.commercialInsuranceOrderNum}
				</td>
				<td>
					${zVehicleInsurance.carrierWarrantyNum}
				</td>
				<td>
					${zVehicleInsurance.mark}
				</td>
				<td>
					${zVehicleInsurance.driverLicense}
				</td>
				<td>
					${zVehicleInsurance.queryCode}
				</td>
				<td>
					${zVehicleInsurance.pic}
				</td>
				<shiro:hasPermission name="zsys:zVehicleInsurance:edit"><td>
    				<a href="${ctx}/zsys/zVehicleInsurance/form?id=${zVehicleInsurance.id}">修改</a>
					<a href="${ctx}/zsys/zVehicleInsurance/delete?id=${zVehicleInsurance.id}" onclick="return confirmx('确认要删除该车辆投保情况查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>