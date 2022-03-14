
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

    <p>

    <h3>New books</h3>
    <form action="library" method="post">
        <label>Title</label><br>
        <input name="title"/><br>
        <label>Author</label><br>
        <input name="author"/><br>
        <label>Quantity</label><br>
        <input name="quantity" type="number" min="10" /><br>

        <button type="submit">ZumZum</button>
    </form>

    </p>

    </form>

    </body>
</html>
