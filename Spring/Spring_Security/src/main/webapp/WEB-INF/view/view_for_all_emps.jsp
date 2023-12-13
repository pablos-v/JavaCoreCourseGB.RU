<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>all-employees</title>
</head>
<body>
    <h2>Info for all Employees: ....</h2>
<br><br>
 <%-- так закрываем кнопки от неавториз юзеров --%>
    <sec:authorize access="hasRole('HR')">
    <input type="button" value="Salary" onclick="window.location.href = 'hr_info'">
    </sec:authorize>
<br><br>
    <sec:authorize access="hasRole('MANAGER')">
    <input type="button" value="Performance" onclick="window.location.href = 'manager_info'">
    </sec:authorize>
</body>
</html>