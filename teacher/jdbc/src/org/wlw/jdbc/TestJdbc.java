package org.wlw.jdbc;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) {
        load();
    }

    public static void loadById(int id) {

    }

    public static void update() {

    }

    public static void delete() {

    }

    public static void load() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String url = "jdbc:mysql://localhost:3306/20wlw_manager";
            String user = "20wlw";
            String pwd = "20wlw123";
            con = DriverManager.getConnection(url,user,pwd);
            String sql = "select * from t_classroom";
            ps = con.prepareStatement(sql);
            //查询出来的结果放到rs中
            rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                String special = rs.getString("special");
                String t1 = rs.getString("teacher1");
                String m1 = rs.getString("mobile1");
                String t2 = rs.getString("teacher2");
                String m2 = rs.getString("mobile2");
                System.out.println(id+","+name+","+grade+","+special+","+t1+","+t2+","+m1+","+m2);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(ps!=null) ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(con!=null) con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void add() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //1、创建连接字符串
            String url = "jdbc:mysql://localhost:3306/20wlw_manager";
            //2、数据库的连接用户名
            String user = "20wlw";
            //3、数据库的连接密码
            String password = "20wlw123";
            //4、创建Connection
            con = DriverManager.getConnection(url,user,password);
            //5、检验con是否完成连接
            System.out.println(con);
            //6、创建sql
            String sql = "insert into t_classroom (name,grade,special,teacher1,mobile1,teacher2,mobile2) value" +
                    " ('2020级物联网工程1班','2020','物联网工程','t1','119','t2','110')";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(ps!=null) ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if(con!=null) con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
