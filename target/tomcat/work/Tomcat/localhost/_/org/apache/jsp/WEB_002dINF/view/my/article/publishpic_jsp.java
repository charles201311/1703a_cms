/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-08-22 23:48:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.my.article;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class publishpic_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>发布图片文章</title>\r\n");
      out.write("<!-- Bootstrap -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"/resource/css/bootstrap.min.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<!-- <h1 align=\"center\">发布图片文字</h1> -->\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-warning\" onclick=\"addDiv()\">增加</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-success\" onclick=\"publish()\">发布</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form action=\"/article/publishpic\" method=\"post\" enctype=\"multipart/form-data\" id=\"form1\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label>图片标题</label> <input type=\"text\" name=\"title\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-inline\">\r\n");
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
      out.write("\t\t\t<div id=\"mdiv\" class=\"form-group\">\r\n");
      out.write("\t\t\t\t<div class=\"card\" style=\"float: left\">\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"files\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<textarea rows=\"5\" cols=\"40\" name=\"picContents\"></textarea>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction addDiv() {\r\n");
      out.write("\t\t\t//增加上传图片 div\r\n");
      out.write("\t\t\t$(\"#mdiv\").append(\"<div class='card' style='float: left'> <input type='file' name='files'> <div class='card-body'> <textarea rows='5' cols='40' name='picContents'></textarea></div></div>\")\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//发布\r\n");
      out.write("\t\tfunction publish(){\r\n");
      out.write("\t\t\t$(\"#form1\").submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t//为下拉框初始化栏目\r\n");
      out.write("\t\t\t$.get(\"/selectChannels\",function(list){\r\n");
      out.write("\t\t\t  \t\r\n");
      out.write("\t\t\t  for(var i in list){\r\n");
      out.write("\t\t\t\t  $(\"#channel\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\t\t  }\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t //为栏目下拉框添加绑定事件\r\n");
      out.write("\t\t\t $(\"#channel\").change(function(){\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t //先清空分类下的内容\r\n");
      out.write("\t\t\t\t  $(\"#cat\").empty();\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t   //去查询当前栏目下的所有分类.并为分类下拉框赋值\r\n");
      out.write("\t\t\t   $.get(\"/selectCategorys\",{channelId:$(this).val()},function(list){\r\n");
      out.write("\t\t\t\t   for(var i in list){\r\n");
      out.write("\t\t\t\t\t\t  $(\"#cat\").append(\"<option value='\"+list[i].id+\"'>\"+list[i].name+\"</option>\")\r\n");
      out.write("\t\t\t\t\t  }   \r\n");
      out.write("\t\t\t   })\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t })\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"/resource/js/jquery-3.2.1.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
