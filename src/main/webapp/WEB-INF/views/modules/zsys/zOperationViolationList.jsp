<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>运营违规记录查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zOperationViolation/">运营违规记录查询列表</a></li>
		<shiro:hasPermission name="zsys:zOperationViolation:edit"><li><a href="${ctx}/zsys/zOperationViolation/form">运营违规记录查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zOperationViolation" action="${ctx}/zsys/zOperationViolation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>投诉时间：</label>
				<input name="beginComplaintTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zOperationViolation.beginComplaintTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endComplaintTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zOperationViolation.endComplaintTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>投诉类型：</label>
				<form:select path="complaintType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('complainType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>投诉人：</label>
				<form:input path="complaintPerson" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>投诉电话：</label>
				<form:input path="complaintPhoneNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>车牌号：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>处理人：</label>
				<form:input path="processingPerson" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>办理日期</th>
				<th>备注信息</th>
				<th>投诉时间</th>
				<th>投诉类型</th>
				<th>投诉人</th>
				<th>投诉电话</th>
				<th>经营者</th>
				<th>经营者电话</th>
				<th>驾驶员</th>
				<th>驾驶员电话</th>
				<th>车牌号</th>
				<th>处理结果</th>
				<th>处理人</th>
				<th>车架号</th>
				<th>查询码</th>
				<shiro:hasPermission name="zsys:zOperationViolation:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zOperationViolation">
			<tr>
				<td><a href="${ctx}/zsys/zOperationViolation/form?id=${zOperationViolation.id}">
					<fmt:formatDate value="${zOperationViolation.handleDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zOperationViolation.remarks}
				</td>
				<td>
					<fmt:formatDate value="${zOperationViolation.complaintTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(zOperationViolation.complaintType, 'complainType', '')}
				</td>
				<td>
					${zOperationViolation.complaintPerson}
				</td>
				<td>
					${zOperationViolation.complaintPhoneNum}
				</td>
				<td>
					${zOperationViolation.operator}
				</td>
				<td>
					${zOperationViolation.operatorPhoneNum}
				</td>
				<td>
					${zOperationViolation.driver}
				</td>
				<td>
					${zOperationViolation.driverPhoneNum}
				</td>
				<td>
					${zOperationViolation.vehicleNum}
				</td>
				<td>
					${zOperationViolation.result}
				</td>
				<td>
					${zOperationViolation.processingPerson}
				</td>
				<td>
					${zOperationViolation.frameNum}
				</td>
				<td>
					${zOperationViolation.queryCode}
				</td>
				<shiro:hasPermission name="zsys:zOperationViolation:edit"><td>
    				<a href="${ctx}/zsys/zOperationViolation/form?id=${zOperationViolation.id}">修改</a>
					<a href="${ctx}/zsys/zOperationViolation/delete?id=${zOperationViolation.id}" onclick="return confirmx('确认要删除该运营违规记录查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>