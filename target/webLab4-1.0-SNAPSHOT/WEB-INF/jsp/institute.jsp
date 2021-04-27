<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${institute.name}</title>
</head>
<body>
<a href="InstituteListController">Home</a>
<br>
<form method="post" action="InstituteController">
    <input type="text" name="faculty_name" value="">
    <input type="hidden" name="institute" value="<c:out value="${institute.name}"></c:out>">
    <input type="submit" value="add faculty">
</form>

<form method="post" action="TestFillController">
    <input type="hidden" name="institute" value="<c:out value="${institute.name}"></c:out>">
    <input type="submit" value="test fill">
</form>
<form method="post" action="ResultsController">
    <input type="hidden" name="institute" value="<c:out value="${institute.name}"></c:out>">
    <input type="submit" value="Do task">
</form>
<h1>Faculty list</h1>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Number of students</td>
    </tr>
    <c:forEach var="i" items="${institute.faculties}">
        <tr>
            <td>
                <c:url var="facultyLink" value="/FacultyController">
                    <c:param name="institute" value="${institute.name}"></c:param>
                    <c:param name="faculty" value="${i.name}"></c:param>
                </c:url>
                <a href="${facultyLink}"><c:out value="${i.name}"></c:out></a>
            </td>
            <td><c:out  value="${i.size}"></c:out> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
