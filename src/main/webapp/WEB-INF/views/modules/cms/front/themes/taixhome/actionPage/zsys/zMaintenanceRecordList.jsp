<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>车辆技术维护记录查询</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/taixhome/css/portal.css"/>
  <link href="${ctxStatic}/modules/cms/front/themes/basic/style.css" type="text/css" rel="stylesheet" />

</head>
<body>
<div id="hp_bg">
  <div id="header">
    <div class="logo">
      <a href="${ctx }">
        <img src="${ctxStatic}/taixhome/image/logo.png"/>
      </a>
    </div>
  </div>
  <div id="nav">
    <div class="name">
      <img src="${ctxStatic}/taixhome/image/name.png"/>
    </div>
  </div>
  <div class="mg_content">
    <div class="mg_title">
      <ul class="yl_chose">
        <li class="mg">车辆技术维护记录查询</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
        
        	<c:forEach items="${page.list}" var="zMaintenanceRecord">
	        	<a href="${ctx}/zsys/zMaintenanceRecord/formDetail?id=${zMaintenanceRecord.id}">
		            <li class="bbm">
		              <span class="zpxx_gyys xq">自编号：${zMaintenanceRecord.selfNum}</span>
		              <span class="zpxx_gyys gsmc">车牌号码：${zMaintenanceRecord.vehicleNum} 年检时间：<fmt:formatDate value="${zMaintenanceRecord.inspectionTime}" pattern="yyyy.MM.dd"/></span>
		              <span class="zpxx_gyys dz"><fmt:formatDate value="${zMaintenanceRecord.updateDate}" pattern="yyyy.MM.dd"/></span>
		            </li>
	          	</a>
          	</c:forEach>
        
        <div class="fy_box">
          <ul>
            ${page.taixHomePage}
            <script type="text/javascript">
				function page(n,s){
					location="${ctx}/zsys/zMaintenanceRecord/list?pageNo="+n+"&pageSize="+s+"&vehicleNum=${zMaintenanceRecord.vehicleNum}";
				}
			</script>
          </ul>
        </div>
        
      </div>
    </div>
  </div>
		  <div class="mg_bottom">
		    <a href="${ctx}/list-34eadbc7ec4e4481af24a9766bf711af.html">
			        <span class="rt_upl lf">返回上一级</span>
	      </a>
	      <a href="${ctx}">
	        <span class="rt_ind lf">返回首页</span>
	      </a>
	      <div class="mg_taxi_bg rt">
		      <img src="${ctxStatic}/taixhome/image/hp_th.png"/>
		    </div>
	    </div>
    
  </div>
</div>
<script src="${ctxStatic}/taixhome/js/jquery-1.11.3.js"></script>
<script src="${ctxStatic}/taixhome/js/index.js"></script>
</body>
</html>