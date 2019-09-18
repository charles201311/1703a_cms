<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>发布文章</title>
<link rel="stylesheet"
	href="/resource/kindeditor/themes/default/default.css" />
<link rel="stylesheet"
	href="/resource/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8"
	src="/resource/kindeditor/plugins/code/prettify.js"></script>
<script charset="utf-8" src="/resource/kindeditor/kindeditor-all.js"></script>
    
<script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
<script
	src="${pageContext.request.contextPath}/resource/js/jquery-3.2.1.js"></script>

<script>
	KindEditor.ready(function(K) {
		window.editor1 = K.create('textarea[name="content"]', {
			cssPath : '/resource/kindeditor/plugins/code/prettify.css',
			uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
	function query() {
		alert(editor1.html())
		//alert( $("[name='content1']").attr("src"))
	}
</script>
</head>
<body>


	<%=htmlData%>
	<form id="form">
		<div class="form-group">
			<label for="title">文章标题</label> <input type="text" name="title"
				class="form-control" id="title" placeholder="请输入标题">
		</div>

		<div class="form-group">
			<textarea name="content"
				style="width: 825px; height: 250px; visibility: hidden;"><%=htmlspecialchars(htmlData)%></textarea>

		</div>
		<div class="form-group">
			<label for="pic">标题图片</label> <input type="file" name="file"
				class="form-control" id="pic">
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

		<div>
			<input type="button" name="button" class="btn btn-info" value="发布文章"
				onclick="publish()" />
		</div>

	</form>
	<script type="text/javascript">
	//发布文章
	function publish(){
		//序列化表单数据带文件
		 var formData = new FormData($( "#form" )[0]);
		
	
		//editor1.html() 获取输入 content1的内容
		 formData.set("content",editor1.html());
	
		 
	  $.ajax({
		  type:"post",
		  data:formData,
		// 告诉jQuery不要去处理发送的数据
		  processData : false,
		  // 告诉jQuery不要去设置Content-Type请求头
		  contentType : false,
		  url:"/article/publish",
		  success:function(obj){
			  if(obj){
				  alert("发布成功");
				//跳转到我的文章
				$("#center").load("/article/getTitles")
	        $('.list-group-item:first').click();
				  
			  }else{
				  alert("发布失败");  
			  }
		  }
		  
		  
		  
		  
		  
	  })	
		
		
		
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




</body>
</html>
<%!private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}%>