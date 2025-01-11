package persistence;

import domain.Cart;
import domain.Item;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {

    void deleteCar(String username,Item item);

    void saveCart(String username,Item item);

    List<String>  getCart(String username);

   String getNumByItemId(String username,String itemId) throws SQLException;

   void updateNum(String username,String itemId,String num);
}
