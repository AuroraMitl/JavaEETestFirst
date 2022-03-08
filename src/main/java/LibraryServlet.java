import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();

        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgresql","postgresql","7411945");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title from books");

            while (rs.next()){
                pw.println(rs.getString("title"));
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
