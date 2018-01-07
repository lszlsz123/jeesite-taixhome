<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>证件遗失补办业务管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zMakeUpLoss/">证件遗失补办业务列表</a></li>
		<shiro:hasPermission name="zsys:zMakeUpLoss:edit"><li><a href="${ctx}/zsys/zMakeUpLoss/form">证件遗失补办业务添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zMakeUpLoss" action="${ctx}/zsys/zMakeUpLoss/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>创建日期：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMakeUpLoss.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMakeUpLoss.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新日期：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMakeUpLoss.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMakeUpLoss.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注信息：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>车牌号码：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>丢失时间：</label>
				<input name="lossTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zMakeUpLoss.lossTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>证件类型：</label>
				<form:select path="certType" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('cert_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>办理事件类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('loss_reassignment_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
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
				<th>车牌号码</th>
				<th>丢失时间</th>
				<th>证件类型</th>
				<th>办理事件类型</th>
				<shiro:hasPermission name="zsys:zMakeUpLoss:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zMakeUpLoss">
			<tr>
				<td><a href="${ctx}/zsys/zMakeUpLoss/form?id=${zMakeUpLoss.id}">
					<fmt:formatDate value="${zMakeUpLoss.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					<fmt:formatDate value="${zMakeUpLoss.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zMakeUpLoss.remarks}
				</td>
				<td>
					${zMakeUpLoss.vehicleNum}
				</td>
				<td>
					<fmt:formatDate value="${zMakeUpLoss.lossTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(zMakeUpLoss.certType, 'cert_type', '')}
				</td>
				<td>
					${fns:getDictLabel(zMakeUpLoss.type, 'loss_reassignment_type', '')}
				</td>
				<shiro:hasPermission name="zsys:zMakeUpLoss:edit"><td>
    				<a href="${ctx}/zsys/zMakeUpLoss/form?id=${zMakeUpLoss.id}">修改</a>
					<a href="${ctx}/zsys/zMakeUpLoss/delete?id=${zMakeUpLoss.id}" onclick="return confirmx('确认要删除该证件遗失补办业务吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>