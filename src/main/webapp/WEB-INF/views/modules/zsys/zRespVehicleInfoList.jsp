<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>责任经营车辆信息查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zRespVehicleInfo/">责任经营车辆信息查询列表</a></li>
		<shiro:hasPermission name="zsys:zRespVehicleInfo:edit"><li><a href="${ctx}/zsys/zRespVehicleInfo/form">责任经营车辆信息查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zRespVehicleInfo" action="${ctx}/zsys/zRespVehicleInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>新车号：</label>
				<form:input path="newVehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>原车号：</label>
				<form:input path="oriVehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>实际上线运营时间</th>
				<th>营运证截止日期</th>
				<th>营运证发证日期</th>
				<th>营运证号</th>
				<th>发动机号</th>
				<th>车架号</th>
				<th>车辆出厂日期</th>
				<th>计价器编号</th>
				<th>车辆型号</th>
				<th>姓名</th>
				<th>新车号</th>
				<th>原车号</th>
				<shiro:hasPermission name="zsys:zRespVehicleInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zRespVehicleInfo">
			<tr>
				<td><a href="${ctx}/zsys/zRespVehicleInfo/form?id=${zRespVehicleInfo.id}">
					<fmt:formatDate value="${zRespVehicleInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zRespVehicleInfo.remarks}
				</td>
				<td>
					<fmt:formatDate value="${zRespVehicleInfo.actualOnlineOperationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${zRespVehicleInfo.operationCertificateExpireDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${zRespVehicleInfo.operationCertificateIssueDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zRespVehicleInfo.operationCertificateNum}
				</td>
				<td>
					${zRespVehicleInfo.engineNum}
				</td>
				<td>
					${zRespVehicleInfo.frameNum}
				</td>
				<td>
					<fmt:formatDate value="${zRespVehicleInfo.vehicleProductionDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zRespVehicleInfo.taximeterNum}
				</td>
				<td>
					${zRespVehicleInfo.vehicleType}
				</td>
				<td>
					${zRespVehicleInfo.name}
				</td>
				<td>
					${zRespVehicleInfo.newVehicleNum}
				</td>
				<td>
					${zRespVehicleInfo.oriVehicleNum}
				</td>
				<shiro:hasPermission name="zsys:zRespVehicleInfo:edit"><td>
    				<a href="${ctx}/zsys/zRespVehicleInfo/form?id=${zRespVehicleInfo.id}">修改</a>
					<a href="${ctx}/zsys/zRespVehicleInfo/delete?id=${zRespVehicleInfo.id}" onclick="return confirmx('确认要删除该责任经营车辆信息查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>