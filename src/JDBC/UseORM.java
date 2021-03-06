package JDBC;

import charactor.Hero;

import javax.management.AttributeList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UseORM {
    /*
    根据ORM的思想，设计其他几个常见的ORM方法：
    把一个Hero对象插入到数据库中 public static void add(Hero h)
    把这个Hero对象对应的数据删除掉 public static void delete(Hero h)
    更新这条Hero对象 public static void update(Hero h)
    把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
    public static List<Hero> list();
     */
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

    public static void add(Hero h){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql="insert into hero values(null,?,?,?)";
        try (Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root","root");PreparedStatement ps=c.prepareStatement(sql)) {
            //设置参数
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Hero h){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql="delete from hero where id = ?";
        try (Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root","root");PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,h.id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Hero h){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql="update hero set name = ? , hp =? , damage = ? where id = ?";
        try (Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root","root");PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            ps.setInt(1,h.id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Hero> list(){
        List<Hero> heroes=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root","root"); Statement s=c.createStatement()){
            String sql = "select * from hero";

            ResultSet rs=s.executeQuery(sql);

            while (rs.next()){
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                heroes.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public static void main(String[] args){
        List<Hero> hs =list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        Hero h = new Hero();
        h.name = "新的英雄";
        System.out.println("新加一条数据");
        add(h);
        hs =list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        System.out.println("取出id=101的数据，它的name是:");
        h = get(101);
        System.out.println(h.name);
        System.out.println("把名字改为 英雄101，并且更新到数据库");
        h.name="英雄101";
        update(h);
        System.out.println("取出id=101的数据，它的name是:");
        h = get(101);
        System.out.println(h.name);
        System.out.println("删除id=101的数据");
        delete(h);
        hs =list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
    }
}
