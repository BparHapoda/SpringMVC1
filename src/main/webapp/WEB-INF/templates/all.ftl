<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>All users</title>
</head>
<style>
    body{display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;}
</style>
<body>
<table border="1">
  <tr>
    <th>id</th>
    <th>name</th>
    <th>surname</th>
  </tr>
   <#list users as user >
    <tr>
<td>${user.id}</td>
    <td>${user.name}"</td>
    <td>${user.surname}"</td>

  </tr>
</#list>
</table>
</body>
</html>