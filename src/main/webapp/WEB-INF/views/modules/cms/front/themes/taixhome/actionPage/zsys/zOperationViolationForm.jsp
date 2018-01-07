<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>运营违规记录查询及处理</title>
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
        <li class="mg">运营违规记录查询及处理</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
          <li class="ri_page_ggys">时间：<fmt:formatDate value="${zOperationViolation.complaintTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
          <li class="ri_page_ggys">投诉类型：${fns:getDictLabel(zOperationViolation.complaintType, 'complainType', '')}</li>
          <li class="ri_page_ggys">投诉人：${zOperationViolation.complaintPerson}</li>
          <li class="ri_page_ggys">投诉人电话：${zOperationViolation.complaintPhoneNum}</li>
          <li class="ri_page_ggys">经营者：${zOperationViolation.operator}</li>
          <li class="ri_page_ggys">经营者电话：${zOperationViolation.operatorPhoneNum}</li>
          <li class="ri_page_ggys">驾驶员：${zOperationViolation.driver}</li>
          <li class="ri_page_ggys">驾驶员电话：${zOperationViolation.driverPhoneNum}</li>
          <li class="ri_page_ggys">车牌号：${zOperationViolation.vehicleNum}</li>
          <li class="ri_page_ggys">事情经过：${zOperationViolation.procedureContent}</li>
          <li class="ri_page_ggys">处理结果：${zOperationViolation.result}</li>
          <li class="ri_page_ggys">处理人：${zOperationViolation.processingPerson}</li>
          
          <li class="ri_page_ggys">发布时间：<fmt:formatDate value="${zOperationViolation.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${zOperationViolation.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="mg_bottom">
    <div class="btn_box">
      <a href="${ctx}/list-3b27eb7a9b234088b2832e9595065286.html">
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