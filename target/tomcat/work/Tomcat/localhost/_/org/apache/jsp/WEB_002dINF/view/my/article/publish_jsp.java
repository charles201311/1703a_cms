/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-08-22 23:48:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.my.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class publish_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("UTF-8");
	String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\" />\r\n");
      out.write("<title>发布文章</title>\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"/resource/kindeditor/themes/default/default.css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"/resource/kindeditor/plugins/code/prettify.css\" />\r\n");
      out.write("<script charset=\"utf-8\"\r\n");
      out.write("\tsrc=\"/resource/kindeditor/plugins/code/prettify.js\"></script>\r\n");
      out.write("<script charset=\"utf-8\" src=\"/resource/kindeditor/kindeditor-all.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("<script charset=\"utf-8\" src=\"/resource/kindeditor/lang/zh-CN.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resource/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tKindEditor.ready(function(K) {\r\n");
      out.write("\t\twindow.editor1 = K.create('textarea[name=\"content\"]', {\r\n");
      out.write("\t\t\tcssPath : '/resource/kindeditor/plugins/code/prettify.css',\r\n");
      out.write("\t\t\tuploadJson : '/resource/kindeditor/jsp/upload_json.jsp',\r\n");
      out.write("\t\t\tfileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',\r\n");
      out.write("\t\t\tallowFileManager : true,\r\n");
      out.write("\t\t\tafterCreate : function() {\r\n");
      out.write("\t\t\t\tvar self = this;\r\n");
      out.write("\t\t\t\tK.ctrl(document, 13, function() {\r\n");
      out.write("\t\t\t\t\tself.sync();\r\n");
      out.write("\t\t\t\t\tdocument.forms['example'].submit();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\tK.ctrl(self.edit.doc, 13, function() {\r\n");
      out.write("\t\t\t\t\tself.sync();\r\n");
      out.write("\t\t\t\t\tdocument.forms['example'].submit();\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tprettyPrint();\r\n");
      out.write("\t});\r\n");
      out.write("\tfunction query() {\r\n");
      out.write("\t\talert(editor1.html())\r\n");
      out.write("\t\t//alert( $(\"[name='content1']\").attr(\"src\"))\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      out.print(htmlData);
      out.write("\r\n");
      out.write("\t<form id=\"form\">\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"title\">文章标题</label> <input type=\"text\" name=\"title\"\r\n");
      out.write("\t\t\t\tclass=\"form-control\" id=\"title\" placeholder=\"请输入标题\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<textarea name=\"content\"\r\n");
      out.write("\t\t\t\tstyle=\"width: 825px; height: 250px; visibility: hidden;\">");
      out.print(htmlspecialchars(htmlData));
      out.write("</textarea>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"pic\">标题图片</label> <input type=\"file\" name=\"file\"\r\n");
      out.write("\t\t\t\tclass=\"form-control\" id=\"pic\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-inline\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<!-- 文章所属栏目 -->\r\n");
      out.write("\t\t\t\t<label for=\"channel\">所属栏目</label> <select\r\n");
      out.write("\t\t\t\t\tclass=\"form-control form-control\" id=\"channel\" name=\"channelId\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\">请选择</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t&nbsp; &nbsp; &nbsp;\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<!-- 文章所分类 -->\r\n");
      out.write("\t\t\t\t<label for=\"cat\">所属分类</label> <select\r\n");
      out.write("\t\t\t\t\tclass=\"form-control form-control\" id=\"cat\" name=\"categoryId\">\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<input type=\"button\" name=\"button\" class=\"btn btn-info\" value=\"发布文章\"\r\n");
      out.write("\t\t\t\tonclick=\"publish()\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t//发布文章\r\n");
      out.write("\tfunction publish(){\r\n");
      out.write("\t\t//序列化表单数据带文件\r\n");
      out.write("\t\t var formData = new FormData($( \"#form\" )[0]);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t//editor1.html() 获取输入 content1的内容\r\n");
      out.write("\t\t formData.set(\"content\",editor1.html());\r\n");
      out.write("\t\r\n");
      out.write("\t\t \r\n");
      out.write("\t  $.ajax({\r\n");
      out.write("\t\t  type:\"post\",\r\n");
      out.write("\t\t  data:formData,\r\n");
      out.write("\t\t// 告诉jQuery不要去处理发送的数据\r\n");
      out.write("\t\t  processData : false,\r\n");
      out.write("\t\t  // 告诉jQuery不要去设置Content-Type请求头\r\n");
      out.write("\t\t  contentType : false,\r\n");
      out.write("\t\t  url:\"/article/publish\",\r\n");
      out.write("\t\t  success:function(obj){\r\n");
      out.write("\t\t\t  if(obj){\r\n");
      out.write("\t\t\t\t  alert(\"发布成功\");\r\n");
      out.write("\t\t\t\t//跳转到我的文章\r\n");
      out.write("\t\t\t\t$(\"#center\").load(\"/article/getTitles\")\r\n");
      out.write("\t        $('.list-group-item:first').click();\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t  }else{\r\n");
      out.write("\t\t\t\t  alert(\"发布失败\");  \r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t  })\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t//为下拉框初始化栏目\r\n");
      out.write("\t\t$.get(\"/selectChannels\",function(list){\r\n");
      out.write("\t\t  \t\r\n");
      out.write("\t\t  for(var i in list){\r\n");
      out.write("\t\t\t  $(\"#channel\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\t  }\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t //为栏目下拉框添加绑定事件\r\n");
      out.write("\t\t $(\"#channel\").change(function(){\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t //先清空分类下的内容\r\n");
      out.write("\t\t\t  $(\"#cat\").empty();\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t   //去查询当前栏目下的所有分类.并为分类下拉框赋值\r\n");
      out.write("\t\t   $.get(\"/selectCategorys\",{channelId:$(this).val()},function(list){\r\n");
      out.write("\t\t\t   for(var i in list){\r\n");
      out.write("\t\t\t\t\t  $(\"#cat\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\t\t\t  }   \r\n");
      out.write("\t\t   })\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
