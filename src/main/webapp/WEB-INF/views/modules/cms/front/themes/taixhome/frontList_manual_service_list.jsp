<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>${category.name}</title>
  <link href="${ctxStatic}/taixhome/css/portal.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div id="hp_bg">
  <div id="header">
    <div class="logo">
      <a href="${ctx}">
        <img src="${ctxStatic}/taixhome/image/logo.png" alt="这是logo"/>
      </a>
    </div>
    <div class="hp_btn">
    </div>
  </div>
  <div id="nav">
    <div class="name">
      <img src="${ctxStatic}/taixhome/image/name.png" alt="这是出租之家图片"/>
    </div>
    <div class="nav_box">
      <ul>
        <li class="hp_vi li_wh" >
          <a href="${ctx}/list-3b27eb7a9b234088b2832e9595065286.html" target="_self">
          	运营违规记录
          </a>
        </li>
        <li class="hp_vi li_wh" >
          <a href="${ctx}/list-4556aa5aeed6471b969a8619c6bdf062.html" target="_self">
          	证件遗失补办业务
          </a>
        </li>
        <li class="hp_vi li_wh" >
          <a href="${ctx}/list-f346aebd3ead4a42ac045d416fe718d5.html" target="_self">
          	拾到物品登记
          </a>
        </li>
        
      </ul>
    </div>
  <div class="mg_bottom">
    <div class="btn_box">
      <a href="${ctx}">
        <span class="rt_ind lf">返回首页</span>
      </a>
    </div>
  </div>
  </div>
  <div id="column">
    <div class="column_box">
      <div class="horn">
        <img src="${ctxStatic}/taixhome/image/hp_horn.png"/>
      </div>
      <div class="uct_box">
        <span class="uct"></span>
        <span class="udl"></span>
        <div class="ifm">
          <ul>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
          </ul>
        </div>
      </div>
      <div class="ri_box">
        <div class="hp_th rt"></div>
        <span class="ri"></span>
        <span class="udl"></span>
        <div class="ifm">
          <ul>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
            <li>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
</body>
</html>