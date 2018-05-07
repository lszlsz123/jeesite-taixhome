<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保险理赔业务查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zInsuranceClaimSettlement/">保险理赔业务查询列表</a></li>
		<shiro:hasPermission name="zsys:zInsuranceClaimSettlement:edit"><li><a href="${ctx}/zsys/zInsuranceClaimSettlement/form">保险理赔业务查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zInsuranceClaimSettlement" action="${ctx}/zsys/zInsuranceClaimSettlement/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>事故编号：</label>
				<form:input path="accNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>自编号：</label>
				<form:input path="selfNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>车牌号：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>肇事时间：</label>
				<input name="beginAccTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.beginAccTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endAccTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.endAccTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结案日期：</label>
				<input name="beginClosingDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.beginClosingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endClosingDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zInsuranceClaimSettlement.endClosingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
				<th>事故编号</th>
				<th>自编号</th>
				<th>车牌号</th>
				<th>肇事时间</th>
				<th>单车经营者</th>
				<th>肇事地点</th>
				<th>责任情况</th>
				<th>肇事司机</th>
				<th>肇事原因</th>
				<th>交强险（车）赔款</th>
				<th>交强险（人伤）赔款</th>
				<th>车损险赔款</th>
				<th>三者险（车）赔款</th>
				<th>三者险（人）赔款</th>
				<th>承运人险赔款</th>
				<th>赔款总金额</th>
				<th>结案日期</th>
				<th>公司发放时间</th>
				<th>备注</th>
				<th>驾照</th>
				<th>查询码</th>
				<shiro:hasPermission name="zsys:zInsuranceClaimSettlement:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zInsuranceClaimSettlement">
			<tr>
				<td><a href="${ctx}/zsys/zInsuranceClaimSettlement/form?id=${zInsuranceClaimSettlement.id}">
					<fmt:formatDate value="${zInsuranceClaimSettlement.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zInsuranceClaimSettlement.remarks}
				</td>
				<td>
					${zInsuranceClaimSettlement.accNum}
				</td>
				<td>
					${zInsuranceClaimSettlement.selfNum}
				</td>
				<td>
					${zInsuranceClaimSettlement.vehicleNum}
				</td>
				<td>
					<fmt:formatDate value="${zInsuranceClaimSettlement.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zInsuranceClaimSettlement.individualVehicleOperator}
				</td>
				<td>
					${zInsuranceClaimSettlement.accidentAddress}
				</td>
				<td>
					${zInsuranceClaimSettlement.respSituation}
				</td>
				<td>
					${zInsuranceClaimSettlement.accDriver}
				</td>
				<td>
					${zInsuranceClaimSettlement.accReason}
				</td>
				<td>
					${zInsuranceClaimSettlement.vehicleIndemnity}
				</td>
				<td>
					${zInsuranceClaimSettlement.humanInjuryIndemnity}
				</td>
				<td>
					${zInsuranceClaimSettlement.lossIndemnity}
				</td>
				<td>
					${zInsuranceClaimSettlement.thirdPartyVehicleIndemnity}
				</td>
				<td>
					${zInsuranceClaimSettlement.thirdPartyHumanInjuryIndemnity}
				</td>
				<td>
					${zInsuranceClaimSettlement.carrierInsuranceIndemnity}
				</td>
				<td>
					${zInsuranceClaimSettlement.totalAmount}
				</td>
				<td>
					<fmt:formatDate value="${zInsuranceClaimSettlement.closingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${zInsuranceClaimSettlement.companyRealseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zInsuranceClaimSettlement.mark}
				</td>
				<td>
					${zInsuranceClaimSettlement.driverLicense}
				</td>
				<td>
					${zInsuranceClaimSettlement.queryCode}
				</td>
				<shiro:hasPermission name="zsys:zInsuranceClaimSettlement:edit"><td>
    				<a href="${ctx}/zsys/zInsuranceClaimSettlement/form?id=${zInsuranceClaimSettlement.id}">修改</a>
					<a href="${ctx}/zsys/zInsuranceClaimSettlement/delete?id=${zInsuranceClaimSettlement.id}" onclick="return confirmx('确认要删除该保险理赔业务查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>