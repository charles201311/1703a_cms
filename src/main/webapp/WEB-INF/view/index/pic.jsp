<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>图片集</title>
<script type="text/javascript">
	
</script>
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
     <!--  标题 -->
     <div><h1 align="center">${title }</h1>
   
     
     </div>
        <hr/>
      <!-- 轮播显示 -->
	<div id="carousel" class="carousel slide" data-ride="carousel">
		<div id="carousel" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
			  <c:forEach items="${pics }" var="p" varStatus="i">
				<div class="carousel-item ${i.index==0?"active":"" }">
					<img class="d-block w-100" src="/pic/${p.url }" alt="First slide">
					<!-- 图片描述 -->
					<div class="carousel-caption" >
						<h3>${p.content}</h3>
					</div>
				</div>
				
				</c:forEach>

			</div>
			<a class="carousel-control-prev" href="#carousel" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carousel" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
		<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>