<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Gestion des articles :</h1>
	<div>
		<h2>Créer un nouvel article</h2>
		<form:form modelAttribute="modelArticle" method="post">
			<form:hidden path="id"/>
			<div>
				<label for="title">Titre :</label> 
				<form:input id="title" path="title" type="text" minlength="5"  required="true"></form:input>
			</div>
			<div>
				<label for="description">Description :</label> 
				<form:input id="description" path="description" type="textarea" minlength="10" />
			</div>
			<button>Valider</button>
		</form:form>
	</div>
</body>
</html>