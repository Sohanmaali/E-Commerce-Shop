package com.commerce.model;

/**
 *
 * @author Sohan_Maali
 */
import com.commerce.services.GetConnection;
//import com.commerce.model.UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//import com.eazydeals.entities.User;

public class UserDto {

    public boolean saveUser(UserDao userDao) {
        Connection con = GetConnection.getConnectin();
        boolean b = false;
        ResultSet rs = null;
        if (con != null) {
            try {

                String query = "insert into user(name, email, password, phone, gender, address, city, pincode, state) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, userDao.getUserName());
                psmt.setString(2, userDao.getUserEmail());
                psmt.setString(3, userDao.getUserPassword());
                psmt.setString(4, userDao.getUserPhone());
                psmt.setString(5, userDao.getUserGender());
                psmt.setString(6, userDao.getUserAddress());
                psmt.setString(7, userDao.getUserCity());
                psmt.setString(8, userDao.getUserPincode());
                psmt.setString(9, userDao.getUserState());
                psmt.executeUpdate();
                b = true;

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return b;
    }

    public boolean userLogin(UserDao userDao) {
        Connection con = GetConnection.getConnectin();
        boolean b = false;
        ResultSet rs = null;
        if (con != null) {
            try {
                String query = "select * from user where email = ? and password = ?";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, userDao.getUserEmail());
                psmt.setString(2, userDao.getUserPassword());
                rs = psmt.executeQuery();

                while (rs.next()) {
                    userDao.setUserId(rs.getInt("id"));
                    userDao.setUserName(rs.getString("name"));
                    userDao.setUserEmail(rs.getString("email"));
                    userDao.setUserPassword(rs.getString("password"));
                    userDao.setUserPhone(rs.getString("phone"));
                    userDao.setUserGender(rs.getString("gender"));
//                  userDao.setDateTime(rs.getTimestamp("registerdate"));
                    userDao.setUserAddress(rs.getString("address"));
                    userDao.setUserCity(rs.getString("city"));
                    userDao.setUserPincode(rs.getString("pincode"));
                    userDao.setUserState(rs.getString("state"));
                    b = true;
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return b;
    }
    
}
