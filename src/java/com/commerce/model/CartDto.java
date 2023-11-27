package com.commerce.model;

/**
 *
 * @author Sohan_Maali
 */
import com.commerce.services.GetConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDto {

    public CartDto() {

    }

    public boolean addToCart(CartDao cart) {
        boolean flag = false;
        Connection con = GetConnection.getConnectin();
        try {
            String query = "insert into cart(uid, pid, quantity) values(?,?,?)";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, cart.getUserId());
            psmt.setInt(2, cart.getProductId());
            psmt.setInt(3, cart.getQuantity());

            psmt.executeUpdate();
            flag = true;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return flag;
    }

    public List<CartDao> getCartListByUserId(int uid) {
        List<CartDao> list = new ArrayList<CartDao>();
        Connection con = GetConnection.getConnectin();
        try {
            String query = "select * from cart where uid = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, uid);

            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                CartDao cart = new CartDao();
                cart.setCartId(rs.getInt("id"));
                cart.setUserId(rs.getInt("uid"));
                cart.setProductId(rs.getInt("pid"));
                cart.setQuantity(rs.getInt("quantity"));

                list.add(cart);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getQuantity(int uid, int pid) {
        int qty = 0;
        Connection con = GetConnection.getConnectin();
        try {
            String query = "select * from cart where uid = ? and pid = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, uid);
            psmt.setInt(2, pid);

            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                qty = rs.getInt("quantity");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return qty;
    }

    public int getQuantityById(int id) {
        int qty = 0;
        Connection con = GetConnection.getConnectin();
        try {
            String query = "select * from cart where id = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                qty = rs.getInt("quantity");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return qty;
    }

    public void updateQuantity(int id, int qty) {
        Connection con = GetConnection.getConnectin();
        try {
            String query = "update cart set quantity = ? where id = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, qty);
            psmt.setInt(2, id);

            psmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeProduct(int cid) {
        Connection con = GetConnection.getConnectin();
        try {
            String query = "delete from cart where id = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, cid);

            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void removeAllProduct() {
        Connection con = GetConnection.getConnectin();
        try {
            String query = "delete from cart";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getIdByUserIdAndProductId(int uid, int pid) {
        int cid = 0;
        Connection con = GetConnection.getConnectin();
        try {
            String query = "select * from cart where uid = ? and pid = ?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, uid);
            psmt.setInt(2, pid);

            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                cid = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cid;
    }

    public int getCartCountByUserId(int uid) {
        Connection con = GetConnection.getConnectin();
        int count = 0;
        try {
            String query = "select count(*) from cart where uid=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, uid);

            ResultSet rs = psmt.executeQuery();
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    public int getProductId(int cid) {
        int pid = 0;
        Connection con = GetConnection.getConnectin();
        try {
            String query = "select pid from cart where id=?";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setInt(1, cid);
            ResultSet rs = psmt.executeQuery();
            rs.next();
            pid = rs.getInt(1);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return pid;
    }
}
