<%@ attribute name="version" %>
<%@ attribute name="showDate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer>
	<i>version ${version}</i>
	<p>
		<c:if test = '${showDate == "true"}'>
			<%= new java.util.Date() %>
		</c:if>
	</p>
</footer>