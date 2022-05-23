### 用JavaScript连接MySQL的一些基本操作（增删改查列表）

- 为数据表添加项：
  
  代码如下：
  
  ```javascript
  public static void add(){
          //创建Connection
          Connection con =null;
          //创建PreparedStatement
          PreparedStatement ps = null;
          try {
              //创建连接字符串
              String url = "jdbc:mysql://localhost:3306/20wlw_manager";
              //数据库的连接用户名
              String user = "20wlw";
              //数据库的连接密码
              String password = "20wlw123";
              con = DriverManager.getConnection(url,user,password);
              //创建sql
              String sql="insert into t_classroom(name,grade,special,teacher1,moblie1," +
                      "teacher2,moblie2) value"+" ('2020级物联网工程班','2020','物联网工程'," +
                      "'刘老师','7788','朱老师','6699')";
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
  ```

代码执行前t_classroom为空

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-26-12-image.png)

运行add()之后t_classroom如下:

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-30-50-image.png)

---

- 删除数据表中的项
  
  代码如下：
  
  ```javascript
  public static void delete() {
          Connection con = null;
          PreparedStatement ps = null;
          try {
              String url = "jdbc:mysql://localhost:3306/20wlw_manager";
              String user = "20wlw";
              String password = "20wlw123";
              con = DriverManager.getConnection(url,user,password);
              String sql = "delete from t_classroom where id=3";
              ps = con.prepareStatement(sql);
              ps.executeUpdate();
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              try {
                  if (ps!=null) ps.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
              try {
                  if (con!=null) con.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
          }
      }
  ```

代码执行前t_classroom:

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-41-40-image.png)

代码执行之后t_classroom:

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-45-06-image.png)

---

- 修改数据表中的数据
  
  代码如下：
  
  ```javascript
  public static void update() {
          Connection con = null;
          PreparedStatement ps = null;
          try {
              String url = "jdbc:mysql://localhost:3306/20wlw_manager";
              String user = "20wlw";
              String password = "20wlw123";
              con = DriverManager.getConnection(url,user,password);
              String sql = "update t_classroom set moblie1='9087' where id=2";
              ps = con.prepareStatement(sql);
              ps.executeUpdate();
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              try {
                  if (ps!=null) ps.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
              try {
                  if (con!=null) con.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
          }
      }
  ```

代码执行前t_classroom:

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-49-30-image.png)

代码执行后t_classroom:

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-50-30-image.png)

---

- 根据id查询数据
  
  代码如下：
  
  ```javascript
  public static void loadById() {
          Connection con = null;
          PreparedStatement ps = null;
          ResultSet rt = null;
          try {
              String url = "jdbc:mysql://localhost:3306/20wlw_manager";
              String user = "20wlw";
              String password = "20wlw123";
              con = DriverManager.getConnection(url,user,password);
              String sql = "select * from t_classroom where id=2";
              ps = con.prepareStatement(sql);
              rt = ps.executeQuery();
              while (rt.next()) {
                  int id = rt.getInt("id");
                  String name = rt.getString("name");
                  String grade = rt.getString("grade");
                  String special = rt.getString("special");
                  String t1 = rt.getString("teacher1");
                  String m1 = rt.getString("moblie1");
                  String t2 = rt.getString("teacher2");
                  String m2 = rt.getString("moblie2");
                  System.out.println(id+","+name+","+grade+","+special+","+t1+","+m1+","+t2+","+m2);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              try {
                  if (rt!=null) rt.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
              try {
                  if (ps!=null) ps.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
              try {
                  if (con!=null) con.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
          }
      }
  ```

运行结果如下:

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-54-02-image.png)

---

- 列出表中的数据
  
  代码如下：
  
  ```javascript
  public static void load() {
          Connection con = null;
          PreparedStatement ps = null;
          ResultSet rs = null;
          try{
              String url = "jdbc:mysql://localhost:3306/20wlw_manager";
              String user = "20wlw";
              String password = "20wlw123";
              con = DriverManager.getConnection(url,user,password);
              String sql = "select * from t_classroom";
              ps = con.prepareStatement(sql);
              rs = ps.executeQuery();
              while (rs.next()){
                  int id = rs.getInt("id");
                  String name = rs.getString("name");
                  String grade = rs.getString("grade");
                  String special = rs.getString("special");
                  String teacher1 = rs.getString("teacher1");
                  String moblie1 = rs.getString("moblie1");
                  String teacher2 = rs.getString("teacher2");
                  String moblie2 = rs.getString("moblie2");
                  System.out.println(id+","+name+","+grade+","+special+","+teacher1+","+moblie1+","+teacher2+","+moblie2);
              }
          } catch (SQLException e) {
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
  ```

运行结果如下：

![](C:\Users\xiaowang\AppData\Roaming\marktext\images\2022-03-27-18-56-13-image.png)

---


