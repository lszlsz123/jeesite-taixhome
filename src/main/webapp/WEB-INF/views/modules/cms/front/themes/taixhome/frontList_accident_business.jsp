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
          <a href="${ctx}/list-f12628b184724423ba8174816450a044.html" target="_self">
          	交通事故查询
          </a>
        </li>
        <li class="hp_vi li_wh" >
          <a href="${ctx}/list-908a051cad9d48989ddbbd0624137cac.html" target="_self">
          	交通事故业务办理
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