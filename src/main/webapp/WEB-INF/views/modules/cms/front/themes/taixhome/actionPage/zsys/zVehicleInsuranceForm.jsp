<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>车辆投保情况查询</title>
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
        <li class="mg">车辆投保情况查询</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
          <li class="ri_page_ggys">

				车牌号：${zVehicleInsurance.vehicleNum}

          </li>
          <li class="ri_page_ggys">

				车型：${zVehicleInsurance.vehicleType}

          </li>
          <li class="ri_page_ggys">

				车架号：${zVehicleInsurance.frameNum}

          </li>
          <li class="ri_page_ggys">

				登记日期：<fmt:formatDate value="${zVehicleInsurance.regDate}" pattern="yyyy-MM-dd HH:mm:ss"/>

          </li>
          <li class="ri_page_ggys">

				保险公司：${zVehicleInsurance.insuranceCompany}

          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				交强险
            </span>
            <span class="ri_page_gsjj1 rt">
				保费：${zVehicleInsurance.premium}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				交强险
            </span>
            <span class="ri_page_gsjj1 rt">
				截止日期：<fmt:formatDate value="${zVehicleInsurance.closingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</span>
          </li>

          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				三者/保费：${zVehicleInsurance.thirdPartyPremium}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				三者/保额：${zVehicleInsurance.thirdPartyInsuredAmount}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				车损险：${zVehicleInsurance.carDamageInsurance }
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				自燃险：${zVehicleInsurance.riskSpontaneousCombustion }
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				不计免赔：${zVehicleInsurance.nonDeductible}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				其他险种：${zVehicleInsurance.otherInsurance}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				商业险
            </span>
            <span class="ri_page_gsjj1 rt">
				截止日期：<fmt:formatDate value="${zVehicleInsurance.closingDate1}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				道路客运承运人责任险
            </span>
            <span class="ri_page_gsjj1 rt">
				保费：${zVehicleInsurance.premium1}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				道路客运承运人责任险
            </span>
            <span class="ri_page_gsjj1 rt">
				保额：${zVehicleInsurance.insuredAmount1}
			</span>
          </li>
          <li class="ri_page_ggys">
          	<span class="ri_page_gsjj lf">
				道路客运承运人责任险
            </span>
            <span class="ri_page_gsjj1 rt">
				截止日期：${zVehicleInsurance.closingDate2}
			</span>
          </li>
          <li class="ri_page_ggys">
				车船税：${zVehicleInsurance.vehicleVesselTax }
          </li>
          <li class="ri_page_ggys">
				保费总合计：${zVehicleInsurance.totalPremium }
          </li>
          <li class="ri_page_ggys">
				交强险保单号：${zVehicleInsurance.compulsoryInsuranceNum }
          </li>
          <li class="ri_page_ggys">
				商业险保单号：${zVehicleInsurance.commercialInsuranceOrderNum }
          </li>
          <li class="ri_page_ggys">
				承运人保单号：${zVehicleInsurance.carrierWarrantyNum }
          </li>
          <li class="ri_page_ggys">发布时间：<fmt:formatDate value="${zVehicleInsurance.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> &nbsp; 更新时间：<fmt:formatDate value="${zVehicleInsurance.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
		  <li class="ri_page_ggys">
				<img src="../../../../${zVehicleInsurance.pic }">
          </li>
        </ul>
      </div>
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
</body>
</html>