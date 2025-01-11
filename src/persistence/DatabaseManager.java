package persistence;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import domain.User;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private ComboPooledDataSource comboPooledDataSource =new ComboPooledDataSource("Data");

    public DatabaseManager() {}

    public Connection getConnection() throws SQLException {return comboPooledDataSource.getConnection();}
    //user
    //向数据库中推入信息
    public boolean insertInfor(User user, String password,String salt) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        int result1,result2;
        try {
            conn = comboPooledDataSource.getConnection();
            String sql = "INSERT INTO user (username, password, salt) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, password);
            ps.setString(3, salt);
            result1 = ps.executeUpdate();// 如果结果大于0, 则表示插入成功

            String sql2="INSERT INTO userinformation(firstname, lastname, sex, email, phone, age, username,country,address,faverCategory) VALUES (?, ?, ?, ?, ? ,?, ?, ?, ?,? ) ";
            ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, user.getFirstName());
            ps2.setString(2, user.getLastName());
            ps2.setString(3, user.getSex());
            ps2.setString(4, user.getEmail());
            ps2.setString(5, user.getPhone());
            ps2.setString(6, user.getAge());
            ps2.setString(7, user.getUsername());
            ps2.setString(8, user.getCountry());
            ps2.setString(9, user.getAddress());
            ps2.setString(10, user.getFaverCategory());
            result2 = ps2.executeUpdate();

            return (result1>0)&&(result2>0);
        } catch (SQLException e) {
            e.printStackTrace(); // 输出异常信息
            return false; // 在发生异常情况下返回false
        }
        finally {   //即使catch到了异常并return了，finally语句也会执行
            // 进行资源清理
            if (ps != null) {
                ps.close();
                ps2.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    //验证（输入的为用户名和未处理过（未加盐and未hash的密码）
    public boolean verityPassword(String name,String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = comboPooledDataSource.getConnection();
            String sql = "SELECT password ,salt FROM user WHERE username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            String pass=null;
            String salt=null;
            if(rs.next()) {
                 pass = rs.getString("password");
                 salt = rs.getString("salt");
            }
            else {
                System.out.println("username not found");
            }
            //获得盐之后哈希密码
            HashOperate hp = new HashOperate();
            String hashedPassword= hp.SHA256Gener(password,salt);
            //将处理后的密码与数据库中获得的密码比较
            return pass.equals(hashedPassword);
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    //检验用户名是否存在
    public boolean ifNameExit(String name) throws SQLException {
        String sql = "SELECT username FROM user WHERE username = ?";
        try (Connection conn = comboPooledDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e)
        {
            throw new RuntimeException("Database error while checking username existence.", e);
        }
    }

    //删除用户信息
    public boolean deleteUser(String name) throws SQLException {
        String sql = "DELETE FROM user WHERE username = ?";
        try (Connection conn = comboPooledDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, name);
            return ps.executeUpdate() > 0;

        }
        catch (SQLException e)
        {
            throw new RuntimeException("Database error while deleting user existence.", e);
        }
    }

    //userinformation
    //将注册的用户信息推入到数据库中
    public boolean insertUserInformation(String firstname,String lastname,String sex,String username,String password,String email) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = comboPooledDataSource.getConnection();
            String sql = "INSERT INTO userinformation (firstname,lastname,sex,email) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, sex);
            ps.setString(4, email);

            int result = ps.executeUpdate();
            return result > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    //修改用户信息
    public  boolean updateUserInformation(User user,String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql="UPDATE userinformation SET firstName = ?,lastName= ?,sex = ?,email = ?,phone = ?,age = ?,country = ?,address = ?,faverCategory= ? WHERE username = ?";
        try {
            conn = comboPooledDataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAge());
            ps.setString(7, user.getCountry());
            ps.setString(8, user.getAddress());
            ps.setString(9, user.getFaverCategory());
            ps.setString(10, username);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //获得用户信息
    public  User getInfByUsername(String username) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = new User();
        String sql="SELECT * FROM userinformation WHERE username = ?";
        try {
            conn = comboPooledDataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()) {
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAge(rs.getString("age"));
                user.setCountry(rs.getString("country"));
                user.setAddress(rs.getString("address"));
                user.setFaverCategory(rs.getString("faverCategory"));
                user.setSex(rs.getString("sex"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return user;

    }

    public String getFavImage(String faverCategory) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql="SELECT bannername FROM bannerdata WHERE favcategory = ?";
        try{
            conn = comboPooledDataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, faverCategory);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString("bannername");
            }
            return null;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getNameByCategory(String category) throws SQLException {
        List<String> petName=new ArrayList<>();
        String sql="SELECT name FROM product WHERE category = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = comboPooledDataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, category);
            rs = ps.executeQuery();
            while (rs.next()) {
                petName.add(rs.getString("name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return petName;

    }
}
