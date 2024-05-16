<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Chat</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Chat Interface</h2>
    <div id="chatbox">
        <div class="chat message">Welcome to the chatbot!</div>
    </div>
    <form id="queryForm" action="chat" method="post">
        <input type="text" name="query" id="query" placeholder="Type your message...">
        <button type="submit">Send</button>
    </form>
    <% 
        String responseText = (String) request.getAttribute("responseText");
        if (responseText != null) {
    %>
        <div class="chat response"><%= responseText %></div>
    <% } %>
</body>
</html>
