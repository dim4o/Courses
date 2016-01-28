<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form class="col-md-6">
		<fieldset class="form-group">
			<label for="idInput">ID</label>
			<input type="text" class="form-control" id="idInput" placeholder="ID">
		</fieldset>
		<fieldset class="form-group">
			<label for="topicInput">Topic</label>
			<input type="text" class="form-control" id="topicInput" placeholder="Topic">
		 </fieldset>
		 <fieldset class="form-group">
			<label for="dateInput">Date</label>
			<input type="date" class="form-control" id="dateInput">
		 </fieldset>
		 <button type="submit" class="btn btn-primary">Submit</button>
		 <button type="button" class="btn">Cancel</button>
	</form>
</body>
</html>