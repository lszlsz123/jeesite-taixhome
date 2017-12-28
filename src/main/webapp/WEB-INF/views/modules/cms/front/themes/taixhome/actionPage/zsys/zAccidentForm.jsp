<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>责任经营车辆信息查询</title>
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
          <li class="ri_page_ggys">共发生交通事故次数：${page.count}</li>
          <li class="ri_page_ggys">事故编号：${zAccident.accidentNum}</li>
          <li class="ri_page_ggys">事故车号：${zAccident.accVehcileNum}</li>
          <li class="ri_page_ggys">驾驶员姓名：${zAccident.driverName}</li>
          <li class="ri_page_ggys">事故时间：<fmt:formatDate value="${zAccident.accTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">事故地点：${zAccident.accAddress}</li>
          <li class="ri_page_ggys">责任情况：${fns:getDictLabel(zAccident.respSituation, 'accident_response', '')}</li>
          <li class="ri_page_ggys">事故等级：${fns:getDictLabel(zAccident.level, 'accident_level', '')}</li>
          <li class="ri_page_ggys">事故原因、种类：${zAccident.accReasonType}</li>
          <li class="ri_page_ggys">车辆承保公司：${zAccident.vehicleInsuranceCompany}</li>
          <li class="ri_page_ggys">预估损失金额（元）：${zAccident.estimationAmount}</li>
          <li class="ri_page_ggys">伤人数：${zAccident.injuredCount}</li>
          <li class="ri_page_ggys">亡人数：${zAccident.deathCount}</li>
          <li class="ri_page_ggys">案件进展情况：${zAccident.caseProgress}</li>
          <li class="ri_page_ggys">保险理赔金额（元）：${zAccident.claimAmount}</li>
          <li class="ri_page_ggys">结案日期：<fmt:formatDate value="${zAccident.closeDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">备注：${zAccident.mark}</li>
          <li class="ri_page_ggys">发布时间：<fmt:formatDate value="${zAccident.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${zAccident.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="mg_bottom">
    <div class="btn_box">
      <a href="${ctx}/list-74be3b0747314c5d93d1687f39a03517.html">
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