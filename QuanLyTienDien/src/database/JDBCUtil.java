/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {

    public static Connection getConnection() {
        Connection c = null;

        try {
            // Đăng ký MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // Các thông số
            String url = "jdbc:mySQL://localhost:3306/quanlytiendien2";
            String username = "root";
            String password = "";

            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
