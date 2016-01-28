<%@ attribute name="title" %>
<%@ attribute name="version" %>
<%@ attribute name="showDate" %>
<%@ taglib prefix="ct" uri="http://jwd.bg/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">     
<title>${title}</title>        	
</head>
<body>
	<ct:header title="${title}" />
	<jsp:doBody/>
	<ct:footer version="${version}" showDate="${showDate}" />
</body>
</html>