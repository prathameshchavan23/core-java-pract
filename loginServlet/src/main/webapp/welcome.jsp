<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
    <link rel="stylesheet" href="index.css"> <!-- Optional: CSS for styling -->
</head>
<body>
    <%
        // Retrieve the current session (don't create a new one if not exists)
        HttpSession session = request.getSession(false);

        // Check if session is valid and username is available
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
    %>

    <div class="container">
        <h1>Welcome, <%= username %>! 👋</h1>
        <p>We're delighted to have you on our platform. 🌟</p>
        <h3>Explore, learn, and connect with our vibrant community! 🚀</h3>
        <p>Feel free to stay as long as you like.</p>
        <p>When you're ready, you can <a href="logout.jsp">LOGOUT</a> securely.</p>
    </div>

    <%
        } else {
            // Session is invalid or expired
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>
