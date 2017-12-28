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
  </div>
  <div id="nav">
    <div class="name">
      <img src="${ctxStatic}/taixhome/image/name.png" alt="这是出租之家图片"/>
    </div>
  </div>
  <div class="mg_content">
    <div class="mg_title">
      <ul class="yl_chose">
        <li class="mg">诉讼案件查询</li>
      </ul>
    </div>
    <div class="mg_mb">
    <form id="searchForm" action="${ctx}/zsys/zLitigation/list" method="post" onsubmit="return submitForm();">
	    <div class="zpxx_box clear">
	        <div class="vi_box">
	              <input type="hidden" id=queryCode name="queryCode" value=""/>
	              <input type="hidden" id="vehicleNum" name="vehicleNum" value=""/>
	          <ul>
	            <li class="vi_li">
	              <span class="vi_cxcs">车牌号码：</span>
	              <input id="text1" class="vi_int1" type="text" placeholder="辽A" value="辽A" maxLength="2"/>
	              <input id="text2" class="vi_int2" type="text" placeholder="请输入您的车牌号码" maxLength="5"/>
	            </li>
	            <li class="vi_li">
	              <span class="vi_cxcs">车架号码：</span>
	              <input style="width:500px;" id="text3" class="vi_int1" type="text" placeholder="请输入您的车架号后四位" maxLength="4"/>
	            </li>
	          </ul>
	          <div class="vi_btnbox ov">
	            <button class="vi_btn1 lf" type="submit">结果查询</button>
	            <button class="vi_btn lf" onclick="cleanSearchForm()" type="button">取消填写</button>
	          </div>
	        </div>
	      </div>
    </form>
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
<script type="text/javascript">
function cleanSearchForm(){
	debugger;
	$("#searchForm").find("input").val("");
}
function submitForm(){
	debugger;
	$("#queryCode").val($("#text3").val());
	$("#vehicleNum").val($("#text1").val()+$("#text2").val());
	if($("#queryCode").val().length<4){
		alert("请输入您的车架号后四位");
		return false;
	}
	if($("#vehicleNum").val().length<7){
		alert("请输入您的车牌号码");
		return false;
	}
	return true;
}
</script>
</body>
</html>