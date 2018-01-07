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
                <li class="mg">办理指南</li>
                <li class="pp">办理进度</li>
            </ul>
        </div>
        <div class="mg_mb">
            <div class="mg_dd">
                <ul>
                    <li>
                    	1.三年无事故证明
                    </li>
                    <li>
						2.无犯罪证明
                    </li>
                    <li>
						3.体检证明
                    </li>
                    <li>
						4.身份证复印件2份
                    </li>
                    <li>
						5.户口本复印件2份
                    </li>
                    <li>
						6.驾驶证复印件2份
                    </li>
                    <li>
						7.从业资格证复印件2份
                    </li>
                    <li>
						8.一寸蓝底条码照3张
                    </li>
                    <li>
						备班：服务质量保证金3000元
                    </li>
                </ul>
            </div>
            <div class="mg_pp no-see">
            	<form method="post" action="${ctx}/zsys/zDriverBusiness/list" onsubmit="return submitSearchForm1();">
	                <div class="mg_search ov">
	                    	<input type="text" class="mg_search_1 lf" id="vehicleNum" name="vehicleNum" placeholder="请输入您的车牌号进行查询" maxlength="7"/>
	                    	<input type="text" class="mg_search_1 rt" id="queryCode" name="queryCode" placeholder="请输入您的车架号码后四位" maxlength="7"/>
	                    	<button class="mg_search_btn1" type="submit">查询</button>
	                </div>
            	</form>
                <div class="mg_step">
                    <ul class="mg_first">
                        <li class="mg_ul_1">
                            <span class="mg_step_bg1 mg_step_1 lf">
                                <p class="mg_step_text">运营审批</p>
                                <p class="mg_step_number1">1</p>
                            </span>
                            <b class="next1 lf">
                                <img src="${ctxStatic}/taixhome/image/mg_next.png"/>
                            </b>
                            <span class="mg_step_bg1 mg_step_2 lf">
                                <p class="mg_step_text">安全技术审批</p>
                                <p class="mg_step_number1">2</p>
                            </span>
                            <b class="next2 lf">
                                <img class="xz" src="${ctxStatic}/taixhome/image/mg_next.png"/>
                            </b>
                            <span class="mg_step_bg1 mg_step_3 lf">
                                <p class="mg_step_text">部门经理审批</p>
                                <p class="mg_step_number1">3</p>
                            </span>
                            <b class="next3 lf">
                                <img class="xz1" src="${ctxStatic}/taixhome/image/mg_next1.png"/>
                            </b>
                        </li>
                    </ul>
                    <ul class="mg_ul_2">
                        <li class="mg_first_li_2">
                            <span class="mg_step_bg1 mg_step_4 rt">
                                <p class="mg_step_text">公司经理审批</p>
                                <p class="mg_step_number1">4</p>
                            </span>
                            <b class="next4 rt">
                                <img class="xz2" src="${ctxStatic}/taixhome/image/mg_next.png"/>
                            </b>
                            <span class="mg_step_bg1 mg_step_5 rt">
                                <p class="mg_step_text">从业司机办理</p>
                                <p class="mg_step_number1">5</p>
                            </span>
                            <b class="next5 rt">
                                <img class="xz3" src="${ctxStatic}/taixhome/image/mg_next2.png"/>
                            </b>
                            <span class="mg_step_bg1 mg_step_6 rt">
                                <p class="mg_step_text">完成</p>
                                <p class="mg_step_number1">6</p>
                            </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="mg_bottom">
        <div class="btn_box">
	      <a href="${ctx}/list-a1976cc4e876445196f20d5fd2a8ed2d.html">
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
function submitSearchForm1(){
	debugger;
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
</script>
</body>
</html>