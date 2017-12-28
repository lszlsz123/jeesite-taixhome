<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆技术维护记录查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zMaintenanceRecord/">车辆技术维护记录查询列表</a></li>
		<shiro:hasPermission name="zsys:zMaintenanceRecord:edit"><li><a href="${ctx}/zsys/zMaintenanceRecord/form">车辆技术维护记录查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zMaintenanceRecord" action="${ctx}/zsys/zMaintenanceRecord/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>自编号：</label>
				<form:input path="selfNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>车牌号：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>车辆年检时间：</label>
				<input name="beginInspectionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMaintenanceRecord.beginInspectionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endInspectionTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMaintenanceRecord.endInspectionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>自编号</th>
				<th>车牌号</th>
				<th>经营者</th>
				<th>一季度</th>
				<th>二季度</th>
				<th>三季度</th>
				<th>四季度</th>
				<th>车辆年检时间</th>
				<th>备注</th>
				<th>驾照</th>
				<th>查询码</th>
				<shiro:hasPermission name="zsys:zMaintenanceRecord:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zMaintenanceRecord">
			<tr>
				<td><a href="${ctx}/zsys/zMaintenanceRecord/form?id=${zMaintenanceRecord.id}">
					<fmt:formatDate value="${zMaintenanceRecord.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zMaintenanceRecord.remarks}
				</td>
				<td>
					${zMaintenanceRecord.selfNum}
				</td>
				<td>
					${zMaintenanceRecord.vehicleNum}
				</td>
				<td>
					${zMaintenanceRecord.operator}
				</td>
				<td>
					${zMaintenanceRecord.firstQuarter}
				</td>
				<td>
					${zMaintenanceRecord.secondQuarter}
				</td>
				<td>
					${zMaintenanceRecord.thirdQuarter}
				</td>
				<td>
					${zMaintenanceRecord.fourthQuarter}
				</td>
				<td>
					<fmt:formatDate value="${zMaintenanceRecord.inspectionTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zMaintenanceRecord.mark}
				</td>
				<td>
					${zMaintenanceRecord.driverLicense}
				</td>
				<td>
					${zMaintenanceRecord.queryCode}
				</td>
				<shiro:hasPermission name="zsys:zMaintenanceRecord:edit"><td>
    				<a href="${ctx}/zsys/zMaintenanceRecord/form?id=${zMaintenanceRecord.id}">修改</a>
					<a href="${ctx}/zsys/zMaintenanceRecord/delete?id=${zMaintenanceRecord.id}" onclick="return confirmx('确认要删除该车辆技术维护记录查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>