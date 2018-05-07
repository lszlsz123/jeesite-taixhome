<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>交通事故查询</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/taixhome/css/portal.css"/>
</head>
<body>

<div id="hp_bg">
  <div id="header">
    <div class="logo">
      <a href="${ctx }">
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
        <li class="mg">交通事故查询</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="mg_dd1">
      <form method="post" action="${ctx}/zsys/zAccident/list" onsubmit="return submitSearchForm();">
        <div class="tai_int_box ov">
          <div class="tai_int_1 lf">
            <span class="tai_int_name">车牌号：</span>
            <input class="tai_int_int1" type="text" id="vehicleNum" name="accVehcileNum" placeholder="请输入您的车牌号进行查询" maxlength="7" value="${zAccident.accVehcileNum}"/>
          </div>
<!--           <div class="tai_int_1 lf"> -->
<!--             <span class="tai_int_name">车架号：</span> -->
<%--             <input class="tai_int_int1" type="text" id="queryCode" name="queryCode" placeholder="请输入您的车架号码后四位" maxlength="4" value="${zAccident.queryCode}"/> --%>
<!--           </div> -->
          <button class="tai_button lf" type="submit">查询</button>
        </div>
      </form>
          <canvas id="canvas" style="width: 100%; height: 1300px; margin-top: 50px"></canvas>
        </div>
      </div>
    </div>
  </div>
  <div class="mg_bottom">
    <div class="btn_box">
      <a href="${ctx }/list-74be3b0747314c5d93d1687f39a03517.html">
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



<!--  出于效率考虑 js放在body结束标签之前 -->
<!-- script src="${ctxStatic}/taixhome/js/index.js"></script-->
<script type="text/javascript" src="${ctxStatic}/taixhome/js/jquery.js"></script>
<script type="text/javascript" src="${ctxStatic}/taixhome/js/jtopo-0.4.8-min.js"></script>
<script type="text/javascript" src="${ctxStatic}/taixhome/js/tu.js"></script>
<script type="text/javascript">
//将第一个节点尺寸 位置设为全局
var defWidth=160;
var defHeight=60;
var defPositionX=580;
var defPositionY=0;
var scene;

var nodeNameStr = '${nodeList}';

var nodeNameArray = nodeNameStr.split("|");

function checkNameArray(name){
	
	for(var i=0; i<nodeNameArray.length; i++){
		var nameStr = $.trim(nodeNameArray[i]);
		var nameStr1 = $.trim(name);
		if(nameStr==nameStr1){
			return true;
		}
	}
	return false;
}

