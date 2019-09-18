<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>用户列表</title>
</head>
<body>

	<div class="container-fluid">
		<!-- 查询条件 -->
		<div>
			<div class="form-group form-inline">
				<label for="username">用户名</label> <input type="text"
					class="form-control" id="username" placeholder="查询条件"
					value="${map.username }"> <label for="locked">状态</label> <select
					class="form-control" id="locked">
					<option value="">全部</option>
					<option value="0">正常</option>
					<option value="1">禁用</option>
				</select>

				<button type="button" class="btn btn-success" onclick="query()">查询</button>
			</div>

		</div>

		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>用户名</th>
					<th>性别</th>
					<th>生日</th>
					<th>注册日期</th>
					<th>修改日期</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="u" varStatus="i">
					<tr>
						<td>${i.index+1 }</td>
						<td>${u.username }</td>
						<td>${u.gender==0?"男":"女" }</td>
						<td>${u.birthday }</td>
						<td>${u.create_time }</td>
						<td>${u.update_time }</td>
						<td><c:if test="${u.locked== 0 }">
								<button type="button" class="btn btn-success"
									onclick="updateLocked(${u.id},this)">正常</button>
							</c:if> <c:if test="${u.locked== 1 }">
								<button type="button" class="btn btn-warning"
									onclick="updateLocked(${u.id},this)">禁用</button>
							</c:if></td>
					</tr>
				</c:forEach>

			</tbody>


		</table>

		${pageInfo }

	</div>

</body>
<script type="text/javascript">
	
	//改变用户状态
	function updateLocked(id,obj){
		
		$.ajax({
			type:"post",
			data:{id:id,locked:$(obj).text()=="正常"?1:0},
			url:"/user/update",
			success:function(result){
				 //后台改变成功.前台按钮也改变
				if(result){
					//获取当前按钮的状态并取反
					 var text= $(obj).text()=="正常"?"禁用":"正常";
					//获取当前按钮对应的按钮状态颜色
					 var style=text=="正常"?"btn btn-success":"btn btn-warning";
					  //当前按钮的值为text
						$(obj).text(text);
						//改变按钮样式
						$(obj).attr("class",style);
				}
			}
			
			
		})
		
		
			
		}
		
		
	
	//查询
	function query(){
		
		var url="/user/selects?username="+$("#username").val()+"&locked="+$("#locked").val()
		alert(url)
				
				$("#content-wrapper").load(url);	
		
		
	}
	$(function(){
		
		//为左侧导航条绑定点击事件
		$(".page-link").click(function(){
			//获取点击行的url
			var url =$(this).attr("data");
			$("#content-wrapper").load(url);
			
		})
		
		
		//回显查询条件--让下拉框选中
		$("#locked").val('${map.locked}')
		
	})
	
	
	
	</script>

</html>