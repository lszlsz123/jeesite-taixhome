<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>从业司机业务办理查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zDriverBusiness/">从业司机业务办理查询列表</a></li>
		<shiro:hasPermission name="zsys:zDriverBusiness:edit"><li><a href="${ctx}/zsys/zDriverBusiness/form">从业司机业务办理查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zDriverBusiness" action="${ctx}/zsys/zDriverBusiness/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>自编号：</label>
				<form:input path="selfNumber" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>车牌：</label>
				<form:input path="vehicleNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>备班驾驶员：</label>
				<form:input path="driver" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>联系电话：</label>
				<form:input path="contactPhone" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>身份证号：</label>
				<form:input path="idCard" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>备班日期：</label>
				<input name="beginDriverDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zDriverBusiness.beginDriverDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endDriverDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zDriverBusiness.endDriverDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>退出日期：</label>
				<input name="beginQuitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zDriverBusiness.beginQuitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endQuitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zDriverBusiness.endQuitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>备注信息</th>
				<th>车型</th>
				<th>自编号</th>
				<th>车牌</th>
				<th>备班驾驶员</th>
				<th>联系电话</th>
				<th>身份证号</th>
				<th>地址</th>
				<th>准驾车型</th>
				<th>驾照初领日期</th>
				<th>从业资格证号</th>
				<th>从业资格证初领日期</th>
				<th>备班日期</th>
				<th>退出日期</th>
				<th>审批流程</th>
				<th>查询号码</th>
				<shiro:hasPermission name="zsys:zDriverBusiness:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zDriverBusiness">
			<tr>
				<td><a href="${ctx}/zsys/zDriverBusiness/form?id=${zDriverBusiness.id}">
					<fmt:formatDate value="${zDriverBusiness.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zDriverBusiness.remarks}
				</td>
				<td>
					${zDriverBusiness.vehicleType}
				</td>
				<td>
					${zDriverBusiness.selfNumber}
				</td>
				<td>
					${zDriverBusiness.vehicleNum}
				</td>
				<td>
					${zDriverBusiness.driver}
				</td>
				<td>
					${zDriverBusiness.contactPhone}
				</td>
				<td>
					${zDriverBusiness.idCard}
				</td>
				<td>
					${zDriverBusiness.address}
				</td>
				<td>
					${zDriverBusiness.allowedDriveModel}
				</td>
				<td>
					<fmt:formatDate value="${zDriverBusiness.licenseInitialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zDriverBusiness.quaCertNum}
				</td>
				<td>
					<fmt:formatDate value="${zDriverBusiness.quaCertInitialDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${zDriverBusiness.driverDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${zDriverBusiness.quitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(zDriverBusiness.step, 'driverBusinessStep', '')}
				</td>
				<td>
					${zDriverBusiness.queryCode}
				</td>
				<shiro:hasPermission name="zsys:zDriverBusiness:edit"><td>
    				<a href="${ctx}/zsys/zDriverBusiness/form?id=${zDriverBusiness.id}">修改</a>
					<a href="${ctx}/zsys/zDriverBusiness/delete?id=${zDriverBusiness.id}" onclick="return confirmx('确认要删除该从业司机业务办理查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>