$(function(){
  // 设置canvas的宽和高为自适应父元素的宽高
  var canvasWidth = $("#canvas").parent().css("width");
  var canvasHeight = $("#canvas").parent().css("height");
  $("#canvas").attr("width", canvasWidth);
  $("#canvas").attr("height", canvasHeight);

  var canvas = document.getElementById('canvas');
  var stage = new JTopo.Stage(canvas); // 创建一个舞台对象
  scene = new JTopo.Scene(stage); // 创建一个场景对象

  var node1 = null;  var node2 = null;  var node3 = null;  var node4 = null;
  var node5 = null;  var node6 = null;  var node7 = null;  var node8 = null;
  var node9 = null;  var node10 = null;  var node11 = null;  var node12 = null;
  var node13 = null;  var node14 = null;  var node15 = null;  var node16 = null;
  var node17 = null;  var node18 = null;  var node19 = null;  var node20 = null;
  var node21 = null;
  //第一个节点
  if(checkNameArray('发生交通事故')){
	  node1 = drawNode('发生交通事故',defPositionX,defPositionY,defWidth,defHeight);
  }else{
	  node1 = drawNode('发生交通事故',defPositionX,defPositionY,defWidth,defHeight);
  }
  
  if(checkNameArray('事故受理责任人')){
	  node2 = drawNode('事故受理责任人',defPositionX,defPositionY+100,defWidth,defHeight);
  }else{
	  node2 = drawMyNode('事故受理责任人',defPositionX,defPositionY+100,defWidth,defHeight);
  }
  
  if(checkNameArray('现场勘查')){
	  node3 = drawNode('现场勘查',defPositionX,defPositionY+200,defWidth,defHeight);
  }else{
	  node3 = drawMyNode('现场勘查',defPositionX,defPositionY+200,defWidth,defHeight);
  }
  
  if(checkNameArray('绘制现场图、登记事故信息')){
	  node4 = drawNode('绘制现场图、登记事故信息',defPositionX-60,defPositionY+300,defWidth+120,defHeight);
  }else{
	  node4 = drawMyNode('绘制现场图、登记事故信息',defPositionX-60,defPositionY+300,defWidth+120,defHeight);
  }
  
  if(checkNameArray('接到事故报道')){
	  node5 = drawNode('接到事故报道',defPositionX-400,defPositionY+100,defWidth,defHeight);
  }else{
	  node5 = drawMyNode('接到事故报道',defPositionX-400,defPositionY+100,defWidth,defHeight);
  }
  
  if(checkNameArray('整理事故案卷、法律诉讼准备')){
	  node6 = drawNode('整理事故案卷、法律诉讼准备',defPositionX-60,defPositionY+400,defWidth+120,defHeight);
  }else{
	  node6 = drawMyNode('整理事故案卷、法律诉讼准备',defPositionX-60,defPositionY+400,defWidth+120,defHeight);
  }
  
  if(checkNameArray('登记事故案件')){
	  node7 = drawNode('登记事故案件',defPositionX+260,defPositionY+400,defWidth,defHeight);
  }else{
	  node7 = drawMyNode('登记事故案件',defPositionX+260,defPositionY+400,defWidth,defHeight);
  }
  
  if(checkNameArray('伤残鉴定')){
	  node8 = drawNode('伤残鉴定',defPositionX-360,defPositionY+480,defWidth,defHeight);
  }else{
	  node8 = drawMyNode('伤残鉴定',defPositionX-360,defPositionY+480,defWidth,defHeight);
  }
  
  if(checkNameArray('车辆定损')){
	  node9 = drawNode('车辆定损',defPositionX-560,defPositionY+480,defWidth,defHeight);
  }else{
	  node9 = drawMyNode('车辆定损',defPositionX-560,defPositionY+480,defWidth,defHeight);
  }
  
  if(checkNameArray('事故和解')){
	  node10 = drawNode('事故和解',defPositionX,defPositionY+640,defWidth,defHeight);
  }else{
	  node10 = drawMyNode('事故和解',defPositionX,defPositionY+640,defWidth,defHeight);
  }
  
  if(checkNameArray('收集整理理赔案卷')){
	  node11 = drawNode('收集整理理赔案卷',defPositionX-12,defPositionY+740,defWidth+26,defHeight);
  }else{
	  node11 = drawMyNode('收集整理理赔案卷',defPositionX-12,defPositionY+740,defWidth+26,defHeight);
  }
  
  if(checkNameArray('肇事驾驶员培训')){
	  node12 = drawNode('肇事驾驶员培训',defPositionX+260,defPositionY+740,defWidth,defHeight);
  }else{
	  node12 = drawMyNode('肇事驾驶员培训',defPositionX+260,defPositionY+740,defWidth,defHeight);
  }
  
  if(checkNameArray('肇事车辆修理')){
	  node13 = drawNode('肇事车辆修理',defPositionX+500,defPositionY+740,defWidth,defHeight);
  }else{
	  node13 = drawMyNode('肇事车辆修理',defPositionX+500,defPositionY+740,defWidth,defHeight);
  }
  
  if(checkNameArray('法律诉讼')){
	  node14 = drawNode('法律诉讼',defPositionX+620,defPositionY+640,defWidth,defHeight);
  }else{
	  node14 = drawMyNode('法律诉讼',defPositionX+620,defPositionY+640,defWidth,defHeight);
  }
  
  if(checkNameArray('审核')){
	  node15 = drawNode('审核',defPositionX-240,defPositionY+740,defWidth,defHeight);
  }else{
	  node15 = drawMyNode('审核',defPositionX-240,defPositionY+740,defWidth,defHeight);
  }
  
  if(checkNameArray('快递送达保险公司')){
	  node16 = drawNode('快递送达保险公司',defPositionX,defPositionY+840,defWidth,defHeight);
  }else{
	  node16 = drawMyNode('快递送达保险公司',defPositionX,defPositionY+840,defWidth,defHeight);
  }
  
  if(checkNameArray('竣工检测')){
	  node17 = drawNode('竣工检测',defPositionX+500,defPositionY+840,defWidth,defHeight);
  }else{
	  node17 = drawMyNode('竣工检测',defPositionX+500,defPositionY+840,defWidth,defHeight);
  }
  
  if(checkNameArray('理赔')){
	  node19 = drawNode('理赔',defPositionX-560,defPositionY+840,defWidth,defHeight);
  }else{
	  node19 = drawMyNode('理赔',defPositionX-560,defPositionY+840,defWidth,defHeight);
  }
  
  if(checkNameArray('事故结案')){
	  node18 = drawNode('事故结案',defPositionX,defPositionY+1000,defWidth,defHeight);
  }else{
	  node18 = drawMyNode('事故结案',defPositionX,defPositionY+1000,defWidth,defHeight);
  }
  
  if(checkNameArray('存档')){
	  node20 = drawNode('存档',defPositionX+260,defPositionY+1100,defWidth,defHeight);
  }else{
	  node20 = drawMyNode('存档',defPositionX+260,defPositionY+1100,defWidth,defHeight);
  }
  
  if(checkNameArray('投入运营')){
	  node21 = drawNode('投入运营',defPositionX-240,defPositionY+1200,defWidth,defHeight);
  }else{
	  node21 = drawMyNode('投入运营',defPositionX-240,defPositionY+1200,defWidth,defHeight);
  }
  
  newLink(node1,node2);
  
  newLink(node2,node3);
  
  newLink(node3,node4);
  var arcnode1=drawArc(defPositionX+330,defPositionY+320);
  newLinkNok(node4,arcnode1);
  
  newLink(node2,node5);
  
  newLink(node4,node6);

  var arcnode2=drawArc(defPositionX-290,defPositionY+420);
  newLinkNok(node6,arcnode2);
  var arcnode3=drawArc(defPositionX-490,defPositionY+420);
  newLinkNok(arcnode2,arcnode3);
  
  newLink(arcnode1,node7);
  
  //newLink(node6,node8);
  newLink(arcnode2,node8);
  
  //newLink(node6,node9);
  newLink(arcnode3,node9);
  var arcnode5=drawArc(defPositionX-490,defPositionY+580);
  newLinkNok(node9,arcnode5);
  
  var arcnode4=drawArc(defPositionX+70,defPositionY+500);
  newLinkNok(node6,arcnode4);
  newLinkNok(node8,arcnode4);
  newLink(arcnode4,node10);
  var arcnode9=drawArc(defPositionX-170,defPositionY+660);
  newLink(arcnode9,node10);
  
  newLink(node10,node11);
  
  newLink(node7,node12);
  
  //newLink(node9,node13);
  var arcnode6=drawArc(defPositionX+570,defPositionY+580);
  newLinkNok(arcnode5,arcnode6);
  newLink(arcnode6,node13);
  var arcnode7=drawArc(defPositionX+700,defPositionY+760);
  //newLinkNok(arcnode5,arcnode6);
  newLink(arcnode7,node13);
  var arcnode8=drawArc(defPositionX+700,defPositionY+860);
  newLinkNok(arcnode7,arcnode8);
  
  newLink(node10,node14);
  
  newLink(node11,node15);
  var arcnode10=drawArc(defPositionX-170,defPositionY+860);
  newLinkNok(node15,arcnode10);
  newLinkNok(arcnode9,node15);
  
  newLink(node11,node16);
  newLink(arcnode10,node16);
  
  newLink(node13,node17);
  newLinkNok(arcnode8,node17);
  
  newLink(node16,node19);
  var arcnode11=drawArc(defPositionX-490,defPositionY+1020);
  newLinkNok(arcnode11,node19);
  
  //newFlexionalLink(node19,node18);
  newLink(arcnode11,node18);
  var arcnode12=drawArc(defPositionX+330,defPositionY+1020);
  newLinkNok(arcnode12,node18);
  
  //newnewFlexionalLink(node18,node20);
  newLink(arcnode12,node20);
  
  //newLink(node17,node21);
  var arcnode13=drawArc(defPositionX+570,defPositionY+1220);
  newLinkNok(arcnode13,node17);
  newLink(arcnode13,node21);
});
</script>

<script type="text/javascript">
function submitSearchForm(){
	var vehicleNum = $("#vehicleNum").val();
	var queryCode = $("#queryCode").val();
	if(vehicleNum.length<7){
		alert("车牌号必须符合规格");
		return false;
	}
// 	if(queryCode.length<4){
// 		alert("查询码必须为4位");
// 		return false;
// 	}
	return true;
}
</script>
</body>
</html>