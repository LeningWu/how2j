package JDBC;

import java.sql.*;

public class Pagesearch {

    public static void list(int start,int count){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root","root");
            Statement s=c.createStatement();) {
            String sql="select * from hero limit " +start + "," + count;

            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString(2);
                float hp=rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){
        list(0,5);
    }
}
