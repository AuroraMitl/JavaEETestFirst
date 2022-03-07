<%--
  Created by IntelliJ IDEA.
  User: Ольга
  Date: 06.03.2022
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>FirstJSP</title>
    </head>
    <body>
    <h1>Testing JSP</h1>
        <p>
            <%= "Hello world!" %>
        </p>
        <p>
            <% java.util.Date now = new java.util.Date();
            String someString = "Current date: " + now;
            %>
            <%= someString %>
            <%= new java.util.Date()
            %>
    </p>

    <p>
        <%@ page import="logic.TestClass" %>
        <% TestClass testClass = new TestClass(); %>
        <%= testClass.getInfo()
        %>
    </p>

    <p>
            <%

            out.println("Hello World 2");

            %>
    </p>
            <%
               for(int i = 0; i < 10; i++){
                   out.println("<p>" + "Goodbye" +"</p>");
               }
            %>
        </p>

    <h1>----------------------------------</h1>

    </body>
</html>
