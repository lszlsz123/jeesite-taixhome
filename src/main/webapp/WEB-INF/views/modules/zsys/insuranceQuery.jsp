<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>安技--车辆投保情况查询</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>安技--车辆投保情况查询</li>
	</ul><br/>
	
			
		<div class="control-group">
			<div class="controls">
				交强险保费统计：${count1 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				交强险保费统计：${count2 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				交强险保费统计：${count3 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				交强险保费统计：${count4 }
			</div>
		</div>
		<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>投保到期日期(交强险为准）</th>
				<th>车辆型号</th>
				<th>同投保日期同车型车辆统计</th>
				<th>同批次车牌号</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="item" >
			<tr>
				<td>
					${item.date }
				</td>
				<td>
					${item.vehicleType }
				</td>
				<td>
					${item.count }
				</td>
				<td>
					<c:forEach var="itemVehicleNum" items="${item.list}">
						${itemVehicleNum} &nbsp;
					</c:forEach>
				</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>