import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class BookDB {

    //PrintWriter pw = response.getWriter();
    public static ArrayList<Book> select() {

        ArrayList<Book> books = new ArrayList<Book>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java_ee_db", "postgres", "7411945");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title from books");

//        while (rs.next()){
//            pw.println(rs.getString("title"));
//        }

            stmt.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        return books;
    }
}


