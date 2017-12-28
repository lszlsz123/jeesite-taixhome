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
      <a href="ic.html">
        <img src="${ctxStatic}/taixhome/image/hp_ic.png" alt="这是车辆保险计算器按钮"/>
      </a>
    </div>
  </div>
  <div id="nav">
    <div class="name">
      <img src="${ctxStatic}/taixhome/image/name.png" alt="这是出租之家图片"/>
    </div>
    <div class="nav_box">
      <ul>
        <li class="hp_vi li_wh" >
          <a href="javascript:void(0);" onclick="submitForm();" target="_self">
          	人工服务
          </a>
        </li>
      </ul>
    </div>
    <form id="searchForm" action="${ctx}/zsys/zManualService/save" method="post">
    </form>
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
        <span class="uct">二手车买卖</span>
        <a href="uci.html">更多>></a>
        <span class="udl"></span>
        <div class="ifm">
          <ul>
            <li>
              <a href="uci.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="uci.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="uci.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="uci.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="uci.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="uci.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
          </ul>
        </div>
      </div>
      <div class="ri_box">
        <div class="hp_th rt"></div>
        <span class="ri">招聘信息</span>
        <a href="ri.html">更多>></a>
        <span class="udl"></span>
        <div class="ifm">
          <ul>
            <li>
              <a href="ri.html">
              <span class="lf">
                · 包吃+包住+户外喷绘写真工人...        (沈阳万赢广告有限公司)...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="ri.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="ri.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="ri.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="ri.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
            <li>
              <a href="ri.html">
              <span class="lf">
                · 二手车 英菲尼迪 FX 2011款 FX35 3.5 手自一体 金尚超越版-车况精品精...
              </span>
              <span class="rt">
                2017-05-06
              </span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="clear"></div>
</div>
<script src="${ctxStatic}/taixhome/js/jquery-1.11.3.js"></script>
<script type="text/javascript">
function submitForm(){
	$("#searchForm").submit();
}
</script>
</body>
</html>