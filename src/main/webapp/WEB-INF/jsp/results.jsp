<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Results</title>
</head>
<body>
<a href="InstituteListController">Home</a>
<c:url var="instituteLink" value="/InstituteController">
    <c:param name="institute" value="${institute.name}"></c:param>
</c:url>
<a href="${instituteLink}">Back</a>
<h2>Total number of students:
    <c:out value="${numberOfStudents}"></c:out>
</h2>
<hr>
<h3>Biggest faculty: <c:out value="${biggestFaculty.name}"></c:out></h3>
<c:if test="${biggestFaculty.name=='FICT'}">
    <c:out value="Test fill?" ></c:out>
</c:if>
<hr>
<h1>Students with higgest marks</h1>
<table border="1">
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Gradebook ID</td>
        <td>Average mark</td>
    </tr>
    <c:forEach var="item" items="${highestMarksStudents}">
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
