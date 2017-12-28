<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流程步骤管理管理</title>
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
		<li class="active"><a href="${ctx}/zprocess/zProcessLink/">流程步骤管理列表</a></li>
		<shiro:hasPermission name="zprocess:zProcessLink:edit"><li><a href="${ctx}/zprocess/zProcessLink/form">流程步骤管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zProcessLink" action="${ctx}/zprocess/zProcessLink/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>开始节点名称：</label>
				<form:input path="startName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>结束节点名称：</label>
				<form:input path="endName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>流程名称：</label>
				<form:input path="processName" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>开始节点名称</th>
				<th>结束节点名称</th>
				<th>流程名称</th>
				<shiro:hasPermission name="zprocess:zProcessLink:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zProcessLink">
			<tr>
				<td><a href="${ctx}/zprocess/zProcessLink/form?id=${zProcessLink.id}">
					<fmt:formatDate value="${zProcessLink.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zProcessLink.remarks}
				</td>
				<td>
					${fns:getZprocessNodeLabel(zProcessLink.startNode)}
				</td>
				<td>
					${fns:getZprocessNodeLabel(zProcessLink.endNode)}
				</td>
				<td>
					${fns:getZProcessLabel(zProcessLink.processId)}
				</td>
				<shiro:hasPermission name="zprocess:zProcessLink:edit"><td>
    				<a href="${ctx}/zprocess/zProcessLink/form?id=${zProcessLink.id}">修改</a>
					<a href="${ctx}/zprocess/zProcessLink/delete?id=${zProcessLink.id}" onclick="return confirmx('确认要删除该流程步骤管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>