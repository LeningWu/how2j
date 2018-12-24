package JDBC;

import charactor.Hero;

import java.sql.*;

public class TestORM {
    public static Hero get(int id){
        Hero hero=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root","root"); Statement s=c.createStatement()){
            String sql="select * from hero where id ="+id;

            ResultSet rs=s.executeQuery(sql);

            if (rs.next()){
                hero=new Hero();
                String name=rs.getString(2);
                float hp=rs.getFloat("hp");
                int damage=rs.getInt(4);
                hero.name=name;
                hero.hp=hp;
                hero.damage=damage;
                hero.id=id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public static void main(String[] args){
        Hero h=get(22);
        System.out.println(h.name);
    }
}
