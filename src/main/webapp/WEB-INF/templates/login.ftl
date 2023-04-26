<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style>
    body{display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;}

    td{border: 1px solid red;
    width: 100px;
    height: 20px;}
</style>
<body>
<h4>User ${loginUser.login} entered to application</h4>
<table>
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    <tr>
        <td>${loginUser.login}</td>
        <td>${loginUser.password}</td>
        <td>${loginUser.name}</td>
        <td>${loginUser.surname}</td>
        <td>${loginUser.email}</td>
    </tr>
</table>

</body>
</html>