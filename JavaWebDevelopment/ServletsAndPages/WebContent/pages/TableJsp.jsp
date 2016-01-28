<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <jsp:useBean id="myHashMap" class="java.util.LinkedHashMap" scope="request"/>
<c:set target="${myHashMap}" 
	property="Web Development Basics" 
	value="<%= new GregorianCalendar(2016, Calendar.JANUARY, 14, 18, 0, 0).getTime() %>"/> 
<c:set target="${myHashMap}" 
	property="Servlets and Pages" 
	value="<%= new GregorianCalendar(2016, Calendar.JANUARY, 21, 18, 0, 0).getTime() %>"/> 
<c:set target="${myHashMap}" 
	property="Containers, Filters and Sessions" 
	value="<%= new GregorianCalendar(2016, Calendar.JANUARY, 28, 18, 0, 0).getTime() %>"/> 
<c:set target="${myHashMap}" 
	property="Java Beans" 
	value="<%= new GregorianCalendar(2016, Calendar.FEBRUARY, 4, 18, 0, 0).getTime() %>"/> 
<c:set target="${myHashMap}" 
	property="Spring Core" 
	value="<%= new GregorianCalendar(2016, Calendar.FEBRUARY, 11, 18, 0, 0).getTime() %>"/> 
<c:set target="${myHashMap}" 
	property="Spring MVC" 
	value="<%= new GregorianCalendar(2016, Calendar.FEBRUARY, 18, 18, 0, 0).getTime() %>"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>Topic</th>
		<th>Date</th>
	</tr>
		<c:forEach items="${myHashMap}" var="lecture">
		    <tr>      
		        <td>${lecture.key}</td> 
		        <td>${lecture.value}</td> 
		    </tr>
		</c:forEach>
	</table>
</body>
</html>