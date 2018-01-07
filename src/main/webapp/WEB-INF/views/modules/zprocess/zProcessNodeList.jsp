<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流程节点管理管理</title>
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
		<li class="active"><a href="${ctx}/zprocess/zProcessNode/">流程节点管理列表</a></li>
		<shiro:hasPermission name="zprocess:zProcessNode:edit"><li><a href="${ctx}/zprocess/zProcessNode/form">流程节点管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zProcessNode" action="${ctx}/zprocess/zProcessNode/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>节点名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>流程名称：</label>
				<form:input path="processName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>排序：</label>
				<form:input path="seq" htmlEscape="false" maxlength="11" class="input-medium"/>
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
				<th>节点名称</th>
				<th>流程名称</th>
				<th>排序</th>
				<shiro:hasPermission name="zprocess:zProcessNode:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zProcessNode">
			<tr>
				<td><a href="${ctx}/zprocess/zProcessNode/form?id=${zProcessNode.id}">
					<fmt:formatDate value="${zProcessNode.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zProcessNode.remarks}
				</td>
				<td>
					${zProcessNode.name}
				</td>
				<td>
					${zProcessNode.processName}
				</td>
				<td>
					${zProcessNode.seq}
				</td>
				<shiro:hasPermission name="zprocess:zProcessNode:edit"><td>
    				<a href="${ctx}/zprocess/zProcessNode/form?id=${zProcessNode.id}">修改</a>
					<a href="${ctx}/zprocess/zProcessNode/delete?id=${zProcessNode.id}" onclick="return confirmx('确认要删除该流程节点管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>