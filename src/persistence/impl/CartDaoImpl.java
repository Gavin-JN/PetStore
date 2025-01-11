package persistence.impl;

import domain.Item;
import persistence.CartDao;
import persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    private static final String InsertToCart="INSERT INTO cartitem (username, itemId,num) VALUES (?, ?,?)";
    private static final String deleteItemFormCart="DELETE FROM cartitem WHERE username=? AND itemId= ?";
    private static final String updateItemNum="UPDATE cartitem SET num=? WHERE username=? AND itemId= ?";
    private static final String getItemFormCart="SELECT itemId FROM cartitem WHERE username=?";
    private static final String getNumByItemId="SELECT num FROM cartitem WHERE username=? AND itemId=?";
    @Override
    public void deleteCar(String username, Item item) {
     Connection con = null;
     PreparedStatement ps = null;
     try {
         con= DBUtil.getConnection();
         ps = con.prepareStatement(deleteItemFormCart);
         ps.setString(1, username);
         ps.setString(2, item.getItemId());
         ps.executeUpdate();
         DBUtil.closePreparedStatement(ps);
         DBUtil.closeConnection(con);
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
    }

    @Override
    public void saveCart(String username, Item item) {
      Connection con = null;
      PreparedStatement ps = null;
      String number= String.valueOf(item.getQuantity());
      try{
          con=DBUtil.getConnection();
          ps = con.prepareStatement(InsertToCart);
          ps.setString(1, username);
          ps.setString(2, item.getItemId());
          ps.setString(3, number);
          ps.executeUpdate();
          DBUtil.closePreparedStatement(ps);
          DBUtil.closeConnection(con);

      } catch (SQLException e) {
          throw new RuntimeException(e);
      }

    }

    @Override
    public List<String> getCart(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> items = new ArrayList<String>();
        try{
            con=DBUtil.getConnection();
            ps = con.prepareStatement(getItemFormCart);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while(rs.next()){
               String itemId = rs.getString("itemId");
               items.add(itemId);
            }
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
    public void updateNum(String username, String itemId,String num) {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con=DBUtil.getConnection();
            ps = con.prepareStatement(updateItemNum);
            ps.setString(1, num);
            ps.setString(2, username);
            ps.setString(3, itemId);
            ps.executeUpdate();
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(con);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getNumByItemId(String username,String itemId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String number= null;
        ResultSet rs=null;
        try{
            con=DBUtil.getConnection();
            ps = con.prepareStatement(getNumByItemId);
            ps.setString(1, username);
            ps.setString(2, itemId);
            rs = ps.executeQuery();


            if (rs.next()){
                 number= rs.getString("num");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(con);
            if(rs!=null)
            {
                rs.close();
            }

        }
        return number;
    }



}
