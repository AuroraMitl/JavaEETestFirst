import java.sql.*;

public class JDBCconnect {

    private static String url = "jdbc:postgresql://localhost:5432/java_ee_db";
    private static String login = "postgres";
    private static String password = "7411945";



    public static void addBooks(String title,String author,int quantity) {

        String query = "INSERT INTO books (title,author,quantity) VALUES(?,?,?)";
        try (Connection con = DriverManager.getConnection(url, login, password); //"открыли соединение с базой данных"
             PreparedStatement preStat = con.prepareStatement(query)){ //"передали запрос в базу данных"
            preStat.setString(1, title);
            preStat.setString(2, author);
            preStat.setInt(3, quantity);
            preStat.executeUpdate(); // выполнение
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
