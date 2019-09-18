<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>文章详情</title>

<script type="text/javascript">
//s审核文章
function check(status){
	$.post("/article/update",{id:'${map.id}',status:status},function(obj){
	  if(obj){
		  alert("操作成功");
		  
		  opener.location.reload()
		  
		  
		  window.close();
	  }	else{
		  alert("操作失败")
	  }
		
		
	})
}


</script>
</head>
<body>
<div align="center">
 当前状态:${map.status=="0"?"待审":map.status=="1"?"已审":"驳回" }
 <button type="button" class="btn btn-success" onclick="check(1)">同意</button>
 <button type="button" class="btn btn-danger" onclick="check(-1)">驳回</button>

</div>
<hr>

	<div class="container" align="center">
		<dl>
			<dt>
				<h2>${map.title }
				 
				
				</h2>
				<h5>作者:${map.nickname } 发布时间: ${map.updated }</h5>
			</dt>
			<dd >${map.content }</dd>
		</dl>
	</div>
	<jsp:include page="/WEB-INF/view/common/footer.jsp" />
</body>
</html>