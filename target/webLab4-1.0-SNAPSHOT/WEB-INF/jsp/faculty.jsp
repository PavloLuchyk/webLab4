<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title><c:out value="${faculty.name}"></c:out></title>
</head>
<body>
<a href="InstituteListController">Home</a>
<c:url var="instituteLink" value="/InstituteController">
    <c:param name="institute" value="${institute.name}"></c:param>
</c:url>
<a href="${instituteLink}">Back</a>
<form action="${pageContext.request.getContextPath()}/FacultyController" method="post">
    <input type="text" name="first_name" value="">
    <input type="text" name="last_name" value="">
    <input type="text" name="gradebook_id" value="">
    <input type="text" name="average_mark" value="">
    <input type="hidden" name="institute" value="<c:out value="${institute.name}"></c:out>">
    <input type="hidden" name="faculty" value="<c:out value="${faculty.name}"></c:out>">
    <input type="submit" name="" value="add student to the list">
</form>

<table border="1">
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Gradebook ID</td>
        <td>Average mark</td>
    </tr>
<c:forEach var="item" items="${faculty.students}">
    <tr>
        <td><c:out value="${item.firstName}"></c:out></td>
        <td><c:out value="${item.lastName}"></c:out></td>
        <td><c:out value="${item.gradebookId}"></c:out></td>
        <td><c:out value="${item.averageMark}"></c:out></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
