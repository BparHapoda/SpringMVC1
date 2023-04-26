<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Root page</title>
</head>
<style>
  body{display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;}
</style>
<body>
<h2>Entrance to Application :</h2>
<form action="login" method="post">
<label for="login">login </label>
<br>
<input type="text" name="login" id="login">
    <br>
<label for="password">password </label>
<br>
<input type="password" name="password" id="password">
<br>
    <input type="submit" value="Go">
</form>
<a href="registration">Registration</a>
<br>
<a href="admin">Admin</a>

</body>
</html>