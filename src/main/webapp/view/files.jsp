<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Dosyalar</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
	</head>
	<body>
		<button id="upload" class="btn btn-success">Yükle</button>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Ad</th>
				</tr>
			</thead>
			<tbody id="files">
				<c:forEach var="file" items="${files}">
					<tr onclick="onFileSelected(${file.id})">
						<td>${file.file}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script src="/js/files.js"></script>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</body>
</html>