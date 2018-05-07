<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>证件遗失补办业务統計</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>证件遗失补办业务統計</li>
	</ul><br/>
	
			
		<div class="control-group">
			<div class="controls">
				<c:forEach var="item" items="${list}" varStatus="status">
			         ${item.time}：${item.count} &nbsp;&nbsp;&nbsp;
				</c:forEach> 
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				1季度：${currentYear_q1 } &nbsp;&nbsp;&nbsp;
				2季度：${currentYear_q2 } &nbsp;&nbsp;&nbsp;
				3季度：${currentYear_q3 } &nbsp;&nbsp;&nbsp;
				4季度：${currentYear_q4 } &nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				与往年对比：
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				季度对比：${lastYear} 年&nbsp;&nbsp;&nbsp;第一季度${lastYear_q1}&nbsp;&nbsp;&nbsp;第二季度${lastYear_q2} &nbsp;&nbsp;&nbsp;第三季度${lastYear_q3} &nbsp;&nbsp;&nbsp;第四季度${lastYear_q4}
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				季度对比：${yearBeforeLastYear} 年&nbsp;&nbsp;&nbsp;第一季度${yearBeforeLastYear_q1}&nbsp;&nbsp;&nbsp;第二季度${yearBeforeLastYear_q2} &nbsp;&nbsp;&nbsp;第三季度${yearBeforeLastYear_q3} &nbsp;&nbsp;&nbsp;第四季度${yearBeforeLastYear_q4}
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				季度对比：${threeYearAgo} 年&nbsp;&nbsp;&nbsp;第一季度${threeYearAgo_q1}&nbsp;&nbsp;&nbsp;第二季度${threeYearAgo_q2} &nbsp;&nbsp;&nbsp;第三季度${threeYearAgo_q3} &nbsp;&nbsp;&nbsp;第四季度${threeYearAgo_q4}
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				月份对比：
				<c:forEach var="item" items="${list1}" varStatus="status">
			         ${item.time}：${item.count} &nbsp;&nbsp;&nbsp;
				</c:forEach> 
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				月份对比：
				<c:forEach var="item" items="${list2}" varStatus="status">
			         ${item.time}：${item.count} &nbsp;&nbsp;&nbsp;
				</c:forEach> 
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				月份对比：
				<c:forEach var="item" items="${list3}" varStatus="status">
			         ${item.time}：${item.count} &nbsp;&nbsp;&nbsp;
				</c:forEach> 
			</div>
		</div>
	
</body>
</html>