<html>
<head>
    <title>All Users</title>
    <br>
</head>
<body>
    <h2>All Users</h2>
    <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Lastname</th>
            <th>Age</th>
        </tr>

        <c:forEach var="user" item="${Users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.lastname}</td>
                <td>${user.age}</td>
            </tr>

        </c:forEach>


    </table>
</body>
</html>
