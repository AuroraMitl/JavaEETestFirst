import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "library")
public class LibraryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title"); // получаем параметры , которые были получены в request
        String author = request.getParameter("author"); // получаем параметры , которые были получены в request
        int quantity = Integer.parseInt(request.getParameter("quantity")); // получаем параметры , которые были получены в request
        JDBCconnect.addBooks(title, author, quantity); //передаем данные методу
        response.sendRedirect("/library"); // перенаправление на страницу , котрая опять подключается к базе и выводит все из таблицы
    }

        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

            PrintWriter pw = response.getWriter();

            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db", "postgres", "7411945");

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT title from books");

                while (rs.next()) {
                    pw.println(rs.getString("title"));
                }

                stmt.close();
            } catch (SQLException s) {
                s.printStackTrace();
            }

        }
    }

