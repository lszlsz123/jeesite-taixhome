<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>excel导入数据库表管理管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zImportTable/">excel导入数据库表管理列表</a></li>
		<shiro:hasPermission name="zsys:zImportTable:edit"><li><a href="${ctx}/zsys/zImportTable/form">excel导入数据库表管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zImportTable" action="${ctx}/zsys/zImportTable/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>表名称：</label>
				<form:input path="tableName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>sheet名称：</label>
				<form:input path="sheetName" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>表名称</th>
				<th>sheet名称</th>
				<shiro:hasPermission name="zsys:zImportTable:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zImportTable">
			<tr>
				<td><a href="${ctx}/zsys/zImportTable/form?id=${zImportTable.id}">
					<fmt:formatDate value="${zImportTable.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zImportTable.remarks}
				</td>
				<td>
					${zImportTable.tableName}
				</td>
				<td>
					${zImportTable.sheetName}
				</td>
				<shiro:hasPermission name="zsys:zImportTable:edit"><td>
    				<a href="${ctx}/zsys/zImportTable/form?id=${zImportTable.id}">修改</a>
					<a href="${ctx}/zsys/zImportTable/delete?id=${zImportTable.id}" onclick="return confirmx('确认要删除该excel导入数据库表管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>