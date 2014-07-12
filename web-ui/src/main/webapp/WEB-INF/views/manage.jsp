<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Runningman Web UI</title>
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<form:form method="post" role="form" modelAttribute="monitorData">
			<div class="form-group">
				<form:label path="Id">Monitor ID</form:label>
				<form:input path="Id" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="Target">Target</form:label>
				<form:input path="Target" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="StartTime">Start Time</form:label>
				<form:input path="StartTime" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="EndTime">End Time</form:label>
				<form:input path="EndTime" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="Frequency">Frequency</form:label>
				<form:input path="Frequency" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="Note">Note</form:label>
				<form:input path="Note" class="form-control" />
			</div>
			<button type="submit" class="btn btn-default">Add</button>
		</form:form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>