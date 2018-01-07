<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>交通事故查询管理</title>
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
		<li class="active"><a href="${ctx}/zsys/zAccident/">交通事故查询列表</a></li>
		<shiro:hasPermission name="zsys:zAccident:edit"><li><a href="${ctx}/zsys/zAccident/form">交通事故查询添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zAccident" action="${ctx}/zsys/zAccident/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>事故时间：</label>
				<input name="beginAccTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zAccident.beginAccTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endAccTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zAccident.endAccTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>事故等级：</label>
				<form:select path="level" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('accident_level')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li>
				<label>责任情况：</label>
				<form:select path="respSituation" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('accident_response')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label style="width:150px;">预估损失金额（元）：</label>
				<form:input path="estimationAmount" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>结案日期：</label>
				<input name="beginCloseDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zAccident.beginCloseDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCloseDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${zAccident.endCloseDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>事故车号：</label>
				<form:input path="accVehcileNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>驾驶员姓名：</label>
				<form:input path="driverName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>事故编号：</label>
				<form:input path="accidentNum" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>驾照：</label>
				<form:input path="driverLicense" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>查询码：</label>
				<form:input path="queryCode" htmlEscape="false" maxlength="50" class="input-medium"/>
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
				<th>事故时间</th>
				<th>事故地点</th>
				<th>责任情况</th>
				<th>事故等级</th>
				<th>事故原因、种类</th>
				<th>车辆承保公司</th>
				<th>预估损失金额（元）</th>
				<th>受伤人数</th>
				<th>死亡人数</th>
				<th>案件进展情况</th>
				<th>保险理赔金额（元）</th>
				<th>结案日期</th>
				<th>备注</th>
				<th>事故车号</th>
				<th>驾驶员姓名</th>
				<th>事故编号</th>
				<th>自编号</th>
				<th>驾照</th>
				<th>查询码</th>
				<shiro:hasPermission name="zsys:zAccident:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zAccident">
			<tr>
				<td><a href="${ctx}/zsys/zAccident/form?id=${zAccident.id}">
					<fmt:formatDate value="${zAccident.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${zAccident.remarks}
				</td>
				<td>
					<fmt:formatDate value="${zAccident.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zAccident.accAddress}
				</td>
				<td>
					${fns:getDictLabel(zAccident.respSituation, 'accident_reponse', '')}
				</td>
				<td>
					${fns:getDictLabel(zAccident.level, 'accident_level', '')}
				</td>
				<td>
					${zAccident.accReasonType}
				</td>
				<td>
					${zAccident.vehicleInsuranceCompany}
				</td>
				<td>
					${zAccident.estimationAmount}
				</td>
				<td>
					${zAccident.injuredCount}
				</td>
				<td>
					${zAccident.deathCount}
				</td>
				<td>
					${zAccident.caseProgress}
				</td>
				<td>
					${zAccident.claimAmount}
				</td>
				<td>
					<fmt:formatDate value="${zAccident.closeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${zAccident.mark}
				</td>
				<td>
					${zAccident.accVehcileNum}
				</td>
				<td>
					${zAccident.driverName}
				</td>
				<td>
					${zAccident.accidentNum}
				</td>
				<td>
					${zAccident.selfNum}
				</td>
				<td>
					${zAccident.driverLicense}
				</td>
				<td>
					${zAccident.queryCode}
				</td>
				<shiro:hasPermission name="zsys:zAccident:edit"><td>
    				<a href="${ctx}/zsys/zAccident/form?id=${zAccident.id}">修改</a>
					<a href="${ctx}/zsys/zAccident/delete?id=${zAccident.id}" onclick="return confirmx('确认要删除该交通事故查询吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>