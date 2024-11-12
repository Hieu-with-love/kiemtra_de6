package devzeus.com.kiemtra_ltweb_de6.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
    private static String USERNAME = "root";
    private static String PASSWORD = "1234";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/kiemtra_ltweb_ct3";

    public static Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    // Đặt hàm main ở đây vơ mục đích la run tại class, kiem tra kết nối CSDL đã than công hay chưa?
    public static void main(String[] args) throws SQLException {
        try{
            new DBConnectMySQL().getDatabaseConnection();
            System.out.println("Database connection established " + DBConnectMySQL.getDatabaseConnection());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
