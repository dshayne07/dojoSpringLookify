<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>New Song</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<div id="header">
			<a href="/dashboard">Dashboard</a>
		</div>
		<h1>Add New Song</h1>
		<form:form action="/songs/new" method="POST" modelAttribute="newSong">
			<p><form:label path="title">
				Title: 
				<form:errors path="title"></form:errors>
				<form:input type="text" path="title"></form:input>
			</form:label></p>
			<p><form:label path="artist">
				Artist: 
				<form:errors path="artist"></form:errors>
				<form:input type="text" path="artist"></form:input>
			</form:label></p>
			<p><form:label path="rating">
				Rating: 
				<form:errors path="rating"></form:errors>
				<form:input type="number" path="rating"></form:input>
			</form:label></p>
			<input type="submit" value="Add Song" />
		</form:form>
	</body>
</html>