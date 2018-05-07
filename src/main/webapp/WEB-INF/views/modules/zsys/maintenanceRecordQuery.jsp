<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>安技--车辆技术维护记录查询</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>安技--车辆技术维护记录查询</li>
	</ul><br/>
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tbody>
		<!-- 1 -->
		<tr>
				<td style="width:300px;">一季度没有做二级维护的车辆：<td>
				<td>车牌号</<td>
		</tr>
		<c:forEach items="${list1}" var="item" >
			<tr>
				<td colspan=3>
					${item }
				</td>
				
			</tr>
		</c:forEach>
		<tr>
				<td>台数统计：${count1 }</td>
		</tr>
		
		<!-- 2 -->
		<tr>
				<td style="width:300px;">二季度没有做二级维护的车辆：<td>
				<td>车牌号</<td>
		</tr>
		<c:forEach items="${list2}" var="item" >
			<tr>
				<td colspan=3>
					${item }
				</td>
				
			</tr>
		</c:forEach>
		<tr>
				<td>台数统计：${count2 }</td>
		</tr>
		
		<!-- 3 -->
		<tr>
				<td style="width:300px;">三季度没有做二级维护的车辆：<td>
				<td>车牌号</<td>
		</tr>
		<c:forEach items="${list3}" var="item" >
			<tr>
				<td colspan=3>
					${item }
				</td>
				
			</tr>
		</c:forEach>
		<tr>
				<td>台数统计：${count3 }</td>
		</tr>
		
		<!-- 4 -->
		<tr>
				<td style="width:300px;">四季度没有做二级维护的车辆：<td>
				<td>车牌号</<td>
		</tr>
		<c:forEach items="${list4}" var="item" >
			<tr>
				<td colspan=3>
					${item }
				</td>
				
			</tr>
		</c:forEach>
		<tr>
				<td>台数统计：${count4 }</td>
		</tr>
		</tbody>
	</table>
		
		
	
</body>
</html>