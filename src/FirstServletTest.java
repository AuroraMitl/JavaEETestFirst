import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServletTest")
public class FirstServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<h1> Hello, " + name + "!</h1>");
        pw.println("</html>");

        //response.sendRedirect("/FirstJSP.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/FirstJSP.jsp");
        dispatcher.forward(request,response);

    }
}
