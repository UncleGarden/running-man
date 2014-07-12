<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<form method="post" role="form">
			<fieldset disabled>
				<div class="form-group">
					<label for="Id">Monitor ID</label>
					<input name="Id" class="form-control" placeholder="${monitor.id}"/>
				</div>
				<div class="form-group">
					<label for="Target">Target</label>
					<input name="Target" class="form-control" placeholder="${monitor.target}"/>
				</div>
				<div class="form-group">
					<label for="StartTime">Start Time</label>
					<input name="StartTime" class="form-control" placeholder="${monitor.startTime}"/>
				</div>
				<div class="form-group">
					<label for="EndTime">End Time</label>
					<input name="EndTime" class="form-control" placeholder="${monitor.endTime}"/>
				</div>
				<div class="form-group">
					<label for="Frequency">Frequency</label>
					<input name="Frequency" class="form-control" placeholder="${monitor.frequency}"/>
				</div>
				<div class="form-group">
					<label for="Note">Note</label>
					<input name="Note" class="form-control" placeholder="${monitor.note}"/>
				</div>
				<div class="form-group">
					<label for="Status">Status</label>
					<textarea name="Status" class="form-control" rows="10" placeholder="${monitor.status}"></textarea>
				</div>
			</fieldset>
		</form>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</body>
</html>