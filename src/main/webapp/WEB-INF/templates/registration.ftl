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
</style>
<body>
<h2>New user :</h2>
<form action="/newUser" method="POST" object="${user}">
    <label for="login">login </label>
    <br>
    <input type="text" name="login" id="login">
    <br>

    <label for="password">password </label>
    <br>
    <input type="password" name="password" id="password">
    <br>
    <label for="name">name </label>
    <br>
    <input type="text" name="name" id="name">
    <br>

    <label for="surname">surname </label>
    <br>
    <input type="text" name="surname" id="surname">
    <br>

    <label for="email">email </label>
    <br>
    <input type="text" name="email" id="email">
    <br>

    <input type="submit" value="Go">
</form>
</body>
</html>