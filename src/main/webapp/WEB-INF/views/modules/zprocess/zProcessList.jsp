<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流程管理管理</title>
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
		<li class="active"><a href="${ctx}/zprocess/zProcess/">流程管理列表</a></li>
		<shiro:hasPermission name="zprocess:zProcess:edit"><li><a href="${ctx}/zprocess/zProcess/form">流程管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zProcess" action="${ctx}/zprocess/zProcess/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>流程名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>流程名称</th>
				<shiro:hasPermission name="zprocess:zProcess:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zProcess">
			<tr>
				<td><a href="${ctx}/zprocess/zProcess/form?id=${zProcess.id}">
					<fmt:formatDate value="${zProcess.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zProcess.remarks}
				</td>
				<td>
					${zProcess.name}
				</td>
				<shiro:hasPermission name="zprocess:zProcess:edit"><td>
    				<a href="${ctx}/zprocess/zProcess/form?id=${zProcess.id}">修改</a>
					<a href="${ctx}/zprocess/zProcess/delete?id=${zProcess.id}" onclick="return confirmx('确认要删除该流程管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>