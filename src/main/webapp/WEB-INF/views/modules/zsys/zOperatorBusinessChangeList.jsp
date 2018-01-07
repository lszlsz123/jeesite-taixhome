<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>责任经营者变更业务办理查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zOperatorBusinessChange/">责任经营者变更业务办理查询列表</a></li>
		<shiro:hasPermission name="zsys:zOperatorBusinessChange:edit"><li><a href="${ctx}/zsys/zOperatorBusinessChange/form">责任经营者变更业务办理查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zOperatorBusinessChange" action="${ctx}/zsys/zOperatorBusinessChange/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>编号：</label>
				<form:input path="num" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>原车牌号：</label>
				<form:input path="oriVehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>新车牌号：</label>
				<form:input path="newVehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="phoneNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>上车时间：</label>
				<input name="beginBoardingTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zOperatorBusinessChange.beginBoardingTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endBoardingTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zOperatorBusinessChange.endBoardingTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
				<th>办理时间</th>
				<th>备注信息</th>
				<th>编号</th>
				<th>原车牌号</th>
				<th>新车牌号</th>
				<th>姓名</th>
				<th>身份证号</th>
				<th>准驾车型</th>
				<th>初领日期</th>
				<th>从业资格证号</th>
				<th>从业资格证初领日期</th>
				<th>电话</th>
				<th>地址</th>
				<th>上车时间</th>
				<th>查询号码</th>
				<th>审批流程</th>
				<shiro:hasPermission name="zsys:zOperatorBusinessChange:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zOperatorBusinessChange">
			<tr>
				<td><a href="${ctx}/zsys/zOperatorBusinessChange/form?id=${zOperatorBusinessChange.id}">
					<fmt:formatDate value="${zOperatorBusinessChange.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td><a href="${ctx}/zsys/zOperatorBusinessChange/form?id=${zOperatorBusinessChange.id}">
					<fmt:formatDate value="${zOperatorBusinessChange.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zOperatorBusinessChange.remarks}
				</td>
				<td>
					${zOperatorBusinessChange.num}
				</td>
				<td>
					${zOperatorBusinessChange.oriVehicleNum}
				</td>
				<td>
					${zOperatorBusinessChange.newVehicleNum}
				</td>
				<td>
					${zOperatorBusinessChange.name}
				</td>
				<td>
					${zOperatorBusinessChange.idCard}
				</td>
				<td>
					${zOperatorBusinessChange.allowedDriveModel}
				</td>
				<td>
					<fmt:formatDate value="${zOperatorBusinessChange.initialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zOperatorBusinessChange.quaCertNum}
				</td>
				<td>
					<fmt:formatDate value="${zOperatorBusinessChange.quaCertInitialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zOperatorBusinessChange.phoneNum}
				</td>
				<td>
					${zOperatorBusinessChange.address}
				</td>
				<td>
					<fmt:formatDate value="${zOperatorBusinessChange.boardingTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zOperatorBusinessChange.queryCode}
				</td>
				<td>
					${fns:getDictLabel(zOperatorBusinessChange.step, 'operator_business_change', '')}
				</td>
				<shiro:hasPermission name="zsys:zOperatorBusinessChange:edit"><td>
    				<a href="${ctx}/zsys/zOperatorBusinessChange/form?id=${zOperatorBusinessChange.id}">修改</a>
					<a href="${ctx}/zsys/zOperatorBusinessChange/delete?id=${zOperatorBusinessChange.id}" onclick="return confirmx('确认要删除该责任经营者变更业务办理查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>