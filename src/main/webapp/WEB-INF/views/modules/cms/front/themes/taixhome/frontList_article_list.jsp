<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>${category.name}</title>
  <link rel="stylesheet" type="text/css" href="${ctxStatic}/taixhome/css/portal.css"/>
  <link href="${ctxStatic}/modules/cms/front/themes/basic/style.css" type="text/css" rel="stylesheet" />

</head>
<body>
<div id="hp_bg">
  <div id="header">
    <div class="logo">
      <a href="${ctx }">
        <img src="${ctxStatic}/taixhome/image/logo.png"/>
      </a>
    </div>
  </div>
  <div id="nav">
    <div class="name">
      <img src="${ctxStatic}/taixhome/image/name.png"/>
    </div>
  </div>
  <div class="mg_content">
    <div class="mg_title">
      <ul class="yl_chose">
        <li class="mg">${category.name}</li>
      </ul>
    </div>
    <div class="mg_mb">
      <div class="zpxx_box clear">
        <ul>
        <c:if test="${category.module eq 'article'}">
        	<c:forEach items="${page.list}" var="article">
	        	<a href="${article.url}">
		            <li class="bbm">
		              <span class="zpxx_gyys xq">${fns:abbr(article.title,30)}</span>
		              <span class="zpxx_gyys gsmc">${fns:abbr(article.description,40)}</span>
		              <span class="zpxx_gyys dz"><fmt:formatDate value="${article.updateDate}" pattern="yyyy.MM.dd"/></span>
		            </li>
	          	</a>
          	</c:forEach>
        </c:if>
        <div class="fy_box">
          <ul>
            ${page.taixHomePage}
            <script type="text/javascript">
				function page(n,s){
					location="${ctx}/list-${category.id}${urlSuffix}?pageNo="+n+"&pageSize="+s;
				}
			</script>
          </ul>
        </div>
        
      </div>
    </div>
  </div>
	<div class="mg_bottom">
		<a href="${ctx}/list-${category.parent.id}${urlSuffix}">
			<span class="rt_upl lf">返回上一级</span>
		</a>
		<a href="${ctx}">
			<span class="rt_ind lf">返回首页</span>
		</a>
		<div class="mg_taxi_bg rt">
			<img src="${ctxStatic}/taixhome/image/hp_th.png"/>
		</div>
	</div>
    
  </div>
</div>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/index.js"></script>
</body>
</html>