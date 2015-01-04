<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"><title>Search</title>
<link rel="icon" href="" type="image/x-icon"/>
<link rel="stylesheet" href="./dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="./dist/css/result.css"/>
<link rel="stylesheet" href="./dist/css/common.css"/>


</head>
<body>
    <div class="container-fluid">
    	<ul class="nav nav-pills pull-right header">
            <li><a href="./login/login-1.html" id="signin-btn">登录</a></li>            
            <li><a href="./Search.jsp">实验室</a></li>
            <li><a href="./Search.jsp">帮助</a></li>
        </ul>
    </div>
    
    <%String query_words=(String)request.getAttribute("query_words"); %>        
            <div class="search-block">
                <form class="form-inline search-form" id="mrs_qbox" name="mrs_qbox" action="Query" method="POST" novalidate="novalidate">
                    <input type="text" class="search-input" maxlength="128" id="mrs_qstring" name="query_words" value="<%=query_words%>">
                    <input type="submit" value="搜索字幕" class="btn btn-primary btn-large" id="mrs_qbutton" name="mrs_qbutton">
                </form>
        	</div>
   

    
    
    
    <div class="search-result">
    <%String query_time=(String)request.getAttribute("query_time"); %>
    <%String result_size=(String)request.getAttribute("result_size"); %>
    <p>共找到<%=result_size %>个相关字幕 (用时<%=query_time%>毫秒)</p>
   
    <c:forEach items="${sub_list}" var="str"> 
       <p><a href=Download?path=${str}><font size="4">${str}</font></a></p> 
    </c:forEach> 
    
    </div>    	
        	
    
 <div class="footer navbar-fixed-bottom">
    <ul class="pull-right">
        <li>Copyright © NJU IIP</li>
        <li>|</li>
        <li>Powered by mrpod2g</li>
        <li>|</li>
        <li><a href="#"></a></li>
        <li>|</li>
        <li><a href="#"></a></li>
    </ul>
</div>

</body>
</html>