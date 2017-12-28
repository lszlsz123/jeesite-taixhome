<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>诉讼案件查询</title>
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
        <li class="mg">责任经营车辆信息查询</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
          <li class="ri_page_ggys">车牌号：${zLitigation.vehicleNum}</li>
          <li class="ri_page_ggys">事故时间：<fmt:formatDate value="${zLitigation.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">诉讼案由（标明伤人、死亡、财产损失）：${zLitigation.litCause}</li>
          <li class="ri_page_ggys">诉讼时间：<fmt:formatDate value="${zLitigation.litTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">诉讼标的：${zLitigation.litTarget}</li>
          <li class="ri_page_ggys">判决金额：${zLitigation.judgmentAmount}</li>
          <li class="ri_page_ggys">保险公司名称：${zLitigation.insuranceCompany}</li>
          <li class="ri_page_ggys">保险支付：${zLitigation.insurancePayment}</li>
          <li class="ri_page_ggys">责任经营者支付：${zLitigation.operatorPayment}</li>
          <li class="ri_page_ggys">结束时间：<fmt:formatDate value="${zLitigation.closeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">诉讼法院：${zLitigation.court}</li>
          <li class="ri_page_ggys">备注：${zLitigation.mark}</li>
          <li class="ri_page_ggys">发布时间：<fmt:formatDate value="${zLitigation.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${zLitigation.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
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