<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>保险理赔业务查询</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/taixhome/css/portal.css"/>

</head>
<body>
<div id="hp_bg">
  <div id="header">
    <div class="logo">
      <a href="${ctx}">
        <img src="${ctxStatic}/taixhome/image/logo.png" alt="这是logo"/>
      </a>
    </div>
  </div>
  <div id="nav">
    <div class="name">
      <img src="${ctxStatic}/taixhome/image/name.png" alt="这是出租之家图片"/>
    </div>
  </div>
  <div class="mg_content">
    <div class="mg_title">
      <ul class="yl_chose">
        <li class="mg">保险理赔业务查询</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
          <li class="ri_page_ggys">车牌号：${zMaintenanceRecord.vehicleNum}</li>
          <li class="ri_page_ggys">经营者：${zMaintenanceRecord.operator}</li>
          <li class="ri_page_ggys">一季度：${zMaintenanceRecord.firstQuarter}</li>
          <li class="ri_page_ggys">二季度：${zMaintenanceRecord.secondQuarter}</li>
          <li class="ri_page_ggys">三季度：${zMaintenanceRecord.thirdQuarter}</li>
          <li class="ri_page_ggys">四季度：${zMaintenanceRecord.fourthQuarter}</li>
          <li class="ri_page_ggys">车辆年检时间：<fmt:formatDate value="${zMaintenanceRecord.inspectionTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">备注：${zMaintenanceRecord.mark}</li>
          <li class="ri_page_ggys">发布时间：<fmt:formatDate value="${zMaintenanceRecord.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${zMaintenanceRecord.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="mg_bottom">
    <div class="btn_box">
      <a href="${ctx}/list-34eadbc7ec4e4481af24a9766bf711af.html">
        <span class="rt_upl lf">返回上一级</span>
      </a>
      <a href="${ctx}">
        <span class="rt_ind lf">返回首页</span>
      </a>
    </div>
    <div class="mg_taxi_bg rt">
      <img src="${ctxStatic}/taixhome/image/hp_th.png"/>
    </div>
  </div>
</div>
<script src="${ctxStatic}/taixhome/js/jquery-1.11.3.js"></script>
<script src="${ctxStatic}/taixhome/js/index.js"></script>
</body>
</html>