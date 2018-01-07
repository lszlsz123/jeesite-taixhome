<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>前台日志管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zAuditHistory/">前台日志列表</a></li>
		<shiro:hasPermission name="zsys:zAuditHistory:edit"><li><a href="${ctx}/zsys/zAuditHistory/form">前台日志添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zAuditHistory" action="${ctx}/zsys/zAuditHistory/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>创建日期：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zAuditHistory.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>模块名称：</label>
				<form:select path="moduleName" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('module_name')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>访问IP：</label>
				<form:input path="visitIp" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>创建日期</th>
				<th>更新日期</th>
				<th>备注信息</th>
				<th>模块名称</th>
				<th>访问IP</th>
				<shiro:hasPermission name="zsys:zAuditHistory:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zAuditHistory">
			<tr>
				<td><a href="${ctx}/zsys/zAuditHistory/form?id=${zAuditHistory.id}">
					<fmt:formatDate value="${zAuditHistory.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					<fmt:formatDate value="${zAuditHistory.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zAuditHistory.remarks}
				</td>
				<td>
					${fns:getDictLabel(zAuditHistory.moduleName, 'module_name', '')}
				</td>
				<td>
					${zAuditHistory.visitIp}
				</td>
				<shiro:hasPermission name="zsys:zAuditHistory:edit"><td>
    				<a href="${ctx}/zsys/zAuditHistory/form?id=${zAuditHistory.id}">修改</a>
					<a href="${ctx}/zsys/zAuditHistory/delete?id=${zAuditHistory.id}" onclick="return confirmx('确认要删除该前台日志吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>