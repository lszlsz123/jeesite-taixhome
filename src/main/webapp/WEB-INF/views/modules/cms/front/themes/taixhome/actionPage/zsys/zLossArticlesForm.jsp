<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title></title>
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
        <li class="mg">遗失物品挂失</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
          <li class="ri_page_ggys">车牌号：${zLossArticles.vehicleNum}</li>
          <li class="ri_page_ggys">登记时间：<fmt:formatDate value="${zLossArticles.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">姓名：${zLossArticles.name}</li>
          <li class="ri_page_ggys">丢失物品：${zLossArticles.lostContent}</li>
          <li class="ri_page_ggys">乘车时间：${zLossArticles.rideTime}</li>
          <li class="ri_page_ggys">上车地点：${zLossArticles.boradingLocation}</li>
          <li class="ri_page_ggys">下车地点：${zLossArticles.dropOffPoint}</li>
          <li class="ri_page_ggys">失主姓名：${zLossArticles.ownerName}</li>
          <li class="ri_page_ggys">联系电话：${zLossArticles.contactPhone}</li>
          <li class="ri_page_ggys">发布时间：<fmt:formatDate value="${zLossArticles.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${zLossArticles.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="mg_bottom">
    <div class="btn_box">
      <a href="${ctx}/list-a1976cc4e876445196f20d5fd2a8ed2d.html">
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