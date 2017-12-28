<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>诉讼案件查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zLitigation/">诉讼案件查询列表</a></li>
		<shiro:hasPermission name="zsys:zLitigation:edit"><li><a href="${ctx}/zsys/zLitigation/form">诉讼案件查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zLitigation" action="${ctx}/zsys/zLitigation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车号：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>事故时间：</label>
				<input name="beginAccTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zLitigation.beginAccTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endAccTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zLitigation.endAccTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>诉讼时间：</label>
				<input name="beginLitTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zLitigation.beginLitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endLitTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zLitigation.endLitTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>更新日期</th>
				<th>备注信息</th>
				<th>车号</th>
				<th>事故时间</th>
				<th>诉讼案由（标明伤人、死亡、财产损失）</th>
				<th>诉讼时间</th>
				<th>诉讼标的</th>
				<th>判决金额</th>
				<th>保险公司名称</th>
				<th>保险支付</th>
				<th>责任经营者支付</th>
				<th>结案时间</th>
				<th>诉讼法院</th>
				<th>备注</th>
				<th>驾照</th>
				<th>查询码</th>
				<shiro:hasPermission name="zsys:zLitigation:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zLitigation">
			<tr>
				<td><a href="${ctx}/zsys/zLitigation/form?id=${zLitigation.id}">
					<fmt:formatDate value="${zLitigation.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zLitigation.remarks}
				</td>
				<td>
					${zLitigation.vehicleNum}
				</td>
				<td>
					<fmt:formatDate value="${zLitigation.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zLitigation.litCause}
				</td>
				<td>
					<fmt:formatDate value="${zLitigation.litTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zLitigation.litTarget}
				</td>
				<td>
					${zLitigation.judgmentAmount}
				</td>
				<td>
					${zLitigation.insuranceCompany}
				</td>
				<td>
					${zLitigation.insurancePayment}
				</td>
				<td>
					${zLitigation.operatorPayment}
				</td>
				<td>
					<fmt:formatDate value="${zLitigation.closeTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zLitigation.court}
				</td>
				<td>
					${zLitigation.mark}
				</td>
				<td>
					${zLitigation.driverLicense}
				</td>
				<td>
					${zLitigation.queryCode}
				</td>
				<shiro:hasPermission name="zsys:zLitigation:edit"><td>
    				<a href="${ctx}/zsys/zLitigation/form?id=${zLitigation.id}">修改</a>
					<a href="${ctx}/zsys/zLitigation/delete?id=${zLitigation.id}" onclick="return confirmx('确认要删除该诉讼案件查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>