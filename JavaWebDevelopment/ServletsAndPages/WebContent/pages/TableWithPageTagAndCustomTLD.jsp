<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>

<c:set var="date" value="<%= new java.util.Date() %>"/>
<c:set var="topic" value="1"/>

<ct:pageTag title="Java Courses" version="0.0.1">
	<jsp:body>
		<ct:verticalTable>
			<jsp:attribute name="row1-title">
				Course
			</jsp:attribute>
			<jsp:attribute name="row1-value">
				Java Basics
			</jsp:attribute>
			<jsp:attribute name="row2-title">
				Date
			</jsp:attribute>
			<jsp:attribute name="row2-value">
				${date}
			</jsp:attribute>
		
			<jsp:attribute name="row3-title">
				Course
			</jsp:attribute>
			<jsp:attribute name="row3-value">
				Web Development Basics
			</jsp:attribute>
			<jsp:attribute name="row4-title">
				Date
			</jsp:attribute>
			<jsp:attribute name="row4-value">
				${date}
			</jsp:attribute>
		
			<jsp:attribute name="row5-title">
				Course
			</jsp:attribute>
			<jsp:attribute name="row5-value">
				Java Web Development
			</jsp:attribute>
			<jsp:attribute name="row6-title">
				Date
			</jsp:attribute>
			<jsp:attribute name="row6-value">
				${date}
			</jsp:attribute>
		
		</ct:verticalTable>
	</jsp:body>
</ct:pageTag>