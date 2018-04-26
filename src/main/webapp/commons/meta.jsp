<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="defaultPageSize" value="15"></c:set>
<c:set var="defaultPageList" value="[15,20,30]"></c:set>

<link rel="stylesheet" href="${ctx}/plugins/layui/css/layui.css"/>

<script src="${ctx}/plugins/js/jquery/jquery-2.1.1.js"></script>
<script src="${ctx}/plugins/layui/layui.js" type="text/javascript"></script>



