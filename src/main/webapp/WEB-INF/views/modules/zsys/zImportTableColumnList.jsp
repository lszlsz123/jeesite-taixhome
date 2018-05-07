<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>excel导入数据库列管理管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zImportTableColumn/">excel导入数据库列管理列表</a></li>
		<shiro:hasPermission name="zsys:zImportTableColumn:edit"><li><a href="${ctx}/zsys/zImportTableColumn/form">excel导入数据库列管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zImportTableColumn" action="${ctx}/zsys/zImportTableColumn/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>字段名称：</label>
				<form:input path="fieldName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>数据库字段名称：</label>
				<form:input path="dbColumn" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>表名称：</label>
				<form:input path="tableName" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>字段名称</th>
				<th>excel列</th>
				<th>字段类型</th>
				<th>数据库字段名称</th>
				<th>日期格式化</th>
				<th>表名称</th>
				<shiro:hasPermission name="zsys:zImportTableColumn:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zImportTableColumn">
			<tr>
				<td><a href="${ctx}/zsys/zImportTableColumn/form?id=${zImportTableColumn.id}">
					<fmt:formatDate value="${zImportTableColumn.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					<fmt:formatDate value="${zImportTableColumn.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zImportTableColumn.remarks}
				</td>
				<td>
					${zImportTableColumn.fieldName}
				</td>
				<td>
					${zImportTableColumn.excelColumn}
				</td>
				<td>
					${zImportTableColumn.columnType}
				</td>
				<td>
					${zImportTableColumn.dbColumn}
				</td>
				<td>
					${zImportTableColumn.dateFormatter}
				</td>
				<td>
					${zImportTableColumn.tableName}
				</td>
				<shiro:hasPermission name="zsys:zImportTableColumn:edit"><td>
    				<a href="${ctx}/zsys/zImportTableColumn/form?id=${zImportTableColumn.id}">修改</a>
					<a href="${ctx}/zsys/zImportTableColumn/delete?id=${zImportTableColumn.id}" onclick="return confirmx('确认要删除该excel导入数据库列管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>