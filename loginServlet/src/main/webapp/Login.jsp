<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>insert title here</title>
  <link rel="stylesheet" href="index.css" />
</head>
<body>
    <div class="container">
        <h1>login</h1>
        <form action="loginservlet" method="post"> <!-- change method to "post" -->
            <label for="username">username:</label>
            <input type="text" id="username" name="username" required><br>
            <label for="password">password:</label>
            <input type="password" id="password" name="password" required><br>
            <button type="submit">login</button>
        </form>

        <p><a href="index.html">back to home</a></p>

        
    </div>
</body>
</html>