<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>遗失物品挂失管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zLossArticles/">遗失物品挂失列表</a></li>
		<shiro:hasPermission name="zsys:zLossArticles:edit"><li><a href="${ctx}/zsys/zLossArticles/form">遗失物品挂失添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zLossArticles" action="${ctx}/zsys/zLossArticles/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车号：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
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
				<th>登记时间</th>
				<th>车号</th>
				<th>姓名</th>
				<th>丢失物品</th>
				<th>乘车时间</th>
				<th>上车地点</th>
				<th>下车地点</th>
				<th>失主姓名</th>
				<th>联系电话</th>
				<shiro:hasPermission name="zsys:zLossArticles:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zLossArticles">
			<tr>
				<td><a href="${ctx}/zsys/zLossArticles/form?id=${zLossArticles.id}">
					<fmt:formatDate value="${zLossArticles.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zLossArticles.remarks}
				</td>
				<td>
					<fmt:formatDate value="${zLossArticles.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zLossArticles.vehicleNum}
				</td>
				<td>
					${zLossArticles.name}
				</td>
				<td>
					${zLossArticles.lostContent}
				</td>
				<td>
					${zLossArticles.rideTime}
				</td>
				<td>
					${zLossArticles.boradingLocation}
				</td>
				<td>
					${zLossArticles.dropOffPoint}
				</td>
				<td>
					${zLossArticles.ownerName}
				</td>
				<td>
					${zLossArticles.contactPhone}
				</td>
				<shiro:hasPermission name="zsys:zLossArticles:edit"><td>
    				<a href="${ctx}/zsys/zLossArticles/form?id=${zLossArticles.id}">修改</a>
					<a href="${ctx}/zsys/zLossArticles/delete?id=${zLossArticles.id}" onclick="return confirmx('确认要删除该遗失物品挂失吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>