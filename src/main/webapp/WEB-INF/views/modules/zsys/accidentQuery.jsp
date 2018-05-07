<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>安技--交通事故查询及业务</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<ul class="nav nav-tabs">
		<li>安技--交通事故查询及业务</li>
	</ul><br/>
	
			
		
		<div class="control-group">
			<div class="controls">
				出险次数统计：${count}
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				保险理赔金额统计：${claimCount}
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				按责任情况统计：全责：${resp_count_1 }&nbsp;&nbsp;&nbsp;主责：${resp_count_2 }&nbsp;&nbsp;&nbsp;同责：${resp_count_3 }&nbsp;&nbsp;&nbsp;次责：${resp_count_4 }&nbsp;&nbsp;&nbsp;无责：${resp_count_5 }
			</div>
		</div>
	
</body>
</html>