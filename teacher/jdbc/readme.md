## JDBC基础
#### 1、JDBC的意义
开发人员只要面对jdbc进行编程，每一家数据库的厂商，需要为jdbc提供接口，所以使用jdbc的第一步是根据数据库下载连接器。
![](https://tva3.sinaimg.cn/large/0068ld55gy1h0iel6gy5qj30he0b70ul.jpg)

#### 2、JDBC的使用
- 创建intelij的java项目
- 创建一个lib的文件夹
- 将连接器拷贝到lib中
- 将lib中的连接器添加到Liberty中
#### 3、JDBC的编写流程
- 创建Connection
```java
String url = "jdbc:mysql://localhost:3306/20wlw_manager";
String user = "20wlw";
String pwd = "20wlw123";
con = DriverManager.getConnection(url,user,pwd);
```
- 创建Prestatement
```java
String sql = "select * from t_classroom";
ps = con.prepareStatement(sql);
```
- 创建rs或者执行更新
如果是更新，直接执行executeUpdate
```java
ps = con.prepareStatement(sql);
ps.executeUpdate();
```
如果是查询，需要通过ResultSet来接收查询字符串
```java
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
```
完整的代码如下
```java
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

```