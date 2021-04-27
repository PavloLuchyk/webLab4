<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Institute list</title>
</head>
<body>
    <form method="post" action="${pageContext.request.getContextPath()}/InstituteListController">
        <input list="institutes" type="text" name="institute_name" value="">
        <datalist id="institutes">
            <option>KPI</option>
        </datalist>
        <input type="submit" value="Add institute">
    </form>

<h1>Institute list</h1>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Number of faculties</td>
    </tr>
    <c:forEach var="i" items="${pageContext.session.getAttributeNames()}">
        <tr>
            <td><c:url var="instituteLink" value="/InstituteController">
                <c:param name="institute" value="${i}"></c:param>
                </c:url>
                <a href="${instituteLink}"><c:out value="${i}"></c:out></a>
            </td>
            <td><c:out  value="${pageContext.session.getAttribute(i).size}"></c:out> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
