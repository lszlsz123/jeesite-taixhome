<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${category.name}</title>
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
                <li class="mg">${category.name}</li>
            </ul>
        </div>
        <div class="mg_mb">
            <div class="mg_dd">
                <form id="searchForm_1" action="${ctx}/zsys/zMakeUpLoss/call" method="post" onsubmit="return submitSearchForm();">
				    <div class="zpxx_box clear">
				        <div class="vi_box">
				          <input type="hidden" id="vehicleNum" name="vehicleNum" value=""/>
				          <ul>
				            <li class="vi_li">
				              <span class="vi_cxcs">车牌号码：</span>
				              <input id="text1" class="vi_int1" type="text" placeholder="辽A" maxLength="2" value="辽A"/>
				              <input id="text2" class="vi_int2" type="text" placeholder="请输入您的车牌号码" maxLength="5"/>
				            </li>
				            <li class="vi_li">
				              <span class="vi_cxcs">车架号码：</span>
				              <input style="width:500px;" id="queryCode" class="vi_int1" type="text" name="queryCode" placeholder="请输入您的车架号后四位" maxLength="4"/>
				            </li>
				            <li class="vi_li">
				              <span class="vi_cxcs">证件类型：</span>
				              <select class="vi_int1" name="certType" style="width:500px;">
				              	<option value="1" selected="selected">身份证</option>
				              	<option value="2">驾驶证</option>
				              	<option value="3">营运证</option>
				              	<option value="4">准驾证</option>
				              </select>
				            </li>
				            <li class="vi_li" id="lossTimeDiv">
				              <span class="vi_cxcs">丢失时间：</span>
				              <input style="width:500px;" id="lossTime" class="vi_int1" type="date" name="lossTime"/>
				            </li>
				            <li class="vi_li">
				              <span class="vi_cxcs">办理事件：</span>
				              <select class="vi_int1" name="type" style="width:500px;" onchange="hideElement(this.value)">
				              	<option value="1" selected="selected">挂失</option>
				              	<option value="2">补办</option>
				              </select>
				            </li>
				          </ul>
				          <div class="vi_btnbox ov">
			 				<button class="vi_btn1 lf" type="submit">人工服务</button>
				          </div>
				        </div>
				      </div>
			    </form>
            </div>
        </div>
    </div>
    <div class="mg_bottom">
        <div class="btn_box">
	      <a href="${ctx}/list-46b03fcc85ed45f1aa91f9171424729c.html">
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
<script src="${ctxStatic}/taixhome/js/jquery-2.1.4.min.js"></script> <!--  出于效率考虑 js放在body结束标签之前 -->
<script src="${ctxStatic}/taixhome/js/index.js"></script>
<script type="text/javascript">
function submitSearchForm(){
	debugger;
	$("#vehicleNum").val($("#text1").val()+$("#text2").val());
	var vehicleNum = $("#vehicleNum").val();
	var queryCode = $("#queryCode").val();
	if(vehicleNum.length<7){
		alert("车牌号必须符合规格");
		return false;
	}
	if(queryCode.length<4){
		alert("查询码必须为4位");
		return false;
	}
	return true;
	
}

function hideElement(value){
	if(value=='2'||value == 2){
		$("#lossTimeDiv").hide();
	}else{
		$("#lossTimeDiv").show();
	}
}
</script>
</body>
</html>