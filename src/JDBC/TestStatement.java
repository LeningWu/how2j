package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try( Connection c= DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root","root");
             Statement s=c.createStatement();
             )
        {

                String sql = "DELETE FROM hero WHERE id=1";
                s.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
