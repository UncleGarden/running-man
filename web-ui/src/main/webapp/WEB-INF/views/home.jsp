<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="refresh" content="60">
	<title>Runningman Web UI</title>
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<table class="table table-hover">
			<tr>
				<th>Monitor ID</th>
				<th>URL</th>
				<th>Status</th>
			</tr>
			<c:if test="${not empty monitors}">
				<c:forEach var="monitor" items="${monitors}">
					<tr>
						<td><a href="monitor/${monitor.id}">${monitor.id}</a></td>
						<td>${monitor.target}</td>
						<td>${monitor.status}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<a href="manage/add">Add Monitor</a>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>
