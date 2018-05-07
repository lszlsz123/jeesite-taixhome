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
				交强险（车）赔款统计：${count1 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				交强险（人伤）赔款统计：${count2 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				车损险赔款统计：${count3 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				三者险（车）赔款统计：${count4 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				三者险（人）赔款统计：${count5 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				承运人险赔款统计：${count6 }
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				赔款总金额统计：${count7 }
			</div>
		</div>
		
		
	
</body>
</html>