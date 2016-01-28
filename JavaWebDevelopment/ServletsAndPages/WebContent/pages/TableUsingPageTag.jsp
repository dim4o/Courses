<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ page import="java.util.*" %>

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
		
<ct:pageTag title="My title" version="0.0.1" showDate="true">
	<jsp:body>
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
	</jsp:body>
</ct:pageTag>
