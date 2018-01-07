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
          <a href="${ctx}/list-4564f980014c42ca9e2b1e29202d82b5.html" target="_self">
          	交通事故报案
          </a>
        </li>
        <li class="hp_vi li_wh" >
          <a href="${ctx}/list-74be3b0747314c5d93d1687f39a03517.html" target="_self">
          	交通事故查询业务
          </a>
        </li>
        <li class="hp_vi li_wh">
          <a href="${ctx}/list-b59e8a1706d44be5b0fb2aefe4cf7e10.html" target="_self">
           	诉讼案件查询
          </a>
        </li>
        <li class="hp_vi li_wh">
          <a href="${ctx}/list-fb106649893d45be8d8a3dec7427afb7.html" target="_self">
 			车辆投保情况查询
          </a>
          <li class="hp_vi li_wh" >
          <a href="${ctx}/list-64ee7c3a83614b8c9400deb66f8d29fa.html" target="_self">
          	保险理赔业务查询
          </a>
        </li>
        <li class="hp_vi li_wh" >
          <a href="${ctx }/list-ae115716024c454f9fde05727081ed80.html" target="_self">
          	法律知识及管理制度
          </a>
        </li>
        <li class="hp_vi li_wh">
          <a href="${ctx }/list-961973c0f6e7493e8bfa09ba648b1752.html">
           	车辆维护记录查询
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