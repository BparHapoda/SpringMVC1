<!DOCTYPE html>
<html lang="ru" xmlns:th="http://thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>New User</title>
</head>
<style>
    body{display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;}
</style>
<body>
<p ${user.login}"></p>
<p>registration well done</p>

</body>
</html>