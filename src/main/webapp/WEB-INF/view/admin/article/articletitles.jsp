<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>文章标题</title>
<script type="text/javascript">
	function mopen(id) {
		window.open("/article/getByAdmin?id=" + id, "_blank")
	}
	function query() {
		var url = "/article/getTitlesByAdmin?" + $("#form1").serialize();
		$("#content-wrapper").load(url)

	}
</script>
</head>
<body>


	<div id="content-wrapper" style="padding: 20px">
		<div>
			<form id="form1">
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
					<div class="form-group">
						<!-- 文章所分类 -->
						<label for="status">审核状态</label> <select
							class="form-control form-control" id="status" name="status">
							<option value="">全部</option>
							<option value="0">待审</option>
							<option value="1">已审</option>
							<option value="-1">驳回</option>

						</select>

						<button type="button" class="btn btn-danger" onclick="query()">查询</button>
					</div>

				</div>
			</form>
		</div>

		<div>

			<hr
				style="height: 1px; border: none; border-top: 1px dashed #0066CC;" />

		</div>
		<div>

			<ul class="list-unstyled">
				<c:forEach items="${titles }" var="t">

					<li class="media"><a href="javascript:mopen(${t.id })"><img
							class="mr-3" src="/pic/${t.picture}" alt="no pic" width="80px" height="80px"></a>
						<div class="media-body">
							<dl>
								<dt style="font-size: 18px">
									<a href="javascript:mopen(${t.id })">${t.title }</a> <small><span
										style="float: right">
											文章状态:${t.status=="0"?"待审":t.status=="1"?"已审":"驳回" } </span></small>
								</dt>
								<dd style="padding-top: 50px">作者:${t.username}
									发布时间:${t.updated}</dd>
							</dl>
						</div></li>
					<hr
						style="height: 1px; border: none; border-top: 1px dashed #0066CC;" />
				</c:forEach>
				${pages }
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		//获取分页连接的URL .并进行加载
		$(function() {
			$('.page-link').click(function(e) {
				//获取点击的的url
				var url = $(this).attr('data');

				//在中间区域显示地址的内容
				$('#content-wrapper').load(url);
			});

		})

		$(function() {
			//为下拉框初始化栏目
			$.get("/selectChannels", function(list) {

				for ( var i in list) {
					$("#channel").append(
							"<option value='"+list[i].id+"'>" + list[i].name
									+ "</option>")
				}

				//下拉框选中
				$("#channel").val('${article.channelId}')

				//为栏目下拉框添加绑定事件
				$("#channel").change(
						function() {
							//先清空分类下的内容
							$("#cat").empty();

							//去查询当前栏目下的所有分类.并为分类下拉框赋值
							$.get("/selectCategorys", {
								channelId : $(this).val()
							}, function(list) {
								for ( var i in list) {
									$("#cat").append(
											"<option value='"+list[i].id+"'>"
													+ list[i].name
													+ "</option>")
								}
							})

						})

			})

			//去查询当前栏目下的所有分类.并为分类下拉框赋值
			$.get("/selectCategorys", {
				channelId : '${article.channelId}'
			}, function(list) {
				for ( var i in list) {
					$("#cat").append(
							"<option value='"+list[i].id+"'>" + list[i].name
									+ "</option>")
				}

				//下拉框选中
				$("#cat").val('${article.categoryId}')
			})

		})
	</script>
</body>
</html>