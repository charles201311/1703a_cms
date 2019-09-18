<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布图片文章</title>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="/resource/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<!-- <h1 align="center">发布图片文字</h1> -->

		<div class="form-group">
			<button type="button" class="btn btn-warning" onclick="addDiv()">增加</button>
			<button type="button" class="btn btn-success" onclick="publish()">发布</button>
		</div>
		<form action="/article/publishpic" method="post" enctype="multipart/form-data" id="form1">
			<div class="form-group">
				<label>图片标题</label> <input type="text" name="title"
					class="form-control">
			</div>
			<div class="form-inline">
			<div class="form-group">
				<!-- 文章所属栏目 -->
				<label for="channel">所属栏目</label> <select
					class="form-control form-control" id="channel" name="channelId">
					<option value="">请选择</option>
				</select>
			</div>
			&nbsp; &nbsp; &nbsp;
			<div class="form-group">
				<!-- 文章所分类 -->
				<label for="cat">所属分类</label> <select
					class="form-control form-control" id="cat" name="categoryId">
				</select>
			</div>
		</div>

			<div id="mdiv" class="form-group">
				<div class="card" style="float: left">
					<input type="file" name="files">
					<div class="card-body">
						<textarea rows="5" cols="40" name="picContents"></textarea>
					</div>
				</div>
			</div>
		</form>

	</div>
	<script type="text/javascript">
		function addDiv() {
			//增加上传图片 div
			$("#mdiv").append("<div class='card' style='float: left'> <input type='file' name='files'> <div class='card-body'> <textarea rows='5' cols='40' name='picContents'></textarea></div></div>")

		}
		
		//发布
		function publish(){
			$("#form1").submit();
		}
		
		

		$(function(){
			//为下拉框初始化栏目
			$.get("/selectChannels",function(list){
			  	
			  for(var i in list){
				  $("#channel").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>")
			  }	
				
			 //为栏目下拉框添加绑定事件
			 $("#channel").change(function(){
				 
				 
				 //先清空分类下的内容
				  $("#cat").empty();
				 
			   //去查询当前栏目下的所有分类.并为分类下拉框赋值
			   $.get("/selectCategorys",{channelId:$(this).val()},function(list){
				   for(var i in list){
						  $("#cat").append("<option value='"+list[i].id+"'>"+list[i].name+"</option>")
					  }   
			   })
				 
				 
				 
			 })
			  
			})
			
			
			
			
			
		})
		
	</script>
	<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</body>
</html>